package com.focus3d.pano.admin.service;

import java.util.List;

import com.focus3d.pano.model.PanoProduct;
import com.focus3d.pano.model.Product;
import com.focus3d.pano.model.ProductModel;

public interface IProductAdmService {

	//public List<ProductModel> listproducts();
	public void addProduct(Product pro);
	public List<Product> listProducts();
	public Product getProductBySn(String psn);
	public Boolean deleteProduct(String sn);
	public boolean updateProduct(Product pro);
}
