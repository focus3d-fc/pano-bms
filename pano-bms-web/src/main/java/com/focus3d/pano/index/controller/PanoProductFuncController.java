package com.focus3d.pano.index.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.focus3d.pano.admin.service.PanoProductFuncService;
import com.focus3d.pano.common.controller.BaseController;
import com.focus3d.pano.model.PanoProductFunc;
import com.focus3d.pano.model.PanoProductType;
import com.focus3d.pano.model.PanoProjectPackage;
import com.focus3d.pano.model.PanoUserLongin;
import com.focus3d.pano.model.PanoVender;
import com.focus3d.pano.model.panoSkin;
import com.focus3d.pano.model.pano_project_style;
import com.focustech.common.utils.EncryptUtil;
import com.focustech.common.utils.JsonUtils;
import com.opensymphony.oscache.util.StringUtil;

@Controller
@RequestMapping(value="/basics")
public class PanoProductFuncController extends BaseController{

	
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
		String i =null;
		String ii = null;
		List<PanoProductType> basics = service.getBasics();
		if(basics.size()>0){
		for(PanoProductType p:basics){
			if(p.getName().equals(name)||name.equals("")){
				i = "errorr";
				ii= "panoadm/baseinfoadm/basic-sort";
				break;
			}else{
				ii="/panoadm/baseinfoadm/basic-combo";
				i = "succeed";
				
			}
		}
	}else{
		ii="/panoadm/baseinfoadm/basic-combo";
		 Long insert = service.getInsert(name);
	}
		if(i.equals("succeed")){
		 Long insert = service.getInsert(name);
		}
		return ii;
			
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
	public String insert1(HttpServletRequest request,HttpServletResponse response,HttpSession session,String fullImgSn){
		String name = request.getParameter("name");
		Long img_sn = null;
		try {
			img_sn = EncryptUtil.decode(fullImgSn);
		} catch (Exception e) {
			e.printStackTrace();
		}
		PanoUserLongin pano =(PanoUserLongin)session.getAttribute("user");
		Long sn = pano.getSn();
		int  a = (int)(Math.random() * 10000000);
		String id = a+"";
		StringBuffer sb = new StringBuffer("A");
		sb.append(id);
		PanoProjectPackage pack = new PanoProjectPackage();
		pack.setId(sb.toString());
		pack.setImg_sn(img_sn);
		pack.setName(name);
		pack.setAdder_sn(sn);
		String i = null;
		String ii = null;
		List<PanoProjectPackage> basics = service.getBasics1();
		if(basics.size()>0){
		for(PanoProjectPackage p:basics){
			if(p.getName().equals(name)||name.equals("")){
				i = "errorr";
				ii= "panoadm/baseinfoadm/basic-sort";
				break;
			}else{
				ii="/panoadm/baseinfoadm/basic-combo";
				i = "succeed";
			}
		}
		if(i.equals("succeed")){
			 Long insert = service.getInsert1(pack);
			}
	}else{
		Long insert = service.getInsert1(pack);
	}
		return ii;
			
	}
	
	
	
