package com.example.challenge_01.webapp.adapter.out.web.seoulopenapi.repository.client;


import com.example.challenge_01.config.properties.SeoulOpenApiWifiInfoProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Slf4j
@Component
@RequiredArgsConstructor
public class WifiInfoResponseClient {
    private final RestTemplate restTemplate;
   private final SeoulOpenApiWifiInfoProperties wifiInfoProperties;

    public WifiResponse getWifiResponse(int startIndex, int endIndex) {
        String url = StringUtils.joinWith("/", wifiInfoProperties.getBaseUrl(), wifiInfoProperties.getToken(), wifiInfoProperties.getPath(), String.valueOf(startIndex), String.valueOf(endIndex));
        URI uri = UriComponentsBuilder.fromUriString(url)
                .build()
                .toUri();
        log.info(uri.toString());
        return restTemplate.getForObject(uri, WifiResponse.class);

    }

}
