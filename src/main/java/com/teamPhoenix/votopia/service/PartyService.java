package com.teamPhoenix.votopia.service;

import com.teamPhoenix.votopia.entity.Party;

import java.util.List;

public interface PartyService {
    List<Party> getAll();
    Party addParty(Party party);
}
