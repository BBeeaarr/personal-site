package com.armand.site.api;

import com.armand.site.api.dto.NLC.NLCCase;
import com.armand.site.api.dto.NLC.NLCPrediction;
import com.armand.site.api.dto.NLC.NLCResponse;
import com.armand.site.service.NLCService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/nlc")
public class NLCController {
    private final NLCService nlcService;

    public NLCController(NLCService nlcService) { this.nlcService = nlcService; }

    @PostMapping
    public ResponseEntity<NLCResponse> predict(){
        NLCResponse response = new NLCResponse(
                List.of(
                        new NLCPrediction(
                                "0",
                                "1",
                                false
                        )
                )
        );
        return ResponseEntity.ok(response);
    }
}
