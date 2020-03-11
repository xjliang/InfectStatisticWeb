package edu.fzu.infect.service.impl;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import edu.fzu.infect.domain.EpidemicSituation;
import edu.fzu.infect.mapper.EpidemicMapper;
import edu.fzu.infect.service.EpidemicService;
import edu.fzu.infect.utils.HttpUtils;
import edu.fzu.infect.utils.MyUtils;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EpidemicServiceImpl implements EpidemicService {

    @Resource
    private EpidemicMapper epidemicMapper;

    @Override
    public List<EpidemicSituation> selectByObject(EpidemicSituation dto) {
        return epidemicMapper.selectByObject(dto);
    }

    @Override
    @Transactional
    public int insertByObject(EpidemicSituation dto) {
        return epidemicMapper.insertByObject(dto);
    }

    @Override
    public int deleteByObject(EpidemicSituation dto) {
        return epidemicMapper.deleteByObject(dto);
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

        // 1.删除当天的数据
        EpidemicSituation d = new EpidemicSituation();
        d.setUpdateDate(currentDate);
        epidemicMapper.deleteByObject(d);
//        String note = "添加时间为：" + MyUtils.dateToStr(new Date(), "yyyy-MM-dd HH:mm:ss");

        // 2.更新数据
        for (Map<String, Object> f : features) {
            Map<String, Object> p = (Map<String, Object>) f.get("properties");
            EpidemicSituation dto = new EpidemicSituation();
            dto.setId(httpArg + MyUtils.getUUID32());
            dto.setUpdateDate(currentDate);
            dto.setProvinceCode("" + MyUtils.doubleToInt((Double) p.get("adcode")));
            dto.setProvinceName((String) p.get("name"));
            dto.setNewSuspectNum(MyUtils.doubleToInt((Double) p.get("新增疑似")));
            dto.setTotalSuspectNum(MyUtils.doubleToInt((Double) p.get("累计疑似")));
            dto.setNewConfirmNum(MyUtils.doubleToInt((Double) p.get("新增确诊")));
            dto.setTotalConfirmNum(MyUtils.doubleToInt((Double) p.get("累计确诊")));
            dto.setNewDeadNum(MyUtils.doubleToInt((Double) p.get("新增死亡")));
            dto.setTotalDeadNum(MyUtils.doubleToInt((Double) p.get("累计死亡")));

            epidemicMapper.insertByObject(dto);
        }
        return features.size();
    }
}
