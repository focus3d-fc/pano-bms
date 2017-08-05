package com.focus3d.pano.admin.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.focus3d.pano.admin.dao.PanoUserLongInDAO;
import com.focus3d.pano.model.PanoProductType;
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
	public List<PanoProjectPackageStyle> getPPPSSelect( PanoProjectPackageStyle ppps) {
		List<PanoProjectPackageStyle>  list =(List<PanoProjectPackageStyle>)getSqlMapClientTemplate().queryForList("pano_bm_longin.getPPPSSelect",ppps);
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

	@Override
	public int getdelete(PanoProjectPackageStyle sns) {
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

	@Override
	public List<getListPano> getselect1(getListPano pano) {
		List<getListPano> list = null;
		System.out.println("DAO");
		list	=(List<getListPano>)getSqlMapClientTemplate().queryForList("pano_bm_longin.getselect1",pano);
		System.out.println(list.size());
		System.out.println("DAO1");
		return list;
	}


}
