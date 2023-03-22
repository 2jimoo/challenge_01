package com.example.challenge_01.domain.service;

import com.example.challenge_01.domain.model.History;
import com.example.challenge_01.domain.port.DeleteHistoryByIdPort;
import com.example.challenge_01.domain.port.FindAllHistoryPort;
import com.example.challenge_01.domain.port.PersistHistoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HistoryService {
    private final FindAllHistoryPort findAllHistoryPort;
    private final PersistHistoryPort persistHistoryPort;

    private final DeleteHistoryByIdPort deleteHistoryByIdPort;

    public Page<History> findAll(Pageable pageable) {
        return findAllHistoryPort.findAll(pageable);
    }

    public History persist(History history){
        return persistHistoryPort.persist(history);
    }
    public void delete(String id){
        deleteHistoryByIdPort.deleteById(id);
    }
}
