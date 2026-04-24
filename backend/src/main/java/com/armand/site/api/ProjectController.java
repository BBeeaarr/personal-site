package com.armand.site.api;

import com.armand.site.api.dto.ProjectResponse;
import com.armand.site.api.dto.CreateProjectRequest;
import com.armand.site.api.dto.UpdateProjectRequest;
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
    public ResponseEntity<ProjectResponse> getBySlug(@PathVariable String slug) {
        ProjectResponse response = projectService.getBySlugOrThrow(slug);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping
    public ResponseEntity<ProjectResponse> create(@RequestBody @Valid CreateProjectRequest request)
    {
        ProjectResponse created = projectService.create(request);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{slug}")
                .buildAndExpand(created.slug())
                .toUri();

        return ResponseEntity.created(location).body(created);
    }

    @PatchMapping("/{slug}")
    public ResponseEntity<ProjectResponse> update(@PathVariable String slug, @RequestBody @Valid UpdateProjectRequest request)
    {
        ProjectResponse response = projectService.update(slug, request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{slug}")
    public ResponseEntity<ProjectResponse> archive(@PathVariable String slug)
    {
        ProjectResponse response = projectService.delete(slug);
        return ResponseEntity.ok(response);
    }
}
