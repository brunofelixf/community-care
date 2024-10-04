package com.brunofelix.community_care.application.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Data
public class CommunityCenterDTO {
    
    private Long id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotBlank(message = "Address is mandatory")
    private String address;

    @Valid
    private LocationDTO location;

    @Positive(message = "Maximum capacity must be greater than 0")
    private int maximumCapacity;

    @PositiveOrZero(message = "Current occupancy cannot be negative")
    private int currentOccupancy;

    @Valid
    private ResourcesDTO resources;
    
}
