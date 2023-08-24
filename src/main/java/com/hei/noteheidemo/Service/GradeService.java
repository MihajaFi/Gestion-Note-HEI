package com.hei.noteheidemo.Service;

import com.hei.noteheidemo.Entity.Grade;
import com.hei.noteheidemo.Repository.GradeREPOSITORY;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class GradeService {
    private GradeREPOSITORY gradeREPOSITORY ;
    public GradeService(GradeREPOSITORY gradeREPOSITORY){
        this.gradeREPOSITORY = gradeREPOSITORY ;
    }

    public Grade insert(Grade toInsert){
        try{
            this.gradeREPOSITORY.insert(toInsert);
            return  toInsert ;
        }catch(SQLException e){
            throw new RuntimeException(("there has error while inserting grade")) ;
        }
    }
    public List<Grade> findAllGrades(){
        try{
            return   gradeREPOSITORY.findAll() ;
        }catch (SQLException e){
            throw  new RuntimeException(("There is a error when fetching all grades" + e)) ;
        }
    }

    public Optional<Grade> findGradeById(int id){
        try{
            return gradeREPOSITORY.findById(id) ;
        }catch(SQLException e){
            throw  new RuntimeException("there has been a error when fetching grade by id !" + id + e);
        }
    }
    public Grade updateGrade(Grade toUpdate){
        try{
            this.gradeREPOSITORY.update(toUpdate);
            return  toUpdate ;
        }catch (SQLException e){
            throw  new RuntimeException("there has a error when updating Grade by id " ) ;
        }
    }

    public void deleteGrade(int id) {
        try {
            gradeREPOSITORY.delete(id);
        } catch (SQLException e) {
            throw new RuntimeException("There was an error when deleting Grade with ID " + id, e);
        }
    }
    public Optional<Grade> findBySubject(String subject, int studentId) {
        try {
            return gradeREPOSITORY.findBySubject(subject, studentId);
        } catch (SQLException e) {
            throw new RuntimeException("There was an error when fetching Grade by subject : " + e.getMessage());
        }
    }
}
