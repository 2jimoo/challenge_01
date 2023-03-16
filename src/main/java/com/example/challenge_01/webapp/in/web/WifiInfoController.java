package com.example.challenge_01.webapp.in.web;

import com.example.challenge_01.domain.model.WifiInfo;
import com.example.challenge_01.domain.service.WifiInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/wifiInfos")
public class WifiInfoController {

    private final WifiInfoService wifiInfoService;

    @GetMapping
    List<WifiInfo> list() {
        return wifiInfoService.list();
    }

}
