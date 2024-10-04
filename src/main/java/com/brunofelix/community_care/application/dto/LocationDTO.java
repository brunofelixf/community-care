package com.brunofelix.community_care.application.dto;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import lombok.Data;

@Data
public class LocationDTO {
    
    @DecimalMin(value = "-90.0", inclusive = true, message = "Latitude must be between -90 and 90")
    @DecimalMax(value = "90.0", inclusive = true, message = "Latitude must be between -90 and 90")
    private double latitude;

    @DecimalMin(value = "-180.0", inclusive = true, message = "Longitude must be between -180 and 180")
    @DecimalMax(value = "180.0", inclusive = true, message = "Longitude must be between -180 and 180")
    private double longitude;
    
}
