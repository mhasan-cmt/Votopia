package com.teamPhoenix.votopia.service;

import com.teamPhoenix.votopia.entity.Vote;

import java.util.List;

public interface VoteService {
    List<Vote> getAll();
    Vote castVote(Vote vote);
}
