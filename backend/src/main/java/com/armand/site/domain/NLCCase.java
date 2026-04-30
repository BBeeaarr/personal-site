package com.armand.site.domain;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "nlc_cases")
public class NLCCase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String caseId;

    @Column(nullable = false)
    private String caseDescription;

    @Column(nullable = false)
    private LocalDate caseDate;

    @Column(nullable = false)
    private String pastDescription;

    @Column(nullable = false)
    private LocalDate pastDate;

    @Column(nullable = true)
    private Boolean label;
}
