package com.example.challenge_01.domain.port;

import com.example.challenge_01.domain.model.History;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FindAllHistoryPort {
    Page<History> findAll(Pageable pageable);
}
