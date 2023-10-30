package com.teamPhoenix.votopia.service;

import com.teamPhoenix.votopia.entity.Election;

import java.util.List;

public interface ElectionService {
    List<Election> getAll();
    Election addElection(Election election);
}
