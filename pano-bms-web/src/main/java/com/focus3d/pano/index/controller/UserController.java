package com.focus3d.pano.index.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import net.sf.json.JSONObject;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.focus3d.pano.admin.service.UserService;
import com.focus3d.pano.admin.utils.Page;
import com.focus3d.pano.common.controller.BaseController;
import com.focus3d.pano.model.PanoLoginModel;
import com.focus3d.pano.model.PanoUserLongin;
import com.focus3d.pano.model.User;
import com.focus3d.pano.rm.PanoRpcUtils;
import com.focustech.common.utils.EncryptUtil;
@Controller
@RequestMapping("/useradm")
public class UserController extends BaseController {
	@Value("${rpc.fs.domain}")
	private String rpcFsDomain;
	@Resource
	private UserService userService;
	
	//进入用户管理页面
	@RequestMapping("/listUser")
	public String into(HttpSession session,HttpServletRequest request){
		PanoLoginModel loginDO=(PanoLoginModel)session.getAttribute("login");
		
		String page = request.getParameter("page");
		
		int count = 0;
		int currentPage = 0;
		Page pages = null;
		List<User> userList = null;
		int upPage=0;
		int nextPage=0;
		
		if (page == null || page.equals("")) {
			currentPage = 1;
		} else {
			currentPage = Integer.parseInt(page);
		}
		if(currentPage==1){
			upPage=1;
			nextPage=2;
		}
		
		//获取查询总记录数 
		count = userService.selectUserCount();
		//通过Page这个类可以获取分页的起始下标和条数 
		pages = new Page(count, currentPage);
		//拼接分页语句 
		userList = userService.limit(pages);
		request.setAttribute("userList",userList);
		request.setAttribute("pages", pages);
		int totalPages=pages.getTotalPages();
		
		if(currentPage==totalPages){
			upPage=currentPage-1;
			nextPage=totalPages;
		}else if(currentPage>1){
			upPage=currentPage-1;
			nextPage=currentPage+1;
		}
		request.setAttribute("upPage", upPage);
		request.setAttribute("nextPage",nextPage);
		int index=(currentPage-1)*pages.getPagesize();
		request.setAttribute("index",index);
		request.setAttribute("currentPage",currentPage);
		
		String lock_action=null;
		for(int i=0;i<userList.size();i++){
			User user=userList.get(i);
			int status_int=user.getStatus();
			if(status_int==1){
				user.setStatus_str("正常");
				
			}else if(status_int==2){
				user.setStatus_str("暂停使用");
				
			}
			int sex_int=user.getSex();
			if(sex_int==1){
				user.setSex_str("女");
			}else if(sex_int==2){
				user.setSex_str("男");
			}
		}
		request.setAttribute("userList",userList);
		request.setAttribute("lock_action",lock_action);
		return "/panoadm/useradm/users";
	}
		
	@RequestMapping("/jumpSaveUser")
	public String jumpSaveUser(Model model){
		List<HashMap<String,Object>> role_nameList=userService.selectRole_name();
		model.addAttribute("role_nameList",role_nameList);
		return "/panoadm/useradm/users-add";
	}
	
