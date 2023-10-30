package com.teamPhoenix.votopia.repository;

import com.teamPhoenix.votopia.entity.Party;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartyRepository extends JpaRepository<Party, Long> {
}
