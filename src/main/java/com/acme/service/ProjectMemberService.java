package com.acme.service;

import com.acme.model.ProjectMember;
import com.acme.repository.PersonRepository;
import com.acme.repository.ProjectMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectMemberService {

    private final ProjectMemberRepository projectMemberRepository;
    private final PersonService personService;
    private final ProjectService projectService;

    public void addMemberToProject(Long projectId, Long memberId) {
        var project = projectService.findById(projectId);

        var member = personService.findById(memberId);

        if (member.getIsEmployee()) {
            project.getMembers().add(member);
            projectService.insert(project);
//            ProjectMember projectMember = ProjectMember.builder()
//                .project(projectSaved)
//                .person(member)
//                .build();
//            projectMemberRepository.save(projectMember);
        } else {
            throw new RuntimeException("Somente funcionários podem ser associados a um projeto.");
        }
    }

    public List<ProjectMember> getAllProjectMembers() {
        return projectMemberRepository.findAll();
    }

    public List<ProjectMember> getAllProjectMembersByProjectId(Long projectId) {
        var project = projectService.findById(projectId);
        return projectMemberRepository.findAll();
    }

    public void removeMemberFromProject(Long id) {
        projectMemberRepository.deleteById(id);
    }
}
