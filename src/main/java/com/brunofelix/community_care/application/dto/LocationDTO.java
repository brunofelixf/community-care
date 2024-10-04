package com.brunofelix.community_care.application.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LocationDTO {
    
    @NotBlank(message = "Latitude is mandatory")
    private double latitude;

    @NotBlank(message = "Longitude is mandatory")
    private double longitude;
    
}
