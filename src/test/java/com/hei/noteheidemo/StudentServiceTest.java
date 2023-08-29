package com.hei.noteheidemo;

import com.hei.noteheidemo.Entity.Student;
import com.hei.noteheidemo.Repository.StudentRepository;
import com.hei.noteheidemo.Service.StudentService;
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

public class StudentServiceTest {
    private StudentService studentService;

    @Mock
    private StudentRepository studentRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        studentService = new StudentService(studentRepository);
    }

    @Test
    void testCreateStudent() throws SQLException {
        Student student = new Student(1, "Doe", "John", "STD22001", 1);

        doNothing().when(studentRepository).insert(student);

        studentService.insert(student);

        verify(studentRepository, times(1)).insert(student);
    }

    @Test
    void testGetAllStudents() throws SQLException {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Doe", "John", "STD22001", 1));
        students.add(new Student(2, "Smith", "Jane", "STD22002", 2));
        when(studentRepository.findAll()).thenReturn(students);

        List<Student> result = studentService.findAllStudents();

        assertEquals(students, result);
        verify(studentRepository, times(1)).findAll();
    }

    @Test
    void testGetStudentById() throws SQLException {
        int studentId = 1;
        Student student = new Student(studentId, "Doe", "John", "STD22001", 1);

        when(studentRepository.findById(studentId)).thenReturn(Optional.of(student));

        Optional<Student> result = studentService.findStudentById(studentId);

        assertEquals(student, result.orElse(null));
        verify(studentRepository, times(1)).findById(studentId);
    }

    @Test
    void testUpdateStudent() throws SQLException {
        Student student = new Student(1, "Doe", "John", "STD22001", 1);

        studentService.updateStudent(student);

        verify(studentRepository, times(1)).update(student);
    }

    @Test
    void testDeleteStudent() throws SQLException {
        int studentId = 1;
        studentService.deleteStudent(studentId);

        verify(studentRepository, times(1)).delete(studentId);
    }
}

