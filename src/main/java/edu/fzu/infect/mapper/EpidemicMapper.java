package edu.fzu.infect.mapper;

import edu.fzu.infect.domain.EpidemicSituation;
import java.util.List;

public interface EpidemicMapper {

    List<EpidemicSituation> selectByObject(EpidemicSituation epidemicSituation);

    int insertByObject(EpidemicSituation epidemicSituation);

    int deleteByObject(EpidemicSituation epidemicSituation);
}
