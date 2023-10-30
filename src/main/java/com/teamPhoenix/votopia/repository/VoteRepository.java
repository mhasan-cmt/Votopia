package com.teamPhoenix.votopia.repository;

import com.teamPhoenix.votopia.entity.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoteRepository extends JpaRepository<Vote, Long> {
}
