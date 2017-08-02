package com.focus3d.pano.admin.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.focus3d.pano.admin.dao.PanoUserLongInDAO;
import com.focus3d.pano.model.PanoProductType;
import com.focus3d.pano.model.PanoUserLongin;
@Repository
public class PanoUserLongInImpl extends BaseDao implements PanoUserLongInDAO{

	@Override
	public List<PanoUserLongin> getUserLongin(PanoUserLongin longin) {
		List<PanoUserLongin> list = null;
		System.out.println("DAO");
		try{
		list= 	(List<PanoUserLongin>)getSqlMapClientTemplate().queryForList("pano_bm_longin.getUserLongin",longin);
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("DAO1");
		return list;
	}

}
