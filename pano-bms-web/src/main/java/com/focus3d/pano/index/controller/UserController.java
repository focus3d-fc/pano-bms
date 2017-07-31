package com.focus3d.pano.index.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.focus3d.pano.admin.service.UserService;
import com.focus3d.pano.common.controller.BaseController;
import com.focus3d.pano.model.PanoLoginModel;
import com.focus3d.pano.model.User;
@Controller
@RequestMapping("/useradm")
public class UserController extends BaseController {
	@Resource
	private UserService userService;
	
	//进入用户管理页面
	@RequestMapping("/listUser")
	public String into(HttpSession session,HttpServletRequest request){
		System.out.println("进入/listUser");
		PanoLoginModel loginDO=(PanoLoginModel)session.getAttribute("login");
		//System.out.println("adminSn:"+loginDO.getSn());
		//System.out.println("admin:"+loginDO);
		//查询时，查询*会报错    ？？？？
		List<User> userList=userService.getUserList();
		//System.out.println("用户列表："+userList);
		String lock_action=null;
		for(int i=0;i<userList.size();i++){
			User user=userList.get(i);
			System.out.println("name:"+user.getName()+",sn:"+user.getSn()+",cert_no:"+user.getCert_no());
			int status_int=user.getStatus();
			System.out.println("status:"+status_int);
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
		//System.out.println("userList2:"+userList+"----------------------------------");
		request.setAttribute("userList",userList);
		request.setAttribute("lock_action",lock_action);
		return "/panoadm/useradm/users";
	}
	@RequestMapping("/jumpSaveUser")
	public String jumpSaveUser(){
		System.out.println("进入/jumpSaveUser,跳转到添加页面");
		return "/panoadm/useradm/users-add";
	}
	//进入添加页面
	@RequestMapping("/saveUser")
	public String saveUser(HttpSession session,HttpServletRequest request,HttpServletResponse response){
		System.out.println("进入/saveUser--------------------------------");
		PanoLoginModel PanoLoginModel=(PanoLoginModel)session.getAttribute("login");
		long adder_sn=PanoLoginModel.getSn();
		String adder_name=PanoLoginModel.getLoginName();
		System.out.println("adder_name:"+adder_name);
		System.out.println("adder_sn:"+adder_sn+"-----------------登陆信息----------------------------");
		/**
		 * 全部字段如下,这里执行添加用户功能，不需要添加全部字段
name(姓名),sex(性别:1女-2男),mobile(手机),status(1正常,2暂停),city(城市),email(邮箱),
cert_no(身份证),role_name(角色),is_allocate_space(是否分配空间0-否，1是),
adder_sn(添加人id),adder_name(添加人姓名),add_time(添加时间),
-----------不需要加,原型没有
nick_name(不需要加),wx_id(不需要加),head_img_sn(不需要加)
-----------暂时不加,操作修改时加
updater_sn(修改人id),updater_name(修改人姓名),update_time(修改时间)
		 */
		try {
			String nick_name=request.getParameter("nick_name");
			String name=request.getParameter("name");
			String city=request.getParameter("city");
			String mobile=request.getParameter("mobile");
			String email=request.getParameter("email");
			String cert_no=request.getParameter("cert_no");
			String role_name=request.getParameter("role_name");//角色表
			int sex=Integer.parseInt(request.getParameter("sex"));
			String password=request.getParameter("password");
			//System.out.println("nick_name:"+nick_name+"name:"+name+
			//		"city:"+city+"mobile:"+mobile+"email:"+email+
			//		"cert_no:"+cert_no+"role_name:"+role_name+"sex:"+sex);
			//根据身份证查询是否已添加
			//System.out.println("根据身份证查询是否已添加------------------------------------------------");
			User user=userService.selectUserByCert_no(cert_no);
			//System.out.println("user:"+user+"-----------------------------------------------------");
			if(user==null){
				//插入到用户表
				userService.saveUser(nick_name,name,city,mobile,email,cert_no,sex,adder_sn);
				//插入到角色表
				   //通过cert_no查询用户表sn
				System.out.println("104行---------------------------------------");
				long user_sn=userService.selectUserSnById(cert_no);//通过cert_no查询用户表sn
				System.out.println("106行---------------------------------------");
				//根据前台传过来的角色名role_name，查询角色表sn
				long role_sn=userService.selectSnByRole_Name(role_name);
				   //把用户表sn和角色表sn插入到用户角色表对应字段
				userService.saveUSn_RSnToU_R(user_sn, role_sn);
				System.out.println("添加用户完成，跳回用户管理页面！------------------------------------------------");
/**
* 插入login表信息//需要添加的字段
* ----------------------------------------------------------------------
* login_name(昵称);password;status(1正常,2暂停);user_sn;login_times(登陆次数);summary(简介);
* last_login_time(最后登录时间);adder_sn;adder_name;add_time;
* updater_sn;updater_name;update_time;
*/
				String login_name=nick_name;
				//password-------------上有
				int status=1;
				//user_sn--------------上有
				//int login_times=0;//暂时不做
				//String summary=null;//暂时不做
				//String last_login_time;//暂时不做，登录时做
				//adder_sn-------------上有
				//adder_name-----------上有
				                        Date date=new Date();
				                        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String add_time=sdf.format(date);
				                        System.out.println("add_time:"+add_time);
				userService.saveLogin(login_name,password,status,user_sn,adder_sn,adder_name,add_time,cert_no);
				System.out.println("已经插入到login表-------------------------------");
				
				return this.redirect("/useradm/listUser");
			}else{
				String existCert_no="该身份证已注册";
				request.setAttribute("existCert_no",existCert_no);
				return "/panoadm/useradm/users-add";
			}
		} catch (Exception e) {
			System.out.println("出现异常，留在原页面------------------------------------------------");
			e.printStackTrace();
			return "/panoadm/useradm/users-add";
		}
	}
	
	//进入查看页面
	@RequestMapping("/getUser")
	public String getUser(HttpServletRequest request){
		System.out.println("进入/getUser");
		String cert_no=request.getParameter("cert_no");
		//selectUserByCert_no
		User user=userService.selectUserByCert_no(cert_no);
		int sex_int=user.getSex();
		if(sex_int==1){
			user.setSex_str("女");
		}else if(sex_int==2){
			user.setSex_str("男");
		}
		//System.out.println("user:"+user+",sn:"+user.getSn()+",name:"+user.getName()+"----------------------------------------------");
		request.setAttribute("user",user);
		return "/panoadm/useradm/users-details";
	}
	
	//进入修改页面
	@RequestMapping("/updateUser")
	public String updateUser(HttpServletRequest request){
		System.out.println("进入/updateUser");
		String cert_no=request.getParameter("cert_no");
		//selectUserByCert_no
		User user=userService.selectUserByCert_no(cert_no);
		System.out.println("nick_name:"+user.getNick_name()+"-------------------------");
		int sex_int=user.getSex();
		if(sex_int==1){
			user.setSex_str("女");
		}else if(sex_int==2){
			user.setSex_str("男");
		}
		//System.out.println("user:"+user+",sn:"+user.getSn()+",name:"+user.getName()+"----------------------------------------------");
		request.setAttribute("user",user);
		return "/panoadm/useradm/users-update";
	}
	//进入确认修改方法
	@RequestMapping("/SureUpdateUser")
	public String SureUpdateUser(HttpServletRequest request){
		System.out.println("进入确认修改方法:/SureUpdateUser");
		String nick_name=request.getParameter("nick_name");
		//String name=request.getParameter("name");
		String city=request.getParameter("city");
		String mobile=request.getParameter("mobile");
		String email=request.getParameter("email");
		String cert_no=request.getParameter("cert_no");
		String role_name=request.getParameter("role_name");
		//String sex=request.getParameter("sex");
System.out.println("nick_name:"+nick_name+
",city:"+city+",mobile:"+mobile+",cert_no:"+cert_no+
",email:"+email+",role_name:"+role_name);
//1.修改用户表信息
userService.updateUserByCert_no(nick_name,city,mobile,email,cert_no);
System.out.println("1.修改用户表信息");
//2.修改用户角色表信息
		//根据role_name查询role_sn;角色表
long role_sn=userService.selectSnByRole_Name(role_name);
System.out.println("role_sn:"+role_sn+"----------------------------------------------");
        //根据用户的cert_no查询user_sn;用户表
long user_sn=userService.selectUserSnById(cert_no);
System.out.println("user_sn:"+user_sn+"----------------------------------------------");
        //根据根据user_sn修改role_sn;用户角色表
userService.updateRole_snByUser_sn(role_sn,user_sn);
System.out.println("根据根据user_sn修改role_sn;用户角色表----------------------------------------------");		
		
		return this.redirect("/useradm/listUser");
	}
	
	    //进入修改状态方法
		@RequestMapping("/updateStatus")
	public String updateStatus(HttpServletRequest request){
			String cert_no=request.getParameter("cert_no");
			int status=Integer.parseInt(request.getParameter("status"));
			System.out.println("status:"+status);
			System.out.println("进入修改状态方法/updateStatus,cert_no:"+cert_no+"---------------------------------------");
			
			if(status==1){
				status=2;
			}else if(status==2){
				status=1;
			}
			userService.updateStatus(cert_no, status);
			System.out.println("状态修改完成------------------------------");
			
			
			return this.redirect("/useradm/listUser");
		}
		@RequestMapping("/selectUser")
	public String selectUser(HttpServletRequest request){
			System.out.println("进入/selectUser方法");
			String nick_name=request.getParameter("nick_name");
			String mobile=request.getParameter("mobile");
			System.out.println("nick_name:"+nick_name+",mobile:"+mobile+"-------------------------------");
			List<User> userList=userService.selectUserByMsg(nick_name,mobile);
			System.out.println("userList:"+userList+"-------------------------------------");
			for(int i=0;i<userList.size();i++){
				User user=userList.get(i);
				System.out.println("name:"+user.getName()+",sn:"+user.getSn()+",cert_no:"+user.getCert_no());
				int status_int=user.getStatus();
				System.out.println("status:"+status_int);
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
			return "/panoadm/useradm/users2";
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
