package com.example.challenge_01.webapp.adapter.in;

import com.example.challenge_01.domain.model.WifiInfo;
import com.example.challenge_01.domain.service.WifiInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/wifiInfos")
public class WifiInfoController {
    private final WifiInfoService wifiInfoService;

    @GetMapping
    public List<WifiInfoViewModel> list() {
        return wifiInfoService.list().stream().map(this::mapToViewModel).toList();
    }

    @PostMapping("/-/loadAll")
    public Integer loadAll() {
        return wifiInfoService.loadAll().size();
    }


    @GetMapping("/-/searchByCoord")
    public List<WifiInfoViewModel> searchClosest(@RequestParam Double y, @RequestParam Double x, @RequestParam(defaultValue = "20") Integer size) {
        return wifiInfoService.searchClosest(y, x, size).stream().map(this::mapToViewModel).toList();
    }

    private WifiInfoViewModel mapToViewModel(WifiInfo wifiInfo) {
        return new WifiInfoViewModel(wifiInfo.getId(), wifiInfo.getName(), wifiInfo.getCoordinate() != null ? wifiInfo.getCoordinate().toText() : null);
    }

    // Point 클래스에 순환참조되는 필드들이 있어서 팔요한 정보만 노출하는 뷰모델로 바꾸어 리턴
    private record WifiInfoViewModel(
            String id,
            String name,
            String coordinates
    ) {
    }
}
