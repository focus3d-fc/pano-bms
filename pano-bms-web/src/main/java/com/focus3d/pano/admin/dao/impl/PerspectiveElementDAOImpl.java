package com.focus3d.pano.admin.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;

import com.focus3d.pano.common.dao.CommonDao;
import com.focus3d.pano.model.Product;
import com.focus3d.pano.model.ibator.PanoPerspectiveElementModel;
import com.focus3d.pano.model.ibator.PanoPerspectiveLayerModel;

@Repository
public class PerspectiveElementDAOImpl extends CommonDao<PanoPerspectiveElementModel> {
	public String UpdateElement(PanoPerspectiveElementModel model) throws SQLException{
		Long sn = model.getSn();
		if(sn!=null){
			getSqlMapClient().update("pano_perspective_element"+UPDATE_BY_PRIMARYKEY_SELECTIVE,model);
		}else{
			int order = QueryElementMaxOrder(model) + 1;
			model.setElementOrder(order);
			getSqlMapClient().insert("pano_perspective_element"+INSERT,model);
		}
		return model.getSn().toString();
	}
	
	public int UpdateElementProductSn(PanoPerspectiveElementModel model) throws SQLException{
		int value = getSqlMapClient().update("pano_perspective_element.update_element_productsn", model);
		return value;
	}
	
	public int QueryElementMaxOrder(PanoPerspectiveElementModel model) throws SQLException{
		Object result = getSqlMapClient().queryForObject("pano_perspective_element.query_max_order",model);
		int value = result == null?0:Integer.parseInt(result.toString());
		return value;
	}
	
	public int QueryElementOrder(Long elementSn) throws SQLException{
		int value = Integer.parseInt(getSqlMapClient().queryForObject("pano_perspective_element.query_order",elementSn).toString());
		return value;
	}
	
	public int DeleteElement(PanoPerspectiveElementModel model) throws SQLException{
		int value = getSqlMapClient().delete("pano_perspective_element.delete_element",model);
		return value;
	}
	
	public List<Map<String, Object>> QueryElement(PanoPerspectiveElementModel model) throws SQLException{
		List<Map<String, Object>> list = getSqlMapClient().queryForList("pano_perspective_element.query_element",model);
		return list;
	}
	
	public List<Map<String, Object>> QueryElementProduct(PanoPerspectiveElementModel model) throws SQLException{
		List<Map<String, Object>> list = (List<Map<String, Object>>)getSqlMapClient().queryForList("pano_perspective_element.query_element_product",model);
		return list;
	}
	
	public void ExchangeOrder(String _pre,String _next) throws SQLException{
		Long pre = Long.parseLong(_pre);
		Long next = Long.parseLong(_next);
		
		int pre_order = QueryElementOrder(pre);
		int next_order = QueryElementOrder(next);
		
		PanoPerspectiveElementModel pre_model = new PanoPerspectiveElementModel();
		pre_model.setSn(pre);
		pre_model.setElementOrder(next_order);
		
		PanoPerspectiveElementModel next_model = new PanoPerspectiveElementModel();
		next_model.setSn(next);
		next_model.setElementOrder(pre_order);
		
		UpdateElement(pre_model);
		UpdateElement(next_model);
	}
}
