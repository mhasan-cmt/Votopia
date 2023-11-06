package com.teamPhoenix.votopia.service.impl;

import com.teamPhoenix.votopia.entity.Election;
import com.teamPhoenix.votopia.entity.Status;
import com.teamPhoenix.votopia.repository.ElectionRepository;
import com.teamPhoenix.votopia.service.ElectionService;
import groovy.util.logging.Slf4j;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
@RequiredArgsConstructor
@Slf4j
public class ElectionServiceImpl implements ElectionService {
    private final ElectionRepository electionRepository;
    @Override
    public List<Election> getAll() {
        List<Election> elections=electionRepository.getAllElections();
        elections.forEach(Election::setStatus);
        return elections;
    }

    @Override
    public Election addElection(Election election) {
        return electionRepository.save(election);
    }
}
