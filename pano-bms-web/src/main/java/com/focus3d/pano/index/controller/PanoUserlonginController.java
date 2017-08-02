package com.focus3d.pano.index.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.http.protocol.HttpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.focus3d.pano.admin.service.PanoUserLongInService;
import com.focus3d.pano.common.controller.BaseController;
import com.focus3d.pano.model.PanoBmRoleResource;
import com.focus3d.pano.model.PanoUserLongin;
import com.focus3d.pano.model.ResultVO;
import com.focustech.common.utils.JsonUtils;

@Controller
@RequestMapping("/users")
public class PanoUserlonginController extends BaseController{
	@Autowired
	private PanoUserLongInService user;
	
	@RequestMapping("lonins")
	public String lonins(){
		return "/member/user/login";
		
	}
	
	@RequestMapping("/longin")
	public void UserLongin(HttpServletRequest request,HttpServletResponse response,HttpSession session,String userName,String passWord){
		PanoUserLongin longIn = new PanoUserLongin();
		ResultVO rv = new ResultVO();
		//longIn.setNike_name(userName);
		longIn.setNick_name(userName);
		longIn.setPassword(passWord);
		System.out.println("shang");
		PanoUserLongin userLongin = user.getUserLongin(longIn);
		System.out.println("xia");
		System.out.println(userLongin);
		if(userLongin.getSn()>0){
			rv.setResult("success");
			rv.setResCode(null);
			rv.setObjData(userLongin);
			System.out.println("succedd");
			System.out.println("进入正确");
			session.setAttribute("user",userLongin );
		}else{
			System.out.println("orrrr");
			rv.setResult("errorr");
			rv.setResCode("登录失败");
			System.out.println("进入错误");
		}

		String objectToJson = JsonUtils.objectToJson(rv);
		System.out.println("登录查看："+objectToJson);
		try {
			this.ajaxOutput(response,objectToJson);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@RequestMapping("/homepage")
	public String homepage(HttpSession session,HttpServletRequest request){
		PanoUserLongin longins =(PanoUserLongin)session.getAttribute("user");
		PanoBmRoleResource pbrr = new PanoBmRoleResource();
		pbrr.setRole_basics(longins.getRole_basics());
		pbrr.setRole_houses(longins.getRole_houses());
		pbrr.setRole_order(longins.getRole_order());
		pbrr.setRole_product(longins.getRole_product());
		pbrr.setRole_user(longins.getRole_user());
		pbrr.setRole_role(longins.getRole_role());
		request.setAttribute("pbrr", pbrr);
		return "/panoadm/admfirst";
		
	}
	
	
	
}
