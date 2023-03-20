package com.example.challenge_01.domain.service;

import com.example.challenge_01.domain.model.History;
import com.example.challenge_01.domain.model.WifiInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
//https://shallow-learning.tistory.com/entry/%EC%8A%A4%ED%94%84%EB%A7%81%EB%B6%80%ED%8A%B8-6-Spring-MVC-View-%EB%A7%8C%EB%93%A4%EA%B8%B0-JSP%EC%99%80-Thymeleaf
@Service
@Slf4j
public class ViewModelService {
//첫줄은 JSP문서라는 뜻이다. JSP 문서는 이렇게 시작해야 한다
    public ModelAndView loadAllViewModel(int total){
        ModelAndView mav = new ModelAndView("loadResult");
        mav.addObject("total", total);
        log.info(mav.getViewName());
        return mav;
    }

    public ModelAndView listWifiInfoViewModel(Page<WifiInfo> wifiInfos){
        ModelAndView mav = new ModelAndView("wifiTable");
        return mav;
    }

    public ModelAndView listHistoryViewModel(Page<History> histories){
        ModelAndView mav = new ModelAndView("historyTable");
        return mav;
    }
}