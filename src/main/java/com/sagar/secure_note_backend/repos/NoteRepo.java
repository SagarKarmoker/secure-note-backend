package com.sagar.secure_note_backend.repos;

import com.sagar.secure_note_backend.models.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// model, data type of primary key
public interface NoteRepo extends JpaRepository<Note, Long> {
    List<Note> findByOwnerUsername(String username);
}