	@RequestMapping("/dalete1")
	public String dalete1(HttpServletRequest request,HttpServletResponse response){
		String name = request.getParameter("id");
		int delete = service.getDelete1(Integer.parseInt(name));
		return "redirect:/basics/classify1";

		 
	}
	@RequestMapping("/update1")
	public String update1(HttpServletRequest request,String fullImgSn){
		Long img_sn = null;
		try {
			img_sn = EncryptUtil.decode(fullImgSn);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("图片ID:"+img_sn);
		String sn1 = request.getParameter("id");
		String name = request.getParameter("name");
		if(StringUtil.isEmpty(name)){
			name = null;
		}
		Long sn = Long.valueOf(sn1);
		PanoProjectPackage p = new PanoProjectPackage();
		p.setName(name);
		p.setSn(sn);
		p.setImg_sn(img_sn);
		int update = service.getUpdate1(p);
		
		return "redirect:/basics/classify1";

	}
	
	@RequestMapping("/updates1")
	public void updates1(HttpServletRequest request,HttpServletResponse response,String sn){
		PanoProjectPackage getupdatas1 = service.getupdatas1(Integer.parseInt(sn));
		String objectToJson = JsonUtils.objectToJson(getupdatas1);
		try {
			this.ajaxOutput(response, objectToJson);
		} catch (IOException e) {
			e.printStackTrace();
		}
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
		String i = null;
		String ii = null;
		List<PanoVender> basics = service.getBasics2();
		if(basics.size()>0){
		for(PanoVender p:basics){
			if(p.getName().equals(name)||name.equals("")){
				i = "errorr";
				ii= "panoadm/baseinfoadm/basic-sort";
				break;
			}else{
				i = "succeed";
				ii="/panoadm/baseinfoadm/basic-combo";
			}
		}
	}else{
		 Long insert = service.getInsert2(name);
	}
		if(i.equals("succeed")){
		 Long insert = service.getInsert2(name);
		}
		return ii;
			
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
		List<pano_project_style> type =service.getBasics3();
		
		 request.setAttribute("type3",type );
		return "/panoadm/baseinfoadm/basic-style";
	}
	
	@RequestMapping("/insert3")
	public String insert3(HttpServletRequest request,HttpServletResponse response,String fullImgSn){
		Long img_sn = null;
		try {
			img_sn = EncryptUtil.decode(fullImgSn);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String name = request.getParameter("name");
		pano_project_style style = new pano_project_style();
		System.out.println("获得图片SN："+img_sn+"姓名："+name);
		style.setImg_sn(img_sn);
		style.setName(name);
		
		String i = null;
		String ii = null;
		List<pano_project_style> basics = service.getBasics3();
		if(basics.size()>0){
		for(pano_project_style p:basics){
			if(p.getName().equals(name)||name.equals("")){
				i = "errorr";
				ii= "panoadm/baseinfoadm/basic-sort";
				break;
			}else{
				ii="/panoadm/baseinfoadm/basic-combo";
				i = "succeed";
			}
			if(i.equals("succeed")){
				 Long insert = service.getInsert3(style);
				}
		}
	}else{
		 Long insert = service.getInsert3(style);
	}
		return ii;
			
	}
	
	@RequestMapping("/dalete3")
	public String dalete3(HttpServletRequest request,HttpServletResponse response){
		String name = request.getParameter("id");
		int delete = service.getDelete3(Integer.parseInt(name));
		return "redirect:/basics/classify3";

		 
	}
	
	@RequestMapping("/update3")
	public String update3(HttpServletRequest request,String fullImgSn){
		Long img_sn = null;
		try {
			img_sn = EncryptUtil.decode(fullImgSn);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String sn1 = request.getParameter("id");
		String name = request.getParameter("name");
		if(StringUtil.isEmpty(name)){
			name = null;
		}
		Long sn = Long.parseLong(sn1);
		pano_project_style p = new pano_project_style();
		p.setName(name);
		p.setSn(sn);
		p.setImg_sn(img_sn);
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
		String i = null;
		String ii = null;
		List<PanoProductFunc> basics = service.getBasics4();
		if(basics.size()>0){
		for(PanoProductFunc p:basics){
			if(p.getName().equals(name)||name.equals("")){
				i = "errorr";
				ii= "panoadm/baseinfoadm/basic-sort";
				break;
			}else{
				ii="/panoadm/baseinfoadm/basic-combo";
				i = "succeed";
			}
		}
	}else{
		 Long insert = service.getInsert4(name);
	}
		if(i.equals("succeed")){
		 Long insert = service.getInsert4(name);
		}
		return ii;
			
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
	
	
	
	/**
	 * 导航
	 * @param request
	 * @return
	 */
	
	@RequestMapping("/classify5")
	public String merchant5(HttpServletRequest request){
		List<panoSkin> type =null;
		
		try{
			type = service.getBasics5();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		 request.setAttribute("type1",type );
		return "/panoadm/baseinfoadm/basic-Navigation";
	}
	
	@RequestMapping("/insert5")
	public String insert5(HttpServletRequest request,HttpServletResponse response,HttpSession session,String fullImgSn){
		String name = request.getParameter("name");
		Long img_sn = null;
		try {
			img_sn = EncryptUtil.decode(fullImgSn);
		} catch (Exception e) {
			e.printStackTrace();
		}
		PanoUserLongin pano =(PanoUserLongin)session.getAttribute("user");
		Long sn = pano.getSn();
		panoSkin pack = new panoSkin();
		pack.setImg_sn(img_sn);
		pack.setName(name);
		pack.setAdder_sn(sn);
		String i = null;
		String ii = null;
		 List<panoSkin> basics5 = service.getBasics5();
		if(basics5.size()>0){
		for(panoSkin p:basics5){
			if(p.getName().equals(name)||name.equals("")){
				i = "errorr";
				ii= "panoadm/baseinfoadm/basic-sort";
				break;
			}else{
				ii="/panoadm/baseinfoadm/basic-combo";
				i = "succeed";
			}
		}
		if(i.equals("succeed")){
			 Long insert = service.getInsert5(pack);
			}
	}else{
		Long insert = service.getInsert5(pack);
	}
		return ii;
			
	}
	
	
	
	@RequestMapping("/dalete5")
	public String dalete5(HttpServletRequest request,HttpServletResponse response){
		String name = request.getParameter("id");
		int delete = service.getDelete5(Integer.parseInt(name));
		return "redirect:/basics/classify5";

		 
	}
	@RequestMapping("/update5")
	public String update5(HttpServletRequest request,String fullImgSn){
		Long img_sn = null;
		try {
			img_sn = EncryptUtil.decode(fullImgSn);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("图片ID:"+img_sn);
		String sn1 = request.getParameter("id");
		String name = request.getParameter("name");
		long sn = Long.valueOf(sn1);
		panoSkin p = new panoSkin();
		p.setName(name);
		p.setSn(sn);
		p.setImg_sn(img_sn);
		int update = service.getUpdate5(p);
		
		return "redirect:/basics/classify5";

	}
	
	@RequestMapping("/updates5")
	public void updates5(HttpServletRequest request,HttpServletResponse response,String sn){
		panoSkin getupdatas1 = service.getupdatas5(Integer.parseInt(sn));
		String objectToJson = JsonUtils.objectToJson(getupdatas1);
		try {
			this.ajaxOutput(response, objectToJson);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
	

