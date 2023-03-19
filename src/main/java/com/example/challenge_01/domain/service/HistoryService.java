package com.example.challenge_01.domain.service;

import com.example.challenge_01.domain.model.History;
import com.example.challenge_01.domain.port.FindAllHistoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HistoryService {
    private final FindAllHistoryPort findAllHistoryPort;

    public Page<History> findAll(Pageable pageable) {
        return findAllHistoryPort.findAll(pageable);
    }
}
