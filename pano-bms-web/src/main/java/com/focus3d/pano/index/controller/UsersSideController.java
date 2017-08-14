package com.focus3d.pano.index.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.focus3d.pano.common.controller.BaseController;
import com.focus3d.pano.model.AddToCar;
import com.focus3d.pano.model.Lable;
import com.focus3d.pano.model.PanoProduct;
import com.focus3d.pano.model.PanoProjectPackage;
import com.focus3d.pano.model.PanoProjectPackageType;
import com.focus3d.pano.model.Product;
import com.focus3d.pano.model.Style;
import com.focus3d.pano.model.pano_project;
import com.focus3d.pano.model.pano_project_house;
import com.focus3d.pano.model.pano_project_space;
import com.focus3d.pano.usersside.service.UsersSideService;
import com.focus3d.pano.usersside.utils.SmsSend;
import com.focustech.common.utils.JsonUtils;
//     /userside/toindex       /usersSide/toIndex
@Controller
@RequestMapping("/usersSide")
public class UsersSideController extends BaseController{
	@Resource
	private UsersSideService usersSideService;

	@RequestMapping("/toIndex")
	public String toIndex(Model model,HttpServletRequest request) throws Exception{
		/*long dec1=EncryptUtil.decode("faAKeUyoNwQS");//广告
		long dec2=EncryptUtil.decode("eEoKUeAyDmkn");//广告
		long dec3=EncryptUtil.decode("awUyeoAKNSby");//广告
		long dec4=EncryptUtil.decode("ajoyeKAohmvD");
		long dec5=EncryptUtil.decode("eIUKAeoyhSRO");//北欧风格
		long dec6=EncryptUtil.decode("eveoAyUKhIRP");//现代风格
		long dec7=EncryptUtil.decode("eYUoeyKADwRc");
		long dec8=EncryptUtil.decode("eNoeUyKAXIlJ");
		long dec9=EncryptUtil.decode("aRAUyeKoDSIy");
		long dec10=EncryptUtil.decode("aGoyUKAeDmIp");
	System.out.println(
"1:"+dec1+",2:"+dec2+",3:"+dec3+",4:"+dec4+",5:"+dec5+",6:"+dec6+
",7:"+dec7+",8:"+dec8+",9:"+dec9+",10:"+dec10
	);
		model.addAttribute("dec1",dec1);
		model.addAttribute("dec2",dec2);
		model.addAttribute("dec3",dec3);
		model.addAttribute("dec5",dec5);
		model.addAttribute("dec6",dec6);*/
		//从广告表取img_sn集合
		System.out.println("进入/toIndex方法");
		
		List<Long> adImg_snList=usersSideService.selectAdImg_sn();
		model.addAttribute("adImg_snList",adImg_snList);
		
		//根据楼盘信息，查询楼盘sn
		String province=request.getParameter("province");
		String city=request.getParameter("city");
		String area=request.getParameter("area");
		String project_name=request.getParameter("project_name");
		//System.out.println("province:"+province+",city:"+city+",area:"+area+",project_name:"+project_name);
		//查询全部楼盘，默认第一个楼盘显示首页
		List<pano_project> pano_projectList=usersSideService.get_projectList();
		//System.out.println("项目集合："+pano_projectList);
		//List<pano_project> pano_projectList=null;
		//默认首页显示数据库里第一个楼盘                   long project_sn=100007;
		pano_project pano_project=pano_projectList.get(0);
		long project_sn=pano_project.getSN();
		//long project_sn=100007;
		if((province!=null)&&(city!=null)&&(area!=null)&&(project_name!=null)){
			//其实这里应该只有一个元素，为了防止添加楼盘时没验证唯一，性导致这里会报错才查的集合
			pano_projectList=usersSideService.list_SelectprojectList2(
					province, city, area, project_name);
			project_sn=pano_projectList.get(0).getSN();
		}
		model.addAttribute("pano_projectList",pano_projectList);
		//查询   楼盘sn(100007)-风格styleList     *project_sn:100012***此事还要关联户型表查询house_sn
		System.out.println("1.查询风格集合,当前参数project_sn:"+project_sn);
		List<Style> styleList=usersSideService.selectStyleByProject_sn(project_sn);
		System.out.println("2.查询风格集合");
		System.out.println("风格s："+styleList);
		model.addAttribute("styleList",styleList);
		//根据每个风格-查询对应的-标签集合
		for(int i=0;i<styleList.size();i++){
			Long style_sn=styleList.get(i).getId();
			//System.out.println("风格sn:"+style_sn);
			List<Lable> lableList=usersSideService.selectLableByStyle_sn(style_sn);
			//System.out.println("标签集合,lableList:"+lableList);			
		}
		
		return "/usersside/index";
	}
	
