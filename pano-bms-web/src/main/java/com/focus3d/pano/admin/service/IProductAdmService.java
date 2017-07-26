package com.focus3d.pano.admin.service;

import java.util.List;

import com.focus3d.pano.model.Product;
import com.focus3d.pano.model.ProductModel;

public interface IProductAdmService {

	//public List<ProductModel> listproducts();
	public void insert(Product pro);
	public List<Product> listProducts();
}
