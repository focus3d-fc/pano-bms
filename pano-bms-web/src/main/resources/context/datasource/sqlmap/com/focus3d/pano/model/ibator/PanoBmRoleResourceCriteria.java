package com.focus3d.pano.model.ibator;

import com.focustech.cief.ibatis.annotation.SqlMap;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SqlMap(Name = "pano_bm_role_resource", Class = PanoBmRoleResource.class)
public class PanoBmRoleResourceCriteria {
    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database table pano_bm_role_resource
     *
     * @ibatorgenerated Sun Aug 20 21:55:48 CST 2017
     */
    protected String orderByClause;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database table pano_bm_role_resource
     *
     * @ibatorgenerated Sun Aug 20 21:55:48 CST 2017
     */
    protected List oredCriteria;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database table pano_bm_role_resource
     *
     * @ibatorgenerated Sun Aug 20 21:55:48 CST 2017
     */
    protected Object record;

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table pano_bm_role_resource
     *
     * @ibatorgenerated Sun Aug 20 21:55:48 CST 2017
     */
    public PanoBmRoleResourceCriteria() {
        oredCriteria = new ArrayList();
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table pano_bm_role_resource
     *
     * @ibatorgenerated Sun Aug 20 21:55:48 CST 2017
     */
    public PanoBmRoleResourceCriteria(PanoBmRoleResourceCriteria example) {
        this.orderByClause = example.orderByClause;
        this.oredCriteria = example.oredCriteria;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table pano_bm_role_resource
     *
     * @ibatorgenerated Sun Aug 20 21:55:48 CST 2017
     */
    public PanoBmRoleResourceCriteria(Object record, PanoBmRoleResourceCriteria example) {
        this.record = record;
        this.orderByClause = example.orderByClause;
        this.oredCriteria = example.oredCriteria;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table pano_bm_role_resource
     *
     * @ibatorgenerated Sun Aug 20 21:55:48 CST 2017
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table pano_bm_role_resource
     *
     * @ibatorgenerated Sun Aug 20 21:55:48 CST 2017
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table pano_bm_role_resource
     *
     * @ibatorgenerated Sun Aug 20 21:55:48 CST 2017
     */
    public List getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table pano_bm_role_resource
     *
     * @ibatorgenerated Sun Aug 20 21:55:48 CST 2017
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table pano_bm_role_resource
     *
     * @ibatorgenerated Sun Aug 20 21:55:48 CST 2017
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table pano_bm_role_resource
     *
     * @ibatorgenerated Sun Aug 20 21:55:48 CST 2017
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table pano_bm_role_resource
     *
     * @ibatorgenerated Sun Aug 20 21:55:48 CST 2017
     */
    public void clear() {
        oredCriteria.clear();
    }

    /**
     * This class was generated by Apache iBATIS ibator.
     * This class corresponds to the database table pano_bm_role_resource
     *
     * @ibatorgenerated Sun Aug 20 21:55:48 CST 2017
     */
    public static class Criteria {
        protected List criteriaWithoutValue;

        protected List criteriaWithSingleValue;

        protected List criteriaWithListValue;

        protected List criteriaWithBetweenValue;

        protected Criteria() {
            super();
            criteriaWithoutValue = new ArrayList();
            criteriaWithSingleValue = new ArrayList();
            criteriaWithListValue = new ArrayList();
            criteriaWithBetweenValue = new ArrayList();
        }

        public boolean isValid() {
            return criteriaWithoutValue.size() > 0
                || criteriaWithSingleValue.size() > 0
                || criteriaWithListValue.size() > 0
                || criteriaWithBetweenValue.size() > 0;
        }

        public List getCriteriaWithoutValue() {
            return criteriaWithoutValue;
        }

        public List getCriteriaWithSingleValue() {
            return criteriaWithSingleValue;
        }

        public List getCriteriaWithListValue() {
            return criteriaWithListValue;
        }

        public List getCriteriaWithBetweenValue() {
            return criteriaWithBetweenValue;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteriaWithoutValue.add(condition);
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            Map map = new HashMap();
            map.put("condition", condition);
            map.put("value", value);
            criteriaWithSingleValue.add(map);
        }

        protected void addCriterion(String condition, List values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            Map map = new HashMap();
            map.put("condition", condition);
            map.put("values", values);
            criteriaWithListValue.add(map);
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            List list = new ArrayList();
            list.add(value1);
            list.add(value2);
            Map map = new HashMap();
            map.put("condition", condition);
            map.put("values", list);
            criteriaWithBetweenValue.add(map);
        }

        public Criteria andSnIsNull() {
            addCriterion("SN is null");
            return this;
        }

        public Criteria andSnIsNotNull() {
            addCriterion("SN is not null");
            return this;
        }

        public Criteria andSnEqualTo(Long value) {
            addCriterion("SN =", value, "sn");
            return this;
        }

        public Criteria andSnNotEqualTo(Long value) {
            addCriterion("SN <>", value, "sn");
            return this;
        }

        public Criteria andSnGreaterThan(Long value) {
            addCriterion("SN >", value, "sn");
            return this;
        }

        public Criteria andSnGreaterThanOrEqualTo(Long value) {
            addCriterion("SN >=", value, "sn");
            return this;
        }

        public Criteria andSnLessThan(Long value) {
            addCriterion("SN <", value, "sn");
            return this;
        }

        public Criteria andSnLessThanOrEqualTo(Long value) {
            addCriterion("SN <=", value, "sn");
            return this;
        }

        public Criteria andSnIn(List values) {
            addCriterion("SN in", values, "sn");
            return this;
        }

        public Criteria andSnNotIn(List values) {
            addCriterion("SN not in", values, "sn");
            return this;
        }

        public Criteria andSnBetween(Long value1, Long value2) {
            addCriterion("SN between", value1, value2, "sn");
            return this;
        }

        public Criteria andSnNotBetween(Long value1, Long value2) {
            addCriterion("SN not between", value1, value2, "sn");
            return this;
        }

        public Criteria andRoleSnIsNull() {
            addCriterion("ROLE_SN is null");
            return this;
        }

        public Criteria andRoleSnIsNotNull() {
            addCriterion("ROLE_SN is not null");
            return this;
        }

        public Criteria andRoleSnEqualTo(Long value) {
            addCriterion("ROLE_SN =", value, "roleSn");
            return this;
        }

        public Criteria andRoleSnNotEqualTo(Long value) {
            addCriterion("ROLE_SN <>", value, "roleSn");
            return this;
        }

        public Criteria andRoleSnGreaterThan(Long value) {
            addCriterion("ROLE_SN >", value, "roleSn");
            return this;
        }

        public Criteria andRoleSnGreaterThanOrEqualTo(Long value) {
            addCriterion("ROLE_SN >=", value, "roleSn");
            return this;
        }

        public Criteria andRoleSnLessThan(Long value) {
            addCriterion("ROLE_SN <", value, "roleSn");
            return this;
        }

        public Criteria andRoleSnLessThanOrEqualTo(Long value) {
            addCriterion("ROLE_SN <=", value, "roleSn");
            return this;
        }

        public Criteria andRoleSnIn(List values) {
            addCriterion("ROLE_SN in", values, "roleSn");
            return this;
        }

        public Criteria andRoleSnNotIn(List values) {
            addCriterion("ROLE_SN not in", values, "roleSn");
            return this;
        }

        public Criteria andRoleSnBetween(Long value1, Long value2) {
            addCriterion("ROLE_SN between", value1, value2, "roleSn");
            return this;
        }

        public Criteria andRoleSnNotBetween(Long value1, Long value2) {
            addCriterion("ROLE_SN not between", value1, value2, "roleSn");
            return this;
        }

        public Criteria andResourceSnIsNull() {
            addCriterion("RESOURCE_SN is null");
            return this;
        }

        public Criteria andResourceSnIsNotNull() {
            addCriterion("RESOURCE_SN is not null");
            return this;
        }

        public Criteria andResourceSnEqualTo(Long value) {
            addCriterion("RESOURCE_SN =", value, "resourceSn");
            return this;
        }

        public Criteria andResourceSnNotEqualTo(Long value) {
            addCriterion("RESOURCE_SN <>", value, "resourceSn");
            return this;
        }

        public Criteria andResourceSnGreaterThan(Long value) {
            addCriterion("RESOURCE_SN >", value, "resourceSn");
            return this;
        }

        public Criteria andResourceSnGreaterThanOrEqualTo(Long value) {
            addCriterion("RESOURCE_SN >=", value, "resourceSn");
            return this;
        }

        public Criteria andResourceSnLessThan(Long value) {
            addCriterion("RESOURCE_SN <", value, "resourceSn");
            return this;
        }

        public Criteria andResourceSnLessThanOrEqualTo(Long value) {
            addCriterion("RESOURCE_SN <=", value, "resourceSn");
            return this;
        }

        public Criteria andResourceSnIn(List values) {
            addCriterion("RESOURCE_SN in", values, "resourceSn");
            return this;
        }

        public Criteria andResourceSnNotIn(List values) {
            addCriterion("RESOURCE_SN not in", values, "resourceSn");
            return this;
        }

        public Criteria andResourceSnBetween(Long value1, Long value2) {
            addCriterion("RESOURCE_SN between", value1, value2, "resourceSn");
            return this;
        }

        public Criteria andResourceSnNotBetween(Long value1, Long value2) {
            addCriterion("RESOURCE_SN not between", value1, value2, "resourceSn");
            return this;
        }

        public Criteria andAdderSnIsNull() {
            addCriterion("ADDER_SN is null");
            return this;
        }

        public Criteria andAdderSnIsNotNull() {
            addCriterion("ADDER_SN is not null");
            return this;
        }

        public Criteria andAdderSnEqualTo(Long value) {
            addCriterion("ADDER_SN =", value, "adderSn");
            return this;
        }

        public Criteria andAdderSnNotEqualTo(Long value) {
            addCriterion("ADDER_SN <>", value, "adderSn");
            return this;
        }

        public Criteria andAdderSnGreaterThan(Long value) {
            addCriterion("ADDER_SN >", value, "adderSn");
            return this;
        }

        public Criteria andAdderSnGreaterThanOrEqualTo(Long value) {
            addCriterion("ADDER_SN >=", value, "adderSn");
            return this;
        }

        public Criteria andAdderSnLessThan(Long value) {
            addCriterion("ADDER_SN <", value, "adderSn");
            return this;
        }

        public Criteria andAdderSnLessThanOrEqualTo(Long value) {
            addCriterion("ADDER_SN <=", value, "adderSn");
            return this;
        }

        public Criteria andAdderSnIn(List values) {
            addCriterion("ADDER_SN in", values, "adderSn");
            return this;
        }

        public Criteria andAdderSnNotIn(List values) {
            addCriterion("ADDER_SN not in", values, "adderSn");
            return this;
        }

        public Criteria andAdderSnBetween(Long value1, Long value2) {
            addCriterion("ADDER_SN between", value1, value2, "adderSn");
            return this;
        }

        public Criteria andAdderSnNotBetween(Long value1, Long value2) {
            addCriterion("ADDER_SN not between", value1, value2, "adderSn");
            return this;
        }

        public Criteria andAdderNameIsNull() {
            addCriterion("ADDER_NAME is null");
            return this;
        }

        public Criteria andAdderNameIsNotNull() {
            addCriterion("ADDER_NAME is not null");
            return this;
        }

        public Criteria andAdderNameEqualTo(String value) {
            addCriterion("ADDER_NAME =", value, "adderName");
            return this;
        }

        public Criteria andAdderNameNotEqualTo(String value) {
            addCriterion("ADDER_NAME <>", value, "adderName");
            return this;
        }

        public Criteria andAdderNameGreaterThan(String value) {
            addCriterion("ADDER_NAME >", value, "adderName");
            return this;
        }

        public Criteria andAdderNameGreaterThanOrEqualTo(String value) {
            addCriterion("ADDER_NAME >=", value, "adderName");
            return this;
        }

        public Criteria andAdderNameLessThan(String value) {
            addCriterion("ADDER_NAME <", value, "adderName");
            return this;
        }

        public Criteria andAdderNameLessThanOrEqualTo(String value) {
            addCriterion("ADDER_NAME <=", value, "adderName");
            return this;
        }

        public Criteria andAdderNameLike(String value) {
            addCriterion("ADDER_NAME like", value, "adderName");
            return this;
        }

        public Criteria andAdderNameNotLike(String value) {
            addCriterion("ADDER_NAME not like", value, "adderName");
            return this;
        }

        public Criteria andAdderNameIn(List values) {
            addCriterion("ADDER_NAME in", values, "adderName");
            return this;
        }

        public Criteria andAdderNameNotIn(List values) {
            addCriterion("ADDER_NAME not in", values, "adderName");
            return this;
        }

        public Criteria andAdderNameBetween(String value1, String value2) {
            addCriterion("ADDER_NAME between", value1, value2, "adderName");
            return this;
        }

        public Criteria andAdderNameNotBetween(String value1, String value2) {
            addCriterion("ADDER_NAME not between", value1, value2, "adderName");
            return this;
        }

        public Criteria andAddTimeIsNull() {
            addCriterion("ADD_TIME is null");
            return this;
        }

        public Criteria andAddTimeIsNotNull() {
            addCriterion("ADD_TIME is not null");
            return this;
        }

        public Criteria andAddTimeEqualTo(Date value) {
            addCriterion("ADD_TIME =", value, "addTime");
            return this;
        }

        public Criteria andAddTimeNotEqualTo(Date value) {
            addCriterion("ADD_TIME <>", value, "addTime");
            return this;
        }

        public Criteria andAddTimeGreaterThan(Date value) {
            addCriterion("ADD_TIME >", value, "addTime");
            return this;
        }

        public Criteria andAddTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ADD_TIME >=", value, "addTime");
            return this;
        }

        public Criteria andAddTimeLessThan(Date value) {
            addCriterion("ADD_TIME <", value, "addTime");
            return this;
        }

        public Criteria andAddTimeLessThanOrEqualTo(Date value) {
            addCriterion("ADD_TIME <=", value, "addTime");
            return this;
        }

        public Criteria andAddTimeIn(List values) {
            addCriterion("ADD_TIME in", values, "addTime");
            return this;
        }

        public Criteria andAddTimeNotIn(List values) {
            addCriterion("ADD_TIME not in", values, "addTime");
            return this;
        }

        public Criteria andAddTimeBetween(Date value1, Date value2) {
            addCriterion("ADD_TIME between", value1, value2, "addTime");
            return this;
        }

        public Criteria andAddTimeNotBetween(Date value1, Date value2) {
            addCriterion("ADD_TIME not between", value1, value2, "addTime");
            return this;
        }

        public Criteria andUpdaterSnIsNull() {
            addCriterion("UPDATER_SN is null");
            return this;
        }

        public Criteria andUpdaterSnIsNotNull() {
            addCriterion("UPDATER_SN is not null");
            return this;
        }

        public Criteria andUpdaterSnEqualTo(Long value) {
            addCriterion("UPDATER_SN =", value, "updaterSn");
            return this;
        }

        public Criteria andUpdaterSnNotEqualTo(Long value) {
            addCriterion("UPDATER_SN <>", value, "updaterSn");
            return this;
        }

        public Criteria andUpdaterSnGreaterThan(Long value) {
            addCriterion("UPDATER_SN >", value, "updaterSn");
            return this;
        }

        public Criteria andUpdaterSnGreaterThanOrEqualTo(Long value) {
            addCriterion("UPDATER_SN >=", value, "updaterSn");
            return this;
        }

        public Criteria andUpdaterSnLessThan(Long value) {
            addCriterion("UPDATER_SN <", value, "updaterSn");
            return this;
        }

        public Criteria andUpdaterSnLessThanOrEqualTo(Long value) {
            addCriterion("UPDATER_SN <=", value, "updaterSn");
            return this;
        }

        public Criteria andUpdaterSnIn(List values) {
            addCriterion("UPDATER_SN in", values, "updaterSn");
            return this;
        }

        public Criteria andUpdaterSnNotIn(List values) {
            addCriterion("UPDATER_SN not in", values, "updaterSn");
            return this;
        }

        public Criteria andUpdaterSnBetween(Long value1, Long value2) {
            addCriterion("UPDATER_SN between", value1, value2, "updaterSn");
            return this;
        }

        public Criteria andUpdaterSnNotBetween(Long value1, Long value2) {
            addCriterion("UPDATER_SN not between", value1, value2, "updaterSn");
            return this;
        }

        public Criteria andUpdaterNameIsNull() {
            addCriterion("UPDATER_NAME is null");
            return this;
        }

        public Criteria andUpdaterNameIsNotNull() {
            addCriterion("UPDATER_NAME is not null");
            return this;
        }

        public Criteria andUpdaterNameEqualTo(String value) {
            addCriterion("UPDATER_NAME =", value, "updaterName");
            return this;
        }

        public Criteria andUpdaterNameNotEqualTo(String value) {
            addCriterion("UPDATER_NAME <>", value, "updaterName");
            return this;
        }

        public Criteria andUpdaterNameGreaterThan(String value) {
            addCriterion("UPDATER_NAME >", value, "updaterName");
            return this;
        }

        public Criteria andUpdaterNameGreaterThanOrEqualTo(String value) {
            addCriterion("UPDATER_NAME >=", value, "updaterName");
            return this;
        }

        public Criteria andUpdaterNameLessThan(String value) {
            addCriterion("UPDATER_NAME <", value, "updaterName");
            return this;
        }

        public Criteria andUpdaterNameLessThanOrEqualTo(String value) {
            addCriterion("UPDATER_NAME <=", value, "updaterName");
            return this;
        }

        public Criteria andUpdaterNameLike(String value) {
            addCriterion("UPDATER_NAME like", value, "updaterName");
            return this;
        }

        public Criteria andUpdaterNameNotLike(String value) {
            addCriterion("UPDATER_NAME not like", value, "updaterName");
            return this;
        }

        public Criteria andUpdaterNameIn(List values) {
            addCriterion("UPDATER_NAME in", values, "updaterName");
            return this;
        }

        public Criteria andUpdaterNameNotIn(List values) {
            addCriterion("UPDATER_NAME not in", values, "updaterName");
            return this;
        }

        public Criteria andUpdaterNameBetween(String value1, String value2) {
            addCriterion("UPDATER_NAME between", value1, value2, "updaterName");
            return this;
        }

        public Criteria andUpdaterNameNotBetween(String value1, String value2) {
            addCriterion("UPDATER_NAME not between", value1, value2, "updaterName");
            return this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("UPDATE_TIME is null");
            return this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("UPDATE_TIME is not null");
            return this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("UPDATE_TIME =", value, "updateTime");
            return this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("UPDATE_TIME <>", value, "updateTime");
            return this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("UPDATE_TIME >", value, "updateTime");
            return this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("UPDATE_TIME >=", value, "updateTime");
            return this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("UPDATE_TIME <", value, "updateTime");
            return this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("UPDATE_TIME <=", value, "updateTime");
            return this;
        }

        public Criteria andUpdateTimeIn(List values) {
            addCriterion("UPDATE_TIME in", values, "updateTime");
            return this;
        }

        public Criteria andUpdateTimeNotIn(List values) {
            addCriterion("UPDATE_TIME not in", values, "updateTime");
            return this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("UPDATE_TIME between", value1, value2, "updateTime");
            return this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("UPDATE_TIME not between", value1, value2, "updateTime");
            return this;
        }

        public Criteria andRoleUserIsNull() {
            addCriterion("ROLE_USER is null");
            return this;
        }

        public Criteria andRoleUserIsNotNull() {
            addCriterion("ROLE_USER is not null");
            return this;
        }

        public Criteria andRoleUserEqualTo(Integer value) {
            addCriterion("ROLE_USER =", value, "roleUser");
            return this;
        }

        public Criteria andRoleUserNotEqualTo(Integer value) {
            addCriterion("ROLE_USER <>", value, "roleUser");
            return this;
        }

        public Criteria andRoleUserGreaterThan(Integer value) {
            addCriterion("ROLE_USER >", value, "roleUser");
            return this;
        }

        public Criteria andRoleUserGreaterThanOrEqualTo(Integer value) {
            addCriterion("ROLE_USER >=", value, "roleUser");
            return this;
        }

        public Criteria andRoleUserLessThan(Integer value) {
            addCriterion("ROLE_USER <", value, "roleUser");
            return this;
        }

        public Criteria andRoleUserLessThanOrEqualTo(Integer value) {
            addCriterion("ROLE_USER <=", value, "roleUser");
            return this;
        }

        public Criteria andRoleUserIn(List values) {
            addCriterion("ROLE_USER in", values, "roleUser");
            return this;
        }

        public Criteria andRoleUserNotIn(List values) {
            addCriterion("ROLE_USER not in", values, "roleUser");
            return this;
        }

        public Criteria andRoleUserBetween(Integer value1, Integer value2) {
            addCriterion("ROLE_USER between", value1, value2, "roleUser");
            return this;
        }

        public Criteria andRoleUserNotBetween(Integer value1, Integer value2) {
            addCriterion("ROLE_USER not between", value1, value2, "roleUser");
            return this;
        }

        public Criteria andRoleBasicsIsNull() {
            addCriterion("ROLE_BASICS is null");
            return this;
        }

        public Criteria andRoleBasicsIsNotNull() {
            addCriterion("ROLE_BASICS is not null");
            return this;
        }

        public Criteria andRoleBasicsEqualTo(Integer value) {
            addCriterion("ROLE_BASICS =", value, "roleBasics");
            return this;
        }

        public Criteria andRoleBasicsNotEqualTo(Integer value) {
            addCriterion("ROLE_BASICS <>", value, "roleBasics");
            return this;
        }

        public Criteria andRoleBasicsGreaterThan(Integer value) {
            addCriterion("ROLE_BASICS >", value, "roleBasics");
            return this;
        }

        public Criteria andRoleBasicsGreaterThanOrEqualTo(Integer value) {
            addCriterion("ROLE_BASICS >=", value, "roleBasics");
            return this;
        }

        public Criteria andRoleBasicsLessThan(Integer value) {
            addCriterion("ROLE_BASICS <", value, "roleBasics");
            return this;
        }

        public Criteria andRoleBasicsLessThanOrEqualTo(Integer value) {
            addCriterion("ROLE_BASICS <=", value, "roleBasics");
            return this;
        }

        public Criteria andRoleBasicsIn(List values) {
            addCriterion("ROLE_BASICS in", values, "roleBasics");
            return this;
        }

        public Criteria andRoleBasicsNotIn(List values) {
            addCriterion("ROLE_BASICS not in", values, "roleBasics");
            return this;
        }

        public Criteria andRoleBasicsBetween(Integer value1, Integer value2) {
            addCriterion("ROLE_BASICS between", value1, value2, "roleBasics");
            return this;
        }

        public Criteria andRoleBasicsNotBetween(Integer value1, Integer value2) {
            addCriterion("ROLE_BASICS not between", value1, value2, "roleBasics");
            return this;
        }

        public Criteria andRoleProductIsNull() {
            addCriterion("ROLE_PRODUCT is null");
            return this;
        }

        public Criteria andRoleProductIsNotNull() {
            addCriterion("ROLE_PRODUCT is not null");
            return this;
        }

        public Criteria andRoleProductEqualTo(Integer value) {
            addCriterion("ROLE_PRODUCT =", value, "roleProduct");
            return this;
        }

        public Criteria andRoleProductNotEqualTo(Integer value) {
            addCriterion("ROLE_PRODUCT <>", value, "roleProduct");
            return this;
        }

        public Criteria andRoleProductGreaterThan(Integer value) {
            addCriterion("ROLE_PRODUCT >", value, "roleProduct");
            return this;
        }

        public Criteria andRoleProductGreaterThanOrEqualTo(Integer value) {
            addCriterion("ROLE_PRODUCT >=", value, "roleProduct");
            return this;
        }

        public Criteria andRoleProductLessThan(Integer value) {
            addCriterion("ROLE_PRODUCT <", value, "roleProduct");
            return this;
        }

        public Criteria andRoleProductLessThanOrEqualTo(Integer value) {
            addCriterion("ROLE_PRODUCT <=", value, "roleProduct");
            return this;
        }

        public Criteria andRoleProductIn(List values) {
            addCriterion("ROLE_PRODUCT in", values, "roleProduct");
            return this;
        }

        public Criteria andRoleProductNotIn(List values) {
            addCriterion("ROLE_PRODUCT not in", values, "roleProduct");
            return this;
        }

        public Criteria andRoleProductBetween(Integer value1, Integer value2) {
            addCriterion("ROLE_PRODUCT between", value1, value2, "roleProduct");
            return this;
        }

        public Criteria andRoleProductNotBetween(Integer value1, Integer value2) {
            addCriterion("ROLE_PRODUCT not between", value1, value2, "roleProduct");
            return this;
        }

        public Criteria andRoleHousesIsNull() {
            addCriterion("ROLE_HOUSES is null");
            return this;
        }

        public Criteria andRoleHousesIsNotNull() {
            addCriterion("ROLE_HOUSES is not null");
            return this;
        }

        public Criteria andRoleHousesEqualTo(Integer value) {
            addCriterion("ROLE_HOUSES =", value, "roleHouses");
            return this;
        }

        public Criteria andRoleHousesNotEqualTo(Integer value) {
            addCriterion("ROLE_HOUSES <>", value, "roleHouses");
            return this;
        }

        public Criteria andRoleHousesGreaterThan(Integer value) {
            addCriterion("ROLE_HOUSES >", value, "roleHouses");
            return this;
        }

        public Criteria andRoleHousesGreaterThanOrEqualTo(Integer value) {
            addCriterion("ROLE_HOUSES >=", value, "roleHouses");
            return this;
        }

        public Criteria andRoleHousesLessThan(Integer value) {
            addCriterion("ROLE_HOUSES <", value, "roleHouses");
            return this;
        }

        public Criteria andRoleHousesLessThanOrEqualTo(Integer value) {
            addCriterion("ROLE_HOUSES <=", value, "roleHouses");
            return this;
        }

        public Criteria andRoleHousesIn(List values) {
            addCriterion("ROLE_HOUSES in", values, "roleHouses");
            return this;
        }

        public Criteria andRoleHousesNotIn(List values) {
            addCriterion("ROLE_HOUSES not in", values, "roleHouses");
            return this;
        }

        public Criteria andRoleHousesBetween(Integer value1, Integer value2) {
            addCriterion("ROLE_HOUSES between", value1, value2, "roleHouses");
            return this;
        }

        public Criteria andRoleHousesNotBetween(Integer value1, Integer value2) {
            addCriterion("ROLE_HOUSES not between", value1, value2, "roleHouses");
            return this;
        }

        public Criteria andRoleRoleIsNull() {
            addCriterion("ROLE_ROLE is null");
            return this;
        }

        public Criteria andRoleRoleIsNotNull() {
            addCriterion("ROLE_ROLE is not null");
            return this;
        }

        public Criteria andRoleRoleEqualTo(Integer value) {
            addCriterion("ROLE_ROLE =", value, "roleRole");
            return this;
        }

        public Criteria andRoleRoleNotEqualTo(Integer value) {
            addCriterion("ROLE_ROLE <>", value, "roleRole");
            return this;
        }

        public Criteria andRoleRoleGreaterThan(Integer value) {
            addCriterion("ROLE_ROLE >", value, "roleRole");
            return this;
        }

        public Criteria andRoleRoleGreaterThanOrEqualTo(Integer value) {
            addCriterion("ROLE_ROLE >=", value, "roleRole");
            return this;
        }

        public Criteria andRoleRoleLessThan(Integer value) {
            addCriterion("ROLE_ROLE <", value, "roleRole");
            return this;
        }

        public Criteria andRoleRoleLessThanOrEqualTo(Integer value) {
            addCriterion("ROLE_ROLE <=", value, "roleRole");
            return this;
        }

        public Criteria andRoleRoleIn(List values) {
            addCriterion("ROLE_ROLE in", values, "roleRole");
            return this;
        }

        public Criteria andRoleRoleNotIn(List values) {
            addCriterion("ROLE_ROLE not in", values, "roleRole");
            return this;
        }

        public Criteria andRoleRoleBetween(Integer value1, Integer value2) {
            addCriterion("ROLE_ROLE between", value1, value2, "roleRole");
            return this;
        }

        public Criteria andRoleRoleNotBetween(Integer value1, Integer value2) {
            addCriterion("ROLE_ROLE not between", value1, value2, "roleRole");
            return this;
        }

        public Criteria andRoleOrderIsNull() {
            addCriterion("ROLE_ORDER is null");
            return this;
        }

        public Criteria andRoleOrderIsNotNull() {
            addCriterion("ROLE_ORDER is not null");
            return this;
        }

        public Criteria andRoleOrderEqualTo(Integer value) {
            addCriterion("ROLE_ORDER =", value, "roleOrder");
            return this;
        }

        public Criteria andRoleOrderNotEqualTo(Integer value) {
            addCriterion("ROLE_ORDER <>", value, "roleOrder");
            return this;
        }

        public Criteria andRoleOrderGreaterThan(Integer value) {
            addCriterion("ROLE_ORDER >", value, "roleOrder");
            return this;
        }

        public Criteria andRoleOrderGreaterThanOrEqualTo(Integer value) {
            addCriterion("ROLE_ORDER >=", value, "roleOrder");
            return this;
        }

        public Criteria andRoleOrderLessThan(Integer value) {
            addCriterion("ROLE_ORDER <", value, "roleOrder");
            return this;
        }

        public Criteria andRoleOrderLessThanOrEqualTo(Integer value) {
            addCriterion("ROLE_ORDER <=", value, "roleOrder");
            return this;
        }

        public Criteria andRoleOrderIn(List values) {
            addCriterion("ROLE_ORDER in", values, "roleOrder");
            return this;
        }

        public Criteria andRoleOrderNotIn(List values) {
            addCriterion("ROLE_ORDER not in", values, "roleOrder");
            return this;
        }

        public Criteria andRoleOrderBetween(Integer value1, Integer value2) {
            addCriterion("ROLE_ORDER between", value1, value2, "roleOrder");
            return this;
        }

        public Criteria andRoleOrderNotBetween(Integer value1, Integer value2) {
            addCriterion("ROLE_ORDER not between", value1, value2, "roleOrder");
            return this;
        }
    }
}