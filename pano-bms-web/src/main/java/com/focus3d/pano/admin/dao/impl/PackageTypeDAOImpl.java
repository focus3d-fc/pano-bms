package com.focus3d.pano.admin.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.focus3d.pano.model.PackageTypeList;
import com.focus3d.pano.model.PanoProjectPackageType;
import com.focus3d.pano.model.PanoUserLongin;
import com.focus3d.pano.model.pano_project_space;
@Repository
public class PackageTypeDAOImpl extends BaseDao implements PackageTypeDAO{

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

}
