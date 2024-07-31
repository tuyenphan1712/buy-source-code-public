package org.example.buysourcecode.dto.asset;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class UploadAssetRequest {

    private String model;

    @NotNull(message = "create by be not black")
    private String createBy;

    @NotNull(message = "file must be not null")
    private MultipartFile file;
}
