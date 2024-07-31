package org.example.buysourcecode.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public interface CloudStorageService {

    String upload(String path, MultipartFile file) throws IOException;
    String[] upload(MultipartFile[] files) throws IOException;
    void delete(String path);
    String getUrl(String path);
}
