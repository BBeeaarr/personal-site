package com.armand.site.service;

import com.armand.site.api.dto.CreateProjectRequest;
import com.armand.site.api.dto.UpdateProjectRequest;
import com.armand.site.domain.Project;
import com.armand.site.repository.ProjectRepository;
import com.armand.site.api.dto.ProjectResponse;

import jakarta.transaction.Transactional;
import org.springframework.dao.DataIntegrityViolationException;
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

    @Transactional
    public ProjectResponse create(CreateProjectRequest request)
    {
        if(projectRepository.existsBySlug(request.slug()))
        {
            throw new DuplicateSlugException(request.slug());
        }

        Project project = new Project(
                request.slug(),
                request.title(),
                request.summary()
        );
        try
        {
            Project saved = projectRepository.save(project);
            return toResponse(saved);
        }
        catch (DataIntegrityViolationException ex)
        {
            throw new DataIntegrityViolationException(request.slug());
        }



    }

    public ProjectResponse update(String slug, UpdateProjectRequest request)
    {
        Project project = projectRepository.findBySlug(slug)
                .orElseThrow(() -> new ProjectNotFoundException(slug));

        project.setSummary(request.summary());
        project.setTitle(request.title());
        try
        {
            Project saved = projectRepository.save(project);
            return toResponse(saved);
        }
        catch (DataIntegrityViolationException ex)
        {
            throw new DataIntegrityViolationException(slug);
        }


    }

    private ProjectResponse toResponse(Project project) {
        return new ProjectResponse(
                project.getSlug(),
                project.getTitle(),
                project.getSummary(),
                project.getCreatedAt(),
                project.getUpdatedAt()
        );
    }
}
