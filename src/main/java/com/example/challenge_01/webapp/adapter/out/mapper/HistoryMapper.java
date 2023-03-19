package com.example.challenge_01.webapp.adapter.out.mapper;

import com.example.challenge_01.domain.model.History;
import com.example.challenge_01.webapp.adapter.out.mysql.repository.HistoryEntity;
import org.springframework.stereotype.Component;

@Component
public class HistoryMapper {

    public History mapToHistory(HistoryEntity entity) {
        return new History(entity.getHistoryId(), entity.getCoordinateSearched(), entity.getSearchedAt(), entity.getVersion());
    }

    public HistoryEntity mapToHistoryEntity(History history) {
        return new HistoryEntity(history.getHistoryId(), history.getCoordinateSearched(), history.getSearchedAt(), history.getVersion());
    }
}
