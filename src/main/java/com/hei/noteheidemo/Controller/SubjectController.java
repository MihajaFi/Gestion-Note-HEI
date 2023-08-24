package com.hei.noteheidemo.Controller;

import com.hei.noteheidemo.Entity.Subject;
import com.hei.noteheidemo.Service.SubjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class SubjectController {
    private final SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @PostMapping("/subject-create")
    public ResponseEntity<String> createSubject(@RequestBody Subject subject) {
        subjectService.createSubject(subject);
        return ResponseEntity.status(HttpStatus.CREATED).body("Subject created successfully");
    }

    @GetMapping("/subjects")
    public List<Subject> getAllSubjects() {
        return subjectService.getAllSubjects();
    }

    @GetMapping("/subjects/{id}")
    public Optional<Subject> getSubjectById(@PathVariable int id) {
        return subjectService.getSubjectById(id);
    }

    @PutMapping("/subjects/{id}")
    public Subject updateSubject(@PathVariable int id, @RequestBody Subject subject) {
        if (subject.getId() != id) {
            throw new IllegalArgumentException("ID mismatch between URL and request body");
        }
        return subjectService.updateSubject(subject);
    }

    @DeleteMapping("/subjects/{id}")
    public ResponseEntity<String> deleteSubject(@PathVariable int id) {
        subjectService.deleteSubject(id);
        return ResponseEntity.ok("Subject with ID " + id + " has been deleted.");
    }
}
