package com.teamPhoenix.votopia.service.impl;

import com.teamPhoenix.votopia.entity.Vote;
import com.teamPhoenix.votopia.repository.VoteRepository;
import com.teamPhoenix.votopia.service.VoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class VoteServiceImpl implements VoteService {
    private final VoteRepository voteRepository;
    @Override
    public List<Vote> getAll() {
        return voteRepository.findAll();
    }

    @Override
    public Vote castVote(Vote vote) {
        return voteRepository.save(vote);
    }
}
