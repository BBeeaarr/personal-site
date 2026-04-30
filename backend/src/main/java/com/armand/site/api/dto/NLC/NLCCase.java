package com.armand.site.api.dto.NLC;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public record NLCCase (
    @NotBlank
    @JsonProperty("case_id")
    String caseId,

    @NotBlank
    @JsonProperty("patient_id")
    String patientId,

    @NotBlank
    @JsonProperty("patient_name")
    String patientName,

    @NotEmpty
    @JsonProperty("current_study")
    NLCStudy currentStudy,

    @NotEmpty
    @JsonProperty("prior_studies")
    List<NLCStudy> priorStudies
) {}