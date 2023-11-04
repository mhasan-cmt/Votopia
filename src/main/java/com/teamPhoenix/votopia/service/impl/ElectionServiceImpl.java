package com.teamPhoenix.votopia.service.impl;

import com.teamPhoenix.votopia.entity.Election;
import com.teamPhoenix.votopia.entity.Status;
import com.teamPhoenix.votopia.repository.ElectionRepository;
import com.teamPhoenix.votopia.service.ElectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
@RequiredArgsConstructor
public class ElectionServiceImpl implements ElectionService {
    private final ElectionRepository electionRepository;
    @Override
    public List<Election> getAll() {
        return electionRepository.getAllElections();
    }

    @Override
    public Election addElection(Election election) {
        if (election.getElectionStartDate().isAfter(LocalDateTime.now())){
            election.setStatus(Status.Upcoming);
        }else if (election.getElectionEndDate().isBefore(LocalDateTime.now()) || election.getElectionEndDate().isEqual(LocalDateTime.now())) {
            election.setStatus(Status.Active);
        }else if (election.getElectionStartDate().isAfter(election.getElectionEndDate())){
            return null;
        }else if (election.getElectionStartDate().isBefore(LocalDateTime.now())){
            return null;
        }
        return electionRepository.save(election);
    }
}
