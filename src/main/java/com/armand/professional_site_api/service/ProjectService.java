package com.armand.professional_site_api.service;

import com.armand.professional_site_api.domain.Project;
import com.armand.professional_site_api.repository.ProjectRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<Project> listProjectsNewestFirst() {
        return projectRepository.findAll(Sort.by(Sort.Direction.DESC, "createdAt"));
    }

    public Project getBySlugOrThrow(String slug) {
        return projectRepository.findBySlug(slug)
                .orElseThrow(() -> new ProjectNotFoundException(slug));
    }
}
