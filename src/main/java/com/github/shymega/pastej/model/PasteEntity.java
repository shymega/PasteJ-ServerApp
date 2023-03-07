package com.github.shymega.pastej.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "pastes")
public class PasteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String fileName;
    private String mimeType;
    private Long fileSize;
    @Lob
    private byte[] data;
}