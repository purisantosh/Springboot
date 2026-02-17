package com.example.demo.controller;

import com.example.demo.service.SubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.SubmissionDTO;

import java.util.List;

@RestController
@RequestMapping("/submission")
public class SubmissionController {
    //I am Srinivasu. I am adding changes to Submission Controller.

    @Autowired
    private SubmissionService submissionService;
    @GetMapping("/{id}")
    public ResponseEntity<SubmissionDTO> getSubmissionById(@PathVariable("id") String id)
    {
        SubmissionDTO submissionDTO = submissionService.getSubmissionById(id);
        return ResponseEntity.ok(submissionDTO);
    }

    @PostMapping("")
    public ResponseEntity<SubmissionDTO> addSubmission(@RequestBody SubmissionDTO submissionDTO)
    {
        SubmissionDTO submissionD = submissionService.addSubmission(submissionDTO);
        return new ResponseEntity<>(submissionDTO, HttpStatus.CREATED);
    }

    @PutMapping("")
    public SubmissionDTO modifySubmission(@RequestBody SubmissionDTO submissionDTO)
    {
        return submissionService.modifySubmission(submissionDTO);
    }

    @DeleteMapping("{id}")
    public void deleteSubmission(@PathVariable("id") String id)
    {
        submissionService.deleteSubmission(id);
    }

    @GetMapping("")
    public List<SubmissionDTO> filterBySalesPerson(@RequestParam("salesPerson") String salesPerson)
    {
        return submissionService.filterBySalesPerson(salesPerson);
    }
}
