package edu.fzu.infect.service.impl;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import edu.fzu.infect.domain.TimeRange;
import edu.fzu.infect.generator.EpidemicSituation;
import edu.fzu.infect.generator.EpidemicSituationExample;
import edu.fzu.infect.generator.EpidemicSituationMapper;
import edu.fzu.infect.service.EpidemicService;
import edu.fzu.infect.utils.HttpUtils;
import edu.fzu.infect.utils.MyUtils;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @author xjliang
 */
@Service
public class EpidemicServiceImpl implements EpidemicService {

    @Resource
    private EpidemicSituationMapper epidemicSituationMapper;

    @Override
    public List<EpidemicSituation> selectByTimeRange(TimeRange range) {
        EpidemicSituationExample epidemicSituationExample = new EpidemicSituationExample();
        epidemicSituationExample.createCriteria().andUpdateDateBetween(range.getStartDate(), range.getEndDate());
        return epidemicSituationMapper.selectByExample(epidemicSituationExample);
    }

    @Override
    public int insert(EpidemicSituation record) {
        return epidemicSituationMapper.insert(record);
    }

    @Override
    public int insertAll(String httpArg) {
        System.out.println("now is:" + httpArg);
        String str = HttpUtils.httpToStr(httpArg);
        if (str == null) {
            return -1;
        }
        Gson gson = new Gson();
        Map<String, Object> map = gson.fromJson(str, new TypeToken<HashMap<String, Object>>() {
        }.getType());
        List<Map<String, Object>> features = (List<Map<String, Object>>) map.get("features");
        Date currentDate = MyUtils.strToDate(httpArg, "yyyyMMdd");

        // 1. delete current data
        EpidemicSituation d = new EpidemicSituation();
        d.setUpdateDate(currentDate);

        EpidemicSituationExample epidemicSituationExample = new EpidemicSituationExample();
        epidemicSituationExample.createCriteria().andUpdateDateEqualTo(currentDate);
        epidemicSituationMapper.deleteByExample(epidemicSituationExample);

        // 2. update data
        for (Map<String, Object> f : features) {
            Map<String, Object> p = (Map<String, Object>) f.get("properties");
            EpidemicSituation record = new EpidemicSituation();
            record.setId(httpArg + MyUtils.getUUID32());
            record.setUpdateDate(currentDate);
            record.setProvinceCode("" + MyUtils.doubleToInt((Double) p.get("adcode")));
            record.setProvinceName((String) p.get("name"));
            record.setNewSuspectNum(MyUtils.doubleToInt((Double) p.get("新增疑似")));
            record.setTotalSuspectNum(MyUtils.doubleToInt((Double) p.get("累计疑似")));
            record.setNewConfirmNum(MyUtils.doubleToInt((Double) p.get("新增确诊")));
            record.setTotalConfirmNum(MyUtils.doubleToInt((Double) p.get("累计确诊")));
            record.setNewDeadNum(MyUtils.doubleToInt((Double) p.get("新增死亡")));
            record.setTotalDeadNum(MyUtils.doubleToInt((Double) p.get("累计死亡")));

            epidemicSituationMapper.insert(record);
        }
        return features.size();
    }
}
