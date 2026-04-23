package com.armand.site.api;

import com.armand.site.api.dto.CreateProjectResponse;
import com.armand.site.api.dto.ProjectResponse;
import com.armand.site.api.dto.CreateProjectRequest;
import com.armand.site.service.ProjectService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @PostMapping
    public ResponseEntity<CreateProjectResponse> create(@RequestBody @Valid CreateProjectRequest request)
    {
        CreateProjectResponse created = projectService.create(request);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{slug}")
                .buildAndExpand(created.slug())
                .toUri();

        return ResponseEntity.created(location).body(created);
    }
}
