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
            throw new RuntimeException("Erreur lors de la création de la note " + note + ": " + e);
        }
    }

    public List<Note> getAllNotes() {
        try {
            return noteRepository.findAll();
        } catch (SQLException e) {
            throw new RuntimeException("Erreur lors de la récupération de toutes les notes: " + e);
        }
    }

    public Optional<Note> getNoteById(int id) {
        try {
            return noteRepository.findById(id);
        } catch (SQLException e) {
            throw new RuntimeException("Erreur lors de la récupération de la note par ID " + id + ": " + e);
        }
    }

    public Note updateNote(Note note) {
        try {
            noteRepository.update(note);
            return note;
        } catch (SQLException e) {
            throw new RuntimeException("Erreur lors de la mise à jour de la note " + note + ": " + e);
        }
    }

    public void deleteNote(int id) {
        try {
            noteRepository.delete(id);
        } catch (SQLException e) {
            throw new RuntimeException("Erreur lors de la suppression de la note " + id + ": " + e);
        }
    }

    public List<Note> getAllNotesForStudent(int studentId) {
        try {
            return noteRepository.getAllNotesForStudent(studentId);
        } catch (SQLException e) {
            throw new RuntimeException("Erreur lors de la récupération de toutes les notes pour l'étudiant " + studentId + ": " + e);
        }
    }

    public List<Note> getAllNotesForSubject(int subjectId) {
        try {
            return noteRepository.getAllNotesForSubject(subjectId);
        } catch (SQLException e) {
            throw new RuntimeException("Erreur lors de la récupération de toutes les notes pour la matière " + subjectId + ": " + e);
        }
    }

    public float getAverageNoteForStudent(int studentId) {
        try {
            return noteRepository.getAverageNoteForStudent(studentId);
        } catch (SQLException e) {
            throw new RuntimeException("Erreur lors du calcul de la moyenne des notes pour l'étudiant " + studentId + ": " + e);
        }
    }
}
