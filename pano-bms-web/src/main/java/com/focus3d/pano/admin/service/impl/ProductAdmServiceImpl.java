package com.focus3d.pano.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.focus3d.pano.admin.dao.IProductAdmDAO;

import com.focus3d.pano.admin.service.IProductAdmService;
import com.focus3d.pano.model.Product;
@Service("productAdmService")
public class ProductAdmServiceImpl implements IProductAdmService{

	
	@Autowired
	private IProductAdmDAO productAdmDAO;

	@Override
	public void insert(Product pro) {
		// TODO Auto-generated method stub
		productAdmDAO.insert(pro);
	}

	@Override
	public List<Product> listProducts() {
		// TODO Auto-generated method stub
		return productAdmDAO.listProducts();
	}
	
	
   
	 
}
