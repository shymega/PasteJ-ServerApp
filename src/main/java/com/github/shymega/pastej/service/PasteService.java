package com.github.shymega.pastej.service;

import com.github.shymega.pastej.model.PasteEntity;
import com.github.shymega.pastej.repository.PasteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PasteService {
    private final PasteRepository pasteRepository;

    @Autowired
    public PasteService(PasteRepository pasteRepository) {
        this.pasteRepository = pasteRepository;
    }

    public void save(MultipartFile multipartFile) throws IOException {
        PasteEntity pasteEntity = new PasteEntity();
        pasteEntity.setFileName(StringUtils.cleanPath(Objects.requireNonNull(multipartFile.getOriginalFilename())));
        pasteEntity.setMimeType(multipartFile.getContentType());
        pasteEntity.setData(multipartFile.getBytes());;
        pasteEntity.setFileSize(multipartFile.getSize());

        // add sha check
        pasteRepository.save(pasteEntity);
    }

    public Optional<PasteEntity> getFile(String fileId) {
        return pasteRepository.findById(fileId);
    }

    public List<PasteEntity> getAllFiles() {
        return pasteRepository.findAll();
    }
}
