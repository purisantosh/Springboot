package com.example.demo.service;

import com.example.demo.Repository.SubmissionRepositoryImpl;
import com.example.demo.entity.SubmissionDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SubmissionServiceImplTest {

    private static SubmissionServiceImpl submissionService;
    private static SubmissionDTO sdto;

    @BeforeAll
    public static void  setUp(){
        submissionService = new SubmissionServiceImpl();
        submissionService.setRepo(new SubmissionRepositoryImpl(new HashMap<String,SubmissionDTO>()));

        sdto = submissionService.addSubmission(new SubmissionDTO());
        submissionService.modifySubmission(new SubmissionDTO(sdto.getId(),"Santosh","","Sagar2","","","Rohit123",""));

    }

    @Test
    void getSubmissionById() {
        SubmissionDTO sdto1 = submissionService.getSubmissionById(sdto.getId());

        Assertions.assertNotNull(sdto1);
        Assertions.assertEquals(sdto.getId(),sdto1.getId());
    }

    @Test
    void addSubmission() {
        SubmissionDTO sdto1 = submissionService.addSubmission(new SubmissionDTO("","Santosh","","Sagar1","","","Rohit123",""));
        Assertions.assertNotNull(sdto1);
        Assertions.assertEquals("Santosh",sdto1.getConsultantName());
        Assertions.assertEquals("Sagar1",sdto1.getLeadName());
    }

    @Test
    void modifySubmission() {
        SubmissionDTO sdto1 = submissionService.modifySubmission(new SubmissionDTO(sdto.getId(),"Santosh","","Sagar2","","","Rohit123",""));
        Assertions.assertNotNull(sdto1);
        Assertions.assertEquals("Santosh",sdto1.getConsultantName());
    }

    @Test
    void deleteSubmission() {
        submissionService.deleteSubmission(sdto.getId());

        SubmissionDTO sdto1=submissionService.getSubmissionById(sdto.getId());
        Assertions.assertNull(sdto1);
    }

    @Test
    void filterBySalesPerson() {
        SubmissionDTO sdto1 = submissionService.addSubmission(new SubmissionDTO("","Santosh","","Sagar","","","Rohit",""));
        SubmissionDTO sdto2 = submissionService.addSubmission(new SubmissionDTO("","Santosh","","Sagar","","","Rohit",""));
        SubmissionDTO sdto3 = submissionService.addSubmission(new SubmissionDTO("","Santosh","","Sagar","","","Rohit",""));



        List<SubmissionDTO> filteredList = submissionService.filterBySalesPerson("Rohit");

       Assertions.assertNotNull(filteredList);
       Assertions.assertEquals(3,filteredList.size());

    }
}