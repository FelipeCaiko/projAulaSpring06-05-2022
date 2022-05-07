package br.com.projAulaSpring.controller;
import br.com.projAulaSpring.constant.Constants;
import br.com.projAulaSpring.model.Assessment;
import br.com.projAulaSpring.service.AssessmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class AssessmentController {

    @Autowired
    private AssessmentService assessmentService;

    @PostMapping(Constants.API_ASSESSMENT)
    public void save(@RequestBody Assessment assessment){
        assessmentService.sendAssessmentRabbit(assessment);
    }

    @GetMapping(Constants.API_ASSESSMENT)
    public List<Assessment> findAll(){
        return assessmentService.findAll();
    }

    @PutMapping(Constants.API_ASSESSMENT)
    public void update(@RequestBody Assessment assessment){
        assessmentService.save(assessment);
    }

    @DeleteMapping(Constants.API_ASSESSMENT + "/{id}")
    public void delete(@PathVariable("id") String id){
        assessmentService.delete(id);
    }

    @GetMapping(Constants.API_ASSESSMENT + "/{id}")
    public Optional<Assessment> findById(@PathVariable("id") String id){
        return assessmentService.findById(id);
    }
}