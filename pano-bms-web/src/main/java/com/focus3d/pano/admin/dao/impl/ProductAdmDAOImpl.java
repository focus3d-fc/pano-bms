package com.focus3d.pano.admin.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.focus3d.pano.admin.dao.IProductAdmDAO;
import com.focus3d.pano.common.dao.CommonDao;
import com.focus3d.pano.model.PanoProduct;
import com.focus3d.pano.model.PanoProductFunc;
import com.focus3d.pano.model.PanoProductType;
import com.focus3d.pano.model.Product;
import com.focus3d.pano.model.ProductInfo;
import com.focus3d.pano.model.ProductModel;
import com.focus3d.pano.model.pano_project_style;
@Repository
public class ProductAdmDAOImpl extends BaseDao implements IProductAdmDAO{

	/*public List<ProductModel> listproducts()  {
		// TODO Auto-generated method stub
		 List<ProductModel> productList=new ArrayList<ProductModel>();
		try {
			productList = (List<ProductModel>)getSqlMapClient().queryForList("listproducts");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productList;
	}*/
	 public ProductAdmDAOImpl(){
	    	System.out.println("-------------mvcIbatisDaoImpl----------------");
	    }
		
	
	public void addProduct(Product pro) {
		// TODO Auto-generated method stub
		super.getSqlMapClientTemplate().insert("pano_product.insert",pro);
	}

	
	
	@Override
	public Integer countProductInfo(Map<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return (Integer)getSqlMapClientTemplate().queryForObject("pano_product.countProductInfo", paramMap);
	}


	public List<ProductInfo> listProductInfo(Map<String,Object> paramMap) {
		// TODO Auto-generated method stub
		
		List<ProductInfo> productInfoList=(List<ProductInfo>)getSqlMapClientTemplate().queryForList("pano_product.getAllProductInfo",paramMap);
		return productInfoList;
	}


	@Override
	public Product getProductBySn(String psn) {
		// TODO Auto-generated method stub
		Product product=(Product)getSqlMapClientTemplate().queryForObject("pano_product.getProductBySn", psn);
		return product;
	}


	@Override
	public ProductInfo getProductDetail(String psn) {
		// TODO Auto-generated method stub
		return (ProductInfo)getSqlMapClientTemplate().queryForObject("pano_product.getProductDetailBySn", psn);
	}


	@Override
	public int deleteProduct(String sn) {
		// TODO Auto-generated method stub
		int row=-1;
		row=getSqlMapClientTemplate().delete("pano_product.deleteProductBySn", sn);
		return row ;
	}


	@Override
	public int updateProduct(Product pro) {
		// TODO Auto-generated method stub
		int row=-1;
		row=getSqlMapClientTemplate().update("pano_product.updateProduct", pro);
		return row ;
	}


	@Override
	public List<PanoProductType> listAllProType() {
		// TODO Auto-generated method stub
		List<PanoProductType> proTypeList=(List<PanoProductType>)getSqlMapClientTemplate().queryForList("pano_product.getAllProType");
		return proTypeList;
	}


	@Override
	public List<PanoProductFunc> listAllProFunc() {
		// TODO Auto-generated method stub
		 List<PanoProductFunc> proFuncList=(List<PanoProductFunc>)getSqlMapClientTemplate().queryForList("pano_product.getAllProFunc");
		return proFuncList;
	}


	@Override
	public List<pano_project_style> listAllProStyle() {
		// TODO Auto-generated method stub
		List<pano_project_style> prosTyleList=(List<pano_project_style>)getSqlMapClientTemplate().queryForList("pano_product.getAllProStyle");
		return prosTyleList;
	}
	
	
}
