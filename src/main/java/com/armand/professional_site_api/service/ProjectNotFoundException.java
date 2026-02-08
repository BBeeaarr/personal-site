package com.armand.professional_site_api.service;

public class ProjectNotFoundException extends RuntimeException {

    public ProjectNotFoundException(String slug) {
        super("Project not found: slug=" + slug);
    }
}
