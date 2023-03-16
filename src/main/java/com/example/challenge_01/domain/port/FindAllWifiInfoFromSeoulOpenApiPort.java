package com.example.challenge_01.domain.port;

import com.example.challenge_01.domain.model.WifiInfo;

import java.util.List;

public interface FindAllWifiInfoFromSeoulOpenApiPort {

    List<WifiInfo> findAll();
}
