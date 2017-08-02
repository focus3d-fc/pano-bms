package com.focus3d.pano.model;

import java.math.BigDecimal;
import java.util.Date;

import com.focus3d.pano.common.model.CommonModel;



public class ProductInfo implements CommonModel{
	   
	
	    private Long sn;

	    private String id;

	    private String name;

	    private String brand;

	    private BigDecimal price;

	    private Integer status;

	    private String summary;

	    private Long leftImgSn;
	    private Long downImgSn;
	    private Long fullImgSn;
	    private Long bannerImgSn;
	    private Long typeSn;
	    private Long funcSn;
	    private Long spaceSn;
	    private Long styleSn;
	    private Integer length;
	    private Integer wide;
	    private Integer height;
	    private String materialName;
	    private Long materialImgSn;
	    private String fabricName;
	    private Long fabricImgSn;
	    private String color;
	    private String model;
	    private String capacity;
	    private String remark;
	    private Long adderSn;
	    private String adderName;
	    private Date addTime;
	    private Long updaterSn;
	    private String updaterName;
	    private Date updateTime;
	    
	    private String materialColor;
	    private String fabricColor;
	    private String workManShip;
	    private String lr;
	    private String lrRound;
	    
        //图片
	    private String fullImg;
	    private String leftImg;
	    private String downImg;
	    private String materialImg;
	    private String fabricImg;
	    private String updateTime1;
	    private String addTime1;
	    private String fullImgUrl;
	    private String leftImgUrl;
	    private String downImgUrl;
	    private String materialImgUrl;
	    private String fabricImgUrl;
	    
	    
	    private String typeName;
	    private String funcName;
	    private String styleName;
	    private String venderName;
	    private String dimension;
		public ProductInfo() {
			super();
		}


		public Long getSn() {
			return sn;
		}


		public void setSn(Long sn) {
			this.sn = sn;
		}


		public String getId() {
			return id;
		}


		public void setId(String id) {
			this.id = id;
		}


