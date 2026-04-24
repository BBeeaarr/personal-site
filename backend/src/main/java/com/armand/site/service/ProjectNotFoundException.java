package com.armand.site.service;

public class ProjectNotFoundException extends RuntimeException {

    public ProjectNotFoundException(String slug) {
        super("Project not found: slug=" + slug);
    }
}
