package com.example.challenge_01.domain.service;

import com.example.challenge_01.domain.model.History;
import com.example.challenge_01.domain.model.WifiInfo;
import com.example.challenge_01.domain.port.FindAllClosestWifiPort;
import com.example.challenge_01.domain.port.FindAllWifiInfoFromSeoulOpenApiPort;
import com.example.challenge_01.domain.port.PersistHistoryPort;
import com.example.challenge_01.domain.port.PersistWifiInfoPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WifiInfoService {
    private final FindAllWifiInfoFromSeoulOpenApiPort findAllWifiInfoFromSeoulOpenApiPort;
    private final PersistWifiInfoPort persistWifiInfoPort;
    private final FindAllClosestWifiPort findAllClosestWifiPort;

    private final HistoryService historyService;

    public List<WifiInfo> list() {
        return findAllWifiInfoFromSeoulOpenApiPort.findAll();
    }


    public List<WifiInfo> loadAll() {
        List<WifiInfo> wifiInfos = list();
        return persistWifiInfoPort.persistAll(wifiInfos);
    }

    @Transactional
    public List<WifiInfo> searchClosest(double y, double x, int size) {
        History history = History.of(y, x);
        historyService.persist(history);
        return findAllClosestWifiPort.findClosest(y, x, size);
    }
}
