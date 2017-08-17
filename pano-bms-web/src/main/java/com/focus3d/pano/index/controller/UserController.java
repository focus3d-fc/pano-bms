package com.focus3d.pano.index.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
			System.out.println("进入/listUser");
			PanoLoginModel loginDO=(PanoLoginModel)session.getAttribute("login");
			//System.out.println("adminSn:"+loginDO.getSn());
			//System.out.println("admin:"+loginDO);
			/**分页start--------------------------------------------------------------*/
			System.out.println("进入/paging方法");
			String page = request.getParameter("page");
			/**
			 * 总记录数
			 */
			int count = 0;
			int currentPage = 0;
			Page pages = null;
			List<User> userList = null;
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
			count = userService.selectUserCount();
			System.out.println("查询count:"+count+"-------------------------------");
			//通过Page这个类可以获取分页的起始下标和条数 
			pages = new Page(count, currentPage);
			System.out.println("currentPage："+currentPage);
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
			System.out.println("当前页："+currentPage+",upPage:"+upPage+",nextPage:"+nextPage+"-----------------------");
			request.setAttribute("upPage", upPage);
			request.setAttribute("nextPage",nextPage);
			int index=(currentPage-1)*pages.getPagesize();
			request.setAttribute("index",index);
			request.setAttribute("currentPage",currentPage);
			
			/**分页end-----------------------------------------------------------------*/
			
			//查询时，查询*会报错    ？？？？
			//List<User> userList=userService.getUserList();
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
	public String jumpSaveUser(Model model){
		System.out.println("进入/jumpSaveUser,跳转到添加页面");
		List<String> role_nameList=userService.selectRole_name();
		model.addAttribute("role_nameList",role_nameList);
		
		
		return "/panoadm/useradm/users-add";
	}
	//进入添加页面
	@RequestMapping("/saveUser")
	public String saveUser(HttpSession session,HttpServletRequest request,HttpServletResponse response){
		System.out.println("进入/saveUser--------------------------------");
		//PanoLoginModel PanoLoginModel=(PanoLoginModel)session.getAttribute("login");
		PanoUserLongin PanoUserLongin=(PanoUserLongin)session.getAttribute("user");
		long adder_sn=PanoUserLongin.getSn();
		String adder_name=PanoUserLongin.getName();
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
			//根据身份证查询是否已添加
			//User user=userService.selectUserByCert_no(cert_no);
			//if(user==null){
			if(true){
				long role_sn=userService.selectSnByRole_Name(role_name);
/**
* 插入login表信息//需要添加的字段
* ----------------------------------------------------------------------
* login_name(昵称);password;status(1正常,2暂停);user_sn;login_times(登陆次数);summary(简介);
* last_login_time(最后登录时间);adder_sn;adder_name;add_time;
* updater_sn;updater_name;update_time;
*/				//nick_name------------上有
				//name-----------------上有
				//city-----------------上有
				//mobile---------------上有
				//email----------------上有
				//cert_no--------------上有
				//sex------------------上有
				//adder_sn-------------上有
				//role_sn--------------上有
				//password-------------上有
				//adder_name-----------上有   
				int status=1;
				                        //int login_times=0;//暂时不做
				                        //String summary=null;//暂时不做
				                        //String last_login_time;//暂时不做，登录时做
				
				
				                        Date date=new Date();
				                        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String add_time=sdf.format(date);
				                        System.out.println("add_time:"+add_time);
//插入到用户表
userService.saveUser(nick_name,name,city,mobile,
email,cert_no,sex,adder_sn,role_sn,password,adder_name,status,add_time);
//查询刚刚插入的用户sn

User user_select=userService.selectUsersnByCert_no(cert_no);
long user_sn=user_select.getId();
System.out.println("1.插入login表");
userService.saveLogin(nick_name,password,status,user_sn,adder_sn,adder_name,add_time,cert_no);
System.out.println("2.已经插入到login表");	

		//add by lihaijun 2017/8/17
		updateUserSpace(user_select, user_sn);

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
		System.out.println("进入/getUser");
		String cert_no=request.getParameter("cert_no");
		System.out.println("1.查看----------------------------------------------");
		User user=userService.selectUserByCert_no(cert_no);
		System.out.println("查看：user.id:"+user.getId()+"------------------------------");
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
		List<String> role_nameList=userService.selectRole_name();
		request.setAttribute("role_nameList",role_nameList);
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
//根据role_name查询role_sn;角色表
long role_sn=userService.selectSnByRole_Name(role_name);		
//1.修改用户表信息
userService.updateUserByCert_no(nick_name,city,mobile,email,cert_no,role_sn);
System.out.println("1.修改用户表信息");		
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
			System.out.println("1.锁定------------------------------------");
			userService.updateStatus(cert_no, status);
			System.out.println("状态修改完成------------------------------");
			System.out.println("2.锁定------------------------------------");
			
			return this.redirect("/useradm/listUser");
		}
		@RequestMapping("/selectUser")
		public String selectUser(HttpServletRequest request){
				System.out.println("进入/selectUser方法");
				/**分页start--------------------------------------------------------------*/
				String page = request.getParameter("page");
				String nick_name=request.getParameter("nick_name");
				String mobile=request.getParameter("mobile");
				System.out.println("搜索page："+page+"------------------------------------");
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
					System.out.println("userList2_:"+userList2_);
					count = userList2_.size();
					System.out.println("搜索userList2_:"+userList2_+"-------------------------------");
					System.out.println("搜索count:"+count+"-------------------------------");
					//通过Page这个类可以获取分页的起始下标和条数 
					pages = new Page(count, currentPage);
					System.out.println("currentPage："+currentPage);
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
					System.out.println("当前页："+currentPage+",upPage:"+upPage+",nextPage:"+nextPage+"-----------------------");
					request.setAttribute("upPage", upPage);
					request.setAttribute("nextPage",nextPage);
					/**分页end-----------------------------------------------------------------*/
					
					for(int i=0;i<userList2.size();i++){
						User user=userList2.get(i);
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
					request.setAttribute("pages2", pages);
					request.setAttribute("userList2",userList2_);
							return "/panoadm/useradm/users2";
				}else{
					System.out.println("空值搜索------------------------------");
					return this.redirect("/useradm/listUser");
				}
				
			}
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	
	
	
	
	
	

}
