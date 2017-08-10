package com.focus3d.pano.index.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.focus3d.pano.admin.service.HousesService;
import com.focus3d.pano.admin.service.PanoUserLongInService;
import com.focus3d.pano.common.controller.BaseController;
import com.focus3d.pano.model.PanoProjectHousePackage;
import com.focus3d.pano.model.PanoProjectPackage;
import com.focus3d.pano.model.PanoProjectPackageStyle;
import com.focus3d.pano.model.getListPano;
import com.focus3d.pano.model.pano_project;
import com.focus3d.pano.model.pano_project_house;
import com.focus3d.pano.model.pano_project_space;
import com.focustech.common.utils.JsonUtils;

@Controller
@RequestMapping("/housess")
public class TestHuosesController extends BaseController{
	
	@Autowired
	private PanoUserLongInService service;
	
	
	
	@RequestMapping("/packageSet")
	public String packageSet(HttpServletRequest request){
		 List<getListPano> list = new ArrayList<getListPano>();
		String id = request.getParameter("id");
		long house_sn = Long.parseLong("100004");
		long project_sn = Long.parseLong("100011");
		long style_sn = Long.parseLong("100036");
		
		/** 
		 *   通过 户型 楼盘 风格 查询 得到主键
		 */
		PanoProjectPackageStyle ppps1 = new PanoProjectPackageStyle();
		ppps1.setHouse_sn(house_sn);
		ppps1.setProject_sn(project_sn);
		ppps1.setStyle_sn(style_sn);
		PanoProjectPackageStyle getpackage1 = service.getpackage1(ppps1);
		if(getpackage1 ==null){
			/**
			 * 	 户型风格表对象
			 */
			PanoProjectPackageStyle pano = new PanoProjectPackageStyle();
			pano.setHouse_sn(house_sn);
			pano.setProject_sn(project_sn);
			pano.setStyle_sn(style_sn);
			service.getinsert(pano);
			getpackage1 = service.getpackage1(ppps1);
		}
		/**
		 * 通过主键得到对应的套餐ID
		 */
		List<PanoProjectHousePackage> getpackage2 = service.getpackage2(getpackage1.getSn());
		/**
		 * 通过套餐户型关系表查看对应的户型风格表是否有对应的套餐
		 */
		List<PanoProjectPackageStyle> ppps = service.getPPPSSelect(getpackage1.getSn());
		getListPano lp = new getListPano();
		if(ppps.size()>0){
			System.out.println("进入有值判断");
			/**
			 * 通过 套餐 户型 风格 楼盘 的主键获得name 和id 
			 */
			  lp.setProject_sn(project_sn);
			  lp.setHouse_sn(house_sn);
			  lp.setStyle_sn(style_sn);
			 for(PanoProjectHousePackage p:getpackage2){
				 lp.setHuose_style_sn(p.getHouse_style_sn());
				 lp.setPackage_sn(p.getPackage_sn());
				 lp.setSn(p.getSn());
				 getListPano getpackage = service.getpackage(lp);
				 request.setAttribute("listss",getpackage);
				 list.add(service.getpackage(lp));
			 }
			
			  request.setAttribute("lists",list);
		
	  }else{
		  System.out.println("进入空值判断");
		  lp.setProject_sn(project_sn);
		  lp.setHouse_sn(house_sn);
		  lp.setStyle_sn(style_sn);
		  getListPano get = service.getselect1(lp);
		  System.out.println(get.getProject_name()+get.getHouse_name()+get.getStyle_name());
		  request.setAttribute("listss",get);
		 
	  }
		List<PanoProjectPackage> getselect = service.getselect();
		request.setAttribute("getselect", getselect);
		return  "/houses/combo";
		
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request){
		String package_sn = request.getParameter("id2");
		PanoProjectHousePackage ppp = new PanoProjectHousePackage();
		ppp.setSn(Long.parseLong(package_sn));
		int getdelete = service.getdelete(ppp);
		return "redirect:/housess/packageSet";
		
	}
	
	
		@RequestMapping("/insert")
	public String insert(HttpServletRequest request){
			String[] package_ = request.getParameterValues("name");
			
			/**
			 * 通过前台得到户型 风格 楼盘的SN
			 */
			String names = request.getParameter("names");
			String[] split = names.split(",");
			String style_sn = split[0];
			String house_sn = split[1];
			String project_sn = split[2];
			System.out.println(style_sn+house_sn+project_sn);
			/**
			 * 在根据户型 户型 楼盘 风格Sn 得到添加了的字段的SN 添加的户型的套餐表 
			 */
			PanoProjectPackageStyle pano = new PanoProjectPackageStyle();
			pano.setHouse_sn(Long.parseLong(house_sn));
			pano.setProject_sn(Long.parseLong(project_sn));
			pano.setStyle_sn(Long.parseLong(style_sn));
			PanoProjectPackageStyle getpackage1 = service.getpackage1(pano);
				PanoProjectHousePackage pphp = new PanoProjectHousePackage();
					pphp.setHouse_style_sn(getpackage1.getSn());
					for(String package_sn:package_ ){
						pphp.setPackage_sn(Long.parseLong(package_sn));
						service.getinserts(pphp);
					}
				
			
			return "redirect:/housess/packageSet";
			
		}
	
}
