package com.teamPhoenix.votopia.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "elections")
@Getter
@Setter
public class Election {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "election_id")
    private Long id;

    @Column(name = "election_name")
    @NotEmpty(message = "Election name cannot be empty")
    private String electionName;

    @Column(name = "election_start")
    @NotNull(message = "Election start date cannot be empty")
    private LocalDateTime electionStartDate;

    @Column(name = "election_end")
    @NotNull(message = "Election end date cannot be empty")
    private LocalDateTime electionEndDate;

    @Column(name = "election_status")
    @Enumerated(EnumType.STRING)
    private Status status;
}

