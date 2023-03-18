package com.example.challenge_01.domain.service;

import com.example.challenge_01.domain.model.WifiInfo;
import com.example.challenge_01.domain.port.FindAllClosestWifiPort;
import com.example.challenge_01.domain.port.FindAllWifiInfoFromSeoulOpenApiPort;
import com.example.challenge_01.domain.port.PersistWifiInfoPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WifiInfoService {
    private final FindAllWifiInfoFromSeoulOpenApiPort findAllWifiInfoFromSeoulOpenApiPort;
    private final PersistWifiInfoPort persistWifiInfoPort;
    private final FindAllClosestWifiPort findAllClosestWifiPort;

    public List<WifiInfo> list() {
        return findAllWifiInfoFromSeoulOpenApiPort.findAll();
    }

    public WifiInfo persist(WifiInfo wifiInfo) {
        return persistWifiInfoPort.persist(wifiInfo);
    }

    public List<WifiInfo> loadAll() {
        List<WifiInfo> wifiInfos = list();
        return persistWifiInfoPort.persistAll(wifiInfos);
    }


    public List<WifiInfo> searchClosest(double y, double x, int size) {
        return findAllClosestWifiPort.findClosest(y, x, size);
    }
}
