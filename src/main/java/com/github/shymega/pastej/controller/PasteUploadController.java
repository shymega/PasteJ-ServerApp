package com.github.shymega.pastej.controller;

import com.github.shymega.pastej.service.PasteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/pastes")
public class PasteUploadController {
    private final PasteService pasteService;

    @Autowired
    public PasteUploadController(PasteService pasteService) {
        this.pasteService = pasteService;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<String> upload(@RequestParam("paste") MultipartFile file) {
        try {
            pasteService.save(file);

            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Uploaded!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error uploading!");
        }
    }
}