package com.acme.service;

import com.acme.crosscutting.exceptions.ManagerNotFoundException;
import com.acme.crosscutting.exceptions.ProjectNotFoundException;
import com.acme.model.Person;
import com.acme.model.Project;
import com.acme.repository.PersonRepository;
import com.acme.repository.ProjectRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class ProjectServiceTest {

    @InjectMocks
    private ProjectService projectService;

    @Mock
    private ProjectRepository projectRepository;

    @Mock
    private PersonRepository personRepository;

    private Person manager;
    private Project project;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        manager = new Person();
        manager.setId(1L);
        manager.setName("Gerente 1");

        project = new Project();
        project.setId(1L);
        project.setName("Projeto 1");
        project.setManager(manager);
    }

    @Test
    void givenManager_whenCreateProject_thenSucess() {
        when(personRepository.findById(manager.getId())).thenReturn(Optional.of(manager));
        when(projectRepository.save(any(Project.class))).thenReturn(project);

        Project createdProject = projectService.createProject(project);

        assertNotNull(createdProject);
        assertEquals("Projeto 1", createdProject.getName());
        verify(personRepository).findById(manager.getId());
        verify(projectRepository).save(project);
    }

    @Test
    void givenManagerNotFound_whenCreateProject_thenError() {
        when(personRepository.findById(manager.getId())).thenReturn(Optional.empty());

        Exception exception = assertThrows(ManagerNotFoundException.class, () -> {
            projectService.createProject(project);
        });

        assertEquals("Gerente não encontrado", exception.getMessage());
        verify(projectRepository, never()).save(any(Project.class));
    }

    @Test
    void givenProjectId_whenSearch_thenSuccess() {
        when(projectRepository.findById(1L)).thenReturn(Optional.of(project));

        Project foundProject = projectService.getProjectById(1L);

        assertNotNull(foundProject);
        assertEquals("Projeto 1", foundProject.getName());
    }

    @Test
    void givenProjectId_whenSearch_thenNotFound() {
        when(projectRepository.findById(1L)).thenReturn(Optional.empty());

        Exception exception = assertThrows(ProjectNotFoundException.class, () -> {
            projectService.getProjectById(1L);
        });

        assertEquals("Projeto não encontrado", exception.getMessage());
    }

    @Test
    void givenData_whenUpdate_thenSuccess() {
        Project updatedProject = new Project();
        updatedProject.setId(1L);
        updatedProject.setName("Projeto Atualizado");
        updatedProject.setManager(manager);

        when(projectRepository.findById(1L)).thenReturn(Optional.of(project));
        when(personRepository.findById(manager.getId())).thenReturn(Optional.of(manager));
        when(projectRepository.save(any(Project.class))).thenReturn(updatedProject);

        Project result = projectService.updateProject(1L, updatedProject);

        assertEquals("Projeto Atualizado", result.getName());
        verify(projectRepository).findById(1L);
        verify(projectRepository).save(any(Project.class));
    }

    @Test
    void givenExistingProject_whenUptated_thenErrorNotFound() {
        when(projectRepository.findById(1L)).thenReturn(Optional.empty());

        Exception exception = assertThrows(ProjectNotFoundException.class, () -> {
            projectService.updateProject(1L, project);
        });

        assertEquals("Projeto não encontrado", exception.getMessage());
    }

    @Test
    void givenProjectId_whenDelete_thenSuccess() {
        when(projectRepository.findById(1L)).thenReturn(Optional.of(project));

        projectService.deleteProject(1L);

        verify(projectRepository).deleteById(1L);
    }


    @Test
    void givenStatusIniciado_whenDelete_ThenErrorNotAllowed() {
        project.setStatus("iniciado");
        when(projectRepository.findById(1L)).thenReturn(Optional.of(project));

        Exception exception = assertThrows(RuntimeException.class, () -> {
            projectService.deleteProject(1L);
        });

        assertEquals("Projeto não pode ser excluído com o status atual.", exception.getMessage());
        verify(projectRepository, never()).deleteById(1L);
    }
}
