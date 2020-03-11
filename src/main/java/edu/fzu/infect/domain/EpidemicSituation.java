package edu.fzu.infect.domain;

import java.util.Date;
import lombok.Data;

/**
 * epidemic_situation
 *
 * @author xjliang
 */
@Data
public class EpidemicSituation {

    private String id;

    /**
     * 省份编码
     */
    private String provinceCode;

    /**
     * 省份名称
     */
    private String provinceName;

    /**
     * 更新时间
     */
    private Date updateDate;

    private String startDate;

    private String endDate;

    /**
     * 新增疑似
     */
    private Integer newSuspectNum;

    /**
     * 累计疑似
     */
    private Integer totalSuspectNum;

    /**
     * 新增确诊
     */
    private Integer newConfirmNum;

    /**
     * 累计确诊
     */
    private Integer totalConfirmNum;

    /**
     * 新增死亡
     */
    private Integer newDeadNum;

    /**
     * 累计死亡
     */
    private Integer totalDeadNum;

}
