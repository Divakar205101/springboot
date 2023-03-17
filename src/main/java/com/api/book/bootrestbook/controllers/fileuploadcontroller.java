package com.api.book.bootrestbook.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class fileuploadcontroller {
    
    @PostMapping("/upload-file")
    public ResponseEntity<String> uploadFile(@RequestPart("file") MultipartFile file){
        System.out.println(file.getOriginalFilename());
        return ResponseEntity.ok("working");
    }
}
