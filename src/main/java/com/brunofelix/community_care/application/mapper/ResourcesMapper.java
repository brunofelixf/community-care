package com.brunofelix.community_care.application.mapper;

import com.brunofelix.community_care.application.dto.ResourcesDTO;
import com.brunofelix.community_care.domain.model.Resources;

public class ResourcesMapper {
            
    public static ResourcesDTO toDTO(Resources resources) {

        if(resources == null) {
            return null;
        }

        ResourcesDTO dto = new ResourcesDTO();
        dto.setDoctors(resources.getDoctors());
        dto.setVolunteers(resources.getVolunteers());
        dto.setMedicalSuppliesKits(resources.getMedicalSuppliesKits());
        dto.setTransportVehicles(resources.getTransportVehicles());
        dto.setBasicBaskets(resources.getBasicBaskets());
        return dto;
    }
    
    public static Resources toEntity(ResourcesDTO dto) {

        if(dto == null) {
            return null;
        }
        
        Resources resources = new Resources();
        resources.setDoctors(dto.getDoctors());
        resources.setVolunteers(dto.getVolunteers());
        resources.setMedicalSuppliesKits(dto.getMedicalSuppliesKits());
        resources.setTransportVehicles(dto.getTransportVehicles());
        resources.setBasicBaskets(dto.getBasicBaskets());
        return resources;
    }
}
