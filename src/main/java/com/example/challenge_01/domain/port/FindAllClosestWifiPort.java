package com.example.challenge_01.domain.port;

import com.example.challenge_01.domain.model.WifiInfo;

import java.util.List;

public interface FindAllClosestWifiPort {

    List<WifiInfo> findClosest(double y, double x, int size);
}
