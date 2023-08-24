package com.hei.noteheidemo.Controller;

import com.hei.noteheidemo.Entity.Grade;
import com.hei.noteheidemo.Service.GradeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class GradeController {
    public GradeService gradeService ;

    public GradeController(GradeService gradeService){
        this.gradeService = gradeService ;
    }
    @PostMapping("/grade")
    public Grade insertGrade(@RequestBody Grade toInsert){
        return gradeService.insert(toInsert) ;
    }

    @GetMapping("/grades")
    public List<Grade> getAllGrades(){
        return gradeService.findAllGrades() ;
    }
    @GetMapping("/grade/{id}")
    public Optional<Grade> getGradeByID(@PathVariable int id){
        return gradeService.findGradeById(id) ;
    }
    @PutMapping("/GradeUpdate/{id}")
    public Grade updateGrade(@PathVariable int id, @RequestBody Grade updatedGrade) {
        if (updatedGrade.getId() != id) {
            throw new IllegalArgumentException("ID mismatch between URL and request body");
        }
        return gradeService.updateGrade(updatedGrade);
    }


    @DeleteMapping("/grade/{id}")
    public ResponseEntity<String> deleteGrade(@PathVariable int id) {
        gradeService.deleteGrade(id);
        return ResponseEntity.ok("Grade with ID " + id + " has been deleted.");
    }
    @GetMapping("/findGradeStudentInSubject")
    public Optional<Grade> findBySubject(
            @RequestParam("subject") String subject,
            @RequestParam("student_id") int studentId) {
        return gradeService.findBySubject(subject, studentId);
    }

}
