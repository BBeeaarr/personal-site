package com.armand.site.service;

import com.armand.site.api.dto.NLC.NLCCurrentCase;
import com.armand.site.api.dto.NLC.NLCRequest;
import com.armand.site.api.dto.NLC.NLCResponse;
import com.armand.site.repository.NLCRepository;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;

@Service
public class NLCService {
    private final NLCRepository nlcRepository;

    public NLCService(NLCRepository nlcRepository) { this.nlcRepository = nlcRepository; }

    public NLCResponse predict(NLCRequest request)
    {
        String challengeId = request.challengeId();
        int schemaVersion = request.schemaVersion();
        OffsetDateTime generatedAt = request.generatedAt();
        List<NLCCurrentCase> nlcCaseList = request.cases();
    }
}
