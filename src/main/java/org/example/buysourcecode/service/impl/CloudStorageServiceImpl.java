package org.example.buysourcecode.service.impl;

import lombok.RequiredArgsConstructor;

import org.example.buysourcecode.service.CloudStorageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.DeleteObjectRequest;
import software.amazon.awssdk.services.s3.model.GetUrlRequest;
import software.amazon.awssdk.services.s3.model.ObjectCannedACL;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class CloudStorageServiceImpl implements CloudStorageService {

    @Value("${aws.s3.bucket-name}")
    private String bucketName;

    private final S3Client s3;

    @Override
    public String upload(String path, MultipartFile file) throws IOException {
        Map<String, String> metadata = new HashMap<>();
        PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                .bucket(bucketName)
                .key(path)
                .acl(ObjectCannedACL.PUBLIC_READ)
                .metadata(metadata)
                .build();

        s3.putObject(
                putObjectRequest,
                RequestBody.fromBytes(file.getBytes())
        );

        return getUrl(path);
    }

    @Override
    public String[] upload(MultipartFile[] files) throws IOException {
        return new String[0];
    }

    @Override
    public void delete(String path) {
        DeleteObjectRequest deleteObjectRequest = DeleteObjectRequest.builder()
                .bucket(bucketName)
                .key(path)
                .build();
        s3.deleteObject(deleteObjectRequest);
    }

    @Override
    public String getUrl(String path) {
        GetUrlRequest getUrlRequest = GetUrlRequest.builder()
                .bucket(bucketName)
                .key(path)
                .build();
        URL url = s3.utilities().getUrl(getUrlRequest);
        return url.toString();
    }
}
