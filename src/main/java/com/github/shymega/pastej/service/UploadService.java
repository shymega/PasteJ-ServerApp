package com.github.shymega.pastej.service;

import com.github.shymega.pastej.model.PasteEntity;
import com.github.shymega.pastej.repository.PastesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class UploadService {
    @Autowired
    private PastesRepository pastesRepository;

    public PasteEntity save(MultipartFile multipartFile) throws IOException {
        PasteEntity pasteEntity = new PasteEntity();
        pasteEntity.setFileName(StringUtils.cleanPath(multipartFile.getOriginalFilename()));
        pasteEntity.setMimeType(multipartFile.getContentType());
        pasteEntity.setData(multipartFile.getBytes());
        pasteEntity.setFileSize(multipartFile.getSize());

        // add sha check
        pastesRepository.save(pasteEntity);

        return pasteEntity;
    }
}
