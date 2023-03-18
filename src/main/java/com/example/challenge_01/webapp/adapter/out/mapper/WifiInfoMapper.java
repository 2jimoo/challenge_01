package com.example.challenge_01.webapp.adapter.out.mapper;

import com.example.challenge_01.domain.model.WifiInfo;
import com.example.challenge_01.webapp.adapter.out.mysql.repository.WifiInfoEntity;
import com.example.challenge_01.webapp.adapter.out.web.seoulopenapi.repository.client.WifiInfoResponseContentRow;
import lombok.extern.slf4j.Slf4j;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.WKTReader;
import org.springframework.stereotype.Component;


@Component
@Slf4j
public class WifiInfoMapper {

    public WifiInfoEntity mapToWifiEntity(WifiInfo wifiInfo) {
        return new WifiInfoEntity(wifiInfo.getId(), wifiInfo.getName(), wifiInfo.getManagementNumber(), wifiInfo.getAutonomousRegion(), wifiInfo.getRoadNameAddress(), wifiInfo.getCoordinate());
    }

    public WifiInfo mapToWifiInfo(WifiInfoEntity entity) {
        return new WifiInfo(entity.getWifiId(), entity.getWifiName(), entity.getManagementNumber(), entity.getAutonomousRegion(), entity.getRoadNameAddress(), entity.getCoordinate());
    }

    public WifiInfo mapToWifiInfo(WifiInfoResponseContentRow content) {
        // X_SWIFI_MGR_NO is key?

        String pointWKT = String.format("POINT(%s %s)", content.LAT(), content.LNT());
        Point point;
        try {
            point = (Point) new WKTReader().read(pointWKT);
        } catch (ParseException e) {
            log.warn("Failed to parse point({}) of WifiInfo(id:{}).", pointWKT, content.X_SWIFI_MGR_NO());
            throw new RuntimeException(e);
        }
        return new WifiInfo(
                content.X_SWIFI_MGR_NO(),
                content.X_SWIFI_MAIN_NM(),
                content.X_SWIFI_MGR_NO(),
                content.X_SWIFI_WRDOFC(),
                content.X_SWIFI_ADRES1()
                , point);
    }
}
