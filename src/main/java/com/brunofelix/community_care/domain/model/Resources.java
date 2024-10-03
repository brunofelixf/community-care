package com.brunofelix.community_care.domain.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Resources implements Serializable{

    private int doctors;
    private int volunteers;
    private int medicalSuppliesKits;
    private int transportVehicles;
    private int basicBaskets;

    public int calculateTotalPoints() {
        return (doctors * 4) +
               (volunteers * 3) +
               (medicalSuppliesKits * 7) +
               (transportVehicles * 5) +
               (basicBaskets * 2);
    }

}
