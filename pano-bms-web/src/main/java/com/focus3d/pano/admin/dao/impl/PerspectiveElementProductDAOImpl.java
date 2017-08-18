package com.focus3d.pano.admin.dao.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.focus3d.pano.common.dao.CommonDao;
import com.focus3d.pano.model.ibator.PanoPerspectiveElementModel;
import com.focus3d.pano.model.ibator.PanoPerspectiveElementProduct;
import com.focus3d.pano.model.ibator.PanoPerspectiveElementProductCriteria;
import com.focus3d.pano.model.ibator.PanoPerspectiveElementProductModel;

@Repository
public class PerspectiveElementProductDAOImpl extends CommonDao<PanoPerspectiveElementProductModel> {
	public String UpdateElementProduct(PanoPerspectiveElementProductModel model) throws SQLException{
		Long element_sn = model.getSn();
		if(element_sn!=null){
			getSqlMapClient().update("pano_perspective_element_product"+UPDATE_BY_PRIMARYKEY_SELECTIVE,model);
		}else{
			getSqlMapClient().insert("pano_perspective_element_product"+INSERT,model);
		}
		return model.getSn().toString();
	}
	
	public PanoPerspectiveElementProduct QueryElementProduct(Long sn) throws SQLException{
		PanoPerspectiveElementProductCriteria productCriteria = new PanoPerspectiveElementProductCriteria();
		productCriteria.createCriteria().andSnEqualTo(sn);
		PanoPerspectiveElementProduct map = (PanoPerspectiveElementProduct)getSqlMapClient().queryForObject("pano_perspective_element_product"+SELECT_BY_EXAMPLE,productCriteria);
		return map;
	}
	
	public List<PanoPerspectiveElementProduct> QueryElementProdctList(Long sn) throws SQLException{
		List<PanoPerspectiveElementProduct> list = getSqlMapClient().queryForList("pano_perspective_element_product.query_element_product",sn);
		return list;
	}
	
	public List<Map<String, Object>> QueryPerspectiveInfoByProductSn(HashMap map) throws SQLException{
		List<Map<String, Object>> list = getSqlMapClient().queryForList("pano_perspective_element_product.query_product_view_element",map);
		return list;
	}
}
