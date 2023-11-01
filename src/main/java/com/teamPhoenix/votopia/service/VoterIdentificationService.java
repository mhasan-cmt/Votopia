package com.teamPhoenix.votopia.service;

import com.teamPhoenix.votopia.entity.VoterIdentification;

public interface VoterIdentificationService {
    Boolean validateIdentificationNumber(String voterIdentificationNumber);

    VoterIdentification findByIdNumber(String voterIdentification);
}
