package com.example.challenge_01.webapp.adapter.out.mysql.mapper;

import com.example.challenge_01.domain.model.WifiInfo;
import com.example.challenge_01.webapp.adapter.out.mysql.repository.WifiInfoEntity;
import org.springframework.stereotype.Component;

@Component
public class WifiInfoMapper {

    public WifiInfoEntity mapToWifiEntity(WifiInfo wifiInfo) {
        return new WifiInfoEntity(wifiInfo.getId(), wifiInfo.getName(), wifiInfo.getManagementNumber(), wifiInfo.getAutonomousRegion(), wifiInfo.getRoadNameAddress(), wifiInfo.getYCoordLat(), wifiInfo.getXCoordLnt());
    }

    public WifiInfo mapToWifiInfo(WifiInfoEntity entity) {
        return new WifiInfo(entity.getWifiId(), entity.getWifiName(), entity.getManagementNumber(), entity.getAutonomousRegion(), entity.getRoadNameAddress(), entity.getYCoordLat(), entity.getXCoordLnt());
    }
}
