package com.hei.noteheidemo;

import com.hei.noteheidemo.Entity.Note;
import com.hei.noteheidemo.Repository.NoteRepository;
import com.hei.noteheidemo.Service.NoteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class NoteServiceTest {
    private NoteService noteService;

    @Mock
    private NoteRepository noteRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        noteService = new NoteService(noteRepository);
    }

    @Test
    void testCreateNote() throws SQLException {
        Note note = new Note(1, 1, 1, 90.0f);

        doNothing().when(noteRepository).insert(note);

        noteService.createNote(note);

        verify(noteRepository, times(1)).insert(note);
    }

    @Test
    void testGetAllNotes() throws SQLException {
        List<Note> notes = new ArrayList<>();
        notes.add(new Note(1, 1, 1, 90.0f));
        notes.add(new Note(2, 2, 2, 85.0f));
        when(noteRepository.findAll()).thenReturn(notes);

        List<Note> result = noteService.getAllNotes();

        assertEquals(notes, result);
        verify(noteRepository, times(1)).findAll();
    }

    @Test
    void testGetNoteById() throws SQLException {
        int noteId = 1;
        Note note = new Note(noteId, 1, 1, 90.0f);

        when(noteRepository.findById(noteId)).thenReturn(Optional.of(note));

        Optional<Note> result = noteService.getNoteById(noteId);

        assertEquals(note, result.orElse(null));
        verify(noteRepository, times(1)).findById(noteId);
    }

    @Test
    void testUpdateNote() throws SQLException {
        Note note = new Note(1, 1, 1, 90.0f);

        noteService.updateNote(note);

        verify(noteRepository, times(1)).update(note);
    }

    @Test
    void testDeleteNote() throws SQLException {
        int noteId = 1;
        noteService.deleteNote(noteId);

        verify(noteRepository, times(1)).delete(noteId);
    }
}
