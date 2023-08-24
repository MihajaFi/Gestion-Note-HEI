package com.hei.noteheidemo.Service;

import com.hei.noteheidemo.Entity.Note;
import com.hei.noteheidemo.Repository.NoteRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class NoteService {
    private final NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public Note createNote(Note note) {
        try {
            noteRepository.insert(note);
            return note;
        } catch (SQLException e) {
            throw new RuntimeException("There was a error when creating note " + note + ": " + e);
        }
    }

    public List<Note> getAllNotes() {
        try {
            return noteRepository.findAll();
        } catch (SQLException e) {
            throw new RuntimeException("There was a error when fetching notes: " + e);
        }
    }

    public Optional<Note> getNoteById(int id) {
        try {
            return noteRepository.findById(id);
        } catch (SQLException e) {
            throw new RuntimeException("There was a error when fetching note by ID " + id + ": " + e);
        }
    }

    public Note updateNote(Note note) {
        try {
            noteRepository.update(note);
            return note;
        } catch (SQLException e) {
            throw new RuntimeException("There was a error when updating note " + note + ": " + e);
        }
    }

    public void deleteNote(int id) {
        try {
            noteRepository.delete(id);
        } catch (SQLException e) {
            throw new RuntimeException("There was a error when deleting note " + id + ": " + e);
        }
    }

    public List<Note> getAllNotesForStudent(int studentId) {
        try {
            return noteRepository.getAllNotesForStudent(studentId);
        } catch (SQLException e) {
            throw new RuntimeException("There was a error when fetching  notes for student " + studentId + ": " + e);
        }
    }

    public List<Note> getAllNotesForSubject(int subjectId) {
        try {
            return noteRepository.getAllNotesForSubject(subjectId);
        } catch (SQLException e) {
            throw new RuntimeException("There was a error when fetching  notes for subject " + subjectId + ": " + e);
        }
    }

    public float getAverageNoteForStudent(int studentId) {
        try {
            return noteRepository.getAverageNoteForStudent(studentId);
        } catch (SQLException e) {
            throw new RuntimeException("There was a error when fetching average notes for student" + studentId + ": " + e);
        }
    }
}
