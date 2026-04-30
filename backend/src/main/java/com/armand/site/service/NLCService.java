package com.armand.site.service;

import com.armand.site.repository.NLCRepository;
import org.springframework.stereotype.Service;

@Service
public class NLCService {
    private final NLCRepository nlcRepository;

    public NLCService(NLCRepository nlcRepository) { this.nlcRepository = nlcRepository; }
}
