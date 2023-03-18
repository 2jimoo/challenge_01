package com.example.challenge_01.webapp.adapter.out.mysql.repository;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.locationtech.jts.geom.Point;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class WifiInfoEntity {
    @Id
    private String wifiId;
    @Column
    private String wifiName;
    @Column
    private String managementNumber;
    @Column
    private String autonomousRegion;
    @Column
    private String roadNameAddress;
    @Column
    private Point coordinate;

}
