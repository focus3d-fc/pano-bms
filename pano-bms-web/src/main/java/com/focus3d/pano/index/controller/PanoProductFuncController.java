package com.focus3d.pano.index.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.focus3d.pano.admin.service.PanoProductFuncService;
import com.focus3d.pano.model.PanoProductFunc;
import com.focus3d.pano.model.PanoProductType;
import com.focus3d.pano.model.PanoProjectPackage;
import com.focus3d.pano.model.PanoVender;
import com.focus3d.pano.model.pano_project_style;

@Controller
@RequestMapping(value="/basics")
public class PanoProductFuncController {

	
	@Autowired 
	private PanoProductFuncService service;
	
	/**
	 * 分类
	 * @param request
	 * @return
	 */
	@RequestMapping("/classify")
	public String merchant(HttpServletRequest request){
		List<PanoProductType> type =null;
		
		try{
			type = service.getBasics();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		 request.setAttribute("type",type );
		return "/panoadm/baseinfoadm/basic-sort";
	}
	
	@RequestMapping("/insert")
	public String insert(HttpServletRequest request,HttpServletResponse response){
		String name = request.getParameter("name");
		System.out.println(name);
		 Long insert = service.getInsert(name);
		return "redirect:/basics/classify";
			
	}
	
	
	
	
	@RequestMapping("/dalete")
	public String dalete(HttpServletRequest request,HttpServletResponse response){
		String name = request.getParameter("id");
		System.out.println("---------3"+name);
		int delete = service.getDelete(Integer.parseInt(name));
		
		return "redirect:/basics/classify";

		 
	}
	@RequestMapping("/update")
	public String update(HttpServletRequest request){
		String sn1 = request.getParameter("id");
		String name = request.getParameter("name");
		long sn = Long.valueOf(sn1);
		PanoProductType p = new PanoProductType();
		p.setName(name);
		p.setSn(sn);
		int update = service.getUpdate(p);
		System.out.println("修改"+update);
		return "redirect:/basics/classify";

	}
	
	
	
	
	
	
	/**
	 * 套餐
	 * @param request
	 * @return
	 */
	
	@RequestMapping("/classify1")
	public String merchant1(HttpServletRequest request){
		List<PanoProjectPackage> type =null;
		
		try{
			type = service.getBasics1();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		 request.setAttribute("type1",type );
		return "/panoadm/baseinfoadm/basic-combo";
	}
	
	@RequestMapping("/insert1")
	public String insert1(HttpServletRequest request,HttpServletResponse response){
		String name = request.getParameter("name");
		 Long insert = service.getInsert1(name);
		return "redirect:/basics/classify1";
			
	}
	
	
	
	@RequestMapping("/dalete1")
	public String dalete1(HttpServletRequest request,HttpServletResponse response){
		String name = request.getParameter("id");
		int delete = service.getDelete1(Integer.parseInt(name));
		return "redirect:/basics/classify1";

		 
	}
	@RequestMapping("/update1")
	public String update1(HttpServletRequest request){
		String sn1 = request.getParameter("id");
		String name = request.getParameter("name");
		long sn = Long.valueOf(sn1);
		PanoProjectPackage p = new PanoProjectPackage();
		p.setName(name);
		p.setSn(sn);
		int update = service.getUpdate1(p);
		System.out.println("修改"+update);
		return "redirect:/basics/classify";

	}
	
	
	

	/**
	 * 厂家
	 * @param request
	 * @return
	 */
	
	@RequestMapping("/classify2")
	public String merchant2(HttpServletRequest request){
		List<PanoVender> type =null;
		
		try{
			type = service.getBasics2();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		 request.setAttribute("type2",type );
		return "/panoadm/baseinfoadm/basic-factory";
	}
	
	@RequestMapping("/insert2")
	public String insert2(HttpServletRequest request,HttpServletResponse response){
		String name = request.getParameter("name");
		 Long insert = service.getInsert2(name);
		System.out.println("=====+"+insert+"+===============");
		return "redirect:/basics/classify2";
			
	}
	
	@RequestMapping("/dalete2")
	public String dalete2(HttpServletRequest request,HttpServletResponse response){
		String name = request.getParameter("id");
		int delete = service.getDelete2(Integer.parseInt(name));
		return "redirect:/basics/classify2";

		 
	}
	
	@RequestMapping("/update2")
	public String update2(HttpServletRequest request){
		String sn1 = request.getParameter("id");
		String name = request.getParameter("name");
		long sn = Long.valueOf(sn1);
		PanoVender p = new PanoVender();
		p.setName(name);
		p.setSn(sn);
		int update = service.getUpdate2(p);
		System.out.println("修改"+update);
		return "redirect:/basics/classify2";

	}
	
	
	/**
	 * 风格
	 * @param request
	 * @return
	 */
	
	@RequestMapping("/classify3")
	public String merchant3(HttpServletRequest request){
		List<pano_project_style> type =null;
		
		try{
			type = service.getBasics3();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		 request.setAttribute("type3",type );
		return "/panoadm/baseinfoadm/basic-style";
	}
	
	@RequestMapping("/insert3")
	public String insert3(HttpServletRequest request,HttpServletResponse response){
		String name = request.getParameter("name");
		System.out.println("----"+name);
		 Long insert = service.getInsert3(name);
		System.out.println("=====+"+insert+"+===============");
		return "redirect:/basics/classify3";
			
	}
	
	@RequestMapping("/dalete3")
	public String dalete3(HttpServletRequest request,HttpServletResponse response){
		String name = request.getParameter("id");
		int delete = service.getDelete3(Integer.parseInt(name));
		return "redirect:/basics/classify3";

		 
	}
	
	@RequestMapping("/update3")
	public String update3(HttpServletRequest request){
		String sn1 = request.getParameter("id");
		String name = request.getParameter("name");
		long sn = Long.valueOf(sn1);
		pano_project_style p = new pano_project_style();
		p.setName(name);
		p.setSn(sn);
		int update = service.getUpdate3(p);
		System.out.println("修改"+update);
		return "redirect:/basics/classify3";

	}
	
	/**
	 * 
	 * @param 功能
	 * @return
	 */
	
	@RequestMapping("/classify4")
	public String merchant4(HttpServletRequest request){
		List<PanoProductFunc> type =null;
		
		try{
			type = service.getBasics4();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		 request.setAttribute("type4",type );
		return "/panoadm/baseinfoadm/basic-function";
	}
	
	
	@RequestMapping("/insert4")
	public String insert4(HttpServletRequest request,HttpServletResponse response){
		String name = request.getParameter("name");
		System.out.println(name);
		 Long insert = service.getInsert4(name);
		return "redirect:/basics/classify4";
			
	}
	
	@RequestMapping("/dalete4")
	public String dalete4(HttpServletRequest request,HttpServletResponse response){
		String name = request.getParameter("id");
		int delete = service.getDelete4(Integer.parseInt(name));
		return "redirect:/basics/classify4";

	}
	@RequestMapping("/update4")
	public String update4(HttpServletRequest request){
		String sn1 = request.getParameter("id");
		String name = request.getParameter("name");
		long sn = Long.valueOf(sn1);
		PanoProductFunc p = new PanoProductFunc();
		p.setName(name);
		p.setSn(sn);
		System.out.println(sn1+name);
		int update = service.getUpdate4(p);
		System.out.println("修改"+update);
		return "redirect:/basics/classify";

	}
	
}
	

