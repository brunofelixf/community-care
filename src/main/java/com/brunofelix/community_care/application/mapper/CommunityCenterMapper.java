package com.brunofelix.community_care.application.mapper;

import com.brunofelix.community_care.application.dto.CommunityCenterDTO;
import com.brunofelix.community_care.application.dto.CommunityCenterNoIdDTO;
import com.brunofelix.community_care.domain.model.CommunityCenter;

public class CommunityCenterMapper {
        
        public static CommunityCenterDTO toDTO(CommunityCenter communityCenter) {

            if(communityCenter == null) {
                return null;
            }

            CommunityCenterDTO dto = new CommunityCenterDTO();
            dto.setId(communityCenter.getId());
            dto.setName(communityCenter.getName());
            dto.setAddress(communityCenter.getAddress());
            dto.setLocation(LocationMapper.toDTO(communityCenter.getLocation()));
            dto.setMaximumCapacity(communityCenter.getMaximumCapacity());
            dto.setCurrentOccupancy(communityCenter.getCurrentOccupancy());
            dto.setResources(ResourcesMapper.toDTO(communityCenter.getResources()));
            return dto;
        }

        public static CommunityCenterNoIdDTO toDtoWithoutId(CommunityCenter communityCenter) {

            if(communityCenter == null) {
                return null;
            }

            CommunityCenterNoIdDTO dto = new CommunityCenterNoIdDTO();
            dto.setName(communityCenter.getName());
            dto.setAddress(communityCenter.getAddress());
            dto.setLocation(LocationMapper.toDTO(communityCenter.getLocation()));
            dto.setMaximumCapacity(communityCenter.getMaximumCapacity());
            dto.setCurrentOccupancy(communityCenter.getCurrentOccupancy());
            dto.setResources(ResourcesMapper.toDTO(communityCenter.getResources()));
            return dto;
        }
        
        public static CommunityCenter toEntity(CommunityCenterDTO dto) {

            if(dto == null) {
                return null;
            }

            CommunityCenter communityCenter = new CommunityCenter();
            communityCenter.setId(dto.getId());
            communityCenter.setName(dto.getName());
            communityCenter.setAddress(dto.getAddress());
            communityCenter.setLocation(LocationMapper.toEntity(dto.getLocation()));
            communityCenter.setMaximumCapacity(dto.getMaximumCapacity());
            communityCenter.setCurrentOccupancy(dto.getCurrentOccupancy());
            communityCenter.setResources(ResourcesMapper.toEntity(dto.getResources()));
            return communityCenter;
        }
}
