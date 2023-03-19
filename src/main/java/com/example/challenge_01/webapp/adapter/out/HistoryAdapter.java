package com.example.challenge_01.webapp.adapter.out;

import com.example.challenge_01.domain.model.History;
import com.example.challenge_01.domain.port.FindAllHistoryPort;
import com.example.challenge_01.domain.port.PersistHistoryPort;
import com.example.challenge_01.webapp.adapter.out.mapper.HistoryMapper;
import com.example.challenge_01.webapp.adapter.out.mysql.repository.HistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class HistoryAdapter implements PersistHistoryPort, FindAllHistoryPort {
    private final HistoryRepository historyRepository;

    private final HistoryMapper historyMapper;

    @Override
    public Page<History> findAll(Pageable pageable) {
        return historyRepository.findAll(pageable).map(historyMapper::mapToHistory);
    }

    @Override
    public History persist(History history) {
        return historyMapper.mapToHistory(historyRepository.save(historyMapper.mapToHistoryEntity(history)));
    }
}
