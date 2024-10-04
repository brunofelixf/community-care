package com.brunofelix.community_care.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brunofelix.community_care.application.dto.CommunityCenterDTO;
import com.brunofelix.community_care.application.dto.CommunityCenterNoIdDTO;
import com.brunofelix.community_care.application.mapper.CommunityCenterMapper;
import com.brunofelix.community_care.domain.model.CommunityCenter;
import com.brunofelix.community_care.domain.service.CommunityCenterService;
import com.brunofelix.community_care.exception.ResourceNotFoundException;

import jakarta.validation.Valid;
@RestController
@RequestMapping("/api/community-centers")
public class CommunityCenterController {

    @Autowired
    private CommunityCenterService service;

    @PostMapping("/create")
    public ResponseEntity<CommunityCenterDTO> createCommunityCenter(@Valid @RequestBody CommunityCenterDTO communityCenterDTO){
        CommunityCenter communityCenter = CommunityCenterMapper.toEntity(communityCenterDTO);
        CommunityCenter createdCommunityCenter = service.save(communityCenter);
        CommunityCenterDTO createdCommunityCenterDTO = CommunityCenterMapper.toDTO(createdCommunityCenter);
        return ResponseEntity.status(201).body(createdCommunityCenterDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommunityCenterNoIdDTO> getCommunityCenter(@PathVariable Long id) {
        return service.findById(id)
                .map(CommunityCenter -> ResponseEntity.ok(CommunityCenterMapper.toDtoWithoutId(CommunityCenter)))
                .orElseThrow(() -> new ResourceNotFoundException("Community Center not found"));
    }

    @GetMapping("")
    public ResponseEntity<List<CommunityCenterDTO>> getAllCommunityCenters() {
        List<CommunityCenter> centers = service.findAll();
        List<CommunityCenterDTO> centersDTO = centers
            .stream()
            .map(CommunityCenterMapper::toDTO).toList();
        return ResponseEntity.ok(centersDTO);
    }

}
