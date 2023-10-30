package com.teamPhoenix.votopia.controller;

import com.teamPhoenix.votopia.dto.APICustomResponse;
import com.teamPhoenix.votopia.dto.GenericController;
import com.teamPhoenix.votopia.entity.Candidate;
import com.teamPhoenix.votopia.service.CandidateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/candidate")
@RequiredArgsConstructor
public class CandidateController extends GenericController {
    private final CandidateService candidateService;

    @GetMapping
    public ResponseEntity<APICustomResponse> getCandidates(){
        List<Candidate> candidates=candidateService.getCandidates();
        if (candidates.isEmpty())
            return createResponse(null,"No candidates found", NOT_FOUND);
        return createResponse(candidates, "Candidates retrieved successfully", OK);
    }

    @PostMapping
    public ResponseEntity<APICustomResponse> addCandidate(@RequestBody Candidate candidate){
        Candidate candidate1=candidateService.addCandidate(candidate);
        if (candidate1==null)
            return createResponse(null,"Candidate not added", NOT_FOUND);
        return createResponse(candidate1, "Candidate added successfully", CREATED);
    }
}
