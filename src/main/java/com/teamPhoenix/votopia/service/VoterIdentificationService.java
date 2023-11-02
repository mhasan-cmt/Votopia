package com.teamPhoenix.votopia.service;

import com.teamPhoenix.votopia.entity.VoterIdentification;

import java.util.List;

public interface VoterIdentificationService {
    Boolean validateIdentificationNumber(String voterIdentificationNumber);

    VoterIdentification findByIdNumber(String voterIdentification);

    List<VoterIdentification> getAll();
}
