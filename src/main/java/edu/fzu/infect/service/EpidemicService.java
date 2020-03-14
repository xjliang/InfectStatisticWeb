package edu.fzu.infect.service;

import edu.fzu.infect.domain.TimeRange;
import edu.fzu.infect.generator.EpidemicSituation;
import java.util.Date;
import java.util.List;

public interface EpidemicService {

    List<EpidemicSituation> selectByTimeRange(TimeRange timeRange);

    int insert(EpidemicSituation record);

    int insertAll(String date);
}
