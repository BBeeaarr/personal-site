package com.armand.site.api;

import com.armand.site.api.dto.NLC.NLCPrediction;
import com.armand.site.api.dto.NLC.NLCRequest;
import com.armand.site.api.dto.NLC.NLCResponse;
import com.armand.site.service.NLCService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/nlc/predict")
public class NLCController {
    private final NLCService nlcService;

    public NLCController(NLCService nlcService) { this.nlcService = nlcService; }

    @PostMapping
    public ResponseEntity<NLCResponse> predict(@RequestBody @Valid NLCRequest request){
        NLCResponse response = nlcService.predict(request);

        return ResponseEntity.ok(response);
    }
}
