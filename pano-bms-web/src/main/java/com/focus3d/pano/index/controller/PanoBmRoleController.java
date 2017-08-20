package com.focus3d.pano.index.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.focus3d.pano.admin.service.PanoBmRoleService;
import com.focus3d.pano.common.controller.BaseController;
import com.focus3d.pano.model.BackUpdate;
import com.focus3d.pano.model.PanoBmRoleResource;
import com.focus3d.pano.model.PanoRole;
import com.focustech.common.utils.JsonUtils;

@Controller
@RequestMapping("/role")
public class PanoBmRoleController extends BaseController{
	
	@Autowired
	private PanoBmRoleService role;
	
	@RequestMapping("/select")
	public String getSelectRole(HttpServletRequest request){
		List<PanoRole> panoRole = role.getPanoRole();
		request.setAttribute("role", panoRole);
		return "/panoadm/baseinfoadm/role";
		
	}
	
	@RequestMapping("/delete")
	public String getDeleteRole(HttpServletRequest request){
		String id = request.getParameter("id");
		Long prDelete = role.getPRDelete(Long.parseLong(id));
		Long pbrrDelete = role.getPBRRDelete(Long.parseLong(id));
		System.out.println(pbrrDelete);
		System.out.println(id);
		return "redirect:/role/select";
		
	}
	
	@ResponseBody
	@RequestMapping("/insert")
	public void getInsertRole(HttpServletRequest request,HttpServletResponse response){
		String url= null;
		int user1 = 0;
		int basics1 = 0;
		int houses1 = 0;
		int product1 = 0;
		int roles1 = 0;
		int order1 = 0;
		String roles = request.getParameter("role");
		String order = request.getParameter("order");
		String role_name = request.getParameter("name");
		String user = request.getParameter("user");
		String basics = request.getParameter("basics");
		String houses = request.getParameter("houses");
		String product = request.getParameter("product");
		if(user!=null){
			user1 = 1;
		}if(basics!=null){
			basics1 = 1;
		}if(houses!=null){
			houses1 = 1;
		}if(product!=null){
			product1=1;
		}if(order!=null){
			order1=1;
		}if(roles!=null){
			roles1=1;
		}
		
		
		List<PanoRole> panoRole = role.getPanoRole();
		if(panoRole.size()>0){
			for(PanoRole pr:panoRole){
				if(pr.getRole_name().equals(role_name)||role_name.equals("")){
					url= "errorr";
					break;
				}else{
					url= "succedd";
				}
			}
		}else{
			url= "succedd";
			PanoBmRoleResource pbrr = new PanoBmRoleResource();
			role.getPRInsert(role_name);
			PanoRole prSelect = role.getPRSelect(role_name);
			pbrr.setRole_sn(prSelect.getSn());
			pbrr.setRole_user(user1);
			pbrr.setRole_basics(basics1);
			pbrr.setRole_houses(houses1);
			pbrr.setRole_product(product1);
			pbrr.setRole_order(order1);
			pbrr.setRole_role(roles1);
			role.getResource(pbrr);
		}
		
		if(url.equals("succedd")){
			PanoBmRoleResource pbrr = new PanoBmRoleResource();
			role.getPRInsert(role_name);
			PanoRole prSelect = role.getPRSelect(role_name);
			pbrr.setRole_sn(prSelect.getSn());
			pbrr.setRole_user(user1);
			pbrr.setRole_basics(basics1);
			pbrr.setRole_houses(houses1);
			pbrr.setRole_product(product1);
			pbrr.setRole_order(order1);
			pbrr.setRole_role(roles1);
			role.getResource(pbrr);
		}
		
		String js = JsonUtils.objectToJson(url);
	    try {
			this.ajaxOutput(response, js);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}
	

	@RequestMapping("/update")
	public String getUpdateRole(HttpServletRequest request){
		
		String ur= null;
		int user1 = 0;
		int basics1 = 0;
		int houses1 = 0;
		int product1 = 0;
		int order1 = 0;
		int roles1 = 0;
		String sn = request.getParameter("sn");
		String roles = request.getParameter("role");
		String order = request.getParameter("order");
		String role_name = request.getParameter("name");
		String role_user = request.getParameter("user");
		String role_basics = request.getParameter("basics");
		String role_houses = request.getParameter("houses");
		String role_product = request.getParameter("product");
		/**
		 * 角色权限设置
		 */
		if(role_user!=null){
			user1 = 1;
		}if(role_basics!=null){
			basics1 = 1;
		}if(role_houses!=null){
			houses1 = 1;
		}if(role_product!=null){
			product1=1;
		}if(roles!=null){
			roles1 = 1;
		}if(order != null){
			order1 = 1;
		}
		
		
		List<PanoRole> panoRole = role.getPanoRole();
		if(panoRole.size()>0){
			for(PanoRole p :panoRole){
				if(role_name.equals("")){
					ur= "errorr";
					break;
				}else{
					ur= "succedd";
				}
			}
		}else{
			ur="succedd";
			/**
			 * 修改角色表的name根据主键id
			 */
			PanoRole pr = new PanoRole();
			pr.setSn(Long.parseLong(sn));
			pr.setRole_name(role_name);
			role.getRPupdate(pr);
			/**
			 * 修改角色资源表的权限 根据角色表的主键id
			 */
			PanoBmRoleResource pbrr = new PanoBmRoleResource();
			pbrr.setRole_user(user1);
			pbrr.setRole_houses(houses1);
			pbrr.setRole_basics(basics1);
			pbrr.setRole_product(product1);
			pbrr.setRole_sn(Long.parseLong(sn));
			pbrr.setRole_order(order1);
			pbrr.setRole_role(roles1);
			role.getPBRRUpdate(pbrr);
		}
		if(ur.equals("succedd")){
			/**
			 * 修改角色表的name根据主键id
			 */
			PanoRole pr = new PanoRole();
			pr.setSn(Long.parseLong(sn));
			pr.setRole_name(role_name);
			role.getRPupdate(pr);
			/**
			 * 修改角色资源表的权限 根据角色表的主键id
			 */
			PanoBmRoleResource pbrr = new PanoBmRoleResource();
			pbrr.setRole_user(user1);
			pbrr.setRole_houses(houses1);
			pbrr.setRole_basics(basics1);
			pbrr.setRole_product(product1);
			pbrr.setRole_sn(Long.parseLong(sn));
			pbrr.setRole_order(order1);
			pbrr.setRole_role(roles1);
			role.getPBRRUpdate(pbrr);
		}
		return "redirect:/role/select";
		
		
		
	}

	
	@RequestMapping("update1")
	public void update1(HttpServletRequest request,HttpServletResponse response,String sn){
		System.out.println("---"+sn);
		BackUpdate back = role.getupdateBack(Integer.parseInt(sn));
		
		String objectToJson = JsonUtils.objectToJson(back);
		System.out.println(objectToJson+"返回值-----");
		try {
			this.ajaxOutput(response, objectToJson);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
		
	
}
