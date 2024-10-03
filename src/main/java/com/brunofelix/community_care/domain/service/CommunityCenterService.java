package com.brunofelix.community_care.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brunofelix.community_care.domain.model.CommunityCenter;
import com.brunofelix.community_care.domain.repository.CommunityCenterRepository;

@Service
public class CommunityCenterService {

    @Autowired
    private CommunityCenterRepository repository;

    public CommunityCenter save(CommunityCenter communityCenter) {
        return repository.save(communityCenter);
    }

    public Optional<CommunityCenter> findById(Long id) {
        return repository.findById(id);
    }

    public List<CommunityCenter> findByName(String name) {
        return repository.findByName(name);
    }

    public List<CommunityCenter> findAll() {
        return repository.findAll();
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    
}
