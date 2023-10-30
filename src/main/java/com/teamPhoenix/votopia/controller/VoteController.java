package com.teamPhoenix.votopia.controller;

import com.teamPhoenix.votopia.dto.APICustomResponse;
import com.teamPhoenix.votopia.dto.GenericController;
import com.teamPhoenix.votopia.entity.Vote;
import com.teamPhoenix.votopia.service.VoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/api/vote")
@RequiredArgsConstructor
public class VoteController extends GenericController {
    private final VoteService voteService;

    @GetMapping
    public ResponseEntity<APICustomResponse> getVotes(){
        List<Vote> votes=voteService.getAll();
        if (votes.isEmpty())
            return createResponse(null,"No votes found", NOT_FOUND);

        return createResponse(votes, "Votes retrieved successfully", OK);
    }

    @PostMapping
    public ResponseEntity<APICustomResponse> castVote(@RequestBody Vote vote){
        Vote vote1=voteService.castVote(vote);
        if (vote1==null)
            return createResponse(null,"Vote not cast", NOT_FOUND);

        return createResponse(vote1, "Vote cast successfully", CREATED);
    }
}
