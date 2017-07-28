package com.focus3d.pano.admin.dao;

import java.util.List;

<<<<<<< HEAD
import com.focus3d.pano.model.PanoProduct;
import com.focus3d.pano.model.Product;

public interface IProductAdmDAO {
	public void addProduct(Product pro);
	public List<Product> listProducts();
	public Product getProductBySn(String psn);
	public int deleteProduct(String sn);
	public int updateProduct(Product pro);
	
=======
import com.focus3d.pano.model.Product;

public interface IProductAdmDAO {
	public void insert(Product pro);
	public List<Product> listProducts();
>>>>>>> 52bf08c4abab5c5ea0085a0d2f74e03c60009ab5
}
