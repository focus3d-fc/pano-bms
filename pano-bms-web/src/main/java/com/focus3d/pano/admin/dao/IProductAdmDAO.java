package com.focus3d.pano.admin.dao;

import java.util.List;

import com.focus3d.pano.model.Product;

public interface IProductAdmDAO {
	public void insert(Product pro);
	public List<Product> listProducts();
}
