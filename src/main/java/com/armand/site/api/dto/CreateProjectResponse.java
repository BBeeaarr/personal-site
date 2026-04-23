package com.armand.site.api.dto;

import java.time.OffsetDateTime;

public record CreateProjectResponse(
        String slug,
        OffsetDateTime createdAt
) {}