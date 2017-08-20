package com.focus3d.pano.admin.dao;

import java.util.List;
import java.util.Map;

import com.focus3d.pano.model.PanoProductFunc;
import com.focus3d.pano.model.PanoProductType;
import com.focus3d.pano.model.PanoProjectPackage;
import com.focus3d.pano.model.PanoVender;
import com.focus3d.pano.model.Product;
import com.focus3d.pano.model.panoSkin;
import com.focus3d.pano.model.pano_project_style;

public interface PanoProductFuncDAO {
	public List<PanoProductType>getBasics(); //分类 查询
	public Long getInsert(String name);
	public int getDelete(int sn);
	public int getUpdate(PanoProductType p);
	public List<PanoProductType> getselect(int sn);
	
	
	
	public List<PanoProjectPackage>getBasics1(); //套餐 查询
	public Long getInsert1(PanoProjectPackage pano);
	public int getDelete1(int sn);
	public int getUpdate1(PanoProjectPackage p);
	public List<PanoProjectPackage>getupdatas1(int sn);
	public List<PanoProjectPackage> getselect1(int sn);
	
	
	public List<PanoProductFunc>getBasics4(); //功能 查询
	public Long getInsert4(String name);
	public int getDelete4(int sn);
	public int getUpdate4(PanoProductFunc p);
	public List<PanoProductFunc> getselect4(int sn);
	
	
	
	public List<PanoVender>getBasics2(); //厂家 查询
	public Long getInsert2(String name);
	public int getDelete2(int sn);
	public int getUpdate2(PanoVender p);
	public List<PanoVender> getselect2(int sn);
	
	
	public List<pano_project_style>getBasics3(); //风格 查询
	public Long getInsert3(pano_project_style style);
	public int getDelete3(int sn);
	public int getUpdate3(pano_project_style p);
	public List<pano_project_style> getselect3(int sn);
	
	
	public List<panoSkin>getBasics5(); //导航 查询
	public Long getInsert5(panoSkin pano);
	public int getDelete5(int sn);
	public int getUpdate5(panoSkin p);
	public List<panoSkin>getupdatas5(int sn);
	public List<panoSkin> getselect5(int sn);
	
}