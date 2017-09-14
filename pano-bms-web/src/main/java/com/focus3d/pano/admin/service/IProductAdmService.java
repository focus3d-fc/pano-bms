package com.focus3d.pano.admin.service;

import java.util.List;
import java.util.Map;

import com.focus3d.pano.model.ProductFeature;
import com.focus3d.pano.model.ProductClassify;
import com.focus3d.pano.model.PanoVender;
import com.focus3d.pano.model.Product;
import com.focus3d.pano.model.ProductInfo;
import com.focus3d.pano.model.pano_project_style;

public interface IProductAdmService {

	//public List<ProductModel> listproducts();
	public void addProduct(Product pro);
	public Integer countProductInfo(Map<String,Object> paramMap);
	public List<ProductInfo> listProductInfo(Map<String,Object> paramMap);
	public Product getProductBySn(String psn);
	public ProductInfo getProductDetail(String psn);
	public Boolean deleteProduct(String sn);
	public boolean updateProduct(Product pro);
	public List<ProductClassify> listAllProType();
	public List<ProductFeature> listAllProFunc();
	public List<pano_project_style> listAllProStyle();
	public List<PanoVender> listAllVender();
	public int ValidateProductId(String productId);
}
