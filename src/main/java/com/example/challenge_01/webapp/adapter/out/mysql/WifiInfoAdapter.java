package com.example.challenge_01.webapp.adapter.out.mysql;

import com.example.challenge_01.domain.model.WifiInfo;
import com.example.challenge_01.domain.port.PersistWifiInfoPort;
import com.example.challenge_01.webapp.adapter.out.mysql.mapper.WifiInfoMapper;
import com.example.challenge_01.webapp.adapter.out.mysql.repository.WifiInfoEntity;
import com.example.challenge_01.webapp.adapter.out.mysql.repository.WifiInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class WifiInfoAdapter implements PersistWifiInfoPort {
    private final WifiInfoRepository wifiInfoRepository;
    private final WifiInfoMapper wifiInfoMapper;

    @Override
    public WifiInfo persist(WifiInfo wifiInfo) {
        WifiInfoEntity entity = wifiInfoMapper.mapToWifiEntity(wifiInfo);
        return wifiInfoMapper.mapToWifiInfo(wifiInfoRepository.save(entity));
    }

    @Override
    public List<WifiInfo> persistAll(List<WifiInfo> wifiInfo) {
        List<WifiInfoEntity> entities = wifiInfo.stream().map(wifiInfoMapper::mapToWifiEntity).toList();
        return wifiInfoRepository.saveAll(entities).stream().map(wifiInfoMapper::mapToWifiInfo).toList();
    }
}
