package com.brunofelix.community_care.application.dto;

import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class ResourcesDTO {
    
    @Positive(message = "The number of doctors must be greater than 0")
    private int doctors;

    @Positive(message = "The number of nurses must be greater than 0")
    private int volunteers;

    @Positive(message = "The number of medical supplies kits must be greater than 0")
    private int medicalSuppliesKits;

    @Positive(message = "The number of transport vehicles must be greater than 0")
    private int transportVehicles;

    @Positive(message = "The number of basic baskets must be greater than 0")
    private int basicBaskets;
    
}
