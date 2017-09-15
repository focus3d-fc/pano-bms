package com.focus3d.pano.index.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.focus3d.pano.admin.service.HousesService;
import com.focus3d.pano.admin.service.PackageTypeService;
import com.focus3d.pano.common.controller.BaseController;
import com.focus3d.pano.model.PanoProjectPackageType;
import com.focustech.common.utils.JsonUtils;

@Controller
@RequestMapping("/type")
public class PanoProjectPackageTypeController extends BaseController{
		@Autowired
		private PackageTypeService typeService;
		
		@Autowired
		private HousesService housesService;
		
		@RequestMapping("/selectList")
		public String select(String house_sn,String housepackagesn,ModelMap map,HttpSession session){
			
			Long housePackageSn = Long.parseLong(housepackagesn);
			Long houseSn = Long.parseLong(house_sn);
			
			List<Map<String,Object>> list = housesService.QueryHouseStylePacakgeType(housePackageSn);
			
			List<Map<String,Object>> space = housesService.QueryTypeSurplusSpace(houseSn);
			
			map.put("list",list);
			map.put("space",space);
			map.put("houseSn", house_sn);
			map.put("housePackageSn",housePackageSn);
			
			return "/houses/classify";
		}
		
		
		
		@RequestMapping("/queryTypeSurplusSpace")
		public void QueryTypeSurplusSpace(HttpServletResponse response,String houseSn,String housePackageSn){
			try{
				Map<String,Object> map = new HashMap<String,Object>();
				map.put("houseSn",houseSn );
				List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
				ajaxOutput(response, JsonUtils.arrayToJson(list.toArray()));
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		
		/**
		 *  添加分类 
		 * @return 
		 */
		@RequestMapping("/insertList")
		public void insert(HttpServletRequest request,HttpServletResponse response){
			/**
			 *  前台得到 户型套餐Sn  类别名称  空间Sn
			 */
			String sn = request.getParameter("sn");
			String typeSn =  request.getParameter("typeSn");
			String sqace = request.getParameter("options");
			String text = request.getParameter("texts");
			/**
			 *  将得到的数值  添加到 套餐类型表中
			 */
			PanoProjectPackageType types = new PanoProjectPackageType();
			types.setSpace_sn(Long.parseLong(sqace));
			types.setHouse_package_sn(Long.parseLong(sn));
			types.setName(text);
			if(typeSn!=null&&!typeSn.equals("")){
				types.setSN(Long.parseLong(typeSn));
				housesService.updateTypeInfo(types);
			}else{
				typeService.getAddType(types);
			}
			try {
				this.ajaxOutput(response,"完毕");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		
		/**
		 * 删除
		 */
		@RequestMapping("/delete")
		public String delete(String sntype,String houseSn,String housePackageSn){
			typeService.getDelete(Long.parseLong(sntype));
			return "redirect:/type/selectList?house_sn="+houseSn+"&housepackagesn="+housePackageSn;
		}
}
