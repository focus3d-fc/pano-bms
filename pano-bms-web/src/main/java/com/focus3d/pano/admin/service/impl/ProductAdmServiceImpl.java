package com.focus3d.pano.admin.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.focus3d.pano.admin.dao.IProductAdmDAO;
import com.focus3d.pano.admin.dao.IProductDAO;
import com.focus3d.pano.admin.service.IProductAdmService;
import com.focus3d.pano.model.ProductFeature;
import com.focus3d.pano.model.ProductClassify;
import com.focus3d.pano.model.PanoVender;
import com.focus3d.pano.model.Product;
import com.focus3d.pano.model.ProductInfo;
import com.focus3d.pano.model.pano_project_style;
@Service("productAdmService")
public class ProductAdmServiceImpl implements IProductAdmService{

	
	@Autowired
	private IProductAdmDAO productAdmDAO;
	
	@Autowired
	private IProductDAO panoProductFuncDAO;

	@Override
	public void addProduct(Product pro) {
		// TODO Auto-generated method stub
		productAdmDAO.addProduct(pro);
	}

	
	@Override
	public Integer countProductInfo(Map<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return productAdmDAO.countProductInfo(paramMap);
	}


	@Override
	public List<ProductInfo> listProductInfo(Map<String,Object> paramMap) {
		// TODO Auto-generated method stub
		return productAdmDAO.listProductInfo(paramMap);
	}

	@Override
	public Product getProductBySn(String psn) {
		// TODO Auto-generated method stub
		return productAdmDAO.getProductBySn(psn);
	}

	@Override
	public ProductInfo getProductDetail(String psn) {
		// TODO Auto-generated method stub
		return productAdmDAO.getProductDetail(psn);
	}

	@Override
	public Boolean deleteProduct(String sn) {
		// TODO Auto-generated method stub
		int row=-1;
		row=productAdmDAO.deleteProduct(sn);
		return row==1;
		
	}

	@Override
	public boolean updateProduct(Product pro) {
		// TODO Auto-generated method stub
		int row=-1;
		row=productAdmDAO.updateProduct(pro);
		return row==1;
	}

	@Override
	public List<ProductClassify> listAllProType() {
		// TODO Auto-generated method stub
		return productAdmDAO.listAllProType();
	}

	@Override
	public List<ProductFeature> listAllProFunc() {
		// TODO Auto-generated method stub
		return productAdmDAO.listAllProFunc();
	}

	@Override
	public List<pano_project_style> listAllProStyle() {
		// TODO Auto-generated method stub
		return productAdmDAO.listAllProStyle();
	}


	@Override
	public List<PanoVender> listAllVender() {
		return panoProductFuncDAO.getBasics2();
	}
	
	@Override
	public int ValidateProductId(String productId){
		return productAdmDAO.ValidateProductId(productId);
	}
}
