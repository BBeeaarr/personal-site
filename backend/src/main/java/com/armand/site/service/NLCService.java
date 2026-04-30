package com.armand.site.service;

import com.armand.site.api.dto.NLC.*;
import com.armand.site.repository.NLCRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
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

    @Value("${nlc.prediction-api-url")
    private String url;

    public NLCService(NLCRepository nlcRepository) { this.nlcRepository = nlcRepository; }

    public NLCResponse predict(NLCRequest request)
    {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<NLCResponse> response = restTemplate.exchange(
                url,
                HttpMethod.POST,
                new HttpEntity<>(request),
                NLCResponse.class
        );

        return response.getBody();
    }
}
