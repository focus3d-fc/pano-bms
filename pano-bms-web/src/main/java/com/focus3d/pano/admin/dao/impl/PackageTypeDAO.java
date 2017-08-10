package com.focus3d.pano.admin.dao.impl;

import java.util.List;

import com.focus3d.pano.model.PackageTypeList;
import com.focus3d.pano.model.PanoProjectPackageType;
import com.focus3d.pano.model.pano_project_space;

public interface PackageTypeDAO {
		public List<PanoProjectPackageType> getSelect(Long sn);		//根据户型套餐SN查询套餐类型是否为空
		public List<PackageTypeList> getList(PackageTypeList sn);	// 若为空显示 固定的信息
		public List<pano_project_space> getSpace(Long sn);	//查询 户型对应的空间Name
		public Long getAddType(PanoProjectPackageType type);  //添加 户型套餐SN  和 空间Sn 到套餐类型
		public List<PanoProjectPackageType> getSelectType(Long sn);  //通过 户型套餐表 主键得到 不同的空间Sn 和分类SN
		public List<PackageTypeList> getSelectList(PackageTypeList sn); // 得到 要显示的 楼盘 户型 空间 套餐....等值
		public int getDelete(Long sn); //根据主键 删除套餐类型一列
}	
