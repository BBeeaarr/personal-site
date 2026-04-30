package com.armand.site.api.dto.NLC;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.OffsetDateTime;
import java.util.List;

public record NLCRequest (
    @NotBlank
    @JsonProperty("challenge_id")
    String challengeId,

    @NotNull
    @JsonProperty("schema_version")
    int schemaVersion,

    @NotNull
    @JsonProperty("generated_at")
    OffsetDateTime generatedAt,

    @NotEmpty
    @JsonProperty("cases")
    List<NLCCurrentCase> cases
) {}
