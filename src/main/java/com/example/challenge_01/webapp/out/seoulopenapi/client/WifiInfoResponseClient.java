package com.example.challenge_01.webapp.out.seoulopenapi.client;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Slf4j
@Component
@RequiredArgsConstructor
public class WifiInfoResponseClient {
    private final RestTemplate restTemplate;
    @Value("${wifi-info.base-url}")
    private String baseUrl;
    @Value("${wifi-info.path}")
    private String wifiPath;
    @Value("${wifi-info.token}")
    private String token;

    public WifiResponse getWifiResponse(int startIndex, int endIndex) {
        String url = StringUtils.joinWith("/", baseUrl, token, wifiPath, String.valueOf(startIndex), String.valueOf(endIndex));
        URI uri = UriComponentsBuilder.fromUriString(url)
                .build()
                .toUri();
        log.info(uri.toString());
        return restTemplate.getForObject(uri, WifiResponse.class);

    }

}
