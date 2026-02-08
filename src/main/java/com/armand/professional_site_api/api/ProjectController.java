package com.armand.professional_site_api.api;

import com.armand.professional_site_api.api.dto.ProjectResponse;
import com.armand.professional_site_api.service.ProjectService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public List<ProjectResponse> list() {
        return projectService.listProjectsNewestFirst();
    }

    @GetMapping("/{slug}")
    public ProjectResponse getBySlug(@PathVariable String slug) {
        return projectService.getBySlugOrThrow(slug);
    }

}
