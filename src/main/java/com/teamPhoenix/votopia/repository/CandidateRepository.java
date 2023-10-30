package com.teamPhoenix.votopia.repository;

import com.teamPhoenix.votopia.entity.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {

}
