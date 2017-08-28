package com.focus3d.pano.index.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.focus3d.pano.common.controller.BaseController;
import com.focus3d.pano.model.AddToCar;
import com.focus3d.pano.model.Lable;
import com.focus3d.pano.model.PanoProjectPackage;
import com.focus3d.pano.model.PanoProjectPackageType;
import com.focus3d.pano.model.Product;
import com.focus3d.pano.model.Style;
import com.focus3d.pano.model.panoSkin;
import com.focus3d.pano.model.pano_ad;
import com.focus3d.pano.model.pano_mem_user;
import com.focus3d.pano.model.pano_order;
import com.focus3d.pano.model.pano_project;
import com.focus3d.pano.model.pano_project_house;
import com.focus3d.pano.model.pano_project_space;
import com.focus3d.pano.model.pano_user_receive_address;
import com.focus3d.pano.usersside.service.PersonalService;
import com.focus3d.pano.usersside.service.UsersSideService;
import com.focus3d.pano.wechat.utils.Constants;
import com.focus3d.pano.wechat.utils.UserInfo;
import com.focustech.common.utils.EncryptUtil;
import com.focustech.common.utils.JsonUtils;
@Controller
@RequestMapping("/usersSide")
public class UsersSideController extends BaseController{
	@Resource
	private UsersSideService usersSideService;
	@Resource
    private PersonalService personalService;
	@RequestMapping("/toIndex")
	public String toIndex(Model model,HttpServletRequest request,HttpSession session) throws Exception{		
		//微信用户对象信息
		UserInfo userInfo = (UserInfo)session.getAttribute(Constants.SESSION_WX_USER);
		//模拟登陆状态，方便后面代码获取user_sn
		long user_sn=1;
		session.setAttribute("user_sn",user_sn);
		
		//根据楼盘信息，查询楼盘sn
		String province=request.getParameter("province");
		String city=request.getParameter("city");
		String area=request.getParameter("area");
		String project_name=request.getParameter("project_name");

		List<pano_project> pano_projectList=usersSideService.get_projectList();

		pano_project pano_project=pano_projectList.get(0);
		
		long project_sn=pano_project.getSN();

		if((province!=null)&&(city!=null)&&(area!=null)&&(project_name!=null)){
			pano_projectList=usersSideService.list_SelectprojectList2(province, city, area, project_name);
			project_sn=pano_projectList.get(0).getSN();
		}
		model.addAttribute("pano_projectList",pano_projectList);
		
		List<pano_ad> adList=usersSideService.selectAdImg_sn(project_sn);
		
		model.addAttribute("adList",adList);
		
		List<Style> styleList=usersSideService.selectStyleByProject_sn(project_sn);
		
		model.addAttribute("styleList",styleList);
		
		Set<String>  set=new HashSet<String>();
		//根据每个风格-查询对应的-标签集合
		for(int i=0;i<styleList.size();i++){
			Style style = styleList.get(i);
			Long style_sn=style.getId();
			if(set.contains(style.getName())){
				styleList.remove(style);
				continue;
			}else{
				set.add(style.getName());
				List<Lable> lableList=usersSideService.selectLableByStyle_sn(style_sn);
				style.setLableList(lableList);
			}
		}
		return "/usersside/index";
	}
	
