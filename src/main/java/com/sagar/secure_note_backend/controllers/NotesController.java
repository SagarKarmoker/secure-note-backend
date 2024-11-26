package com.sagar.secure_note_backend.controllers;

import com.sagar.secure_note_backend.models.Note;
import com.sagar.secure_note_backend.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * AuthenticationPrincipal = ensure that currently logged-in user
 * and user details
 */

@RestController
@RequestMapping("/api/nots")
public class NotesController {

    @Autowired
    private NoteService noteService;

    @PostMapping
    public Note createNote(@RequestBody String content, @AuthenticationPrincipal UserDetails userDetails) {
        return noteService.createNoteForUser(userDetails.getUsername(), content);
    }

    @GetMapping
    public List<Note> getAllNotes(@AuthenticationPrincipal UserDetails userDetails){
       return noteService.getNotesForUser(userDetails.getUsername());
    }

    @GetMapping
    public List<Note> getNotesForUser(String username){
        return noteService.getNotesForUser(username);
    }

    @PutMapping("/{noteId}")
    public Note updateNote(@PathVariable Long noteId, @RequestBody String content, @AuthenticationPrincipal UserDetails userDetails) {
        return noteService.updateNoteForUser(userDetails.getUsername(), content, noteId);
    }

    @DeleteMapping("/{noteId}")
    public void deleteNote(@PathVariable Long noteId, @AuthenticationPrincipal UserDetails userDetails) {
        noteService.deleteNoteForUser(userDetails.getUsername(), noteId);
    }
}
