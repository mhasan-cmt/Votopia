package com.teamPhoenix.votopia.service.impl;

import com.teamPhoenix.votopia.entity.Party;
import com.teamPhoenix.votopia.repository.PartyRepository;
import com.teamPhoenix.votopia.service.PartyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class PartyServiceImpl implements PartyService {
    private final PartyRepository partyRepository;
    @Override
    public List<Party> getAll() {
        return partyRepository.findAll();
    }

    @Override
    public Party addParty(Party party) {
        return partyRepository.save(party);
    }
}
