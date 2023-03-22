package com.example.challenge_01.webapp.adapter.out;

import com.example.challenge_01.domain.model.WifiInfo;
import com.example.challenge_01.domain.port.FindAllClosestWifiPort;
import com.example.challenge_01.domain.port.FindAllWifiInfoFromSeoulOpenApiPort;
import com.example.challenge_01.domain.port.FindAllWifiInfoPort;
import com.example.challenge_01.domain.port.PersistWifiInfoPort;
import com.example.challenge_01.webapp.adapter.out.mapper.WifiInfoMapper;
import com.example.challenge_01.webapp.adapter.out.mysql.repository.WifiInfoEntity;
import com.example.challenge_01.webapp.adapter.out.mysql.repository.WifiInfoRepository;
import com.example.challenge_01.webapp.adapter.out.web.seoulopenapi.repository.WifiInfoResponseContentRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class WifiInfoAdapter implements PersistWifiInfoPort, FindAllClosestWifiPort, FindAllWifiInfoFromSeoulOpenApiPort, FindAllWifiInfoPort {

    private final WifiInfoResponseContentRepository wifiInfoResponseContentRepository;
    private final WifiInfoRepository wifiInfoRepository;
    private final WifiInfoMapper wifiInfoMapper;
    private final EntityManager entityManager;

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

    @Override
    public List<WifiInfo> findClosest(double y, double x, int size) {
        // 쿼리
        //https://stackoverflow.com/questions/49372146/find-the-nearest-point-from-a-given-point-in-mysql
        String currentLocation = "POINT(%s, %s)".formatted(x,y);
        String sqlString = "SELECT p.*, ST_DISTANCE( %s, p.coordinate) as dist FROM wifi_info_entity p ORDER BY dist LIMIT %s".formatted(currentLocation, size);
        Query query = entityManager.createNativeQuery(sqlString, WifiInfoEntity.class);

        List<WifiInfoEntity> result = query.getResultList();
        return result.stream().map(wifiInfoMapper::mapToWifiInfo).toList();
    }

    @Override
    public List<WifiInfo> findAll() {
        return wifiInfoResponseContentRepository.findAll().stream().map(wifiInfoMapper::mapToWifiInfo).toList();
    }

    @Override
    public Page<WifiInfo> findAll(Pageable pageable) {
        return wifiInfoRepository.findAll(pageable).map(wifiInfoMapper::mapToWifiInfo);
    }
}
