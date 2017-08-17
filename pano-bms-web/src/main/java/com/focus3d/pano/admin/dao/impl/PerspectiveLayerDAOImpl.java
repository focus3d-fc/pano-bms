package com.focus3d.pano.admin.dao.impl;

import java.sql.SQLException;

import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;

import com.focus3d.pano.common.dao.CommonDao;
import com.focus3d.pano.model.ibator.PanoPerspectiveElementModel;
import com.focus3d.pano.model.ibator.PanoPerspectiveLayerModel;

@Repository
public class PerspectiveLayerDAOImpl extends CommonDao<PanoPerspectiveLayerModel> {
	public String UpdateLayer(PanoPerspectiveLayerModel model) throws SQLException{
		Long sn = model.getSn();
		if(sn!=null){
			getSqlMapClient().update("pano_perspective_layer"+UPDATE_BY_PRIMARYKEY_SELECTIVE, model);
		}else{
			int order = QueryLayerMaxOrder(model)+1;
			model.setLayerOrder(order);
			getSqlMapClient().insert("pano_perspective_layer"+INSERT,model);
		}
		return model.getSn().toString();
	}
	
	public int DeleteLayer(PanoPerspectiveLayerModel model) throws SQLException{
		int value = getSqlMapClient().delete("pano_perspective_layer.delete_layer",model);
		return value;
	}
	
	public int QueryLayerMaxOrder(PanoPerspectiveLayerModel model) throws SQLException{
		Object result =	getSqlMapClient().queryForObject("pano_perspective_layer.query_max_order",model);
		int value = result == null?0:Integer.parseInt(result.toString());
		return value;
	}
	
	public int QueryLayerOrder(Long layerSn) throws SQLException{
		int value = Integer.parseInt(getSqlMapClient().queryForObject("pano_perspective_layer.query_order",layerSn).toString());
		return value;
	}
	
	public void ExchangeOrder(String _pre,String _next) throws SQLException{
		Long pre = Long.parseLong(_pre);
		Long next = Long.parseLong(_next);
		
		int pre_order = QueryLayerOrder(pre);
		int next_order = QueryLayerOrder(next);
		
		PanoPerspectiveLayerModel pre_model = new PanoPerspectiveLayerModel();
		pre_model.setSn(pre);
		pre_model.setLayerOrder(next_order);
		
		PanoPerspectiveLayerModel next_model = new PanoPerspectiveLayerModel();
		next_model.setSn(next);
		next_model.setLayerOrder(pre_order);
		
		UpdateLayer(pre_model);
		UpdateLayer(next_model);
	}
}
