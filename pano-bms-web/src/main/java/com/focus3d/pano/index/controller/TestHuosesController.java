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
	
	
	

	@RequestMapping("/tohouseSet")
	public String tohouseSet(HttpServletRequest request) {
		return "/houses/styeSetS";
	}
	
	
	
	
	@RequestMapping("/packageSet")
	public String packageSet(HttpServletRequest request){
		 List<getListPano> list = new ArrayList<getListPano>();
		String id = request.getParameter("id");
		long house_sn = Long.parseLong("1");
		long project_sn = Long.parseLong("1");
		long style_sn = Long.parseLong("100017");
		/**
		 * 根据传过来的Id找到对应的套餐
		 */
		PanoProjectPackageStyle ppp = new PanoProjectPackageStyle();
		ppp.setHouse_sn(house_sn);
		ppp.setProject_sn(project_sn);
		ppp.setStyle_sn(style_sn);
		List<PanoProjectPackageStyle> ppps = service.getPPPSSelect(ppp);
		  getListPano lp = new getListPano();
		
		/**
		 *  循环输出套餐id
		 */
		if(ppps.size()>0){
		for(int i = 0; i<ppps.size();i++){
			 PanoProjectPackageStyle panoProjectPackageStyle = ppps.get(i);
			  Long package_sn = panoProjectPackageStyle.getPackage_sn();
			  Long sn = panoProjectPackageStyle.getSn();
			  /**
			   * 输出 楼层 / 套餐 / 风格 / 户型 得到 name值
			   */
			  lp.setSn(sn);
			  lp.setPackage_id(package_sn);
			  lp.setProject_id(project_sn);
			  lp.setHouse_id(house_sn);
			  lp.setStyle_id(style_sn);
			  getListPano getpackage = service.getpackage(lp);
			  System.out.println("----"+getpackage.getHouse_sn()+getpackage.getProject_sn()+getpackage.getStyle_sn());
			  list.add(getpackage);
			  request.setAttribute("listss",getpackage);
		}
	  }else{
		  System.out.println(project_sn+"-"+house_sn+"-"+style_sn);
		  lp.setProject_sn(project_sn);
		  lp.setHouse_sn(house_sn);
		  lp.setStyle_sn(style_sn);
		  System.out.println("进入空的以后的方法");
		  getListPano get = service.getselect1(lp);
		  System.out.println("户型详情："+get.getHouse_name()+get.getHouse_sn()
				  +"楼盘详情："+get.getProject_name()+get.getProject_sn()
				  +"风格详情："+get.getStyle_name()+get.getStyle_sn());
		  request.setAttribute("listss",get);
	  }
		List<PanoProjectPackage> getselect = service.getselect();
		request.setAttribute("getselect", getselect);
		request.setAttribute("list",list);
		return  "/houses/combo";
		
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request){
		String house_sn = request.getParameter("id");
		String project_sn = request.getParameter("id1");
		String style_sn = request.getParameter("id2");
		String sn = request.getParameter("id3");
		PanoProjectPackageStyle ppp = new PanoProjectPackageStyle();
		ppp.setHouse_sn(Long.parseLong(house_sn));
		ppp.setProject_sn(Long.parseLong(project_sn));
		ppp.setStyle_sn(Long.parseLong(style_sn));
		ppp.setSn(Long.parseLong(sn));
		int getdelete = service.getdelete(ppp);
		return "redirect:/housess/packageSet";
		
	}
	
	
		@RequestMapping("/insert")
	public String insert(HttpServletRequest request){
			System.out.println("进入添加页面");
			PanoProjectPackageStyle pano = new PanoProjectPackageStyle();
			String[] package_sn = request.getParameterValues("name");
			String names = request.getParameter("names");
			String[] split = names.split(",");
			String style_sn = split[0];
			String house_sn = split[1];
			String project_sn = split[2];
			pano.setHouse_sn(Long.parseLong(house_sn));
			pano.setProject_sn(Long.parseLong(project_sn));
			pano.setStyle_sn(Long.parseLong(style_sn));
			for(int i = 0; i < package_sn.length; i++){
				System.out.println("套餐："+package_sn[i]);
				pano.setPackage_sn(Long.parseLong(package_sn[i]));
				service.getinsert(pano);
			}
			return "redirect:/housess/packageSet";
			
		}
	
}