	//进入添加页面
	@RequestMapping("/saveUser")
	public String saveUser(HttpSession session,HttpServletRequest request,HttpServletResponse response){
		
		PanoUserLongin PanoUserLongin=(PanoUserLongin)session.getAttribute("user");
		long adder_sn=PanoUserLongin.getSn();
		String adder_name=PanoUserLongin.getName();
		
		try {
			String nick_name=request.getParameter("nick_name");
			String name=request.getParameter("name");
			String mobile=request.getParameter("mobile");
			String email=request.getParameter("email");
			String cert_no=request.getParameter("cert_no");
			String rolesn=request.getParameter("role_sn");//角色表
			int sex=Integer.parseInt(request.getParameter("sex"));
			String password=request.getParameter("password");
			
			if(true){
				long role_sn=Long.parseLong(rolesn);
				int status=1;
                Date date=new Date();
                SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String add_time=sdf.format(date);
				userService.saveUser(nick_name,name,mobile,email,cert_no,sex,adder_sn,role_sn,password,adder_name,status,add_time);

				User user_select=userService.selectUsersnByCert_no(cert_no);
				long user_sn=user_select.getId();
				userService.saveLogin(nick_name,password,status,user_sn,adder_sn,adder_name,add_time,cert_no);

				updateUserSpace(user_select, user_sn);

				return this.redirect("/useradm/listUser");
			}else{
				String existCert_no="该身份证已注册";
				request.setAttribute("existCert_no",existCert_no);
				return "/panoadm/useradm/users-add";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "/panoadm/useradm/users-add";
		}
	}
	
	/**
	 * add by lihaijun 2017/8/17
	 * *
	 * @param user_select
	 * @param user_sn
	 */
	private void updateUserSpace(User user_select, long user_sn) {
		//add by lihaijun 2017/8/17
		//分配用户空间
		//String token = defaultEncryptService.encrypt(EncryptUtil.encode(user.getSn()), null);
		List<NameValuePair> qparams = new ArrayList<NameValuePair>();
		qparams.add(new BasicNameValuePair("userToken", EncryptUtil.encode(user_sn)));
		PanoRpcUtils panoRpcUtils = new PanoRpcUtils();
		String rv = panoRpcUtils.httpRequest(rpcFsDomain + "/pano/prm/user_space_allocate", qparams, HttpMethod.POST);
		JSONObject rpcJo = JSONObject.fromObject(rv);
		if("1".equals(rpcJo.getString("status"))){
			user_select.setIsAllocateSpace(1);
			user_select.setId(user_sn);
			userService.updateAllocateSpace(user_select);
		}
	}
	
	//进入查看页面
	@RequestMapping("/getUser")
	public String getUser(HttpServletRequest request){
		Long user_sn=Long.parseLong(request.getParameter("user_sn"));
		User user=userService.selectUserByCert_no(user_sn);
		int sex_int=user.getSex();
		if(sex_int==1){
			user.setSex_str("女");
		}else if(sex_int==2){
			user.setSex_str("男");
		}
		request.setAttribute("user",user);
		return "/panoadm/useradm/users-details";
	}
	
	//进入修改页面
	@RequestMapping("/updateUser")
	public String updateUser(HttpServletRequest request){
		Long user_sn=Long.parseLong(request.getParameter("user_sn"));
		//selectUserByCert_no
		User user=userService.selectUserByCert_no(user_sn);
		int sex_int=user.getSex();
		if(sex_int==1){
			user.setSex_str("女");
		}else if(sex_int==2){
			user.setSex_str("男");
		}
		List<HashMap<String,Object>> role_nameList=userService.selectRole_name();
		
		request.setAttribute("role_nameList",role_nameList);
		request.setAttribute("user",user);
		return "/panoadm/useradm/users-update";
	}
	//进入确认修改方法
	@RequestMapping("/SureUpdateUser")
	public String SureUpdateUser(String user_id,String password,String nick_name,String name,String mobile,String email,String cert_no,String role_sn,String sex){
		Long roleSn=Long.parseLong(role_sn);
		Long userSn = Long.parseLong(user_id);
		int sex_value =Integer.parseInt(sex); 
		userService.updateUserByCert_no(userSn,password,nick_name,name,mobile,email,cert_no,roleSn,sex_value);
		return this.redirect("/useradm/listUser");
	}
	
	//进入修改状态方法
	@RequestMapping("/updateStatus")
	public String updateStatus(HttpServletRequest request){
		String cert_no=request.getParameter("cert_no");
		int status=Integer.parseInt(request.getParameter("status"));
		
		if(status==1){
			status=2;
		}else if(status==2){
			status=1;
		}
		userService.updateStatus(cert_no, status);
		
		return this.redirect("/useradm/listUser");
	}
	
	@RequestMapping("/selectUser")
	public String selectUser(HttpServletRequest request){
			/**分页start--------------------------------------------------------------*/
			String page = request.getParameter("page");
			String nick_name=request.getParameter("nick_name");
			String mobile=request.getParameter("mobile");
			if(!(nick_name.equals("")&&mobile.equals(""))){
				/**
				 * 总记录数
				 */
				int count = 0;
				int currentPage = 0;
				Page pages = null;
				List<User> userList2 = null;
				int upPage=0;
				int nextPage=0;
				
				/**
				 * 判断当前页
				 */
				if (page == null || page.equals("")) {
					currentPage = 1;
				} else {
					currentPage = Integer.parseInt(page);
				}
				if(currentPage==1){
					upPage=1;
					nextPage=2;
				}
				
				//获取查询总记录数 
				List<User> userList2_=userService.selectUserByMsg2(nick_name,mobile);
				count = userList2_.size();
				//通过Page这个类可以获取分页的起始下标和条数 
				pages = new Page(count, currentPage);
				//拼接分页语句 
				int startIndex=pages.getStartIndex();
				int pagesize=pages.getPagesize();
				userList2 = userService.selectUserByMsg(nick_name,mobile,startIndex,pagesize);
				
				int totalPages=pages.getTotalPages();
				
				if(currentPage==totalPages){
					upPage=currentPage-1;
					nextPage=totalPages;
				}else if(currentPage>1){
					upPage=currentPage-1;
					nextPage=currentPage+1;
				}
				request.setAttribute("upPage", upPage);
				request.setAttribute("nextPage",nextPage);
				
				for(int i=0;i<userList2.size();i++){
					User user=userList2.get(i);
					int status_int=user.getStatus();
					if(status_int==1){
						user.setStatus_str("正常");
						
					}else if(status_int==2){
						user.setStatus_str("暂停使用");
					}
					int sex_int=user.getSex();
					if(sex_int==1){
						user.setSex_str("女");
					}else if(sex_int==2){
						user.setSex_str("男");
					}
				}
				request.setAttribute("pages2", pages);
				request.setAttribute("userList2",userList2_);
						return "/panoadm/useradm/users2";
			}else{
				return this.redirect("/useradm/listUser");
			}
			
		}
		
		@RequestMapping("/deleteUser")
		public String deleteUser(HttpServletResponse response,String userSn){
			Long UserSn = Long.parseLong(userSn);
			userService.deleteUser(UserSn);
			return this.redirect("/useradm/listUser");
		}
}
