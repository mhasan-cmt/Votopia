package com.teamPhoenix.votopia.service;

import com.teamPhoenix.votopia.entity.Candidate;

import java.util.List;

public interface CandidateService {
    List<Candidate> getCandidates();
    Candidate addCandidate(Candidate candidate);
}
