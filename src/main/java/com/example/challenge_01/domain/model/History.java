package com.example.challenge_01.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.WKTReader;

import java.time.Instant;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class History {
    private String historyId;
    private Point coordinateSearched;
    private Instant searchedAt;
    private Long version;

    public static History of(double y, double x) {
        History history = new History();
        history.setHistoryId(UUID.randomUUID().toString());
        String pointWKT = String.format("POINT(%s %s)", y, x);
        try {
            history.setCoordinateSearched((Point) new WKTReader().read(pointWKT));
        } catch (ParseException e) {
            throw new RuntimeException("Failed to parse point %s.".formatted(pointWKT), e);
        }
        return history;
    }

}
