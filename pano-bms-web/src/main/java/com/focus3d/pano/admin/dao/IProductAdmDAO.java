package com.focus3d.pano.admin.dao;

import java.util.List;

import com.focus3d.pano.model.PanoProduct;
import com.focus3d.pano.model.Product;

public interface IProductAdmDAO {
	public void addProduct(Product pro);
	public List<Product> listProducts();
	public Product getProductBySn(String psn);
	public int deleteProduct(String sn);
	public int updateProduct(Product pro);
	
}
