package com.armand.site.api.dto.NLC;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record NLCPrediction(
   @NotBlank
   @JsonProperty("case_id")
   String caseId,

   @NotBlank
   @JsonProperty("study_id")
   String studyId,

   @NotNull
   @JsonProperty("predicted_is_relevant")
   boolean predictedIsRelevant
) {}
