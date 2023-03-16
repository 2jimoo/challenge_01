package com.example.challenge_01.webapp.out.seoulopenapi;

import com.example.challenge_01.domain.model.WifiInfo;
import com.example.challenge_01.webapp.out.seoulopenapi.client.WifiInfoResponseContentRow;
import org.springframework.stereotype.Component;

@Component
public class WifiInfoMapper {
    WifiInfo mapToWifiInfo(WifiInfoResponseContentRow content) {
        // X_SWIFI_MGR_NO is key?
        return new WifiInfo(
                content.X_SWIFI_MGR_NO(),
                content.X_SWIFI_MAIN_NM(),
                content.X_SWIFI_MGR_NO(),
                content.X_SWIFI_WRDOFC(),
                content.X_SWIFI_ADRES1()
                , content.LAT(), content.LNT());
    }
}
