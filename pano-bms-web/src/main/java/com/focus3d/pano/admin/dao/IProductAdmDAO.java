package com.focus3d.pano.admin.dao;

import java.util.List;
import java.util.Map;

import com.focus3d.pano.model.ProductFeature;
import com.focus3d.pano.model.ProductClassify;
import com.focus3d.pano.model.Product;
import com.focus3d.pano.model.ProductInfo;
import com.focus3d.pano.model.pano_project_style;

public interface IProductAdmDAO {
	public void addProduct(Product pro);
	public Integer countProductInfo(Map<String,Object> paramMap);
	public List<ProductInfo> listProductInfo(Map<String,Object> paramMap);
	public Product getProductBySn(String psn);
	public ProductInfo getProductDetail(String psn);
	public int deleteProduct(String sn);
	public int updateProduct(Product pro);
	public List<ProductClassify> listAllProType();
	public List<ProductFeature> listAllProFunc();
	public List<pano_project_style> listAllProStyle();
	public int ValidateProductId(String productId);
}
