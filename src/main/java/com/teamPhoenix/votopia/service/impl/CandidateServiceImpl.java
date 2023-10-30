package com.teamPhoenix.votopia.service.impl;

import com.teamPhoenix.votopia.entity.Candidate;
import com.teamPhoenix.votopia.repository.CandidateRepository;
import com.teamPhoenix.votopia.service.CandidateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CandidateServiceImpl implements CandidateService {
    private final CandidateRepository candidateRepository;

    @Override
    public List<Candidate> getCandidates() {
        return candidateRepository.findAll();
    }

    @Override
    public Candidate addCandidate(Candidate candidate) {
        return candidateRepository.save(candidate);
    }
}
