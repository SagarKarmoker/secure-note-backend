package com.sagar.secure_note_backend.services;

import com.sagar.secure_note_backend.models.Note;
import com.sagar.secure_note_backend.repos.NoteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServiceImp implements NoteService {

    @Autowired
    private NoteRepo noteRepo;

    @Override
    public Note createNoteForUser(String username, String note) {
        Note newNote = new Note();
        newNote.setOwnerUsername(username);
        newNote.setContent(note);
        return noteRepo.save(newNote);
    }

    @Override
    public Note upateNoteForUser(String username, String content, Long id) {
        Note existingNote = noteRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Note not found"));

        existingNote.setContent(content);
        return noteRepo.save(existingNote);
    }

    @Override
    public void deleteNoteForUser(String username, Long id) {
        noteRepo.deleteById(id);
    }

    @Override
    public List<Note> getNotesForUser(String username) {
        return noteRepo.findByOwnerUsername(username);
    }
}
