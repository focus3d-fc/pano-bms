package com.focus3d.pano.admin.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.focus3d.pano.admin.dao.IProductAdmDAO;
import com.focus3d.pano.common.dao.CommonDao;
import com.focus3d.pano.model.PanoProduct;
import com.focus3d.pano.model.Product;
import com.focus3d.pano.model.ProductModel;
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

	
	public List<Product> listProducts() {
		// TODO Auto-generated method stub
		
		List<Product> productList=(List<Product>)getSqlMapClientTemplate().queryForList("pano_product.getAllProducts");
		return productList;
	}


	@Override
	public Product getProductBySn(String psn) {
		// TODO Auto-generated method stub
		Product product=(Product)getSqlMapClientTemplate().queryForObject("pano_product.getProductBySn", psn);
		return product;
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
	
	
}
