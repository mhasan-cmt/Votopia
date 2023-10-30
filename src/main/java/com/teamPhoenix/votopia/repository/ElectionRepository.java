package com.teamPhoenix.votopia.repository;

import com.teamPhoenix.votopia.entity.Election;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ElectionRepository extends JpaRepository<Election, Long> {
}
