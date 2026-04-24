package com.armand.site.api.dto;

import jakarta.annotation.Nullable;

import java.time.OffsetDateTime;

public record ProjectResponse (
    String slug,
    String title,
    String summary,
    OffsetDateTime createdAt,
    OffsetDateTime updatedAt
) {};
