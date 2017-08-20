package com.focus3d.pano.model.ibator;

import com.focustech.cief.ibatis.annotation.Column;
import com.focustech.cief.ibatis.annotation.PrimaryKey;
import com.focustech.cief.ibatis.annotation.SqlMap;
import com.focustech.cief.ibatis.annotation.Xss;
import java.util.Date;

@Xss
@SqlMap(Name = "pano_perspective_element", Class = PanoPerspectiveElement.class)
public class PanoPerspectiveElement<T, U> {
    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column pano_perspective_element.SN
     *
     * @ibatorgenerated Sun Aug 20 22:00:29 CST 2017
     */
    @PrimaryKey
    @Column
    private Long sn;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column pano_perspective_element.LAYER_SN
     *
     * @ibatorgenerated Sun Aug 20 22:00:29 CST 2017
     */
    @Column
    private Long layerSn;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column pano_perspective_element.ELEMENT_NAME
     *
     * @ibatorgenerated Sun Aug 20 22:00:29 CST 2017
     */
    @Column
    private String elementName;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column pano_perspective_element.ELEMENT_ORDER
     *
     * @ibatorgenerated Sun Aug 20 22:00:29 CST 2017
     */
    @Column
    private Integer elementOrder;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column pano_perspective_element.PACKAGE_TYPE_SN
     *
     * @ibatorgenerated Sun Aug 20 22:00:29 CST 2017
     */
    @Column
    private Long packageTypeSn;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column pano_perspective_element.ELEMENT_PRODUCT_SN
     *
     * @ibatorgenerated Sun Aug 20 22:00:29 CST 2017
     */
    @Column
    private Long elementProductSn;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column pano_perspective_element.ADDER_SN
     *
     * @ibatorgenerated Sun Aug 20 22:00:29 CST 2017
     */
    @Column
    private Long adderSn;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column pano_perspective_element.ADDER_NAME
     *
     * @ibatorgenerated Sun Aug 20 22:00:29 CST 2017
     */
    @Column
    private String adderName;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column pano_perspective_element.ADD_TIME
     *
     * @ibatorgenerated Sun Aug 20 22:00:29 CST 2017
     */
    @Column
    private Date addTime;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column pano_perspective_element.UPDATER_SN
     *
     * @ibatorgenerated Sun Aug 20 22:00:29 CST 2017
     */
    @Column
    private Long updaterSn;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column pano_perspective_element.UPDATER_NAME
     *
     * @ibatorgenerated Sun Aug 20 22:00:29 CST 2017
     */
    @Column
    private String updaterName;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column pano_perspective_element.UPDATE_TIME
     *
     * @ibatorgenerated Sun Aug 20 22:00:29 CST 2017
     */
    @Column
    private Date updateTime;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column pano_perspective_element.encryptSn
     *
     * @ibatorgenerated Sun Aug 20 22:00:29 CST 2017
     */
    @Column
    private String encryptSn;

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column pano_perspective_element.SN
     *
     * @return the value of pano_perspective_element.SN
     *
     * @ibatorgenerated Sun Aug 20 22:00:29 CST 2017
     */
    public Long getSn() {
        return sn;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column pano_perspective_element.SN
     *
     * @param sn the value for pano_perspective_element.SN
     *
     * @ibatorgenerated Sun Aug 20 22:00:29 CST 2017
     */
    public void setSn(Long sn) {
        this.sn = sn;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column pano_perspective_element.LAYER_SN
     *
     * @return the value of pano_perspective_element.LAYER_SN
     *
     * @ibatorgenerated Sun Aug 20 22:00:29 CST 2017
     */
    public Long getLayerSn() {
        return layerSn;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column pano_perspective_element.LAYER_SN
     *
     * @param layerSn the value for pano_perspective_element.LAYER_SN
     *
     * @ibatorgenerated Sun Aug 20 22:00:29 CST 2017
     */
    public void setLayerSn(Long layerSn) {
        this.layerSn = layerSn;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column pano_perspective_element.ELEMENT_NAME
     *
     * @return the value of pano_perspective_element.ELEMENT_NAME
     *
     * @ibatorgenerated Sun Aug 20 22:00:29 CST 2017
     */
    public String getElementName() {
        return elementName;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column pano_perspective_element.ELEMENT_NAME
     *
     * @param elementName the value for pano_perspective_element.ELEMENT_NAME
     *
     * @ibatorgenerated Sun Aug 20 22:00:29 CST 2017
     */
    public void setElementName(String elementName) {
        this.elementName = elementName;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column pano_perspective_element.ELEMENT_ORDER
     *
     * @return the value of pano_perspective_element.ELEMENT_ORDER
     *
     * @ibatorgenerated Sun Aug 20 22:00:29 CST 2017
     */
    public Integer getElementOrder() {
        return elementOrder;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column pano_perspective_element.ELEMENT_ORDER
     *
     * @param elementOrder the value for pano_perspective_element.ELEMENT_ORDER
     *
     * @ibatorgenerated Sun Aug 20 22:00:29 CST 2017
     */
    public void setElementOrder(Integer elementOrder) {
        this.elementOrder = elementOrder;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column pano_perspective_element.PACKAGE_TYPE_SN
     *
     * @return the value of pano_perspective_element.PACKAGE_TYPE_SN
     *
     * @ibatorgenerated Sun Aug 20 22:00:29 CST 2017
     */
    public Long getPackageTypeSn() {
        return packageTypeSn;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column pano_perspective_element.PACKAGE_TYPE_SN
     *
     * @param packageTypeSn the value for pano_perspective_element.PACKAGE_TYPE_SN
     *
     * @ibatorgenerated Sun Aug 20 22:00:29 CST 2017
     */
    public void setPackageTypeSn(Long packageTypeSn) {
        this.packageTypeSn = packageTypeSn;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column pano_perspective_element.ELEMENT_PRODUCT_SN
     *
     * @return the value of pano_perspective_element.ELEMENT_PRODUCT_SN
     *
     * @ibatorgenerated Sun Aug 20 22:00:29 CST 2017
     */
    public Long getElementProductSn() {
        return elementProductSn;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column pano_perspective_element.ELEMENT_PRODUCT_SN
     *
     * @param elementProductSn the value for pano_perspective_element.ELEMENT_PRODUCT_SN
     *
     * @ibatorgenerated Sun Aug 20 22:00:29 CST 2017
     */
    public void setElementProductSn(Long elementProductSn) {
        this.elementProductSn = elementProductSn;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column pano_perspective_element.ADDER_SN
     *
     * @return the value of pano_perspective_element.ADDER_SN
     *
     * @ibatorgenerated Sun Aug 20 22:00:29 CST 2017
     */
    public Long getAdderSn() {
        return adderSn;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column pano_perspective_element.ADDER_SN
     *
     * @param adderSn the value for pano_perspective_element.ADDER_SN
     *
     * @ibatorgenerated Sun Aug 20 22:00:29 CST 2017
     */
    public void setAdderSn(Long adderSn) {
        this.adderSn = adderSn;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column pano_perspective_element.ADDER_NAME
     *
     * @return the value of pano_perspective_element.ADDER_NAME
     *
     * @ibatorgenerated Sun Aug 20 22:00:29 CST 2017
     */
    public String getAdderName() {
        return adderName;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column pano_perspective_element.ADDER_NAME
     *
     * @param adderName the value for pano_perspective_element.ADDER_NAME
     *
     * @ibatorgenerated Sun Aug 20 22:00:29 CST 2017
     */
    public void setAdderName(String adderName) {
        this.adderName = adderName;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column pano_perspective_element.ADD_TIME
     *
     * @return the value of pano_perspective_element.ADD_TIME
     *
     * @ibatorgenerated Sun Aug 20 22:00:29 CST 2017
     */
    public Date getAddTime() {
        return addTime;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column pano_perspective_element.ADD_TIME
     *
     * @param addTime the value for pano_perspective_element.ADD_TIME
     *
     * @ibatorgenerated Sun Aug 20 22:00:29 CST 2017
     */
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column pano_perspective_element.UPDATER_SN
     *
     * @return the value of pano_perspective_element.UPDATER_SN
     *
     * @ibatorgenerated Sun Aug 20 22:00:29 CST 2017
     */
    public Long getUpdaterSn() {
        return updaterSn;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column pano_perspective_element.UPDATER_SN
     *
     * @param updaterSn the value for pano_perspective_element.UPDATER_SN
     *
     * @ibatorgenerated Sun Aug 20 22:00:29 CST 2017
     */
    public void setUpdaterSn(Long updaterSn) {
        this.updaterSn = updaterSn;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column pano_perspective_element.UPDATER_NAME
     *
     * @return the value of pano_perspective_element.UPDATER_NAME
     *
     * @ibatorgenerated Sun Aug 20 22:00:29 CST 2017
     */
    public String getUpdaterName() {
        return updaterName;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column pano_perspective_element.UPDATER_NAME
     *
     * @param updaterName the value for pano_perspective_element.UPDATER_NAME
     *
     * @ibatorgenerated Sun Aug 20 22:00:29 CST 2017
     */
    public void setUpdaterName(String updaterName) {
        this.updaterName = updaterName;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column pano_perspective_element.UPDATE_TIME
     *
     * @return the value of pano_perspective_element.UPDATE_TIME
     *
     * @ibatorgenerated Sun Aug 20 22:00:29 CST 2017
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column pano_perspective_element.UPDATE_TIME
     *
     * @param updateTime the value for pano_perspective_element.UPDATE_TIME
     *
     * @ibatorgenerated Sun Aug 20 22:00:29 CST 2017
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column pano_perspective_element.encryptSn
     *
     * @return the value of pano_perspective_element.encryptSn
     *
     * @ibatorgenerated Sun Aug 20 22:00:29 CST 2017
     */
    public String getEncryptSn() {
        return encryptSn;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column pano_perspective_element.encryptSn
     *
     * @param encryptSn the value for pano_perspective_element.encryptSn
     *
     * @ibatorgenerated Sun Aug 20 22:00:29 CST 2017
     */
    public void setEncryptSn(String encryptSn) {
        this.encryptSn = encryptSn;
    }
}