package com.example.challenge_01.webapp.adapter.in;

import com.example.challenge_01.domain.model.History;
import com.example.challenge_01.domain.service.HistoryService;
import com.example.challenge_01.domain.service.ViewModelService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.ZoneId;

@Controller
@RequestMapping("/view/histories")
@RequiredArgsConstructor
public class HistoryViewController {
    private final HistoryService historyService;
    private final ViewModelService viewModelService;

    @GetMapping
    public ModelAndView list(@PageableDefault Pageable pageable) {
        Page<History> histories = historyService.findAll(pageable);
       return viewModelService.listHistoryViewModel(histories);
    }
}
