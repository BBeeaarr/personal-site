package com.armand.site.api.dto.NLC;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record NLCStudy (
   @NotBlank
   @JsonProperty("study_id")
   String studyId,

   @NotBlank
   @JsonProperty("study_description")
   String studyDescription,

   @NotBlank
   @JsonProperty("study_date")
   LocalDate studyDate
) {}

