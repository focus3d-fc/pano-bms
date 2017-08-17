package com.focus3d.pano.admin.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.focus3d.pano.admin.dao.PackageTypeDAO;
import com.focus3d.pano.admin.service.PackageTypeService;
import com.focus3d.pano.model.GetproductList;
import com.focus3d.pano.model.PackageTypeList;
import com.focus3d.pano.model.Package_Product;
import com.focus3d.pano.model.Paging;
import com.focus3d.pano.model.PanoProjectPackageType;
import com.focus3d.pano.model.Product;
import com.focus3d.pano.model.ProductList;
import com.focus3d.pano.model.pano_project_space;
@Service
public class PackageTypeServiceImpl implements PackageTypeService{
		@Autowired
		private PackageTypeDAO typeDao;
	
		/**
		 * 根据户型套餐 查询 套餐类型的 是否为 空
		 */
		
	public List<PanoProjectPackageType> getSelect(Long sn) {
		return typeDao.getSelect(sn);
	}
	
	
	/**
	 * 若为空 则显示固定的数值的
	 */
	public PackageTypeList getList(PackageTypeList sn) {
		 PackageTypeList list = null;
		 List<PackageTypeList> lists = typeDao.getList(sn);
		 	if(lists.size()>0){
			list = lists.get(0);
		 	}
		 	return list;
		}


	/**
	 * 	根据户型的Sn 查询对应的 空间Name
	 */
	public List<pano_project_space> getSpace(Long sn) {
		return typeDao.getSpace(sn);
	}


	/**
	 *  前台得到 户型套餐Sn 和 空间SN 和输入的类别名称 到套餐类型表
	 */
	public Long getAddType(PanoProjectPackageType type) {
		return typeDao.getAddType(type);
	}


	/**
	 *  通过 户型套餐表 主键得到 不同的空间Sn 和分类SN
	 */
	public List<PanoProjectPackageType> getSelectType(Long sn) {
		return typeDao.getSelectType(sn);
	}



	/**
	 *  查询要显示的 楼盘 户型 空间 套餐....等值
	 *  因为通过 套餐类型主页查询的 空间 和 户型套餐Sn 得到的数值是唯一的
	 *  所以把List 转换成 一个对象
	 */
	public PackageTypeList getSelectList(PackageTypeList type) {
		PackageTypeList list = null;
		List<PackageTypeList> selectList = typeDao.getSelectList(type);
		if(selectList.size()>0){
			list = selectList.get(0);
		}
		return list;
	}


	/***
	 *  根据主键 删除套餐类型的一列
	 */
	public int getDelete(Long sn) {
		return typeDao.getDelete(sn);
	}




	
	
	
	
	
	
	
	
	
	/**
	 * 
	 *    产品页面功能  
	 *    
	 * 
	 *   第一次进入页面时 没有
	 */
	public List<Package_Product> getProduct(Long sn) {
		return typeDao.getProduct(sn);
	}


	
	public Paging getProductList(Map<String,Object> map,int pageNum) {
		System.out.println("Service层执行查询总记录数数据开始");
		Integer totalRecord = typeDao.getTotalRecord(map);
		System.out.println("Service层执行查询总记录数数据结束总记录数是："+totalRecord);
		Paging page = new Paging(totalRecord,pageNum);
		System.out.println("当前的索引位置"+page.getStartIndex()+" /每行显示页数："+page.getPageSize()+"当前页数："+page.getPageNum());
		map.put("startIndex",page.getStartIndex() );
		map.put("pageSize", page.getPageSize());
		System.out.println("Service层执行查询List数据开始");
		List<ProductList> productList = typeDao.getProductList(map);
		System.out.println("Service层执行查询List数据结束查询出长度为："+productList.size());
		page.setList(productList);
		return page;
	}


	public List<ProductList> getType() {
		return typeDao.getType();
	}

	public List<ProductList> getFunc() {
		return typeDao.getFunc();
	}

	public List<ProductList> getStyle() {
		return typeDao.getStyle();
	}


	@Override
	public GetproductList getListProduct(GetproductList list) {
		GetproductList prList = null;
		List<GetproductList> listProduct = typeDao.getListProduct(list);
		if(listProduct.size()>0){
			prList = listProduct.get(0);
		}
		return prList;
	}


	@Override
	public List<Product> getProductSn(Long sn) {
		return typeDao.getProductSn(sn);
				
	}


	@Override
	public GetproductList GetMap(Map map) {
		GetproductList list = null;
		List<GetproductList> getMap = typeDao.GetMap(map);
		if(getMap.size()>0){
			list = getMap.get(0);
		}
		return list;
	}


	@Override
	public int getdelete(Package_Product product) {
		return typeDao.getdelete(product);
	}


	@Override
	public Long getinsert(Package_Product product) {
		return typeDao.getinsert(product);
	}


	@Override
	public List<Package_Product> getSelectProduct(Long package_type_sn) {
		return typeDao.getSelectProduct(package_type_sn);
	}



}
