package com.teamPhoenix.votopia.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "parties")
@Setter
@Getter
public class Party {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "party_id")
    private Long partyID;
    @Column(name = "party_name")
    private String partyName;
    @Column(name = "party_symbol")
    private String partySymbol;
    @Column(name = "party_leader")
    private String partyLeader;
    @Column(name = "party_description")
    private String partyDescription;
}

