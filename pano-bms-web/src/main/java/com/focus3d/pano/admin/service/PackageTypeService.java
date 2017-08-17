package com.focus3d.pano.admin.service;

import java.util.List;
import java.util.Map;

import com.focus3d.pano.model.GetproductList;
import com.focus3d.pano.model.PackageTypeList;
import com.focus3d.pano.model.Package_Product;
import com.focus3d.pano.model.Paging;
import com.focus3d.pano.model.PanoProjectPackageType;
import com.focus3d.pano.model.Product;
import com.focus3d.pano.model.ProductList;
import com.focus3d.pano.model.pano_project_space;

public interface PackageTypeService {
	public List<PanoProjectPackageType> getSelect(Long sn);  //根据户型套餐SN查询套餐类型是否为空
	public PackageTypeList getList(PackageTypeList sn);	// 若为空显示 固定的信息
	public 	List<pano_project_space> getSpace(Long sn); 	//查询 户型对应的空间Name
	public Long getAddType(PanoProjectPackageType type);  //添加 户型套餐SN  和 空间Sn 到套餐类型	
	public List<PanoProjectPackageType> getSelectType(Long sn); //通过 户型套餐表 主键得到 不同的空间Sn 和分类SN
	public PackageTypeList getSelectList(PackageTypeList type); // 得到 要显示的 楼盘 户型 空间 套餐....等值
	public int getDelete(Long sn); //根据主键 删除套餐类型一列
	
	
	
	
	

	/**
	 * 
	 * 	 产品DAO层 
	 * 
	 */
	
	public List<Package_Product> getProduct(Long sn); // 第一次进入产品页面时 有无数据
	public Paging getProductList(Map<String,Object> map,int pageNum); // 显示所有产品数值 模糊查询 和 分页
	/**
	 * 查询 风格 类型 功能名称
	 * @return
	 */
	public List<ProductList> getType(); 
	public List<ProductList> getFunc(); 
	public List<ProductList> getStyle(); 
	
	public GetproductList getListProduct(GetproductList list); //用于展示分类下产品的固定值
	
	public List<Product> getProductSn(Long sn);   //查看分类和产品关联的数据
	
	public GetproductList GetMap(Map map);//查询 分类下的产品在关联的数据
	
	public int  getdelete(Package_Product product);   //删除 分类下的产品在关联的数据
	
	public Long getinsert(Package_Product product);   //添加 分类下的产品在关联的数据
	
	public List<Package_Product> getSelectProduct(Long package_type_sn);   //先查询 分类产品里面的是否有重复的
}
