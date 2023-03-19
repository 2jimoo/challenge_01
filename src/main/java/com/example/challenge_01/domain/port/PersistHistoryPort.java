package com.example.challenge_01.domain.port;

import com.example.challenge_01.domain.model.History;

public interface PersistHistoryPort {
    History persist(History history);
}
