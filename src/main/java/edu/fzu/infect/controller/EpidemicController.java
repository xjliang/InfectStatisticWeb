package edu.fzu.infect.controller;

import edu.fzu.infect.domain.EpidemicSituation;
import edu.fzu.infect.service.CityDataService;
import edu.fzu.infect.service.EpidemicService;
import edu.fzu.infect.utils.PropertyUtils;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author xjliang
 */
@RestController
@RequestMapping("/epidemic")
@Slf4j
public class EpidemicController {

    @Autowired
    private EpidemicService epidemicService;

    @Autowired
    private CityDataService cityDataService;

    @PostMapping(value = "selectByObject")
    public List<EpidemicSituation> selectByObject(EpidemicSituation dto) {
        return epidemicService.selectByObject(dto);
    }

    @GetMapping("/total")
    public ModelAndView total(Model model) throws Exception {
        String serverPath = ResourceUtils.getURL("classpath:property").getPath();
        log.info(serverPath);
        Map<String, String> m = PropertyUtils.readToMap(serverPath + "/my.properties");
        model.addAttribute("totalSuspectNum", m.get("totalSuspectNum"));
        model.addAttribute("totalConfirmNum", m.get("totalConfirmNum"));
        model.addAttribute("totalDeadNum", m.get("totalDeadNum"));
        model.addAttribute("lastUpdateDay", m.get("lastDay"));
        model.addAttribute("cityList", cityDataService.listCity());
        return new ModelAndView("infect/index", "reportModel", model);
    }
}
