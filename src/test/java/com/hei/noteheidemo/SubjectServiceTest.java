package com.hei.noteheidemo;
import com.hei.noteheidemo.Entity.Subject;
import com.hei.noteheidemo.Repository.SubjectRepository;
import com.hei.noteheidemo.Service.SubjectService;
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

public class SubjectServiceTest {
    private SubjectService subjectService;

    @Mock
    private SubjectRepository subjectRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        subjectService = new SubjectService(subjectRepository);
    }

    @Test
    void testCreateSubject() throws SQLException {
        Subject subject = new Subject(1, "PROG1", 3);

        doNothing().when(subjectRepository).insert(subject);

        subjectService.createSubject(subject);

        verify(subjectRepository, times(1)).insert(subject);
    }

    @Test
    void testGetAllSubjects() throws SQLException {
        List<Subject> subjects = new ArrayList<>();
        subjects.add(new Subject(1, "PROG1", 3));
        subjects.add(new Subject(2, "WEB1", 2));
        when(subjectRepository.findAll()).thenReturn(subjects);

        List<Subject> result = subjectService.getAllSubjects();

        assertEquals(subjects, result);
        verify(subjectRepository, times(1)).findAll();
    }

    @Test
    void testGetSubjectById() throws SQLException {
        int subjectId = 1;
        Subject subject = new Subject(subjectId, "PROG1", 3);

        when(subjectRepository.findById(subjectId)).thenReturn(Optional.of(subject));

        Optional<Subject> result = subjectService.getSubjectById(subjectId);

        assertEquals(subject, result.orElse(null));
        verify(subjectRepository, times(1)).findById(subjectId);
    }

    @Test
    void testUpdateSubject() throws SQLException {
        Subject subject = new Subject(1, "PROG1", 3);

        subjectService.updateSubject(subject);

        verify(subjectRepository, times(1)).update(subject);
    }

    @Test
    void testDeleteSubject() throws SQLException {
        int subjectId = 1;
        subjectService.deleteSubject(subjectId);

        verify(subjectRepository, times(1)).delete(subjectId);
    }
}
