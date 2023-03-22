package com.example.challenge_01.domain.port;

import com.example.challenge_01.domain.model.WifiInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FindAllWifiInfoPort {
    Page<WifiInfo> findAll(Pageable pageable);
}
