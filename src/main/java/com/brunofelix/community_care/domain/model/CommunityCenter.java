package com.brunofelix.community_care.domain.model;

import java.io.Serializable;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
    
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "community_centers")
public class CommunityCenter implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private int maximumCapacity;
    private int currentOccupancy;

    @Embedded
    private Location location;

    @Embedded
    private Resources resources;


    public boolean isAtOrOverMaximumCapacity() {
        return this.currentOccupancy >= this.maximumCapacity;
    }

    public double getOccupancyPercentage() {
        if (maximumCapacity == 0) {
            return 0;
        }
        return ((double) currentOccupancy / maximumCapacity) * 100;
    }

    public CommunityCenter(String name, String address, Location location, int maximumCapacity, int currentOccupancy, Resources resources) {
        this.name = name;
        this.address = address;
        this.location = location;
        this.maximumCapacity = maximumCapacity;
        this.currentOccupancy = currentOccupancy;
        this.resources = resources;
    }
}
