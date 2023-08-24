package com.hei.noteheidemo.Service;

import com.hei.noteheidemo.Entity.Evaluations;
import com.hei.noteheidemo.Repository.EvaluationsREPOSITORY;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class EvaluationsService {
    private EvaluationsREPOSITORY evaluationsREPOSITORY ;
    public  EvaluationsService(EvaluationsREPOSITORY evaluationsREPOSITORY){
        this.evaluationsREPOSITORY =  evaluationsREPOSITORY ;
    }

    public Evaluations addEvaluation (Evaluations toInsert){
        try{
            evaluationsREPOSITORY.insert(toInsert);
            return toInsert ;
        }catch (SQLException e){
            throw new RuntimeException("There is a error when inserting evaluation" + e) ;
        }
    }

    public List<Evaluations> findAllEvaluation(){
        try{
            return evaluationsREPOSITORY.findAll() ;
        }catch (SQLException e){
            throw  new RuntimeException("There is a error when fetching evaluations" +e) ;
        }
    }

    public Optional<Evaluations> findEvaluationById(int id){
        try {
            return evaluationsREPOSITORY.findById(id) ;
        }catch (SQLException e){
            throw  new RuntimeException("There is a error when fetching evaluation by id " + id + e) ;
        }
    }

    public Evaluations updateEvaluation(Evaluations toUpdate){
        try{
            evaluationsREPOSITORY.update(toUpdate);
            return toUpdate ;
        }catch (SQLException e){
            throw new RuntimeException("There is a error when updating " + toUpdate + e) ;
        }
    }
    public void  deleteEvaluation(int id){
        try{
            evaluationsREPOSITORY.delete(id);
        }catch (SQLException e){
            throw new RuntimeException("There is a error when deleting evaluation" + id + e ) ;
        }
    }
}
