package com.brunofelix.community_care.application.mapper;

import com.brunofelix.community_care.application.dto.LocationDTO;
import com.brunofelix.community_care.domain.model.Location;

public class LocationMapper {
        
        public static LocationDTO toDTO(Location location) {
    
            if(location == null) {
                return null;
            }
    
            LocationDTO dto = new LocationDTO();
            dto.setLatitude(location.getLatitude());
            dto.setLongitude(location.getLongitude());
            return dto;
        }
        
        public static Location toEntity(LocationDTO dto) {
    
            if(dto == null) {
                return null;
            }
            
            Location location = new Location();
            location.setLatitude(dto.getLatitude());
            location.setLongitude(dto.getLongitude());
            return location;
        }
}
