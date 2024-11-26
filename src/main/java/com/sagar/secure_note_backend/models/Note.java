package com.sagar.secure_note_backend.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Note {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;

    @Lob
    private String content;
    private String ownerUsername;
}
