package com.sagar.secure_note_backend.services;

import com.sagar.secure_note_backend.models.Note;

import java.util.List;

public interface NoteService {
    Note createNoteForUser(String username, String note);

    Note updateNoteForUser(String username, String content, Long id);

    void deleteNoteForUser(String username, Long id);

    List<Note> getNotesForUser(String username);
}
