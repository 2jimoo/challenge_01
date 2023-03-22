package com.example.challenge_01.webapp.adapter.in;

import com.example.challenge_01.domain.model.WifiInfo;
import com.example.challenge_01.domain.service.ViewModelService;
import com.example.challenge_01.domain.service.WifiInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/view/wifiInfos")
@RequiredArgsConstructor
public class WifiInfoViewController {
    private final WifiInfoService wifiInfoService;
    private final ViewModelService viewModelService;

    @GetMapping
    public ModelAndView list(@PageableDefault(size = 20)Pageable pageable){
        List<WifiInfo> wifiInfos= wifiInfoService.list(pageable).getContent();
        return viewModelService.listWifiInfoViewModel(wifiInfos);
    }

    @GetMapping("/-/loadAll")
    public ModelAndView loadAll() {
        int total = wifiInfoService.loadAll().size();
        return viewModelService.loadAllViewModel(total);
    }

    @GetMapping("/-/searchByCoord")
    public ModelAndView searchClosest(@RequestParam Double y, @RequestParam Double x, @RequestParam(defaultValue = "20") Integer size) {
        List<WifiInfo> wifiInfos= wifiInfoService.searchClosest(y, x, size);
        return viewModelService.listWifiInfoViewModel(wifiInfos);
    }
}
