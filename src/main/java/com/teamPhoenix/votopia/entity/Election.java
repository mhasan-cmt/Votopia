package com.teamPhoenix.votopia.entity;

import jakarta.persistence.*;
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
    private String electionName;

    @Column(name = "election_start")
    private LocalDateTime electionStartDate;

    @Column(name = "election_end")
    private LocalDateTime electionEndDate;

    @Column(name = "election_status")
    @Enumerated(EnumType.STRING)
    private Status status;
}

