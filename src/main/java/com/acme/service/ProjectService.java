package com.acme.service;

import com.acme.crosscutting.exceptions.ManagerNotFoundException;
import com.acme.crosscutting.exceptions.ProjectNotFoundException;
import com.acme.model.Person;
import com.acme.model.Project;
import com.acme.repository.ProjectRepository;
import com.acme.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;
    private final PersonRepository personRepository;

    public Project createProject(Project project) {
        Person manager = personRepository.findById(project.getManager().getId())
            .orElseThrow(() -> new ManagerNotFoundException("Gerente não encontrado"));
        project.setManager(manager);
        return projectRepository.save(project);
    }

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public Project getProjectById(Long id) {
        return projectRepository.findById(id)
            .orElseThrow(() -> new ProjectNotFoundException("Projeto não encontrado"));
    }

    public Project updateProject(Long id, Project updatedProject) {
        Project existingProject = projectRepository.findById(id)
            .orElseThrow(() -> new ProjectNotFoundException("Projeto não encontrado"));
        existingProject.setName(updatedProject.getName());
        existingProject.setStartDate(updatedProject.getStartDate());
        existingProject.setExpectedEndDate(updatedProject.getExpectedEndDate());
        existingProject.setEndDate(updatedProject.getEndDate());
        existingProject.setDescription(updatedProject.getDescription());
        existingProject.setStatus(updatedProject.getStatus());
        existingProject.setBudget(updatedProject.getBudget());
        existingProject.setRisk(updatedProject.getRisk());

        Person manager = personRepository.findById(updatedProject.getManager().getId())
            .orElseThrow(() -> new ManagerNotFoundException("Gerente não encontrado"));
        existingProject.setManager(manager);

        return projectRepository.save(existingProject);
    }

    public void deleteProject(Long id) {
        Project project = projectRepository.findById(id)
            .orElseThrow(() -> new ProjectNotFoundException("Projeto não encontrado"));
        if ("iniciado".equals(project.getStatus()) || "em andamento".equals(project.getStatus()) || "encerrado".equals(project.getStatus())) {
            throw new RuntimeException("Projeto não pode ser excluído.");
        }
        projectRepository.deleteById(id);
    }

    public Project findById(Long projectId) {
        return projectRepository.findById(projectId)
            .orElseThrow(() -> new ProjectNotFoundException("Projeto não encontrado"));
    }

    public Project insert(Project project) {
        return projectRepository.save(project);
    }
}