		public String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
		}


		public String getBrand() {
			return brand;
		}


		public void setBrand(String brand) {
			this.brand = brand;
		}


		public BigDecimal getPrice() {
			return price;
		}


		public void setPrice(BigDecimal price) {
			this.price = price;
		}


		public Integer getStatus() {
			return status;
		}


		public void setStatus(Integer status) {
			this.status = status;
		}


		public String getSummary() {
			return summary;
		}


		public void setSummary(String summary) {
			this.summary = summary;
		}

        
		public Long getLeftImgSn() {
			return leftImgSn;
		}


		public void setLeftImgSn(Long leftImgSn) {
			this.leftImgSn = leftImgSn;
		}


		public Long getDownImgSn() {
			return downImgSn;
		}


		public void setDownImgSn(Long downImgSn) {
			this.downImgSn = downImgSn;
		}


		public Long getFullImgSn() {
			return fullImgSn;
		}


		public void setFullImgSn(Long fullImgSn) {
			this.fullImgSn = fullImgSn;
		}


		public Long getBannerImgSn() {
			return bannerImgSn;
		}


		public void setBannerImgSn(Long bannerImgSn) {
			this.bannerImgSn = bannerImgSn;
		}


		public Long getTypeSn() {
			return typeSn;
		}


		public void setTypeSn(Long typeSn) {
			this.typeSn = typeSn;
		}


		public Long getFuncSn() {
			return funcSn;
		}


		public void setFuncSn(Long funcSn) {
			this.funcSn = funcSn;
		}


		public Long getSpaceSn() {
			return spaceSn;
		}


		public void setSpaceSn(Long spaceSn) {
			this.spaceSn = spaceSn;
		}


		public Long getStyleSn() {
			return styleSn;
		}


		public void setStyleSn(Long styleSn) {
			this.styleSn = styleSn;
		}


		public Integer getLength() {
			return length;
		}


		public void setLength(Integer length) {
			this.length = length;
		}


		public Integer getWide() {
			return wide;
		}


		public void setWide(Integer wide) {
			this.wide = wide;
		}


		public Integer getHeight() {
			return height;
		}


		public void setHeight(Integer height) {
			this.height = height;
		}


		public String getMaterialName() {
			return materialName;
		}


		public void setMaterialName(String materialName) {
			this.materialName = materialName;
		}


		public Long getMaterialImgSn() {
			return materialImgSn;
		}


		public void setMaterialImgSn(Long materialImgSn) {
			this.materialImgSn = materialImgSn;
		}


		public String getFabricName() {
			return fabricName;
		}


		public void setFabricName(String fabricName) {
			this.fabricName = fabricName;
		}


		public Long getFabricImgSn() {
			return fabricImgSn;
		}


		public void setFabricImgSn(Long fabricImgSn) {
			this.fabricImgSn = fabricImgSn;
		}


		public String getColor() {
			return color;
		}


		public void setColor(String color) {
			this.color = color;
		}


		public String getModel() {
			return model;
		}


		public void setModel(String model) {
			this.model = model;
		}


		public String getCapacity() {
			return capacity;
		}


		public void setCapacity(String capacity) {
			this.capacity = capacity;
		}


		public String getRemark() {
			return remark;
		}


		public void setRemark(String remark) {
			this.remark = remark;
		}


		
		
		
		public String getMaterialColor() {
			return materialColor;
		}


		public void setMaterialColor(String materialColor) {
			this.materialColor = materialColor;
		}


		public String getFabricColor() {
			return fabricColor;
		}


		public void setFabricColor(String fabricColor) {
			this.fabricColor = fabricColor;
		}

		

		public String getWorkManShip() {
			return workManShip;
		}


		public void setWorkManShip(String workManShip) {
			this.workManShip = workManShip;
		}


		public String getLr() {
			return lr;
		}


		public void setLr(String lr) {
			this.lr = lr;
		}


		public String getLrRound() {
			return lrRound;
		}


		public void setLrRound(String lrRound) {
			this.lrRound = lrRound;
		}


		
		public String getFullImg() {
			return fullImg;
		}


		public void setFullImg(String fullImg) {
			this.fullImg = fullImg;
		}


		public String getLeftImg() {
			return leftImg;
		}


		public void setLeftImg(String leftImg) {
			this.leftImg = leftImg;
		}


		public String getDownImg() {
			return downImg;
		}


		public void setDownImg(String downImg) {
			this.downImg = downImg;
		}


		public String getMaterialImg() {
			return materialImg;
		}


		public void setMaterialImg(String materialImg) {
			this.materialImg = materialImg;
		}


		public String getFabricImg() {
			return fabricImg;
		}


		public void setFabricImg(String fabricImg) {
			this.fabricImg = fabricImg;
		}


		public String getUpdateTime1() {
			return updateTime1;
		}


		public void setUpdateTime1(String updateTime1) {
			this.updateTime1 = updateTime1;
		}


		public String getAddTime1() {
			return addTime1;
		}


		public void setAddTime1(String addTime1) {
			this.addTime1 = addTime1;
		}

		

		public String getFullImgUrl() {
			return fullImgUrl;
		}


		public void setFullImgUrl(String fullImgUrl) {
			this.fullImgUrl = fullImgUrl;
		}


		public String getLeftImgUrl() {
			return leftImgUrl;
		}


		public void setLeftImgUrl(String leftImgUrl) {
			this.leftImgUrl = leftImgUrl;
		}


		public String getDownImgUrl() {
			return downImgUrl;
		}


		public void setDownImgUrl(String downImgUrl) {
			this.downImgUrl = downImgUrl;
		}


		public String getMaterialImgUrl() {
			return materialImgUrl;
		}


		public void setMaterialImgUrl(String materialImgUrl) {
			this.materialImgUrl = materialImgUrl;
		}


		public String getFabricImgUrl() {
			return fabricImgUrl;
		}


		public void setFabricImgUrl(String fabricImgUrl) {
			this.fabricImgUrl = fabricImgUrl;
		}


		public String getTypeName() {
			return typeName;
		}


		public void setTypeName(String typeName) {
			this.typeName = typeName;
		}


		public String getFuncName() {
			return funcName;
		}


		public void setFuncName(String funcName) {
			this.funcName = funcName;
		}


		public String getStyleName() {
			return styleName;
		}


		public void setStyleName(String styleName) {
			this.styleName = styleName;
		}


		public String getVenderName() {
			return venderName;
		}


		public void setVenderName(String venderName) {
			this.venderName = venderName;
		}


		public String getDimension() {
			return dimension;
		}


		public void setDimension(String dimension) {
			this.dimension = dimension;
		}


		@Override
		public Long getAdderSn() {
			// TODO Auto-generated method stub
			return adderSn;
		}


		@Override
		public void setAdderSn(Long adderSn) {
			// TODO Auto-generated method stub
			this.adderSn=adderSn;
		}


		@Override
		public String getAdderName() {
			// TODO Auto-generated method stub
			return adderName;
		}


		@Override
		public void setAdderName(String adderName) {
			// TODO Auto-generated method stub
			this.adderName=adderName;
		}


		@Override
		public Date getAddTime() {
			// TODO Auto-generated method stub
			return addTime;
		}


		@Override
		public void setAddTime(Date addTime) {
			// TODO Auto-generated method stub
			this.setAddTime(addTime);
		}


		@Override
		public Long getUpdaterSn() {
			// TODO Auto-generated method stub
			return updaterSn;
		}


		@Override
		public void setUpdaterSn(Long updaterSn) {
			// TODO Auto-generated method stub
			this.updaterSn=updaterSn;
		}


		@Override
		public String getUpdaterName() {
			// TODO Auto-generated method stub
			return updaterName;
		}


		@Override
		public void setUpdaterName(String updaterName) {
			// TODO Auto-generated method stub
			this.updaterName=updaterName;
		}


		@Override
		public Date getUpdateTime() {
			// TODO Auto-generated method stub
			return updateTime;
		}


		@Override
		public void setUpdateTime(Date updateTime) {
			// TODO Auto-generated method stub
			this.updateTime=updateTime;
		}


		@Override
		public String getEncryptSn() {
			// TODO Auto-generated method stub
			return null;
		}


		@Override
		public void setEncryptSn(String encryptSn) {
			// TODO Auto-generated method stub
			
		}

	    
}
