package com.focus3d.pano.admin.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.focus3d.pano.admin.dao.IProductAdmDAO;
import com.focus3d.pano.common.dao.CommonDao;
import com.focus3d.pano.model.PanoUserModel;
import com.focus3d.pano.model.ProductModel;
@Repository("productAdmDAO")
public class ProductAdmDAO extends CommonDao<ProductModel> {


	public List<ProductModel> listproducts() throws SQLException {
		// TODO Auto-generated method stub
		 List<ProductModel> productList=(List<ProductModel>)getSqlMapClient().queryForList("listproducts");
		return productList;
	}
   
}
