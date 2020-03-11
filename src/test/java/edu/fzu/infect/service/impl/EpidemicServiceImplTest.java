package edu.fzu.infect.service.impl;

import static org.junit.Assert.*;

import edu.fzu.infect.domain.EpidemicSituation;
import edu.fzu.infect.service.EpidemicService;
import edu.fzu.infect.utils.MyUtils;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class EpidemicServiceImplTest {

    @Autowired
    private EpidemicService epidemicService;

    @Test
    public void selectByObject() {
        EpidemicSituation epidemicSituation = new EpidemicSituation();
        epidemicSituation.setStartDate("20200309");
        epidemicSituation.setEndDate("20200309");
        List<EpidemicSituation> epidemicSituations = epidemicService.selectByObject(epidemicSituation);
        for (EpidemicSituation situation : epidemicSituations) {
            System.out.println(situation);
        }
    }

    @Test
    public void insertByObject() {

    }

    @Test
    public void deleteByObject() {
        EpidemicSituation d = new EpidemicSituation();
        d.setUpdateDate(MyUtils.strToDate("20200212", "yyyyMMdd"));
        epidemicService.deleteByObject(d);
    }

    @Test
    public void insertAll() {
        int result = epidemicService.insertAll("20200307");
        System.out.println(result);
    }
}
