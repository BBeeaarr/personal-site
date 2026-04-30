package com.armand.site.api.dto.NLC;

import jakarta.validation.constraints.NotEmpty;
import java.util.List;

public record NLCResponse (
     @NotEmpty
     List<NLCPrediction> predictions
) {}
