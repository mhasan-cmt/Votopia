package com.teamPhoenix.votopia.controller;

import com.teamPhoenix.votopia.dto.APICustomResponse;
import com.teamPhoenix.votopia.dto.GenericController;
import com.teamPhoenix.votopia.entity.VoterIdentification;
import com.teamPhoenix.votopia.service.VoterIdentificationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/voter-identification")
@RequiredArgsConstructor
public class VoterIdentificationController extends GenericController {
    private final VoterIdentificationService voterIdentificationService;
    @PostMapping
    public ResponseEntity<APICustomResponse> addVoterIdentification(@Valid @RequestBody VoterIdentification voterIdentification) {
        Boolean exists = voterIdentificationService.validateIdentificationNumber(voterIdentification.getIdNumber());

        if (exists)
            return createResponse(null, "Voter identification already exists", HttpStatus.MULTI_STATUS);
        return createResponse(voterIdentificationService.addVoterIdentification(voterIdentification), "Voter identification added successfully", HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<APICustomResponse> getAllIdentifications(){
        List<VoterIdentification> voterIdentifications = voterIdentificationService.getAll();
        return createResponse(voterIdentifications, "Voter identifications retrieved successfully", HttpStatus.OK);
    }
}
