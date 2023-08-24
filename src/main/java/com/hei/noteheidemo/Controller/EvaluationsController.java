package com.hei.noteheidemo.Controller;

import com.hei.noteheidemo.Entity.Evaluations;
import com.hei.noteheidemo.Service.EvaluationsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EvaluationsController {
    public EvaluationsService evaluationsService ;

    private EvaluationsController(EvaluationsService evaluationsService){
        this.evaluationsService = evaluationsService ;
    }

    @PostMapping("/AddEvaluation")
    public Evaluations insertEvaluation(@RequestBody Evaluations toInsert){
        return evaluationsService.addEvaluation(toInsert) ;
    }

    @GetMapping("/evaluations")
    public List<Evaluations> getAllEvaluations(){
        return evaluationsService.findAllEvaluation() ;
    }

    @GetMapping("/evaluation/{id}")
    public Optional<Evaluations> getEvaluationById(@PathVariable int id){
        return  evaluationsService.findEvaluationById(id) ;
    }

    @PutMapping("/evaluation/{id}")
    public Evaluations  updateEvaluationById(@PathVariable int id , @RequestBody Evaluations UpdatedEvaluation){
        if (UpdatedEvaluation.getId() != id) {
            throw new IllegalArgumentException("ID mismatch between URL and request body");
        }
        return evaluationsService.updateEvaluation(UpdatedEvaluation) ;
    }

    @DeleteMapping("/evaluation/{id}")
    public ResponseEntity<String> deleteEvaluation(@PathVariable int id) {
        evaluationsService.deleteEvaluation(id);
        return ResponseEntity.ok(" Evaluation with ID " + id + " has been deleted.");
    }

}
