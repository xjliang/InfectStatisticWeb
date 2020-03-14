package edu.fzu.infect.domain;

import edu.fzu.infect.utils.MyUtils;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author xjliang
 */
@Data
public class TimeRange {

    private String startDateStr;

    private String endDateStr;

    private String format;

    public TimeRange(String startDateStr, String endDateStr, String dateFormat) {
        this.startDateStr = startDateStr;
        this.endDateStr = endDateStr;
        this.format = dateFormat;
    }

    public Date getStartDate() {
        return MyUtils.strToDate(startDateStr, this.format);
    }
    public Date getEndDate() {
        return MyUtils.strToDate(endDateStr, this.format);
    }
}