	@RequestMapping("/selectProject")
	public void selectProject(String province,String city,String area,HttpServletResponse response) throws IOException{
		List<pano_project> projectList=usersSideService.list_SelectprojectList(province,city,area);
		List<String> project_name=new ArrayList();
		for(int i=0;i<projectList.size();i++){
			project_name.add(projectList.get(i).getNAME());
		}
		String jsonProject=	JsonUtils.objectToJson(project_name);
		this.ajaxOutput(response,jsonProject);
	}
	//跳转到个人中心
	@RequestMapping("/tomy")
	public String tomy(){
 		return "/usersside/my";
	}
	//跳转到登陆页面
	@RequestMapping("/tologin")
    public String tologin(){
		return "/usersside/login";
	}
	//跳转到分享页面
	@RequestMapping("/toshareYM")
    public String toshare(){
		return "/usersside/share";
	}
	//跳转到720页面
		Long style_id_str = null;
		@RequestMapping("/to720")
		public String to720(HttpServletRequest request,HttpSession session){
			//EncryptUtil.decode("");
			if(request.getParameter("style_id") != null){
				style_id_str=Long.parseLong(request.getParameter("style_id"));
			}
			request.setAttribute("style_id",style_id_str);
			//获取到style_id
			long style_id=style_id_str;
			session.setAttribute("style_id",style_id);
			//-------------------------------------------------------------------------------------------
			//获取户型s
			List<pano_project_house> houseList=usersSideService.get_selectHouseListByStyle_sn(style_id);
			if(houseList.size()>0){
				long house_sn=houseList.get(0).getSN();
				List<PanoProjectPackage> packageList=usersSideService.list_selectPackageByHouse_sn(house_sn);
				session.setAttribute("packageList",packageList);
				session.setAttribute("house_sn",house_sn);
			}
			//获取导航图
			List<panoSkin> panoSkinList=usersSideService.list_selectPanoSkinList();
			String skinName="";
			long img_tc=0;
			long img_space=0;
			long img_house=0;
			long img_cart=0;
			for(int i=0;i<panoSkinList.size();i++){
				skinName=panoSkinList.get(i).getName();
				if(skinName.equals("套餐")){
					img_tc=panoSkinList.get(i).getImg_sn();
				}else if(skinName.equals("房间")){
					img_space=panoSkinList.get(i).getImg_sn();
				}else if(skinName.equals("户型")){
					img_house=panoSkinList.get(i).getImg_sn();
				}else if(skinName.equals("购物车")){
					img_cart=panoSkinList.get(i).getImg_sn();
				}
			}
			request.setAttribute("img_tc",img_tc);
			request.setAttribute("img_space",img_space);
			request.setAttribute("img_house",img_house);
			request.setAttribute("img_cart",img_cart);
			
			
			
			
			/*List<Long> skinImg_snList=new ArrayList<Long>();
			skinImg_snList.add();*/
			
			
			
			return "/usersside/720";
		}
	@RequestMapping("/to720_tc")
	public String to720_tc(HttpServletRequest request,HttpSession session){
		return "/usersside/720-tc";
	}
	@RequestMapping("/to720_space")
	public String to720_space(HttpServletRequest request,HttpSession session){
		long house_sn=(Long) session.getAttribute("house_sn");
		//获取空间s
		List<pano_project_space> spaceList=usersSideService.list_selectSpaceNameListByHouse_sn(house_sn);
		request.setAttribute("spaceList",spaceList);
		return "/usersside/720-space";
	}
	@RequestMapping("/to720_unit")
	public String to720_unit(HttpServletRequest request,HttpSession session){
		long style_id=(Long) session.getAttribute("style_id");
		//获取户型s
		List<pano_project_house> houseList=usersSideService.get_selectHouseListByStyle_sn(style_id);
		request.setAttribute("houseList",houseList);
		return "/usersside/720-unit";
	}
	
