package com.armand.site.service;

import com.armand.site.api.dto.NLC.*;
import com.armand.site.repository.NLCRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class NLCService {
    private final NLCRepository nlcRepository;

    public NLCService(NLCRepository nlcRepository) { this.nlcRepository = nlcRepository; }

    public NLCResponse predict(NLCRequest request)
    {
        String challengeId = request.challengeId();
        int schemaVersion = request.schemaVersion();
        OffsetDateTime generatedAt = request.generatedAt(); //pretty sure this is gonna be a string
        List<NLCCurrentCase> nlcCaseList = request.cases();
        List<NLCPrediction> responses = new ArrayList<NLCPrediction>();


        for (NLCCurrentCase nlcCurrentCase : nlcCaseList)
        {
            String caseId = nlcCurrentCase.caseId();
            NLCStudy currentStudy = nlcCurrentCase.currentStudy();
            LocalDate currentDate = currentStudy.studyDate(); //pretty sure this is gonna be a string
            String currentDescription = currentStudy.studyDescription();
            RestTemplate restTemplate = new RestTemplate();
            String url = PREDICTION_SERVICE_URL;


            for (NLCStudy priorStudy : nlcCurrentCase.priorStudies())
            {
                String priorDescription = priorStudy.studyDescription();
                String priorId = priorStudy.studyId();
                LocalDate priorDate = priorStudy.studyDate();
                Map<String, Object> body = Map.of(
                        "query", currentDescription,
                        "text", priorDescription,
                        "query_date", currentDate,
                        "text_date", priorDate
                );


                ResponseEntity<Integer> response = restTemplate.postForEntity(url, body, Integer.class);

                responses.add(new NLCPrediction(
                        caseId,
                        priorId,
                        response.getBody() == 1 ? true : false
                ));
            }
        }
        return new NLCResponse(responses);
    }
}
