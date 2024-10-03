package com.brunofelix.community_care.application.dto;

import lombok.Data;

@Data
public class CommunityCenterNoIdDTO {
    
    private String name;
    private String address;
    private LocationDTO location;
    private int maximumCapacity;
    private int currentOccupancy;
    private ResourcesDTO resources;
    
}
