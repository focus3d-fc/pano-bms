package com.focus3d.pano.admin.dao;

import java.util.List;
import java.util.Map;

import com.focus3d.pano.model.PanoProductFunc;
import com.focus3d.pano.model.PanoProductType;
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
	public List<PanoProductType> listAllProType();
	public List<PanoProductFunc> listAllProFunc();
	public List<pano_project_style> listAllProStyle();
}
