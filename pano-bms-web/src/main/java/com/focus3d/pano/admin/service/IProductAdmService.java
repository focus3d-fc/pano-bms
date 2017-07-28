package com.focus3d.pano.admin.service;

import java.util.List;

<<<<<<< HEAD
import com.focus3d.pano.model.PanoProduct;
=======
>>>>>>> 52bf08c4abab5c5ea0085a0d2f74e03c60009ab5
import com.focus3d.pano.model.Product;
import com.focus3d.pano.model.ProductModel;

public interface IProductAdmService {

	//public List<ProductModel> listproducts();
<<<<<<< HEAD
	public void addProduct(Product pro);
	public List<Product> listProducts();
	public Product getProductBySn(String psn);
	public Boolean deleteProduct(String sn);
	public boolean updateProduct(Product pro);
=======
	public void insert(Product pro);
	public List<Product> listProducts();
>>>>>>> 52bf08c4abab5c5ea0085a0d2f74e03c60009ab5
}