	@RequestMapping("/selectProject")
	public void selectProject(String province,String city,String area,HttpServletResponse response) throws IOException{
		System.out.println("进入查询项目名方法：");
		//System.out.println("省："+province+",市："+city+",区："+area);
		List<pano_project> projectList=usersSideService.list_SelectprojectList(province,city,area);
		List<String> project_name=new ArrayList();
		for(int i=0;i<projectList.size();i++){
			project_name.add(projectList.get(i).getNAME());
		}
		//project_name.add("盛鑫佳园1");
		//project_name.add("盛鑫佳园2");
		//System.out.println("楼盘名集合："+project_name);
		String jsonProject=	JsonUtils.objectToJson(project_name);
		this.ajaxOutput(response,jsonProject);
	}
	//跳转到个人中心
	@RequestMapping("/tomy")
	public String tomy(){
		System.out.println("进入tomy方法:");
		
		return "/usersside/my";
	}
	//跳转到登陆页面
	@RequestMapping("/tologin")
    public String tologin(){
		System.out.println("进入tologin方法:");
		
		return "/usersside/login";
	}
	//跳转到分享页面
	@RequestMapping("/toshareYM")
    public String toshare(){
		System.out.println("进入toshareYM方法:");
		return "/usersside/share";
	}
	//跳转到720页面
	@RequestMapping("/to720")
	public String to720(HttpServletRequest request,HttpSession session){
		System.out.println("进入to720方法:");
		String style_id_str=request.getParameter("style_id");
		//获取到style_id
		long style_id=Integer.parseInt(style_id_str);
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
		//获取套餐s
		
		return "/usersside/720";
	}
	@RequestMapping("/to720_tc")
	public String to720_tc(HttpServletRequest request,HttpSession session){
		System.out.println("进入to720-tc方法:");
		return "/usersside/720-tc";
	}
	@RequestMapping("/to720_space")
	public String to720_space(HttpServletRequest request,HttpSession session){
		System.out.println("进入to720_space方法:");
		long house_sn=(Long) session.getAttribute("house_sn");
		//获取空间s
		List<pano_project_space> spaceList=usersSideService.list_selectSpaceNameListByHouse_sn(house_sn);
		request.setAttribute("spaceList",spaceList);
		return "/usersside/720-space";
	}
	@RequestMapping("/to720_unit")
	public String to720_unit(HttpServletRequest request,HttpSession session){
		System.out.println("进入to720_unit方法:");
		long style_id=(Long) session.getAttribute("style_id");
		//获取户型s
		List<pano_project_house> houseList=usersSideService.get_selectHouseListByStyle_sn(style_id);
		request.setAttribute("houseList",houseList);
		return "/usersside/720-unit";
	}
	
