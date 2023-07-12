package com.example.demo.service;

import com.example.demo.Repository.SubmissionRepositoryImpl;
import com.example.demo.entity.SubmissionDTO;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubmissionServiceImpl implements SubmissionService {

    @Autowired
    private SubmissionRepositoryImpl submissionRepositoryImpl;

    public void setRepo(SubmissionRepositoryImpl srb)
    {
        this.submissionRepositoryImpl = srb;
    }

    @Override
    public SubmissionDTO getSubmissionById(String id) {

        return submissionRepositoryImpl.getSubmissionById(id);
    }

    @Override
    public SubmissionDTO addSubmission(SubmissionDTO submissionDTO) {
        return submissionRepositoryImpl.addSubmission(submissionDTO);
    }

    @Override
    public SubmissionDTO modifySubmission(SubmissionDTO submissionDTO) {
        return submissionRepositoryImpl.modifySubmission(submissionDTO);
    }

    @Override
    public void deleteSubmission(String id) {
        submissionRepositoryImpl.deleteSubmission(id);
    }

    @Override
    public List<SubmissionDTO> filterBySalesPerson(String salesPerson) {
        return submissionRepositoryImpl.filterBySalesPerson(salesPerson);
    }
}
