package com.teamPhoenix.votopia.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
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
    @Pattern(regexp = "\\d{10}", message = "Voter ID number must be a 10-digit number")
    private String idNumber;
    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    @Transient
    private Boolean isRegistered;
    public Boolean getIsRegistered() {
        return this.user != null;
    }

}
