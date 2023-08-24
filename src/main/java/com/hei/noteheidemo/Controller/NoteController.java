package com.hei.noteheidemo.Controller;

import com.hei.noteheidemo.Entity.Note;
import com.hei.noteheidemo.Service.NoteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class NoteController {
    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @PostMapping("/note-create")
    public ResponseEntity<String> createNote(@RequestBody Note note) {
        noteService.createNote(note);
        return ResponseEntity.status(HttpStatus.CREATED).body("Note created successfully");
    }

    @GetMapping("/notes")
    public List<Note> getAllNotes() {
        return noteService.getAllNotes();
    }

    @GetMapping("/notes/{id}")
    public Optional<Note> getNoteById(@PathVariable int id) {
        return noteService.getNoteById(id);
    }

    @PutMapping("/notes/{id}")
    public Note updateNote(@PathVariable int id, @RequestBody Note note) {
        if (note.getId() != id) {
            throw new IllegalArgumentException("ID mismatch between URL and request body");
        }
        return noteService.updateNote(note);
    }

    @DeleteMapping("/notes/{id}")
    public ResponseEntity<String> deleteNote(@PathVariable int id) {
        noteService.deleteNote(id);
        return ResponseEntity.ok("Note with ID " + id + " has been deleted.");
    }

    @GetMapping("/notes/student/{studentId}")
    public List<Note> getAllNotesForStudent(@PathVariable int studentId) {
        return noteService.getAllNotesForStudent(studentId);
    }

    @GetMapping("/notes/subject/{subjectId}")
    public List<Note> getAllNotesForSubject(@PathVariable int subjectId) {
        return noteService.getAllNotesForSubject(subjectId);
    }

    @GetMapping("/notes/average/student/{studentId}")
    public float getAverageNoteForStudent(@PathVariable int studentId) {
        return noteService.getAverageNoteForStudent(studentId);
    }
}
