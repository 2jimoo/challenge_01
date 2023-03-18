package com.example.challenge_01.webapp.adapter.out.web.seoulopenapi.repository;

import com.example.challenge_01.webapp.adapter.out.web.seoulopenapi.repository.client.WifiInfoResponseClient;
import com.example.challenge_01.webapp.adapter.out.web.seoulopenapi.repository.client.WifiInfoResponseContent;
import com.example.challenge_01.webapp.adapter.out.web.seoulopenapi.repository.client.WifiInfoResponseContentRow;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class WifiInfoResponseContentRepository {

    private final WifiInfoResponseClient wifiInfoResponseClient;
    private final int MAX_REQUEST_SIZE = 1000;

    public List<WifiInfoResponseContentRow> findAll() {
        List<WifiInfoResponseContentRow> wifiInfoResponseContentRows = new ArrayList<>();

        WifiInfoResponseContent wifiInfoResponseContent = wifiInfoResponseClient.getWifiResponse(1, 1).getContent();
        int totalCount = wifiInfoResponseContent.totalCount();
        log.info("Total wifi info rows: {}", totalCount);

        totalCount = 1000; // this line is for test
        for (int startIndex = 1, lastIndex = 1; startIndex <= totalCount; startIndex = lastIndex + 1) {
            lastIndex = Math.min(startIndex + MAX_REQUEST_SIZE, totalCount);
            try {
                wifiInfoResponseContent = wifiInfoResponseClient.getWifiResponse(startIndex, lastIndex).getContent();
                log.info("wifi info rows [{}/{}]", lastIndex, totalCount);
                wifiInfoResponseContentRows.addAll(wifiInfoResponseContent.rows());
            } catch (Exception ex) {
                log.warn("Getting wifi info rows failed. startIndex:{} lastIndex:{}", startIndex, lastIndex, ex);
            }
        }
        return wifiInfoResponseContentRows;
    }


}
