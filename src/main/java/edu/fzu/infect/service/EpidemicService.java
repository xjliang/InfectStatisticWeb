package edu.fzu.infect.service;

import edu.fzu.infect.domain.EpidemicSituation;
import java.util.List;

public interface EpidemicService {

    List<EpidemicSituation> selectByObject(EpidemicSituation dto);

    int insertByObject(EpidemicSituation dto);

    int deleteByObject(EpidemicSituation dto);

    int insertAll(String date);
}
