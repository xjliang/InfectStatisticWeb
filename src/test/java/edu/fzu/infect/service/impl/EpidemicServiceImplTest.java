package edu.fzu.infect.service.impl;

import static org.junit.Assert.*;

import edu.fzu.infect.domain.TimeRange;
import edu.fzu.infect.generator.EpidemicSituation;
import edu.fzu.infect.generator.EpidemicSituationExample;
import edu.fzu.infect.generator.EpidemicSituationMapper;
import edu.fzu.infect.service.EpidemicService;
import edu.fzu.infect.utils.MyUtils;
import java.util.Date;
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

    @Autowired
    private EpidemicSituationMapper epidemicSituationMapper;

    @Test
    public void selectByTimeRange() {
        String dateStr = "20200310";
        TimeRange timeRange = new TimeRange(dateStr, dateStr, MyUtils.USER_DATE_FORMAT);
        List<EpidemicSituation> epidemicSituations = epidemicService.selectByTimeRange(timeRange);
        for (EpidemicSituation situation : epidemicSituations) {
            System.out.println(situation.getProvinceName() + " " + situation.getUpdateDate());
        }
    }

    @Test
    public void deleteByDate() {
        EpidemicSituation d = new EpidemicSituation();
        Date currentDate = MyUtils.strToDate("20200117", MyUtils.USER_DATE_FORMAT);;
        d.setUpdateDate(currentDate);

        EpidemicSituationExample epidemicSituationExample = new EpidemicSituationExample();
        epidemicSituationExample.createCriteria().andUpdateDateEqualTo(currentDate);
        epidemicSituationMapper.deleteByExample(epidemicSituationExample);
    }

    @Test
    public void insertAll() {
        int result = epidemicService.insertAll("20200117");
        System.out.println(result);
    }
}
