package com.teamPhoenix.votopia.service.impl;

import com.teamPhoenix.votopia.entity.VoterIdentification;
import com.teamPhoenix.votopia.repository.VoterIdentificationRepository;
import com.teamPhoenix.votopia.service.VoterIdentificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VoterIdentificationServiceImpl implements VoterIdentificationService {
    private final VoterIdentificationRepository voterIdentificationRepository;

    @Override
    public Boolean validateIdentificationNumber(String voterIdentificationNumber) {
        return voterIdentificationRepository.existsByIdNumber(voterIdentificationNumber);
    }

    @Override
    public VoterIdentification findByIdNumber(String voterIdentification) {
        return voterIdentificationRepository.findByIdNumber(voterIdentification);
    }

    @Override
    public List<VoterIdentification> getAll() {
        return voterIdentificationRepository.findAll();
    }

    @Override
    public VoterIdentification addVoterIdentification(VoterIdentification voterIdentification) {
        return voterIdentificationRepository.save(voterIdentification);
    }
}
