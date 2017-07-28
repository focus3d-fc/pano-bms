package com.focus3d.pano.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.focus3d.pano.admin.dao.IProductAdmDAO;

import com.focus3d.pano.admin.service.IProductAdmService;
import com.focus3d.pano.model.PanoProduct;
import com.focus3d.pano.model.Product;
@Service("productAdmService")
public class ProductAdmServiceImpl implements IProductAdmService{

	
	@Autowired
	private IProductAdmDAO productAdmDAO;

	@Override
	public void addProduct(Product pro) {
		// TODO Auto-generated method stub
		productAdmDAO.addProduct(pro);
	}

	@Override
	public List<Product> listProducts() {
		// TODO Auto-generated method stub
		return productAdmDAO.listProducts();
	}

	@Override
	public Product getProductBySn(String psn) {
		// TODO Auto-generated method stub
		return productAdmDAO.getProductBySn(psn);
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
	
	
   
	 
}
