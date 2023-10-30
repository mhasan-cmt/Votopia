package com.teamPhoenix.votopia.controller;

import com.teamPhoenix.votopia.dto.APICustomResponse;
import com.teamPhoenix.votopia.dto.GenericController;
import com.teamPhoenix.votopia.entity.Party;
import com.teamPhoenix.votopia.service.PartyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/api/party")
@RequiredArgsConstructor
public class PartyController extends GenericController {
    private final PartyService partyService;
    @GetMapping
    public ResponseEntity<APICustomResponse> getParties(){
        List<Party> parties=partyService.getAll();
        if (parties.isEmpty())
            return createResponse(null,"No parties found", NOT_FOUND);

        return createResponse(parties, "Parties retrieved successfully", OK);
    }

    @PostMapping
    public ResponseEntity<APICustomResponse> addParty(@RequestBody Party party){
        Party party1=partyService.addParty(party);
        if (party1==null)
            return createResponse(null,"Party not added", NOT_FOUND);

        return createResponse(party1, "Party added successfully", CREATED);
    }
}
