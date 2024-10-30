package com.acme.controller;

import com.acme.model.ProjectMember;
import com.acme.service.ProjectMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/project")
@RequiredArgsConstructor
public class ProjectMemberController {

    private final ProjectMemberService projectMemberService;

    @PutMapping("/{projectId}/members/{memberId}")
    public ResponseEntity<ProjectMember> addMemberToProject(@PathVariable Long projectId,
                                                            @PathVariable Long memberId) {
        projectMemberService.addMemberToProject(projectId, memberId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<ProjectMember>> getAllProjectMembers() {
        List<ProjectMember> members = projectMemberService.getAllProjectMembers();
        return new ResponseEntity<>(members, HttpStatus.OK);
    }

    @DeleteMapping("/{id}/member")
    public ResponseEntity<Void> removeMemberFromProject(@PathVariable Long id) {
        projectMemberService.removeMemberFromProject(id);
        return ResponseEntity.noContent().build();
    }

}
