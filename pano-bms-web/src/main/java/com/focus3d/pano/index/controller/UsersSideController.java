package com.focus3d.pano.index.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.focus3d.pano.common.controller.BaseController;
import com.focus3d.pano.model.Lable;
import com.focus3d.pano.model.Style;
import com.focus3d.pano.model.pano_project;
import com.focus3d.pano.model.pano_project_house;
import com.focus3d.pano.usersside.service.UsersSideService;
import com.focustech.common.utils.EncryptUtil;
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
		System.out.println("province:"+province+",city:"+city+",area:"+area+",project_name:"+project_name);
		//查询全部楼盘，默认第一个楼盘显示首页
		List<pano_project> pano_projectList=usersSideService.get_projectList();
		System.out.println("项目集合："+pano_projectList);
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
		//查询   楼盘sn(100007)-风格styleList
		List<Style> styleList=usersSideService.selectStyleByProject_sn(project_sn);
		//System.out.println("风格s："+styleList);
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
	public String to720(HttpServletRequest request){
		System.out.println("进入to720方法:");
		String style_id_str=request.getParameter("style_id");
		long style_id=Integer.parseInt(style_id_str);
		System.out.println("style_id:"+style_id+",style_id+5:"+(style_id+5));
		//  get_selectHouseListByStyle_sn
		List<pano_project_house> houseList=usersSideService.get_selectHouseListByStyle_sn(style_id);
		System.out.println("houseList:"+houseList);
		request.setAttribute("houseList",houseList);
		return "/usersside/720";
	}
	//分享到朋友圈方法
	@RequestMapping("/share")
	public void share(HttpServletRequest request,HttpServletResponse response){
		System.out.println("进入share方法:");
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}















