package edu.fzu.infect.generator;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EpidemicSituationMapper {
    long countByExample(EpidemicSituationExample example);

    int deleteByExample(EpidemicSituationExample example);

    int deleteByPrimaryKey(String id);

    int insert(EpidemicSituation record);

    int insertSelective(EpidemicSituation record);

    List<EpidemicSituation> selectByExample(EpidemicSituationExample example);

    EpidemicSituation selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") EpidemicSituation record, @Param("example") EpidemicSituationExample example);

    int updateByExample(@Param("record") EpidemicSituation record, @Param("example") EpidemicSituationExample example);

    int updateByPrimaryKeySelective(EpidemicSituation record);

    int updateByPrimaryKey(EpidemicSituation record);
}
