package com.teamPhoenix.votopia.repository;

import com.teamPhoenix.votopia.entity.VoterIdentification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoterIdentificationRepository extends JpaRepository<VoterIdentification, Long> {
    Boolean existsByIdNumber(String idNumber);

    VoterIdentification findByIdNumber(String voterIdentification);
}
