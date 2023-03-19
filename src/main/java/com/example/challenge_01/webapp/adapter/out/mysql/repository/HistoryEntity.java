package com.example.challenge_01.webapp.adapter.out.mysql.repository;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.locationtech.jts.geom.Point;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
public class HistoryEntity {
    @Column
    @CreatedDate
    Instant searchedAt;
    @Column
    @Version
    Long version;
    @Id
    private String historyId;
    @Column
    private Point coordinateSearched;

}
