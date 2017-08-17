package com.focus3d.pano.admin.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.focus3d.pano.admin.dao.PackageTypeDAO;
import com.focus3d.pano.model.GetproductList;
import com.focus3d.pano.model.PackageTypeList;
import com.focus3d.pano.model.Package_Product;
import com.focus3d.pano.model.PanoProjectPackageType;
import com.focus3d.pano.model.PanoUserLongin;
import com.focus3d.pano.model.Product;
import com.focus3d.pano.model.ProductList;
import com.focus3d.pano.model.pano_project_space;
@Repository
public  class PackageTypeDAOImpl extends BaseDao implements PackageTypeDAO{

	/**
	 * 根据户型套餐 查询 套餐类型的 是否为 空
	 */
	public List<PanoProjectPackageType> getSelect(Long sn) {
		return 	(List<PanoProjectPackageType>)getSqlMapClientTemplate().queryForList("pano_project_package_type.getSelect",sn);
	}
	
	

	/**
	 * 若为空 则显示固定的数值的
	 */
	public List<PackageTypeList> getList(PackageTypeList sn) {
		List<PackageTypeList> list = null;
		try{
		list =(List<PackageTypeList>)getSqlMapClientTemplate().queryForList("pano_project_package_type.getList",sn);
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}

	
	/**
	 * 	根据户型的Sn 查询对应的 空间Name
	 */
	
	public 	List<pano_project_space> getSpace(Long sn) {
		List<pano_project_space> list = null;
		try{
		list = (List<pano_project_space>)getSqlMapClientTemplate().queryForList("pano_project_package_type.getSpace",sn);
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}



	/**
	 *  前台得到 户型套餐Sn 和 空间SN 和输入的类别名称 到套餐类型表
	 */
	public Long getAddType(PanoProjectPackageType type) {
		Long i = null ;
		try{
		 i = (Long)getSqlMapClientTemplate().insert("pano_project_package_type.getAddType",type);
		}catch(Exception e){
			e.printStackTrace();
		}
		return i;
	}



	/**
	 *  通过 户型套餐表 主键得到 不同的空间Sn 和分类SN
	 */
	public List<PanoProjectPackageType> getSelectType(Long sn) {
		return (List<PanoProjectPackageType>)getSqlMapClientTemplate().queryForList("pano_project_package_type.getSelectType",sn);
	}



	/**
	 *  查询要显示的 楼盘 户型 空间 套餐....等值
	 */
	public List<PackageTypeList> getSelectList(PackageTypeList type) {
		List<PackageTypeList> list = null;
		try{
			list =(List<PackageTypeList>)getSqlMapClientTemplate().queryForList("pano_project_package_type.getSelectList",type);
		}catch(Exception e){
			e.printStackTrace();
		}
			return list;
	}



	/**
	 * 根据主键 删除套餐类型 一列
	 */
	public int getDelete(Long sn) {
		return  getSqlMapClientTemplate().delete("pano_project_package_type.getDelete",sn);
	}



	
	
	
	
	
	
	
	
	
	
	/**
	 * 
	 *    产品页面功能  
	 *    
	 * 
	 *   第一次进入页面时 没有
	 */
	public List<Package_Product> getProduct(Long sn) {
		return 	(List<Package_Product>)getSqlMapClientTemplate().queryForList("pano_project_package_type.getProduct",sn);
		
	}



	/**
	 * 根据 前台穿的值 封装到一个Map里面 查询所有的产品数值
	 */
	public List<ProductList> getProductList(Map<String, Object> map) {
		List<ProductList> list = null;
		try{
		list = (List<ProductList>)getSqlMapClientTemplate().queryForList("pano_project_package_type.getProductList",map);
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}



	/**
	 * 查询总记录数
	 */
	public Integer getTotalRecord(Map<String, Object> map) {
		Integer integer = null;
		try{
		 integer = (Integer)getSqlMapClientTemplate().queryForObject("pano_project_package_type.getTotalRecord", map);
		}catch(Exception e){
			e.printStackTrace();
		}
		return integer;
	}


	/**
	 * 查询风格 功能 类型名称
	 */
	public List<ProductList> getType() {
		return (List<ProductList>)getSqlMapClientTemplate().queryForList("pano_project_package_type.getType");
	}

	public List<ProductList> getFunc() {
		return (List<ProductList>)getSqlMapClientTemplate().queryForList("pano_project_package_type.getFunc");
	}

	public List<ProductList> getStyle() {
		return (List<ProductList>)getSqlMapClientTemplate().queryForList("pano_project_package_type.getStyle");
	}



	@Override
	public List<GetproductList> getListProduct(GetproductList list) {
		return (List<GetproductList>)getSqlMapClientTemplate().queryForList("pano_project_package_type.getListProduct",list);
	}



	@Override
	public List<Product> getProductSn(Long sn) {
		return (List<Product>)getSqlMapClientTemplate().queryForList("pano_project_package_type.getProductSn",sn); 
	}



	@Override
	public List<GetproductList> GetMap(Map map) {
		return (List<GetproductList>)getSqlMapClientTemplate().queryForList("pano_project_package_type.GetMap",map); 
	}



	@Override
	public int getdelete(Package_Product product) {
		return  getSqlMapClientTemplate().delete("pano_project_package_type.getdelete",product);
	}



	@Override
	public Long getinsert(Package_Product product) {
		
		return  (Long)getSqlMapClientTemplate().insert("pano_project_package_type.getinsert",product);
	}



	@Override
	public List<Package_Product> getSelectProduct(Long package_type_sn) {
		return (List<Package_Product>)getSqlMapClientTemplate().queryForList("pano_project_package_type.getSelectProduct",package_type_sn); 
	} 

}
