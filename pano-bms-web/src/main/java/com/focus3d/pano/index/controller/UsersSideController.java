package com.focus3d.pano.index.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.focus3d.pano.usersside.service.UsersSideService;
import com.focustech.common.utils.EncryptUtil;
//            /usersSide/toIndex
@Controller
@RequestMapping("/usersSide")
public class UsersSideController {
	@Resource
	private UsersSideService usersSideService;
	@RequestMapping("/toIndex")
	public String toIndex(Model model) throws Exception{
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
		List<Long> adImg_snList=usersSideService.selectAdImg_sn();
		model.addAttribute("adImg_snList",adImg_snList);
		//查询   楼盘sn(100007)-风格styleList
		long project=100007;
		
		
		
		
		
		return "/usersside/index";
	}
	
	
	
	
	
	
	
	
	
}















