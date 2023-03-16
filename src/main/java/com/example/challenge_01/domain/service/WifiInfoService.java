package com.example.challenge_01.domain.service;

import com.example.challenge_01.domain.model.WifiInfo;
import com.example.challenge_01.domain.port.FindAllWifiInfoFromSeoulOpenApiPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WifiInfoService {

    private final FindAllWifiInfoFromSeoulOpenApiPort findAllWifiInfoFromSeoulOpenApiPort;

    public List<WifiInfo> list() {
        return findAllWifiInfoFromSeoulOpenApiPort.findAll();
    }
}
