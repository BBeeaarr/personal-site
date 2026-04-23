package com.armand.site.service;

import com.armand.site.domain.Project;
import com.armand.site.repository.ProjectRepository;
import com.armand.site.api.dto.ProjectResponse;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }


    public List<ProjectResponse> listProjectsNewestFirst() {
        return projectRepository
                .findAll(Sort.by(Sort.Direction.DESC, "createdAt"))
                .stream()
                .map(this::toResponse)
                .toList();

    }

    public ProjectResponse getBySlugOrThrow(String slug) {
        Project project = projectRepository.findBySlug(slug)
                .orElseThrow(() -> new ProjectNotFoundException(slug));

        return toResponse(project);
    }

    private ProjectResponse toResponse(Project project) {
        return new ProjectResponse(
                project.getSlug(),
                project.getTitle(),
                project.getSummary(),
                project.getCreatedAt()
        );
    }
}
