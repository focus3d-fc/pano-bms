package com.focus3d.pano.admin.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.focus3d.pano.admin.dao.impl.PerspectiveElementDAOImpl;
import com.focus3d.pano.admin.dao.impl.PerspectiveElementProductDAOImpl;
import com.focus3d.pano.admin.dao.impl.PerspectiveLayerDAOImpl;
import com.focus3d.pano.admin.dao.impl.PerspectiveSpaceDAOImpl;
import com.focus3d.pano.admin.dao.impl.PerspectiveViewDAOImpl;
import com.focus3d.pano.admin.service.IPerspectiveService;
import com.focus3d.pano.model.ibator.PanoPerspectiveElementModel;
import com.focus3d.pano.model.ibator.PanoPerspectiveElementProduct;
import com.focus3d.pano.model.ibator.PanoPerspectiveElementProductModel;
import com.focus3d.pano.model.ibator.PanoPerspectiveLayerModel;
import com.focus3d.pano.model.ibator.PanoPerspectiveViewModel;

@Service
@Transactional
public class PerspectiveServiceImpl implements IPerspectiveService{
	
	@Autowired
	private PerspectiveSpaceDAOImpl perspectiveSpace;
	@Autowired
	private PerspectiveViewDAOImpl perspectiveView;
	@Autowired
	private PerspectiveLayerDAOImpl perspectiveLayer;
	@Autowired
	private PerspectiveElementDAOImpl perspectiveElement;
	@Autowired
	private PerspectiveElementProductDAOImpl perspectiveElementProduct;
	
	@Override
	public List<Map<String, Object>> QuerySpace(Long house_sn) throws SQLException{
		List<String> valueList = new ArrayList<String>();
		
		List<Map<String, Object>> list = perspectiveSpace.QuerySpace(house_sn);
		
		return list; 
	}
	
	@Override
	public List<PanoPerspectiveViewModel> QueryViewInfo(PanoPerspectiveViewModel model) throws SQLException {
		List<PanoPerspectiveViewModel> view = perspectiveView.QueryViewInfo(model);
		return view;
	}
	
	public String UpdateView(PanoPerspectiveViewModel model) throws SQLException{
		String value = perspectiveView.UpdateView(model);
		return value;
	}
	
	public String UpdateLayer(PanoPerspectiveLayerModel model) throws SQLException{
		String value = perspectiveLayer.UpdateLayer(model);
		return value;
	}

	@Override
	public List<LinkedHashMap<String, Object>> QueryViewAllProductInfo(PanoPerspectiveViewModel map) throws SQLException {
		List<LinkedHashMap<String, Object>> list = perspectiveView.QueryViewAllProductInfo(map);
		return list;
	}

	@Override
	public List<Map<String, Object>> QueryPackageTypeName(PanoPerspectiveViewModel map) throws SQLException {
		List<Map<String, Object>> list = perspectiveView.QueryPackageTypeName(map);
		return list;
	}

	@Override
	public String UpdateElement(PanoPerspectiveElementModel model) throws SQLException {
		String value = perspectiveElement.UpdateElement(model);
		return value;
	}

	@Override
	public List<Map<String, Object>> queryElementProduct(PanoPerspectiveElementModel model) throws SQLException {
		List<Map<String, Object>> list = perspectiveElement.QueryElementProduct(model);
		return list;
	}
	
	@Override
	public List<Map<String, Object>> QueryElement(PanoPerspectiveElementModel model) throws SQLException {
		List<Map<String, Object>> list = perspectiveElement.QueryElement(model);
		return list;
	}

	@Override
	public String UpdateElementProduct(PanoPerspectiveElementProductModel model) throws SQLException {
		String value = perspectiveElementProduct.UpdateElementProduct(model);
		return value;
	}

	@Override
	public PanoPerspectiveElementProduct QueryElementProductInfo(Long sn) throws SQLException {
		PanoPerspectiveElementProduct map = perspectiveElementProduct.QueryElementProduct(sn);
		return map;
	}

	@Override
	public int DeleteElement(PanoPerspectiveElementModel model) throws SQLException {
		int value = perspectiveElement.DeleteElement(model);
		return 0;
	}

	@Override
	public int DeleteLayer(PanoPerspectiveLayerModel model) throws SQLException {
		int value = perspectiveLayer.DeleteLayer(model);
		return value;
	}

	@Override
	public int DeleteView(PanoPerspectiveViewModel model) throws SQLException {
		int value = perspectiveView.DeleteView(model);
		return value;
	}

	@Override
	public void ExchangeElementOrder(String pre,String next) throws SQLException {
		perspectiveElement.ExchangeOrder(pre,next);
	}

	@Override
	public void ExchangeLayerOrder(String pre,String next) throws SQLException {
		perspectiveLayer.ExchangeOrder(pre,next);
	}

	@Override
	public int UpdateElementProductSn(PanoPerspectiveElementModel model)
			throws SQLException {
		int value = perspectiveElement.UpdateElementProductSn(model);
		return value;
	}

	@Override
	public List<Map<String, Object>> QueryPerspectiveInfo(HashMap map) throws SQLException {
		List<Map<String, Object>> list = perspectiveElementProduct.QueryPerspectiveInfoByProductSn(map);
		return list;
	}

	@Override
	public List<PanoPerspectiveElementProduct> QueryElementProdctList(
			Long elementSn) throws SQLException {
		List<PanoPerspectiveElementProduct> list = perspectiveElementProduct.QueryElementProdctList(elementSn);
		return list;
	}

	@Override
	public List<LinkedHashMap<String, Object>> QueryViewLayerElementInfo(Long sn) throws SQLException {
		List<LinkedHashMap<String, Object>> list = perspectiveView.QueryViewLayerElementInfo(sn);
		return null;
	}

	@Override
	public List<String> QueryUsedPackageTypeName(Long sn) throws SQLException {
		List<String> list = perspectiveView.QueryUsedPackageTypeName(sn);
		return list;
	}

}
