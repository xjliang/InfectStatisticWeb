package edu.fzu.infect.generator;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class EpidemicSituationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public EpidemicSituationExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Long offset) {
        this.offset = offset;
    }

    public Long getOffset() {
        return offset;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeIsNull() {
            addCriterion("province_code is null");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeIsNotNull() {
            addCriterion("province_code is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeEqualTo(String value) {
            addCriterion("province_code =", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeNotEqualTo(String value) {
            addCriterion("province_code <>", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeGreaterThan(String value) {
            addCriterion("province_code >", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeGreaterThanOrEqualTo(String value) {
            addCriterion("province_code >=", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeLessThan(String value) {
            addCriterion("province_code <", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeLessThanOrEqualTo(String value) {
            addCriterion("province_code <=", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeLike(String value) {
            addCriterion("province_code like", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeNotLike(String value) {
            addCriterion("province_code not like", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeIn(List<String> values) {
            addCriterion("province_code in", values, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeNotIn(List<String> values) {
            addCriterion("province_code not in", values, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeBetween(String value1, String value2) {
            addCriterion("province_code between", value1, value2, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeNotBetween(String value1, String value2) {
            addCriterion("province_code not between", value1, value2, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceNameIsNull() {
            addCriterion("province_name is null");
            return (Criteria) this;
        }

        public Criteria andProvinceNameIsNotNull() {
            addCriterion("province_name is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceNameEqualTo(String value) {
            addCriterion("province_name =", value, "provinceName");
            return (Criteria) this;
        }

        public Criteria andProvinceNameNotEqualTo(String value) {
            addCriterion("province_name <>", value, "provinceName");
            return (Criteria) this;
        }

        public Criteria andProvinceNameGreaterThan(String value) {
            addCriterion("province_name >", value, "provinceName");
            return (Criteria) this;
        }

        public Criteria andProvinceNameGreaterThanOrEqualTo(String value) {
            addCriterion("province_name >=", value, "provinceName");
            return (Criteria) this;
        }

        public Criteria andProvinceNameLessThan(String value) {
            addCriterion("province_name <", value, "provinceName");
            return (Criteria) this;
        }

        public Criteria andProvinceNameLessThanOrEqualTo(String value) {
            addCriterion("province_name <=", value, "provinceName");
            return (Criteria) this;
        }

        public Criteria andProvinceNameLike(String value) {
            addCriterion("province_name like", value, "provinceName");
            return (Criteria) this;
        }

        public Criteria andProvinceNameNotLike(String value) {
            addCriterion("province_name not like", value, "provinceName");
            return (Criteria) this;
        }

        public Criteria andProvinceNameIn(List<String> values) {
            addCriterion("province_name in", values, "provinceName");
            return (Criteria) this;
        }

        public Criteria andProvinceNameNotIn(List<String> values) {
            addCriterion("province_name not in", values, "provinceName");
            return (Criteria) this;
        }

        public Criteria andProvinceNameBetween(String value1, String value2) {
            addCriterion("province_name between", value1, value2, "provinceName");
            return (Criteria) this;
        }

        public Criteria andProvinceNameNotBetween(String value1, String value2) {
            addCriterion("province_name not between", value1, value2, "provinceName");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNull() {
            addCriterion("update_date is null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNotNull() {
            addCriterion("update_date is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateEqualTo(Date value) {
            addCriterionForJDBCDate("update_date =", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("update_date <>", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThan(Date value) {
            addCriterionForJDBCDate("update_date >", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("update_date >=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThan(Date value) {
            addCriterionForJDBCDate("update_date <", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("update_date <=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIn(List<Date> values) {
            addCriterionForJDBCDate("update_date in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("update_date not in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("update_date between", value1, value2, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("update_date not between", value1, value2, "updateDate");
            return (Criteria) this;
        }

        public Criteria andNewSuspectNumIsNull() {
            addCriterion("new_suspect_num is null");
            return (Criteria) this;
        }

        public Criteria andNewSuspectNumIsNotNull() {
            addCriterion("new_suspect_num is not null");
            return (Criteria) this;
        }

        public Criteria andNewSuspectNumEqualTo(Integer value) {
            addCriterion("new_suspect_num =", value, "newSuspectNum");
            return (Criteria) this;
        }

        public Criteria andNewSuspectNumNotEqualTo(Integer value) {
            addCriterion("new_suspect_num <>", value, "newSuspectNum");
            return (Criteria) this;
        }

        public Criteria andNewSuspectNumGreaterThan(Integer value) {
            addCriterion("new_suspect_num >", value, "newSuspectNum");
            return (Criteria) this;
        }

        public Criteria andNewSuspectNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("new_suspect_num >=", value, "newSuspectNum");
            return (Criteria) this;
        }

        public Criteria andNewSuspectNumLessThan(Integer value) {
            addCriterion("new_suspect_num <", value, "newSuspectNum");
            return (Criteria) this;
        }

        public Criteria andNewSuspectNumLessThanOrEqualTo(Integer value) {
            addCriterion("new_suspect_num <=", value, "newSuspectNum");
            return (Criteria) this;
        }

        public Criteria andNewSuspectNumIn(List<Integer> values) {
            addCriterion("new_suspect_num in", values, "newSuspectNum");
            return (Criteria) this;
        }

        public Criteria andNewSuspectNumNotIn(List<Integer> values) {
            addCriterion("new_suspect_num not in", values, "newSuspectNum");
            return (Criteria) this;
        }

        public Criteria andNewSuspectNumBetween(Integer value1, Integer value2) {
            addCriterion("new_suspect_num between", value1, value2, "newSuspectNum");
            return (Criteria) this;
        }

        public Criteria andNewSuspectNumNotBetween(Integer value1, Integer value2) {
            addCriterion("new_suspect_num not between", value1, value2, "newSuspectNum");
            return (Criteria) this;
        }

        public Criteria andTotalSuspectNumIsNull() {
            addCriterion("total_suspect_num is null");
            return (Criteria) this;
        }

        public Criteria andTotalSuspectNumIsNotNull() {
            addCriterion("total_suspect_num is not null");
            return (Criteria) this;
        }

        public Criteria andTotalSuspectNumEqualTo(Integer value) {
            addCriterion("total_suspect_num =", value, "totalSuspectNum");
            return (Criteria) this;
        }

        public Criteria andTotalSuspectNumNotEqualTo(Integer value) {
            addCriterion("total_suspect_num <>", value, "totalSuspectNum");
            return (Criteria) this;
        }

        public Criteria andTotalSuspectNumGreaterThan(Integer value) {
            addCriterion("total_suspect_num >", value, "totalSuspectNum");
            return (Criteria) this;
        }

        public Criteria andTotalSuspectNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("total_suspect_num >=", value, "totalSuspectNum");
            return (Criteria) this;
        }

        public Criteria andTotalSuspectNumLessThan(Integer value) {
            addCriterion("total_suspect_num <", value, "totalSuspectNum");
            return (Criteria) this;
        }

        public Criteria andTotalSuspectNumLessThanOrEqualTo(Integer value) {
            addCriterion("total_suspect_num <=", value, "totalSuspectNum");
            return (Criteria) this;
        }

        public Criteria andTotalSuspectNumIn(List<Integer> values) {
            addCriterion("total_suspect_num in", values, "totalSuspectNum");
            return (Criteria) this;
        }

        public Criteria andTotalSuspectNumNotIn(List<Integer> values) {
            addCriterion("total_suspect_num not in", values, "totalSuspectNum");
            return (Criteria) this;
        }

        public Criteria andTotalSuspectNumBetween(Integer value1, Integer value2) {
            addCriterion("total_suspect_num between", value1, value2, "totalSuspectNum");
            return (Criteria) this;
        }

        public Criteria andTotalSuspectNumNotBetween(Integer value1, Integer value2) {
            addCriterion("total_suspect_num not between", value1, value2, "totalSuspectNum");
            return (Criteria) this;
        }

        public Criteria andNewConfirmNumIsNull() {
            addCriterion("new_confirm_num is null");
            return (Criteria) this;
        }

        public Criteria andNewConfirmNumIsNotNull() {
            addCriterion("new_confirm_num is not null");
            return (Criteria) this;
        }

        public Criteria andNewConfirmNumEqualTo(Integer value) {
            addCriterion("new_confirm_num =", value, "newConfirmNum");
            return (Criteria) this;
        }

        public Criteria andNewConfirmNumNotEqualTo(Integer value) {
            addCriterion("new_confirm_num <>", value, "newConfirmNum");
            return (Criteria) this;
        }

        public Criteria andNewConfirmNumGreaterThan(Integer value) {
            addCriterion("new_confirm_num >", value, "newConfirmNum");
            return (Criteria) this;
        }

        public Criteria andNewConfirmNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("new_confirm_num >=", value, "newConfirmNum");
            return (Criteria) this;
        }

        public Criteria andNewConfirmNumLessThan(Integer value) {
            addCriterion("new_confirm_num <", value, "newConfirmNum");
            return (Criteria) this;
        }

        public Criteria andNewConfirmNumLessThanOrEqualTo(Integer value) {
            addCriterion("new_confirm_num <=", value, "newConfirmNum");
            return (Criteria) this;
        }

        public Criteria andNewConfirmNumIn(List<Integer> values) {
            addCriterion("new_confirm_num in", values, "newConfirmNum");
            return (Criteria) this;
        }

        public Criteria andNewConfirmNumNotIn(List<Integer> values) {
            addCriterion("new_confirm_num not in", values, "newConfirmNum");
            return (Criteria) this;
        }

        public Criteria andNewConfirmNumBetween(Integer value1, Integer value2) {
            addCriterion("new_confirm_num between", value1, value2, "newConfirmNum");
            return (Criteria) this;
        }

        public Criteria andNewConfirmNumNotBetween(Integer value1, Integer value2) {
            addCriterion("new_confirm_num not between", value1, value2, "newConfirmNum");
            return (Criteria) this;
        }

        public Criteria andTotalConfirmNumIsNull() {
            addCriterion("total_confirm_num is null");
            return (Criteria) this;
        }

        public Criteria andTotalConfirmNumIsNotNull() {
            addCriterion("total_confirm_num is not null");
            return (Criteria) this;
        }

        public Criteria andTotalConfirmNumEqualTo(Integer value) {
            addCriterion("total_confirm_num =", value, "totalConfirmNum");
            return (Criteria) this;
        }

        public Criteria andTotalConfirmNumNotEqualTo(Integer value) {
            addCriterion("total_confirm_num <>", value, "totalConfirmNum");
            return (Criteria) this;
        }

        public Criteria andTotalConfirmNumGreaterThan(Integer value) {
            addCriterion("total_confirm_num >", value, "totalConfirmNum");
            return (Criteria) this;
        }

        public Criteria andTotalConfirmNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("total_confirm_num >=", value, "totalConfirmNum");
            return (Criteria) this;
        }

        public Criteria andTotalConfirmNumLessThan(Integer value) {
            addCriterion("total_confirm_num <", value, "totalConfirmNum");
            return (Criteria) this;
        }

        public Criteria andTotalConfirmNumLessThanOrEqualTo(Integer value) {
            addCriterion("total_confirm_num <=", value, "totalConfirmNum");
            return (Criteria) this;
        }

        public Criteria andTotalConfirmNumIn(List<Integer> values) {
            addCriterion("total_confirm_num in", values, "totalConfirmNum");
            return (Criteria) this;
        }

        public Criteria andTotalConfirmNumNotIn(List<Integer> values) {
            addCriterion("total_confirm_num not in", values, "totalConfirmNum");
            return (Criteria) this;
        }

        public Criteria andTotalConfirmNumBetween(Integer value1, Integer value2) {
            addCriterion("total_confirm_num between", value1, value2, "totalConfirmNum");
            return (Criteria) this;
        }

        public Criteria andTotalConfirmNumNotBetween(Integer value1, Integer value2) {
            addCriterion("total_confirm_num not between", value1, value2, "totalConfirmNum");
            return (Criteria) this;
        }

        public Criteria andNewDeadNumIsNull() {
            addCriterion("new_dead_num is null");
            return (Criteria) this;
        }

        public Criteria andNewDeadNumIsNotNull() {
            addCriterion("new_dead_num is not null");
            return (Criteria) this;
        }

        public Criteria andNewDeadNumEqualTo(Integer value) {
            addCriterion("new_dead_num =", value, "newDeadNum");
            return (Criteria) this;
        }

        public Criteria andNewDeadNumNotEqualTo(Integer value) {
            addCriterion("new_dead_num <>", value, "newDeadNum");
            return (Criteria) this;
        }

        public Criteria andNewDeadNumGreaterThan(Integer value) {
            addCriterion("new_dead_num >", value, "newDeadNum");
            return (Criteria) this;
        }

        public Criteria andNewDeadNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("new_dead_num >=", value, "newDeadNum");
            return (Criteria) this;
        }

        public Criteria andNewDeadNumLessThan(Integer value) {
            addCriterion("new_dead_num <", value, "newDeadNum");
            return (Criteria) this;
        }

        public Criteria andNewDeadNumLessThanOrEqualTo(Integer value) {
            addCriterion("new_dead_num <=", value, "newDeadNum");
            return (Criteria) this;
        }

        public Criteria andNewDeadNumIn(List<Integer> values) {
            addCriterion("new_dead_num in", values, "newDeadNum");
            return (Criteria) this;
        }

        public Criteria andNewDeadNumNotIn(List<Integer> values) {
            addCriterion("new_dead_num not in", values, "newDeadNum");
            return (Criteria) this;
        }

        public Criteria andNewDeadNumBetween(Integer value1, Integer value2) {
            addCriterion("new_dead_num between", value1, value2, "newDeadNum");
            return (Criteria) this;
        }

        public Criteria andNewDeadNumNotBetween(Integer value1, Integer value2) {
            addCriterion("new_dead_num not between", value1, value2, "newDeadNum");
            return (Criteria) this;
        }

        public Criteria andTotalDeadNumIsNull() {
            addCriterion("total_dead_num is null");
            return (Criteria) this;
        }

        public Criteria andTotalDeadNumIsNotNull() {
            addCriterion("total_dead_num is not null");
            return (Criteria) this;
        }

        public Criteria andTotalDeadNumEqualTo(Integer value) {
            addCriterion("total_dead_num =", value, "totalDeadNum");
            return (Criteria) this;
        }

        public Criteria andTotalDeadNumNotEqualTo(Integer value) {
            addCriterion("total_dead_num <>", value, "totalDeadNum");
            return (Criteria) this;
        }

        public Criteria andTotalDeadNumGreaterThan(Integer value) {
            addCriterion("total_dead_num >", value, "totalDeadNum");
            return (Criteria) this;
        }

        public Criteria andTotalDeadNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("total_dead_num >=", value, "totalDeadNum");
            return (Criteria) this;
        }

        public Criteria andTotalDeadNumLessThan(Integer value) {
            addCriterion("total_dead_num <", value, "totalDeadNum");
            return (Criteria) this;
        }

        public Criteria andTotalDeadNumLessThanOrEqualTo(Integer value) {
            addCriterion("total_dead_num <=", value, "totalDeadNum");
            return (Criteria) this;
        }

        public Criteria andTotalDeadNumIn(List<Integer> values) {
            addCriterion("total_dead_num in", values, "totalDeadNum");
            return (Criteria) this;
        }

        public Criteria andTotalDeadNumNotIn(List<Integer> values) {
            addCriterion("total_dead_num not in", values, "totalDeadNum");
            return (Criteria) this;
        }

        public Criteria andTotalDeadNumBetween(Integer value1, Integer value2) {
            addCriterion("total_dead_num between", value1, value2, "totalDeadNum");
            return (Criteria) this;
        }

        public Criteria andTotalDeadNumNotBetween(Integer value1, Integer value2) {
            addCriterion("total_dead_num not between", value1, value2, "totalDeadNum");
            return (Criteria) this;
        }
    }

    /**
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}