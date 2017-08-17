package com.focus3d.pano.model.ibator;

import com.focustech.cief.ibatis.annotation.Column;
import com.focustech.cief.ibatis.annotation.PrimaryKey;
import com.focustech.cief.ibatis.annotation.SqlMap;
import com.focustech.cief.ibatis.annotation.Xss;
import java.util.Date;

@Xss
@SqlMap(Name = "pano_perspective_layer", Class = PanoPerspectiveLayer.class)
public class PanoPerspectiveLayer<T, U> {
    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column pano_perspective_layer.SN
     *
     * @ibatorgenerated Sun Aug 13 08:41:01 CST 2017
     */
    @PrimaryKey
    @Column
    private Long sn;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column pano_perspective_layer.LAYER_NAME
     *
     * @ibatorgenerated Sun Aug 13 08:41:01 CST 2017
     */
    @Column
    private String layerName;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column pano_perspective_layer.LAYER_ORDER
     *
     * @ibatorgenerated Sun Aug 13 08:41:01 CST 2017
     */
    @Column
    private Integer layerOrder;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column pano_perspective_layer.VIEW_SN
     *
     * @ibatorgenerated Sun Aug 13 08:41:01 CST 2017
     */
    @Column
    private Long viewSn;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column pano_perspective_layer.ADDER_SN
     *
     * @ibatorgenerated Sun Aug 13 08:41:01 CST 2017
     */
    @Column
    private Long adderSn;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column pano_perspective_layer.ADDER_NAME
     *
     * @ibatorgenerated Sun Aug 13 08:41:01 CST 2017
     */
    @Column
    private String adderName;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column pano_perspective_layer.ADD_TIME
     *
     * @ibatorgenerated Sun Aug 13 08:41:01 CST 2017
     */
    @Column
    private Date addTime;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column pano_perspective_layer.UPDATER_SN
     *
     * @ibatorgenerated Sun Aug 13 08:41:01 CST 2017
     */
    @Column
    private Long updaterSn;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column pano_perspective_layer.UPDATER_NAME
     *
     * @ibatorgenerated Sun Aug 13 08:41:01 CST 2017
     */
    @Column
    private String updaterName;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column pano_perspective_layer.UPDATE_TIME
     *
     * @ibatorgenerated Sun Aug 13 08:41:01 CST 2017
     */
    @Column
    private Date updateTime;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column pano_perspective_layer.encryptSn
     *
     * @ibatorgenerated Sun Aug 13 08:41:01 CST 2017
     */
    @Column
    private String encryptSn;

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column pano_perspective_layer.SN
     *
     * @return the value of pano_perspective_layer.SN
     *
     * @ibatorgenerated Sun Aug 13 08:41:01 CST 2017
     */
    public Long getSn() {
        return sn;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column pano_perspective_layer.SN
     *
     * @param sn the value for pano_perspective_layer.SN
     *
     * @ibatorgenerated Sun Aug 13 08:41:01 CST 2017
     */
    public void setSn(Long sn) {
        this.sn = sn;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column pano_perspective_layer.LAYER_NAME
     *
     * @return the value of pano_perspective_layer.LAYER_NAME
     *
     * @ibatorgenerated Sun Aug 13 08:41:01 CST 2017
     */
    public String getLayerName() {
        return layerName;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column pano_perspective_layer.LAYER_NAME
     *
     * @param layerName the value for pano_perspective_layer.LAYER_NAME
     *
     * @ibatorgenerated Sun Aug 13 08:41:01 CST 2017
     */
    public void setLayerName(String layerName) {
        this.layerName = layerName;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column pano_perspective_layer.LAYER_ORDER
     *
     * @return the value of pano_perspective_layer.LAYER_ORDER
     *
     * @ibatorgenerated Sun Aug 13 08:41:01 CST 2017
     */
    public Integer getLayerOrder() {
        return layerOrder;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column pano_perspective_layer.LAYER_ORDER
     *
     * @param layerOrder the value for pano_perspective_layer.LAYER_ORDER
     *
     * @ibatorgenerated Sun Aug 13 08:41:01 CST 2017
     */
    public void setLayerOrder(Integer layerOrder) {
        this.layerOrder = layerOrder;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column pano_perspective_layer.VIEW_SN
     *
     * @return the value of pano_perspective_layer.VIEW_SN
     *
     * @ibatorgenerated Sun Aug 13 08:41:01 CST 2017
     */
    public Long getViewSn() {
        return viewSn;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column pano_perspective_layer.VIEW_SN
     *
     * @param viewSn the value for pano_perspective_layer.VIEW_SN
     *
     * @ibatorgenerated Sun Aug 13 08:41:01 CST 2017
     */
    public void setViewSn(Long viewSn) {
        this.viewSn = viewSn;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column pano_perspective_layer.ADDER_SN
     *
     * @return the value of pano_perspective_layer.ADDER_SN
     *
     * @ibatorgenerated Sun Aug 13 08:41:01 CST 2017
     */
    public Long getAdderSn() {
        return adderSn;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column pano_perspective_layer.ADDER_SN
     *
     * @param adderSn the value for pano_perspective_layer.ADDER_SN
     *
     * @ibatorgenerated Sun Aug 13 08:41:01 CST 2017
     */
    public void setAdderSn(Long adderSn) {
        this.adderSn = adderSn;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column pano_perspective_layer.ADDER_NAME
     *
     * @return the value of pano_perspective_layer.ADDER_NAME
     *
     * @ibatorgenerated Sun Aug 13 08:41:01 CST 2017
     */
    public String getAdderName() {
        return adderName;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column pano_perspective_layer.ADDER_NAME
     *
     * @param adderName the value for pano_perspective_layer.ADDER_NAME
     *
     * @ibatorgenerated Sun Aug 13 08:41:01 CST 2017
     */
    public void setAdderName(String adderName) {
        this.adderName = adderName;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column pano_perspective_layer.ADD_TIME
     *
     * @return the value of pano_perspective_layer.ADD_TIME
     *
     * @ibatorgenerated Sun Aug 13 08:41:01 CST 2017
     */
    public Date getAddTime() {
        return addTime;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column pano_perspective_layer.ADD_TIME
     *
     * @param addTime the value for pano_perspective_layer.ADD_TIME
     *
     * @ibatorgenerated Sun Aug 13 08:41:01 CST 2017
     */
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column pano_perspective_layer.UPDATER_SN
     *
     * @return the value of pano_perspective_layer.UPDATER_SN
     *
     * @ibatorgenerated Sun Aug 13 08:41:01 CST 2017
     */
    public Long getUpdaterSn() {
        return updaterSn;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column pano_perspective_layer.UPDATER_SN
     *
     * @param updaterSn the value for pano_perspective_layer.UPDATER_SN
     *
     * @ibatorgenerated Sun Aug 13 08:41:01 CST 2017
     */
    public void setUpdaterSn(Long updaterSn) {
        this.updaterSn = updaterSn;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column pano_perspective_layer.UPDATER_NAME
     *
     * @return the value of pano_perspective_layer.UPDATER_NAME
     *
     * @ibatorgenerated Sun Aug 13 08:41:01 CST 2017
     */
    public String getUpdaterName() {
        return updaterName;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column pano_perspective_layer.UPDATER_NAME
     *
     * @param updaterName the value for pano_perspective_layer.UPDATER_NAME
     *
     * @ibatorgenerated Sun Aug 13 08:41:01 CST 2017
     */
    public void setUpdaterName(String updaterName) {
        this.updaterName = updaterName;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column pano_perspective_layer.UPDATE_TIME
     *
     * @return the value of pano_perspective_layer.UPDATE_TIME
     *
     * @ibatorgenerated Sun Aug 13 08:41:01 CST 2017
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column pano_perspective_layer.UPDATE_TIME
     *
     * @param updateTime the value for pano_perspective_layer.UPDATE_TIME
     *
     * @ibatorgenerated Sun Aug 13 08:41:01 CST 2017
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column pano_perspective_layer.encryptSn
     *
     * @return the value of pano_perspective_layer.encryptSn
     *
     * @ibatorgenerated Sun Aug 13 08:41:01 CST 2017
     */
    public String getEncryptSn() {
        return encryptSn;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column pano_perspective_layer.encryptSn
     *
     * @param encryptSn the value for pano_perspective_layer.encryptSn
     *
     * @ibatorgenerated Sun Aug 13 08:41:01 CST 2017
     */
    public void setEncryptSn(String encryptSn) {
        this.encryptSn = encryptSn;
    }
}