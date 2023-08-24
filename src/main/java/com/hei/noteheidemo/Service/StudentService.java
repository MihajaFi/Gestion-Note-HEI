package com.hei.noteheidemo.Service;

import com.hei.noteheidemo.Entity.Student;
import com.hei.noteheidemo.Repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public  class StudentService {
    private StudentRepository studentDAO ;
    public StudentService(StudentRepository studentDAO){
        this.studentDAO = studentDAO ;
    }
    public Student insert(Student toInsert){
        try{
            this.studentDAO.insert(toInsert);
            return  toInsert ;
        }catch(SQLException e){
            throw new RuntimeException(("there has error while insering data") ,e) ;
        }
    }

    public List<Student> findAllStudents(){
        try{
            return studentDAO.findAll() ;
        }catch (SQLException e){
            throw new RuntimeException("there has been a error when fetching all student") ;
        }
    }
    public Optional<Student> findStudentById(int id){
        try{
            return studentDAO.findById(id) ;
        }catch(SQLException e){
            throw  new RuntimeException("there has bee a error when fetching student by id !" + id);
        }
    }

    public Student updateStudent(Student toUpdate){
        try{
            this.studentDAO.update(toUpdate);
            return  toUpdate ;
        }catch (SQLException e){
            throw  new RuntimeException("there has a error when updating student by id ",e ) ;
        }
    }
    public void deleteStudent(int id) {
        try {
            studentDAO.delete(id);
        } catch (SQLException e) {
            throw new RuntimeException("There was an error when deleting student with ID " + id, e);
        }
    }
}
