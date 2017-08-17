package com.focus3d.pano.admin.service;

import java.util.List;

import com.focus3d.pano.model.PanoProjectHousePackage;
import com.focus3d.pano.model.PanoProjectPackage;
import com.focus3d.pano.model.PanoProjectPackageStyle;
import com.focus3d.pano.model.PanoUserLongin;
import com.focus3d.pano.model.getListPano;

public interface PanoUserLongInService {
	public PanoUserLongin getUserLongin(PanoUserLongin longin);
	public List<PanoProjectPackageStyle> getPPPSSelect( Long house_style_sn);
	public int getdelete(PanoProjectHousePackage sns);
	public List<PanoProjectPackage> getselect();
	public Long getinsert(PanoProjectPackageStyle pano);//套餐添加
	public PanoProjectPackageStyle getselects(PanoProjectPackageStyle pano);//根据套餐查询添加后的sn
	public Long getinserts(PanoProjectHousePackage pano);
	public getListPano getselect1(getListPano pano);
	
	/**
	 * 查询套餐 风格 楼盘 户型 name
	 */
	public getListPano getpackage(getListPano sn);
	public List<PanoProjectHousePackage> getpackage2(Long house_style_sn);
	public PanoProjectPackageStyle getpackage1(PanoProjectPackageStyle sn);
	
	public int getInsert1(PanoProjectHousePackage sn);
}
