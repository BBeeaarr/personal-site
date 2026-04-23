package com.armand.site.api.dto;

import java.time.OffsetDateTime;

public record ProjectResponse (
    String slug,
    String title,
    String summary,
    OffsetDateTime createdAt
) {};
