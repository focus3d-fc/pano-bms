package com.focus3d.pano.admin.dao.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.focus3d.pano.common.dao.CommonDao;
import com.focus3d.pano.model.ibator.PanoPerspectiveViewCriteria;
import com.focus3d.pano.model.ibator.PanoPerspectiveViewModel;

@Repository
public class PerspectiveViewDAOImpl extends CommonDao<PanoPerspectiveViewModel>{
	public String UpdateView(PanoPerspectiveViewModel model) throws SQLException{
		Long sn = model.getSn();
		if(sn!=null){
			getSqlMapClient().update("pano_perspective_view"+UPDATE_BY_PRIMARYKEY_SELECTIVE, model);
		}else{
			getSqlMapClient().insert("pano_perspective_view"+INSERT,model);
		}
		return model.getSn().toString();
	}
	
	public int DeleteView(PanoPerspectiveViewModel model) throws SQLException{
		int value = getSqlMapClient().delete("pano_perspective_view.delete_view",model);
		return value;
	}
	
	public List<LinkedHashMap<String, Object>> QueryViewAllProductInfo(PanoPerspectiveViewModel model) throws SQLException{
		List<LinkedHashMap<String, Object>> list = getSqlMapClient().queryForList("pano_perspective_view.view_all_products", model);
		return list;
	}
	
	public List<LinkedHashMap<String, Object>> QueryViewLayerElementInfo(Long sn) throws SQLException{
		List<LinkedHashMap<String, Object>> list = getSqlMapClient().queryForList("pano_perspective_view.view_layer_element", sn);
		return list;
	}
	
	public List<PanoPerspectiveViewModel> QueryViewInfo(PanoPerspectiveViewModel map) throws SQLException{
		PanoPerspectiveViewCriteria viewCriteria = new PanoPerspectiveViewCriteria();
		viewCriteria.createCriteria().andHouseStyleSnEqualTo(map.getHouseStyleSn()).andHouseSpaceSnEqualTo(map.getHouseSpaceSn());
		List<PanoPerspectiveViewModel> list = getSqlMapClient().queryForList("pano_perspective_view"+SELECT_BY_EXAMPLE, viewCriteria);
		return list;
	}
	
	public List<Map<String, Object>> QueryPackageTypeName(PanoPerspectiveViewModel map) throws SQLException{
		List<Map<String, Object>> list = getSqlMapClient().queryForList("pano_perspective_view.query_package_type", map);
		return list;
	}
	
	public List<String> QueryUsedPackageTypeName(Long sn) throws SQLException{
		List<String> list = getSqlMapClient().queryForList("pano_perspective_view.query_used_package_type", sn);
		return list;
	}
	
}
