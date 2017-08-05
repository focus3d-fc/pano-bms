package com.focus3d.pano.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.focus3d.pano.admin.dao.PanoUserLongInDAO;
import com.focus3d.pano.admin.service.PanoUserLongInService;
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
	public List<PanoProjectPackageStyle> getPPPSSelect(PanoProjectPackageStyle ppps) {
		List<PanoProjectPackageStyle> pppsSelect = userlongin.getPPPSSelect(ppps);
		return pppsSelect;
	}
	
	
	@Override
	public getListPano getpackage(getListPano sn) {
	      getListPano getpackage =null;
		List<getListPano> getpackage2 = userlongin.getpackage(sn);
		if(getpackage2.size()>0){
			getpackage = getpackage2.get(0);
		}
		return getpackage;
	}
	@Override
	public int getdelete(PanoProjectPackageStyle sns) {
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
	@Override
	public getListPano getselect1(getListPano pano) {
		getListPano getList = null;
		List<getListPano> getListPano = userlongin.getselect1(pano);
		System.out.println("service长度"+getListPano.size());
		if(getListPano.size()>0){
			System.out.println("1");
			getList = getListPano.get(0);
		}
		System.out.println("2");
		return getList;
	}
	

}
