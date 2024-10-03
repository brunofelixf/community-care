package com.brunofelix.community_care.domain.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Location implements Serializable{

    private double latitude;
    private double longitude;
    
}