	@RequestMapping("/selectPackage")
	public void selectPackage(String houseSn,HttpServletResponse response,HttpServletRequest request,HttpSession session) throws Exception{
		long house_sn=EncryptUtil.decode(houseSn);
		
		List<PanoProjectPackage> packageList=usersSideService.list_selectPackageByHouse_sn(house_sn);
		session.setAttribute("packageList",packageList);
		//return this.redirect("/usersside/720");
		session.setAttribute("house_sn",house_sn);
		String msg="";
		String jsonProject=	JsonUtils.objectToJson(msg);
		this.ajaxOutput(response,jsonProject);
		//return "/usersside/720";
	}
	//获取验证码----------------------------------------------------------------
	@RequestMapping("/getVerifyCode")
	public void getVerifyCode(String phone,HttpServletResponse response,HttpSession session) throws IOException{
		//SmsSend send=new SmsSend();
		//测试验证码
		String phoneCode="123456";
		//不能删下面注释代码！！
		/*String phoneCode=send.sendPhoneCode(phone);*/
		session.setAttribute("phoneCode",phoneCode);
		
		
		String jsonProject=	JsonUtils.objectToJson(phoneCode);
		this.ajaxOutput(response,jsonProject);
	}
	@RequestMapping("/surelogin")
	public void login(String phoneCode_in,String phone,HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException{
		String phoneCode_out=(String)session.getAttribute("phoneCode");
		//首先判断有没有该用户
				List<pano_mem_user> muserList_only=usersSideService.get_selectMUserByPhone(phone);
				int muserListSize=muserList_only.size();
				if(muserListSize==0){
					//用户不存在，向用户表插入数据
					usersSideService.insert_UserMsg_Phone(phone);
				}
				
		//验证码正确，进入登录后页面
		String msg="";
		if(phoneCode_in.equals(phoneCode_out)){
			msg="success";
			//验证码正确，查询手机用户信息
			List<pano_mem_user> muserList_only_login=usersSideService.get_selectMUserByPhone(phone);
			session.setAttribute("userMsg_phone",muserList_only_login.get(0));
			
		}else{
			msg="error";
		}
		String jsonProject=	JsonUtils.objectToJson(msg);
		this.ajaxOutput(response,jsonProject);
	}
	
	@RequestMapping("/exitLogin")
	public String exitLogin(HttpSession session){
		session.removeAttribute("userMsg_phone");
		return this.redirect("/userside/tologin");
	}
	
	
	@RequestMapping("/tocar")
	public String tocar(HttpServletRequest request,HttpSession session){
		pano_mem_user userMsg_phone =(pano_mem_user) session.getAttribute("userMsg_phone");
		if(userMsg_phone==null){
			return this.redirect("/userside/tologin");
		}else{
			//查询显示在购物车里的属性信息
			long user_sn=userMsg_phone.getSN();
			List<AddToCar> addToCarList=usersSideService.get_selectAddToCar2(user_sn);
			request.setAttribute("addToCarList",addToCarList);
			return "/usersSide/car";
			
		}
		
		
	}
	@RequestMapping("/addToCar")
	public void addToCar(String packageSn,HttpServletRequest request,HttpServletResponse response,HttpSession session) throws Exception{
		pano_mem_user userMsg_phone =(pano_mem_user) session.getAttribute("userMsg_phone");
		String msg="";
		//判断是否已经登录，如果没登陆就跳到登陆页面
		if(userMsg_phone==null){
			//如果用户未登录
			msg="nologin";
			
		}else if(userMsg_phone!=null){
			//如果已登录
			//这里packageSn是户型套餐表主键,不是套餐表主键
			long house_package_sn=EncryptUtil.decode(packageSn);
			//long package_sn=Long.parseLong(request.getParameter("package_sn"));
			//查询购物车里是否已经添加该套餐，如果已经添加了那么此次点击就是删掉，如果没有添加就添加进去
			List<AddToCar> packageList_only=usersSideService.selectCarByPackage_sn(house_package_sn);
			if(packageList_only.size()==0){
				//此方法仅作为查询pano_project_house_package.SN as house_package_sn
				List<AddToCar> addToCarList_only=usersSideService.get_selectAddToCar(house_package_sn);
				//long house_package_sn=addToCarList_only.get(0).getHouse_package_sn();
				//向购物车表插入数据-------------------------------------------------------------------------		
				
			//private long USER_SN;---------------登陆后获得
			//private long HOUSE_PACKAGE_SN;------上有
			//private int PURCHASE_NUM;-----------默认1
				
				long USER_SN=userMsg_phone.getSN();
				usersSideService.add_ShopCar(USER_SN,house_package_sn);
			}else{
				//long house_package_sn=packageList_only.get(0).getHouse_package_sn();
				//通过house_package_sn删除购物车表记录
				usersSideService.delete_shopCarByHouse_package_sn(house_package_sn);
			}
			
			msg="yeslogin";
		}
		
		
		
		String jsonProject=	JsonUtils.objectToJson(msg);
		this.ajaxOutput(response,jsonProject);
		//return "/usersside/720-tc";
	}
	long house_package_sn;
	//点击展开进入此方法
	@RequestMapping("/carshow")
	public String carshow(HttpServletRequest request,HttpSession session){
		//获取
		house_package_sn=Long.parseLong(request.getParameter("house_package_sn"));
		//查询套餐对应的户型
		List<AddToCar> addToCarList=usersSideService.get_selectAddToCar(house_package_sn);
		//查询套餐类型集合
		List<PanoProjectPackageType> packageTypeList=usersSideService.
				list_selectPackageTypeListByPackage_Sn(house_package_sn);
		int pAgeTListSize=packageTypeList.size();
		//设置每个套餐类型里面的产品集合
		if(pAgeTListSize>0){
			//类型1有产品集合里3个产品，类型2/3没有
			List<Product> productList=null;
			for(int i=0;i<pAgeTListSize;i++){
			  long packageType_sn=packageTypeList.get(i).getSN();
			  productList=usersSideService.list_selectProductListByPAT_sn(packageType_sn);			
			  //下面代码有问题
			  if(productList.size()==0){
				Product product=new Product();
				productList.add(product);
			    //packageTypeList.get(i).setProductList(productList);
			  }
			packageTypeList.get(i).setProductList(productList);
			}
		}
		request.setAttribute("addToCarList",addToCarList);
		request.setAttribute("packageTypeList",packageTypeList);
		return "/usersside/carshow";
	}
	
	@RequestMapping("/carshow2")
	public String carshow2(HttpServletRequest request,HttpSession session){
		//获取
		//查询套餐对应的户型
		List<AddToCar> addToCarList=usersSideService.get_selectAddToCar(house_package_sn);
		//查询套餐类型集合
		List<PanoProjectPackageType> packageTypeList=usersSideService.
				list_selectPackageTypeListByPackage_Sn(house_package_sn);
		int pAgeTListSize=packageTypeList.size();
		//设置每个套餐类型里面的产品集合
		if(pAgeTListSize>0){
			//类型1有产品集合里3个产品，类型2/3没有
			List<Product> productList=null;
			for(int i=0;i<pAgeTListSize;i++){
			  long packageType_sn=packageTypeList.get(i).getSN();
			  productList=usersSideService.list_selectProductListByPAT_sn(packageType_sn);			
			  //下面代码有问题
			  if(productList.size()==0){
				Product product=new Product();
				productList.add(product);
			    //packageTypeList.get(i).setProductList(productList);
			  }
			packageTypeList.get(i).setProductList(productList);
			}
		}
		request.setAttribute("addToCarList",addToCarList);
		request.setAttribute("packageTypeList",packageTypeList);
		return "/usersside/carshow";
	}
	//点击展开进入此方法
	@RequestMapping("/topro")
	public String topro(HttpServletRequest request){
		long packageType_sn=Long.parseLong(request.getParameter("packageType_sn"));
		
		List<Product> productList_pro=usersSideService.list_selectProductByPackageType_sn(packageType_sn);
		
		request.setAttribute("productList_pro",productList_pro);
		
		return "/usersside/pro";
	}
	//toconfirm
	//点击结算进入此方法
		@RequestMapping("/toconfirm")
		public void toconfirm(String total_price_,long house_package_sn,HttpSession session,HttpServletRequest request,HttpServletResponse response) throws IOException{
			//查询是否已添加该订单
			long USER_SN=(Long) session.getAttribute("user_sn");
			//查询显示
			//List<AddToCar> addToCarList_toConfirm=usersSideService.
			//		get_selectAddToCarToConfirm(house_package_sn,USER_SN);
			//if(addToCarList_toConfirm.size()==0){
				/*order表
				 * order_num(上有),order_time,status,address_sn,user_sn,total_price
				 */
		List<String> order_numList=new ArrayList<String>();
		String order_num = "";
				StringBuffer builder = new StringBuffer(order_num);
				for(int i=0;i<6;i++){
					int x=(int)(Math.random()*10);
					builder.append(x);
				}
				//获取StringBuilder内部修改好的字符串
		                    order_num = builder.toString();
		                    order_numList.add(order_num);
				            Date date=new Date();
				            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String order_time=sdf.format(date);
		int status=1;//待付款//total_price;
		long user_sn=(Long)session.getAttribute("user_sn");//登陆写完再取值
		        //通过user_sn查询pano_user_receive_address表主键address_sn
		//此处报错，但不影响运行，暂不处理
		long address_sn=usersSideService.get_address_snByUser_sn(user_sn);//暂时随便取值
		BigDecimal total_price=new BigDecimal(total_price_.substring(1,total_price_.length()).trim());
			    usersSideService.insert_order(order_num,order_time,
					status,address_sn,user_sn,total_price);
				//根据order_num查询order表sn
				pano_order order=usersSideService.get_order_snByOrder_num(order_num);
				long order_sn=order.getSN();
				
				
				/*item表
				 * order_sn
				 */   
					//插入item表
				    //根据package_sn
				    //long house_package_sn=usersSideService.get_House_package_snByPackage_sn(package_sn);
			        usersSideService.insert_item(order_sn,house_package_sn);
			        
				
				
				/*logtc表
				 * id(物流编号,String),order_sn(订单编号,上有)
				 */
			        String id="物流编号";
			        usersSideService.insert_logtc(id,order_sn);
			//}
			//下用
			session.setAttribute("package_count",1);//套餐数量
			session.setAttribute("house_package_sn",house_package_sn);
			session.setAttribute("order_numList",order_numList);
			String jsonProject=	JsonUtils.objectToJson("123");
			this.ajaxOutput(response,jsonProject);
		}
	//点击结算后通过success函数进入此方法，跳转页面
		@RequestMapping("/toconfirm_YM")
		public String toconfirm_YM(HttpSession session,HttpServletRequest request){
			//userMsg_phone
			pano_mem_user userMsg_phone =(pano_mem_user) session.getAttribute("userMsg_phone");
			long USER_SN = userMsg_phone.getSN();
			//long USER_SN=(Long) session.getAttribute("user_sn");
			//显示默认地址信息
			List<pano_user_receive_address> address = personalService
					.selAddressbyDef(USER_SN);
			if(address.size()>0){
				request.setAttribute("address", address.get(0));
			}
			
			//查询显示
			//order_numList
			List<String> order_numList=(List<String>) session.getAttribute("order_numList");
			String order_num="";
			//??
			//long house_package_sn=(Long) session.getAttribute("house_package_sn");
			List<AddToCar> addToCarList_toConfirm=new ArrayList<AddToCar>();
			List<AddToCar> addToCarList_only=new ArrayList<AddToCar>();
			for(int i=0;i<order_numList.size();i++){
				order_num=order_numList.get(i);
				addToCarList_only=usersSideService.get_selectAddToCarToConfirm(USER_SN,order_num);
				if(addToCarList_only.size()>0){
			    	addToCarList_toConfirm.add(addToCarList_only.get(0));
			    }
			}
			double price_sum=0;//new BigDecimal(null);
			for(int i=0;i<addToCarList_toConfirm.size();i++){
				String price_sum_str=addToCarList_toConfirm.get(i).getPackage_price()+"";
				price_sum=price_sum+Double.parseDouble(price_sum_str);
			}
			request.setAttribute("addToCarList_toConfirm",addToCarList_toConfirm);
			request.setAttribute("price_sum",price_sum);
			
			return "/usersside/confirm";
		}
	@RequestMapping("/toconfirm_car")
	public void toconfirm_car(String total_price_,String house_pack_sn_strs,HttpSession session,HttpServletRequest request,HttpServletResponse response) throws IOException{
		house_pack_sn_strs.split("/");
		List<String> house_pack_sn_list_ = Arrays.asList(house_pack_sn_strs.split("/"));
		List<String> house_pack_sn_list =new ArrayList<String>();
		for(int i=1;i<house_pack_sn_list_.size();i++){
			if(!(house_pack_sn_list_.get(i).equals("undefined"))){
				house_pack_sn_list.add(house_pack_sn_list_.get(i));
			}
			
		}
		session.setAttribute("package_count",house_pack_sn_list.size());
		//开始插入表
long user_sn=(Long)session.getAttribute("user_sn");//登陆写完再取值
        List<String> order_numList=new ArrayList<String>();
		for(int i=0;i<house_pack_sn_list.size();i++){
			/*order表
			 * order_num(上有),order_time,status,address_sn,user_sn,total_price
			 */
			String order_num = "";
			StringBuffer builder = new StringBuffer(order_num);
			for(int j=0;j<6;j++){
				int x=(int)(Math.random()*10);
				builder.append(x);
			}
			//获取StringBuilder内部修改好的字符串
	        order_num = builder.toString();
	        order_numList.add(order_num);
	        Date date=new Date();
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
String order_time=sdf.format(date);
int status=1;//待付款//total_price;

             //通过user_sn查询pano_user_receive_address表主键address_sn
//此处报错，但不影响运行，暂不处理
long address_sn=usersSideService.get_address_snByUser_sn(user_sn);//暂时随便取值
             //这个我认为应该是单个套餐价格
BigDecimal total_price=new BigDecimal(total_price_.substring(1,total_price_.length()).trim());
	    usersSideService.insert_order(order_num,order_time,
			status,address_sn,user_sn,total_price);
		//根据order_num查询order表sn
		pano_order order=usersSideService.get_order_snByOrder_num(order_num);
		long order_sn=order.getSN();
		/*item表
		 * order_sn
		 */   
			//插入item表
		                //根据package_sn查询house_package_sn
		                //long house_package_sn=usersSideService.get_House_package_snByPackage_sn(package_sn);
		    long house_package_sn=Long.parseLong(house_pack_sn_list.get(i));    
		    usersSideService.insert_item(order_sn,house_package_sn);
	    /*logtc表
		 * id(物流编号,String),order_sn(订单编号,上有)
		 */
		    String id="物流编号";
		    usersSideService.insert_logtc(id,order_sn);
		}
		session.setAttribute("order_numList",order_numList);
		String jsonProject=	JsonUtils.objectToJson("test");
		this.ajaxOutput(response,jsonProject);
	}
	//获取验证码(提交订单)----------------------------------------------------------------
		@RequestMapping("/getVerifyCode_order")
		public void getVerifyCode_order(String phone,HttpServletResponse response,HttpSession session) throws IOException{
			//SmsSend send=new SmsSend();
			//不能删下面注释代码！！
			/*String phoneCode=send.sendPhoneCode(phone);
			
			session.setAttribute("phoneCode_order","123456");//测试假数据
			/*String str="";
			String jsonProject=	JsonUtils.objectToJson(str);
			this.ajaxOutput(response,jsonProject);*/
		}
		@RequestMapping("/toVerify")
		public void toVerify(String phone,String verify,HttpServletResponse response,
				HttpSession session) throws IOException{
			String phone_in=phone.trim();
			String verify_in=verify.trim();
			String phoneCode_order=((String) session.getAttribute("phoneCode_order")).trim();
			String msg="";
			if(verify_in.equals(phoneCode_order)){
				msg="success";
			}else{
				msg="error";
			}
			String jsonProject=	JsonUtils.objectToJson(msg);
			this.ajaxOutput(response,jsonProject);
		}
		@RequestMapping("/toYM")
	    public String toYM(){
			//return "/usersside/index";
			return this.redirect("/usersSide/toIndex");
		}
		/**
		 * 支付订单--------------------------------------------------
		 */
		@RequestMapping("/toPayAllorder")
	    public String toPayAllorder(HttpSession session) throws Exception{
			List<pano_order> order_List =(List<pano_order>) session.getAttribute("order_List_chindren");
			String All_order_num =(String) session.getAttribute("All_order_num");
			//向合并订单表插入数据
			String ORDER_NUM="";
			if(order_List!=null){
				for(int i=0;i<order_List.size();i++){
                    //for(int i=0;i<5;i++){//测试代码
                    ORDER_NUM=order_List.get(i).getORDER_NUM();
                    usersSideService.insert_Merge(ORDER_NUM,All_order_num);
                    //修改订单表状态
                    int STATUS=3;
                    usersSideService.update_orderStatus(STATUS,ORDER_NUM);
                }
			}else{
			}
			
			
			return this.redirect("/usersSide/toIndex");
			
		}
	
	
	
	
}















