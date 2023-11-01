package com.teamPhoenix.votopia.repository;

import com.teamPhoenix.votopia.entity.Election;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ElectionRepository extends JpaRepository<Election, Long> {
    @Query(value = "select * from election", nativeQuery = true)
    List<Election> getAllElections();
}
