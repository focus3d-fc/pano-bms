package com.focus3d.pano.admin.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.focus3d.pano.admin.dao.PanoUserLongInDAO;
import com.focus3d.pano.model.PanoProductType;
import com.focus3d.pano.model.PanoProjectHousePackage;
import com.focus3d.pano.model.PanoProjectPackage;
import com.focus3d.pano.model.PanoProjectPackageStyle;
import com.focus3d.pano.model.PanoUserLongin;
import com.focus3d.pano.model.getListPano;
@Repository
public class PanoUserLongInImpl extends BaseDao implements PanoUserLongInDAO{

	@Override
	public List<PanoUserLongin> getUserLongin(PanoUserLongin longin) {
		List<PanoUserLongin> list = null;
		list= 	(List<PanoUserLongin>)getSqlMapClientTemplate().queryForList("pano_bm_longin.getUserLongin",longin);
		return list;
	}

	@Override
	public List<PanoProjectPackageStyle> getPPPSSelect( Long house_style_sn) {
		List<PanoProjectPackageStyle>  list =(List<PanoProjectPackageStyle>)getSqlMapClientTemplate().queryForList("pano_bm_longin.getPPPSSelect",house_style_sn);
		return list;
	}
	
	
	@Override
	public List<getListPano> getpackage(getListPano sn) {
		List<getListPano> list = null;
		try{
			list	=(List<getListPano>)getSqlMapClientTemplate().queryForList("pano_bm_longin.getpackage",sn);
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	
	}
	
	public List<PanoProjectHousePackage> getpackage2(Long house_style_sn){
		List<PanoProjectHousePackage> list = null;
		list =  (List<PanoProjectHousePackage>)getSqlMapClientTemplate().queryForList("pano_bm_longin.getpackage2",house_style_sn);
		return list;
	}
	
	public List<PanoProjectPackageStyle> getpackage1(PanoProjectPackageStyle sn){
		return (List<PanoProjectPackageStyle>)getSqlMapClientTemplate().queryForList("pano_bm_longin.getpackage1",sn);
	}
	

	@Override
	public int getdelete(PanoProjectHousePackage sns) {
		return  getSqlMapClientTemplate().delete("pano_bm_longin.getdelete",sns);
	}

	@Override
	public List<PanoProjectPackage> getselect() {
		return (List<PanoProjectPackage>)getSqlMapClientTemplate().queryForList("pano_bm_longin.getselect");
		
	}

	@Override
	public Long getinsert(PanoProjectPackageStyle pano) {
		Long i = (Long)getSqlMapClientTemplate().insert("pano_bm_longin.getinsert",pano);
		return i;
	}
	
	public Long getinserts(PanoProjectHousePackage pano){
		Long i = null ;
		try{
		 i = (Long)getSqlMapClientTemplate().insert("pano_bm_longin.getinserts",pano);
		 System.out.println("套餐是否成功+="+i);
		}catch(Exception e){
			e.printStackTrace();
		}
		return i;
	}
	
	
	public List<PanoProjectPackageStyle>getselects(PanoProjectPackageStyle pano){
		List<PanoProjectPackageStyle> list = null;
		list =(List<PanoProjectPackageStyle>)getSqlMapClientTemplate().queryForList("pano_bm_longin.getselects",pano);
		return list;
	}
	
	@Override
	public List<getListPano> getselect1(getListPano pano) {
		List<getListPano> list = null;
		list	=(List<getListPano>)getSqlMapClientTemplate().queryForList("pano_bm_longin.getselect1",pano);
		System.out.println(list.size());
		return list;
	}

	@Override
	public int getInsert1(PanoProjectHousePackage sn) {
		int i =0;
		try{
		i=  getSqlMapClientTemplate().update("pano_bm_longin.getInsert5",sn);
		}catch(Exception e){
			e.printStackTrace();
		}
		return i;
	}


}
