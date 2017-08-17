package com.focus3d.pano.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.focus3d.pano.admin.dao.PanoUserLongInDAO;
import com.focus3d.pano.admin.service.PanoUserLongInService;
import com.focus3d.pano.model.PanoProjectHousePackage;
import com.focus3d.pano.model.PanoProjectPackage;
import com.focus3d.pano.model.PanoProjectPackageStyle;
import com.focus3d.pano.model.PanoUserLongin;
import com.focus3d.pano.model.getListPano;
@Service 
public class PanoUserLongInServiceImpl implements PanoUserLongInService{
	 @Autowired
	private PanoUserLongInDAO userlongin;
	@Override
	public PanoUserLongin getUserLongin(PanoUserLongin longin) {
		PanoUserLongin panoUserLongin = null;
		List<PanoUserLongin> user = userlongin.getUserLongin(longin);
		if(user.size()>0){
		 panoUserLongin = user.get(0);
		}
		return panoUserLongin;
	}
	@Override
	public List<PanoProjectPackageStyle> getPPPSSelect(Long house_style_sn ) {
		List<PanoProjectPackageStyle> pppsSelect = userlongin.getPPPSSelect(house_style_sn);
		return pppsSelect;
	}
	
	
	@Override
	public getListPano getpackage(getListPano sn) {
		getListPano list = null;
		List<getListPano> getpackage = userlongin.getpackage(sn);
		if(getpackage.size()>0){
			list = getpackage.get(0);
		}
		return list;
	}
	
	public List<PanoProjectHousePackage> getpackage2(Long house_style_sn){
		return userlongin.getpackage2(house_style_sn);
		
	}
	public PanoProjectPackageStyle getpackage1(PanoProjectPackageStyle sn) {
		PanoProjectPackageStyle list = null;
		List<PanoProjectPackageStyle> getpackage1 = userlongin.getpackage1(sn);
		if(getpackage1.size()>0){
			list=getpackage1.get(0);
		}
		return list;
	}
	@Override
	public int getdelete(PanoProjectHousePackage sns) {
		return userlongin.getdelete(sns);
	}
	@Override
	public List<PanoProjectPackage> getselect() {
		return userlongin.getselect();
	}
	@Override
	public Long getinsert(PanoProjectPackageStyle pano) {
		return  userlongin.getinsert(pano);
	}
	
	public PanoProjectPackageStyle getselects(PanoProjectPackageStyle pano){
		PanoProjectPackageStyle getList = null;
		List<PanoProjectPackageStyle> getselects = userlongin.getselects(pano);
		System.out.println("service长度："+getselects.size());
		if(getselects.size()>0){
			getList = getselects.get(0);
		}
		  return getList;
	}
	
	@Override
	public getListPano getselect1(getListPano pano) {
		getListPano getList = null;
		List<getListPano> getListPano = userlongin.getselect1(pano);
		if(getListPano.size()>0){
			getList = getListPano.get(0);
		}
		return getList;
	}
	@Override
	public Long getinserts(PanoProjectHousePackage pano) {
		return userlongin.getinserts(pano);
	}
	@Override
	public int getInsert1(PanoProjectHousePackage sn) {
		return userlongin.getInsert1(sn);
	}
	

}
