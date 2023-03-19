package com.example.challenge_01.webapp.adapter.in;

import com.example.challenge_01.domain.service.HistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@RestController
@RequestMapping("/api/histories")
@RequiredArgsConstructor
public class HistoryController {
    private final HistoryService historyService;

    @GetMapping
    public Page<HistoryViewModel> list(@PageableDefault Pageable pageable, ZoneId zoneId) {
        return historyService.findAll(pageable)
                .map(e -> new HistoryViewModel(e.getHistoryId(), e.getSearchedAt().atZone(zoneId),
                        e.getCoordinateSearched().getX(), e.getCoordinateSearched().getY()));
        // Coordinate x,y,z,w 순서 저장
        // 행(위도), 열(경도)순으로 저장했기 떄문에 y,x순서로 x,y자리에 저장됨
    }

    private record HistoryViewModel(String id, ZonedDateTime searchedAt, double y, double x) {
    }
}