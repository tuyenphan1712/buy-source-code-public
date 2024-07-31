package org.example.buysourcecode.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.buysourcecode.dto.asset.AssetResponse;
import org.example.buysourcecode.dto.asset.UploadAssetRequest;
import org.example.buysourcecode.exception.NotFoundException;
import org.example.buysourcecode.map.AssetMapper;
import org.example.buysourcecode.model.Asset;
import org.example.buysourcecode.model.User;
import org.example.buysourcecode.service.AssetService;
import org.example.buysourcecode.service.CloudStorageService;
import org.example.buysourcecode.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/assets")
@RequiredArgsConstructor
public class AssetController {

    private final CloudStorageService cloudStorageService;
    private final AssetService assetService;
    private final AssetMapper assetMapper;
    private final UserService userService;


    @GetMapping("/{id}")
    public ResponseEntity<?> getAsset(@PathVariable("id") Long id) {
        Asset document = assetService.findById(id);
        if(document == null)
            throw new RuntimeException(String.format("Document with id %s not found", id));

        String url = cloudStorageService.getUrl(document.getPath());
        AssetResponse response = assetMapper.toAssetResponse(document);
        response.setUrl(url);

        return ResponseEntity.ok(response);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@ModelAttribute @Valid UploadAssetRequest request) {
        try {
            MultipartFile file = request.getFile();
            String fileName = file.getOriginalFilename();
            String fileType = file.getContentType();
            Long fileSize = file.getSize();
            Long maxId = assetService.findMaxId();


            String path = generatePath(
                    request.getModel(),
                    maxId == null ? 1 : maxId + 1,
                    fileName,
                    fileType,
                    null
            );

            String url = cloudStorageService.upload(path, file);

            User createBy = userService.findUserById(request.getCreateBy());
            if(createBy == null) { throw new NotFoundException("User not found"); }

            Asset asset = Asset.builder()
                    .name(fileName)
                    .path(path)
                    .type(fileType)
                    .size(fileSize)
                    .createBy(createBy)
                    .build();

            assetService.create(asset);

            AssetResponse response = assetMapper.toAssetResponse(asset);
            response.setUrl(url);

            return ResponseEntity.ok(response);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDocument(@PathVariable("id") Long id) {
        Asset asset = assetService.findById(id);
        if(asset == null)
            throw new RuntimeException(String.format("Document with id %s not found", id));

        cloudStorageService.delete(asset.getPath());
        assetService.delete(asset);

        return ResponseEntity.ok(id);
    }

    private String generatePath(String model, Long fileId, String fileName, String fileType, String imageType) {
        if(model == null) model = "general";

        boolean isImage = fileType.startsWith("image");
        if(isImage && imageType == null) imageType = "original";

        String idString = String.format("%09d", fileId);

        String[] parts = new String[3];
        for(int i = 0; i < 3; i++)
            parts[i] = idString.substring(i * 3, i * 3 + 3);

        return (isImage ? "images/" : "")
                + model + "/"
                + String.join("/", parts) + "/"
                + (isImage ? imageType + "/" : "")
                + fileName;
    }


}
