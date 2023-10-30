package com.teamPhoenix.votopia.controller;

import com.teamPhoenix.votopia.dto.APICustomResponse;
import com.teamPhoenix.votopia.dto.GenericController;
import com.teamPhoenix.votopia.entity.Election;
import com.teamPhoenix.votopia.service.ElectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/api/election")
@RequiredArgsConstructor
public class ElectionController extends GenericController {
    private final ElectionService electionService;

    @GetMapping
    public ResponseEntity<APICustomResponse> getElections(){
        List<Election> elections=electionService.getAll();

        if (elections.isEmpty())
            return createResponse(null,"No elections found", NOT_FOUND);

        return createResponse(elections, "Elections retrieved successfully", OK);
    }

    @PostMapping
    public ResponseEntity<APICustomResponse> addElection(@RequestBody Election election){
        Election election1=electionService.addElection(election);

        if (election1==null)
            return createResponse(null,"Election not added", NOT_FOUND);

        return createResponse(election1, "Election added successfully", CREATED);
    }

    @PostMapping("/test")
    public String test(){
        return "Hello World";
    }


}
