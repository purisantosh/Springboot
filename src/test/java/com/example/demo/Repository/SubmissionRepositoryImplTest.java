package com.example.demo.Repository;

import com.example.demo.entity.SubmissionDTO;
import com.example.demo.service.SubmissionServiceImpl;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//import static jdk.internal.org.objectweb.asm.util.CheckClassAdapter.verify;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class SubmissionRepositoryImplTest {

public class SubmissionServiceImplTest {

        @Mock
        private SubmissionRepositoryImpl submissionRepositoryImpl;

        @InjectMocks
        private SubmissionServiceImpl submissionService;

        @Before
        public void setUp() {
            MockitoAnnotations.openMocks(this);
        }

        @Test
        public void testGetSubmissionById() {
            // Arrange
            String id = "1";
            SubmissionDTO expectedSubmission = new SubmissionDTO();
            when(submissionRepositoryImpl.getSubmissionById(id)).thenReturn(expectedSubmission);

            // Act
            SubmissionDTO actualSubmission = submissionService.getSubmissionById(id);

            // Assert
            Assertions.assertEquals(expectedSubmission, actualSubmission);
            //verify(submissionRepositoryImpl, times(1)).getSubmissionById(id);
        }

        @Test
        public void testAddSubmission() {
            // Arrange
            SubmissionDTO submissionDTO = new SubmissionDTO();
            when(submissionRepositoryImpl.addSubmission(submissionDTO)).thenReturn(submissionDTO);

            // Act
            SubmissionDTO addedSubmission = submissionService.addSubmission(submissionDTO);

            // Assert
            Assertions.assertEquals(submissionDTO, addedSubmission);
          // verify(submissionRepositoryImpl, times(1)).addSubmission(submissionDTO);
        }

        @Test
        public void testModifySubmission() {
            // Arrange
            SubmissionDTO submissionDTO = new SubmissionDTO();
            when(submissionRepositoryImpl.modifySubmission(submissionDTO)).thenReturn(submissionDTO);

            // Act
            SubmissionDTO modifiedSubmission = submissionService.modifySubmission(submissionDTO);

            // Assert
            Assertions.assertEquals(submissionDTO, modifiedSubmission);
           // verify(submissionRepositoryImpl, times(1)).modifySubmission(submissionDTO);
        }

        @Test
        public void testDeleteSubmission() {
            // Arrange
            String id = "1";

            // Act
            submissionService.deleteSubmission(id);

            // Assert
            //verify(submissionRepositoryImpl, times(1)).deleteSubmission(id);
        }

        @Test
        public void testFilterBySalesPerson() {
            // Arrange
            String salesPerson = "John Doe";
            List<SubmissionDTO> expectedList = new ArrayList<>();
            when(submissionRepositoryImpl.filterBySalesPerson(salesPerson)).thenReturn(expectedList);

            // Act
            List<SubmissionDTO> resultList = submissionService.filterBySalesPerson(salesPerson);

            // Assert
            Assertions.assertEquals(expectedList, resultList);
           // verify(submissionRepositoryImpl, times(1)).filterBySalesPerson(salesPerson);
        }
    }

}