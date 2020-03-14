package edu.fzu.infect.generator;

import java.io.Serializable;
import java.util.Date;

/**
 * epidemic_situation
 * @author 
 */
public class EpidemicSituation implements Serializable {
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

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Integer getNewSuspectNum() {
        return newSuspectNum;
    }

    public void setNewSuspectNum(Integer newSuspectNum) {
        this.newSuspectNum = newSuspectNum;
    }

    public Integer getTotalSuspectNum() {
        return totalSuspectNum;
    }

    public void setTotalSuspectNum(Integer totalSuspectNum) {
        this.totalSuspectNum = totalSuspectNum;
    }

    public Integer getNewConfirmNum() {
        return newConfirmNum;
    }

    public void setNewConfirmNum(Integer newConfirmNum) {
        this.newConfirmNum = newConfirmNum;
    }

    public Integer getTotalConfirmNum() {
        return totalConfirmNum;
    }

    public void setTotalConfirmNum(Integer totalConfirmNum) {
        this.totalConfirmNum = totalConfirmNum;
    }

    public Integer getNewDeadNum() {
        return newDeadNum;
    }

    public void setNewDeadNum(Integer newDeadNum) {
        this.newDeadNum = newDeadNum;
    }

    public Integer getTotalDeadNum() {
        return totalDeadNum;
    }

    public void setTotalDeadNum(Integer totalDeadNum) {
        this.totalDeadNum = totalDeadNum;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        EpidemicSituation other = (EpidemicSituation) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getProvinceCode() == null ? other.getProvinceCode() == null : this.getProvinceCode().equals(other.getProvinceCode()))
            && (this.getProvinceName() == null ? other.getProvinceName() == null : this.getProvinceName().equals(other.getProvinceName()))
            && (this.getUpdateDate() == null ? other.getUpdateDate() == null : this.getUpdateDate().equals(other.getUpdateDate()))
            && (this.getNewSuspectNum() == null ? other.getNewSuspectNum() == null : this.getNewSuspectNum().equals(other.getNewSuspectNum()))
            && (this.getTotalSuspectNum() == null ? other.getTotalSuspectNum() == null : this.getTotalSuspectNum().equals(other.getTotalSuspectNum()))
            && (this.getNewConfirmNum() == null ? other.getNewConfirmNum() == null : this.getNewConfirmNum().equals(other.getNewConfirmNum()))
            && (this.getTotalConfirmNum() == null ? other.getTotalConfirmNum() == null : this.getTotalConfirmNum().equals(other.getTotalConfirmNum()))
            && (this.getNewDeadNum() == null ? other.getNewDeadNum() == null : this.getNewDeadNum().equals(other.getNewDeadNum()))
            && (this.getTotalDeadNum() == null ? other.getTotalDeadNum() == null : this.getTotalDeadNum().equals(other.getTotalDeadNum()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getProvinceCode() == null) ? 0 : getProvinceCode().hashCode());
        result = prime * result + ((getProvinceName() == null) ? 0 : getProvinceName().hashCode());
        result = prime * result + ((getUpdateDate() == null) ? 0 : getUpdateDate().hashCode());
        result = prime * result + ((getNewSuspectNum() == null) ? 0 : getNewSuspectNum().hashCode());
        result = prime * result + ((getTotalSuspectNum() == null) ? 0 : getTotalSuspectNum().hashCode());
        result = prime * result + ((getNewConfirmNum() == null) ? 0 : getNewConfirmNum().hashCode());
        result = prime * result + ((getTotalConfirmNum() == null) ? 0 : getTotalConfirmNum().hashCode());
        result = prime * result + ((getNewDeadNum() == null) ? 0 : getNewDeadNum().hashCode());
        result = prime * result + ((getTotalDeadNum() == null) ? 0 : getTotalDeadNum().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", provinceCode=").append(provinceCode);
        sb.append(", provinceName=").append(provinceName);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", newSuspectNum=").append(newSuspectNum);
        sb.append(", totalSuspectNum=").append(totalSuspectNum);
        sb.append(", newConfirmNum=").append(newConfirmNum);
        sb.append(", totalConfirmNum=").append(totalConfirmNum);
        sb.append(", newDeadNum=").append(newDeadNum);
        sb.append(", totalDeadNum=").append(totalDeadNum);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}