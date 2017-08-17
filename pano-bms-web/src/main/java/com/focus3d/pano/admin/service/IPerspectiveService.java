package com.focus3d.pano.admin.service;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.focus3d.pano.model.ibator.PanoPerspectiveElementModel;
import com.focus3d.pano.model.ibator.PanoPerspectiveElementProduct;
import com.focus3d.pano.model.ibator.PanoPerspectiveElementProductModel;
import com.focus3d.pano.model.ibator.PanoPerspectiveLayerModel;
import com.focus3d.pano.model.ibator.PanoPerspectiveViewModel;

public interface IPerspectiveService{
	List<Map<String, Object>> QuerySpace(Long house_sn) throws SQLException;
	
	List<PanoPerspectiveViewModel> QueryViewInfo(PanoPerspectiveViewModel model) throws SQLException;
	
	List<LinkedHashMap<String, Object>> QueryViewAllProductInfo(PanoPerspectiveViewModel map) throws SQLException;
	
	List<Map<String, Object>> QueryElement(PanoPerspectiveElementModel model) throws SQLException;
	
	List<Map<String, Object>> QueryPackageTypeName(PanoPerspectiveViewModel map) throws SQLException;
	
	List<Map<String, Object>> queryElementProduct(PanoPerspectiveElementModel model) throws SQLException;
	
	PanoPerspectiveElementProduct QueryElementProductInfo(Long sn) throws SQLException;
	
	String UpdateView(PanoPerspectiveViewModel model) throws SQLException;
	
	String UpdateLayer(PanoPerspectiveLayerModel model) throws SQLException;
	
	String UpdateElement(PanoPerspectiveElementModel model) throws SQLException;
	
	int UpdateElementProductSn(PanoPerspectiveElementModel model) throws SQLException;
	
	String UpdateElementProduct(PanoPerspectiveElementProductModel model) throws SQLException;
	
	int DeleteElement(PanoPerspectiveElementModel model) throws SQLException;
	
	int DeleteLayer(PanoPerspectiveLayerModel model) throws SQLException;
	
	int DeleteView(PanoPerspectiveViewModel model) throws SQLException;
	
	void ExchangeElementOrder(String pre,String next) throws SQLException;
	
	void ExchangeLayerOrder(String pre,String next) throws SQLException;
}
