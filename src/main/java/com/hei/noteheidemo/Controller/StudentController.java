package com.hei.noteheidemo.Controller;

import com.hei.noteheidemo.Entity.Student;
import com.hei.noteheidemo.Service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {
    public StudentService studentService ;

    public StudentController(StudentService studentService){
        this.studentService = studentService ;
    }
    @PostMapping("/student")
    public Student insertStudent(@RequestBody Student toInsert){
        return studentService.insert(toInsert) ;
    }
    @GetMapping("/students")
    public List<Student> getAllStudents(){
        return studentService.findAllStudents() ;
    }
    @GetMapping("/student/{id}")
    public Optional<Student> getStudentByID(@PathVariable int id){
        return studentService.findStudentById(id) ;
    }
    @PutMapping("/studentUpdate/{id}")
    public Student updateStudent(@PathVariable int id, @RequestBody Student updatedStudent) {
        if (updatedStudent.getId() != id) {
            throw new IllegalArgumentException("ID mismatch between URL and request body");
        }
        return studentService.updateStudent(updatedStudent);
    }

    @DeleteMapping("/student/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable int id) {
        studentService.deleteStudent(id);
        return ResponseEntity.ok("Student with ID " + id + " has been deleted.");
    }
}
