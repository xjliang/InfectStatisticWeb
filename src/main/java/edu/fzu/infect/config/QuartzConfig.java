package edu.fzu.infect.config;

import edu.fzu.infect.domain.EpidemicSituation;
import edu.fzu.infect.service.EpidemicService;
import edu.fzu.infect.utils.MyUtils;
import edu.fzu.infect.utils.PropertyUtils;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

/**
 * @author xjliang
 */
@Component
@Slf4j
public class QuartzConfig {
    /*
    cron:
        第一位, 表示秒, [0 ~ 60)
        第二位, 表示分. [0 ~ 60)
        第三位, 表示小时, [0 ~ 24)
        第四位, 表示天/日, [0 ~ 31]
        第五位, 表示月份, 取值是1 ~ 12
        第六位, 表示星期, 取值是1 ~ 7, 星期一，星期二...， 还有 1 表示星期日
        第七位, 年份, 可以留空, 取值是1970 ~ 2099

        0 0 3 * * ? ：每天 3 点执行；
        0 5 3 * * ?：每天 3 点 5 分执行；
        0 5 3 ? * *：每天 3 点 5 分执行，与上面作用相同；
        0 5/10 3 * * ?：每天 3 点的 5 分、15 分、25 分、35 分、45 分、55分这几个时间点执行；
        0 10 3 ? * 1：每周星期天，3 点 10 分执行，注，1 表示星期天；
        0 10 3 ? * 1#3：每个月的第三个星期，星期天执行，# 号只能出现在星期的位置。
    */

    @Autowired
    private EpidemicService epidemicService;

    /**
     * update infect situation schedule (every 6 hours)
     *
     * @throws FileNotFoundException
     */
//    @Scheduled(cron = "0 0 0/6 * * ?")
    @Scheduled(cron = "0 03 11 * * ?")
    private void updateYqInformation() throws FileNotFoundException {
        log.info("更新疫情数据");
        String serverPath = ResourceUtils.getURL("classpath:property").getPath();
        String day = MyUtils.getYesterdayByDate();
        // String day = MyUtils.dateToStr(new Date(),"yyyyMMdd");
        String lastDay = PropertyUtils.readByKey(serverPath + "/my.properties", "lastDay");
        List<String> list = MyUtils.getDays(lastDay, day, "yyyyMMdd");
        for (String str : list) {
            // if(!str.equals(day) && !str.equals(lastDay)){   //抛去首尾
            int i = epidemicService.insertAll(str);
            if (i != -1) {
                // 得到当前的确诊人数
                EpidemicSituation dto = new EpidemicSituation();
                dto.setStartDate(str);
                dto.setEndDate(str);
                List<EpidemicSituation> listByDay = epidemicService.selectByObject(dto);
                BigDecimal totalSuspectNum = new BigDecimal(0);
                BigDecimal totalConfirmNum = new BigDecimal(0);
                BigDecimal totalDeadNum = new BigDecimal(0);
                for (EpidemicSituation d : listByDay) {
                    totalSuspectNum = totalSuspectNum.add(new BigDecimal(d.getTotalSuspectNum()));
                    totalConfirmNum = totalConfirmNum.add(new BigDecimal(d.getTotalConfirmNum()));
                    totalDeadNum = totalDeadNum.add(new BigDecimal(d.getTotalDeadNum()));
                }
                log.info(totalSuspectNum + " " + totalConfirmNum + " " + totalDeadNum);
                Map<String, Object> map = new HashMap<>();
                map.put("lastDay", str);
                map.put("totalSuspectNum", totalSuspectNum.toString());
                map.put("totalConfirmNum", totalConfirmNum.toString());
                map.put("totalDeadNum", totalDeadNum.toString());
                PropertyUtils.savePro(serverPath + "/my.properties", map);
            }
            // }
        }
    }
}
