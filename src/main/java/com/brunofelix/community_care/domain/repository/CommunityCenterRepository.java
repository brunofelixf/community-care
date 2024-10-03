package com.brunofelix.community_care.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brunofelix.community_care.domain.model.CommunityCenter;

public interface CommunityCenterRepository extends JpaRepository<CommunityCenter, Long> {
    List<CommunityCenter> findByName(String name);
}


