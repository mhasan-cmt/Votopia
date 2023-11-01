package com.teamPhoenix.votopia.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "voter_identification")
@Getter
@Setter
public class VoterIdentification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "id_number")
    private String idNumber;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
