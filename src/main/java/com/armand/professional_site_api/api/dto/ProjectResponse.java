package com.armand.professional_site_api.api.dto;

import java.time.OffsetDateTime;

public record ProjectResponse (
    String slug,
    String title,
    String summary,
    OffsetDateTime createdAt
) {};