	@RequestMapping("/selectPackage")
	public String selectPackage(HttpServletRequest request,HttpSession session){
		System.out.println("进入selectPackage方法:");
		String house_sn_str=request.getParameter("house_sn");
		long house_sn=Long.parseLong(house_sn_str);
		List<PanoProjectPackage> packageList=usersSideService.list_selectPackageByHouse_sn(house_sn);
		session.setAttribute("packageList",packageList);
		System.out.println("户型"+house_sn+"套餐："+packageList);
		//return this.redirect("/usersside/720");
		session.setAttribute("house_sn",house_sn);
		return "/usersside/720";
	}
	//获取验证码----------------------------------------------------------------
	@RequestMapping("/getVerifyCode")
	public void getVerifyCode(String phone,HttpSession session) throws UnsupportedEncodingException{
		System.out.println("进入getVerifyCode方法:");
		System.out.println("手机号："+phone);
		SmsSend send=new SmsSend();
		//不能删下面注释代码！！
		/*String phoneCode=send.sendPhoneCode(phone);
		System.out.println("手机验证码为："+phoneCode);
		session.setAttribute("phoneCode",phoneCode);*/
	}
	@RequestMapping("/surelogin")
	public String login(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException{
		String phoneCode_out=(String)session.getAttribute("phoneCode");
		String phoneCode_in=request.getParameter("phoneCode_in");
		System.out.println("phoneCode_out:"+phoneCode_out+",phoneCode_in:"+phoneCode_in);
		//首先判断有没有该用户
		/*String phone=request.getParameter("phone");
		List<pano_mem_user> muserList_only=usersSideService.get_selectMUserByPhone(phone);
		int muserListSize=muserList_only.size();
		if(muserListSize==0){
			String msg="用户不存在";
			String jsonProject=	JsonUtils.objectToJson(msg);
			this.ajaxOutput(response,jsonProject);
			return "";
		}*/
		//验证码正确，进入登录后页面
		
		return "";
	}
	@RequestMapping("/tocar")
	public String tocar(HttpServletRequest request,HttpSession session){
		System.out.println("进入tocar方法:");
		//查询显示在购物车里的属性信息
		long user_sn=111111;
		List<AddToCar> addToCarList=usersSideService.get_selectAddToCar2(user_sn);
		System.out.println("addToCarList:"+addToCarList);
		request.setAttribute("addToCarList",addToCarList);
		return "/usersside/car";
	}
	@RequestMapping("/addToCar")
	public String addToCar(HttpServletRequest request,HttpSession session){
		System.out.println("进入/addToCar方法");
		long package_sn=Long.parseLong(request.getParameter("package_sn"));		
		//此方法仅作为查询pano_project_house_package.SN as house_package_sn
		List<AddToCar> addToCarList_only=usersSideService.get_selectAddToCar(package_sn);
		System.out.println("addToCarList_only:"+addToCarList_only);
		long house_package_sn=addToCarList_only.get(0).getHouse_package_sn();
		//向购物车表插入数据-------------------------------------------------------------------------		
		/*
	private long USER_SN;---------------登陆后获得
	private long HOUSE_PACKAGE_SN;------上有
	private int PURCHASE_NUM;-----------默认1
		 */
		long USER_SN=111111;
		System.out.println("1.测试");
		usersSideService.add_ShopCar(USER_SN,house_package_sn);
		System.out.println("2.测试");
		return "/usersside/720-tc";
	}
	//点击展开进入此方法
	@RequestMapping("/carshow")
	public String carshow(HttpServletRequest request,HttpSession session){
		System.out.println("进入/carshow方法");
		//获取
		long package_sn=Long.parseLong(request.getParameter("package_sn"));
		//查询套餐对应的户型
		List<AddToCar> addToCarList=usersSideService.get_selectAddToCar(package_sn);
		//查询套餐类型集合
		List<PanoProjectPackageType> packageTypeList=usersSideService.
				list_selectPackageTypeListByPackage_Sn(package_sn);
		//System.out.println("套餐类型集合："+packageTypeList);
		int pAgeTListSize=packageTypeList.size();
		//设置每个套餐类型里面的产品集合
		System.out.println("套餐类型集合长度:"+pAgeTListSize);
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
			System.out.println("套餐类型sn:"+packageType_sn+",产品集合："+productList);
			}
		}
		//System.out.println("1.packageTypeList:"+packageTypeList);addToCarList
		request.setAttribute("addToCarList",addToCarList);
		request.setAttribute("packageTypeList",packageTypeList);
		return "/usersside/carshow";
	}
	//点击展开进入此方法
	@RequestMapping("/topro")
	public String topro(HttpServletRequest request){
		System.out.println("进入/topro方法");
		long packageType_sn=Long.parseLong(request.getParameter("packageType_sn"));
		
		System.out.println("套餐类型sn:"+packageType_sn);
		
		List<Product> productList_pro=usersSideService.list_selectProductByPackageType_sn(packageType_sn);
		System.out.println("产品集合_pro:"+productList_pro);
		
		request.setAttribute("productList_pro",productList_pro);
		
		return "/usersside/pro";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}















