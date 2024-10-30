package com.acme.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pessoa")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false, length = 100)
    private String name;

    @Column(name = "datanascimento")
    private LocalDate birthDate;

    @Column(name = "cpf", length = 14)
    private String cpf;

    @Column(name = "funcionario")
    private Boolean isEmployee;

    @Column(name = "gerente")
    private Boolean isManager;

    @OneToMany(mappedBy = "manager", cascade = CascadeType.ALL)
    private List<Project> projectsManaged;

    @ManyToMany(mappedBy = "members")
    private List<Project> projects;
}