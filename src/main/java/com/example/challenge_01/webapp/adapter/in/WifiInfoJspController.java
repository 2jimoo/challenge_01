package com.example.challenge_01.webapp.adapter.in;

import com.example.challenge_01.domain.service.ViewModelService;
import com.example.challenge_01.domain.service.WifiInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/view/wifiInfos")
@RequiredArgsConstructor
public class WifiInfoJspController {
    private final WifiInfoService wifiInfoService;
    private final ViewModelService viewModelService;

    @GetMapping("/-/loadAll")
    public ModelAndView loadAll() {
        int total= wifiInfoService.loadAll().size();
        return viewModelService.loadAllViewModel(total);
    }
    //이 오류는 Spring Boot에서 내장된 Tomcat을 사용 하는 경우 JSP 를 처리하는 서블릿을 추가하지 않아 발생하는 것으로 의존성(dependency)을 추가해주면 된다.
}
