package com.armand.site.domain;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "nlc_cases")
public class NLCCase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="case_id", nullable = false, unique = true)
    private String caseId;

    @Column(name="case_description", nullable = false)
    private String caseDescription;

    @Column(name="case_date", nullable = false)
    private LocalDate caseDate;

    @Column(name="past_description", nullable = false)
    private String pastDescription;

    @Column(name="past_date", nullable = false)
    private LocalDate pastDate;

    @Column(nullable = true)
    private Boolean label;
}
