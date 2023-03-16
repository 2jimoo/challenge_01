package com.example.challenge_01.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WifiInfo {
    private String id;
    private String name;
    private String managementNumber;
    private String autonomousRegion;
    private String roadNameAddress;
    private Double yCoordLat;
    private Double xCoordLnt;

}
