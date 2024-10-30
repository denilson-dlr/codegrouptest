package com.acme.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "projeto")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false, length = 200)
    private String name;

    @Column(name = "data_inicio")
    private LocalDate startDate;

    @Column(name = "data_previsao_fim")
    private LocalDate expectedEndDate;

    @Column(name = "data_fim")
    private LocalDate endDate;

    @Column(name = "descricao", length = 5000)
    private String description;

    @Column(name = "status", length = 45)
    private String status;

    @Column(name = "orcamento")
    private BigDecimal budget;

    @Column(name = "risco", length = 45)
    private String risk;

    @ManyToOne
    @JoinColumn(name = "idgerente", nullable = false)
    private Person manager;

    @ManyToMany
    @JoinTable(
        name = "project_members",
        joinColumns = @JoinColumn(name = "project_id"),
        inverseJoinColumns = @JoinColumn(name = "person_id")
    )
    private List<Person> members;
}

//    @Enumerated(EnumType.STRING)
//    private ProjectStatusEnum status;
//
//    @Enumerated(EnumType.STRING)
//    private ProjectRiskEnum risk;
//
//    public void updateDetails(Project project) {
//        this.name = project.getName();
//        this.description = project.getDescription();
//        this.startDate = project.getStartDate();
//        this.expectedEndDate = project.getExpectedEndDate();
//        this.actualEndDate = project.getActualEndDate();
//        this.totalBudget = project.getTotalBudget();
//        this.status = project.getStatus();
//        this.risk = project.getRisk();
//    }
//}