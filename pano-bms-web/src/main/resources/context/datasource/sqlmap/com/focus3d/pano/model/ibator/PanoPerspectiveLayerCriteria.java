package com.focus3d.pano.model.ibator;

import com.focustech.cief.ibatis.annotation.SqlMap;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SqlMap(Name = "pano_perspective_layer", Class = PanoPerspectiveLayer.class)
public class PanoPerspectiveLayerCriteria {
    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database table pano_perspective_layer
     *
     * @ibatorgenerated Sun Aug 20 22:36:51 CST 2017
     */
    protected String orderByClause;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database table pano_perspective_layer
     *
     * @ibatorgenerated Sun Aug 20 22:36:51 CST 2017
     */
    protected List oredCriteria;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database table pano_perspective_layer
     *
     * @ibatorgenerated Sun Aug 20 22:36:51 CST 2017
     */
    protected Object record;

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table pano_perspective_layer
     *
     * @ibatorgenerated Sun Aug 20 22:36:51 CST 2017
     */
    public PanoPerspectiveLayerCriteria() {
        oredCriteria = new ArrayList();
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table pano_perspective_layer
     *
     * @ibatorgenerated Sun Aug 20 22:36:51 CST 2017
     */
    public PanoPerspectiveLayerCriteria(PanoPerspectiveLayerCriteria example) {
        this.orderByClause = example.orderByClause;
        this.oredCriteria = example.oredCriteria;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table pano_perspective_layer
     *
     * @ibatorgenerated Sun Aug 20 22:36:51 CST 2017
     */
    public PanoPerspectiveLayerCriteria(Object record, PanoPerspectiveLayerCriteria example) {
        this.record = record;
        this.orderByClause = example.orderByClause;
        this.oredCriteria = example.oredCriteria;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table pano_perspective_layer
     *
     * @ibatorgenerated Sun Aug 20 22:36:51 CST 2017
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table pano_perspective_layer
     *
     * @ibatorgenerated Sun Aug 20 22:36:51 CST 2017
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table pano_perspective_layer
     *
     * @ibatorgenerated Sun Aug 20 22:36:51 CST 2017
     */
    public List getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table pano_perspective_layer
     *
     * @ibatorgenerated Sun Aug 20 22:36:51 CST 2017
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table pano_perspective_layer
     *
     * @ibatorgenerated Sun Aug 20 22:36:51 CST 2017
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
     * This method corresponds to the database table pano_perspective_layer
     *
     * @ibatorgenerated Sun Aug 20 22:36:51 CST 2017
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table pano_perspective_layer
     *
     * @ibatorgenerated Sun Aug 20 22:36:51 CST 2017
     */
    public void clear() {
        oredCriteria.clear();
    }

    /**
     * This class was generated by Apache iBATIS ibator.
     * This class corresponds to the database table pano_perspective_layer
     *
     * @ibatorgenerated Sun Aug 20 22:36:51 CST 2017
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

        public Criteria andLayerNameIsNull() {
            addCriterion("LAYER_NAME is null");
            return this;
        }

        public Criteria andLayerNameIsNotNull() {
            addCriterion("LAYER_NAME is not null");
            return this;
        }

        public Criteria andLayerNameEqualTo(String value) {
            addCriterion("LAYER_NAME =", value, "layerName");
            return this;
        }

        public Criteria andLayerNameNotEqualTo(String value) {
            addCriterion("LAYER_NAME <>", value, "layerName");
            return this;
        }

        public Criteria andLayerNameGreaterThan(String value) {
            addCriterion("LAYER_NAME >", value, "layerName");
            return this;
        }

        public Criteria andLayerNameGreaterThanOrEqualTo(String value) {
            addCriterion("LAYER_NAME >=", value, "layerName");
            return this;
        }

        public Criteria andLayerNameLessThan(String value) {
            addCriterion("LAYER_NAME <", value, "layerName");
            return this;
        }

        public Criteria andLayerNameLessThanOrEqualTo(String value) {
            addCriterion("LAYER_NAME <=", value, "layerName");
            return this;
        }

        public Criteria andLayerNameLike(String value) {
            addCriterion("LAYER_NAME like", value, "layerName");
            return this;
        }

        public Criteria andLayerNameNotLike(String value) {
            addCriterion("LAYER_NAME not like", value, "layerName");
            return this;
        }

        public Criteria andLayerNameIn(List values) {
            addCriterion("LAYER_NAME in", values, "layerName");
            return this;
        }

        public Criteria andLayerNameNotIn(List values) {
            addCriterion("LAYER_NAME not in", values, "layerName");
            return this;
        }

        public Criteria andLayerNameBetween(String value1, String value2) {
            addCriterion("LAYER_NAME between", value1, value2, "layerName");
            return this;
        }

        public Criteria andLayerNameNotBetween(String value1, String value2) {
            addCriterion("LAYER_NAME not between", value1, value2, "layerName");
            return this;
        }

        public Criteria andLayerOrderIsNull() {
            addCriterion("LAYER_ORDER is null");
            return this;
        }

        public Criteria andLayerOrderIsNotNull() {
            addCriterion("LAYER_ORDER is not null");
            return this;
        }

        public Criteria andLayerOrderEqualTo(Integer value) {
            addCriterion("LAYER_ORDER =", value, "layerOrder");
            return this;
        }

        public Criteria andLayerOrderNotEqualTo(Integer value) {
            addCriterion("LAYER_ORDER <>", value, "layerOrder");
            return this;
        }

        public Criteria andLayerOrderGreaterThan(Integer value) {
            addCriterion("LAYER_ORDER >", value, "layerOrder");
            return this;
        }

        public Criteria andLayerOrderGreaterThanOrEqualTo(Integer value) {
            addCriterion("LAYER_ORDER >=", value, "layerOrder");
            return this;
        }

        public Criteria andLayerOrderLessThan(Integer value) {
            addCriterion("LAYER_ORDER <", value, "layerOrder");
            return this;
        }

        public Criteria andLayerOrderLessThanOrEqualTo(Integer value) {
            addCriterion("LAYER_ORDER <=", value, "layerOrder");
            return this;
        }

        public Criteria andLayerOrderIn(List values) {
            addCriterion("LAYER_ORDER in", values, "layerOrder");
            return this;
        }

        public Criteria andLayerOrderNotIn(List values) {
            addCriterion("LAYER_ORDER not in", values, "layerOrder");
            return this;
        }

        public Criteria andLayerOrderBetween(Integer value1, Integer value2) {
            addCriterion("LAYER_ORDER between", value1, value2, "layerOrder");
            return this;
        }

        public Criteria andLayerOrderNotBetween(Integer value1, Integer value2) {
            addCriterion("LAYER_ORDER not between", value1, value2, "layerOrder");
            return this;
        }

        public Criteria andViewSnIsNull() {
            addCriterion("VIEW_SN is null");
            return this;
        }

        public Criteria andViewSnIsNotNull() {
            addCriterion("VIEW_SN is not null");
            return this;
        }

        public Criteria andViewSnEqualTo(Long value) {
            addCriterion("VIEW_SN =", value, "viewSn");
            return this;
        }

        public Criteria andViewSnNotEqualTo(Long value) {
            addCriterion("VIEW_SN <>", value, "viewSn");
            return this;
        }

        public Criteria andViewSnGreaterThan(Long value) {
            addCriterion("VIEW_SN >", value, "viewSn");
            return this;
        }

        public Criteria andViewSnGreaterThanOrEqualTo(Long value) {
            addCriterion("VIEW_SN >=", value, "viewSn");
            return this;
        }

        public Criteria andViewSnLessThan(Long value) {
            addCriterion("VIEW_SN <", value, "viewSn");
            return this;
        }

        public Criteria andViewSnLessThanOrEqualTo(Long value) {
            addCriterion("VIEW_SN <=", value, "viewSn");
            return this;
        }

        public Criteria andViewSnIn(List values) {
            addCriterion("VIEW_SN in", values, "viewSn");
            return this;
        }

        public Criteria andViewSnNotIn(List values) {
            addCriterion("VIEW_SN not in", values, "viewSn");
            return this;
        }

        public Criteria andViewSnBetween(Long value1, Long value2) {
            addCriterion("VIEW_SN between", value1, value2, "viewSn");
            return this;
        }

        public Criteria andViewSnNotBetween(Long value1, Long value2) {
            addCriterion("VIEW_SN not between", value1, value2, "viewSn");
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
    }
}