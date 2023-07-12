package com.example.demo.Repository;

import com.example.demo.entity.SubmissionDTO;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class SubmissionRepositoryImpl implements SubmissionRepository{


    private Map<String,SubmissionDTO> submissionMap;
    public SubmissionRepositoryImpl(Map<String,SubmissionDTO> submissionMap)
    {

        this.submissionMap = submissionMap;
    }
    @Override
    public SubmissionDTO getSubmissionById(String id) {

        return submissionMap.get(id);
    }

    @Override
    public SubmissionDTO addSubmission(SubmissionDTO submissionDTO) {
        UUID uuid = UUID.randomUUID();
        String id = uuid.toString();
        submissionDTO.setId(id);
        submissionMap.put(id,submissionDTO);
        return submissionDTO;
    }

    @Override
    public SubmissionDTO modifySubmission(SubmissionDTO submissionDTO) {
        String id = submissionDTO.getId();
        submissionMap.put(id,submissionDTO);
        return  submissionDTO;
    }

    @Override
    public void deleteSubmission(String id) {
        submissionMap.remove(id);
    }

    @Override
    public List<SubmissionDTO> filterBySalesPerson(String salesPerson) {
        List<SubmissionDTO> result = new ArrayList<>();
        for (Map.Entry<String, SubmissionDTO> entry : submissionMap.entrySet()) {
            if(entry.getValue().getSalesPersonName().equals(salesPerson))
            {
                result.add(entry.getValue());
            }
        }
        return result;
    }
}
