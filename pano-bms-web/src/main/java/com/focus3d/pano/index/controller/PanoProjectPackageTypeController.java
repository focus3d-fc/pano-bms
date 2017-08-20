package com.focus3d.pano.index.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.focus3d.pano.admin.service.PackageTypeService;
import com.focus3d.pano.common.controller.BaseController;
import com.focus3d.pano.model.PackageTypeList;
import com.focus3d.pano.model.PanoProjectPackageType;
import com.focus3d.pano.model.pano_project_space;
import com.focustech.common.utils.JsonUtils;

@Controller
@RequestMapping("/type")
public class PanoProjectPackageTypeController extends BaseController{
		@Autowired
		private PackageTypeService typeService;
		
		@RequestMapping("/selectList")
		public String select(HttpServletRequest request,HttpSession session){
			
			System.out.println("进入查询");
			/**
			 * 通过前台获得楼盘 户型 风格 套餐 和套餐关联表主键
			 */
			if(request.getParameter("ids") != null){
				System.out.println("-------套餐获得数值");
			long project = Long.parseLong(request.getParameter("ids"));
			long house = Long.parseLong(request.getParameter("ids1"));
			long style = Long.parseLong(request.getParameter("ids2"));
			long packages = Long.parseLong(request.getParameter("ids4"));
			long sns = Long.parseLong(request.getParameter("ids5"));
			/**
			 * 添加跳转页面以后 不获取不到id值 就这样在获得数值
			 */
			List li = new ArrayList();
			li.add(project);
			li.add(house);
			li.add(style);
			li.add(packages);
			li.add(sns);
			session.setAttribute("li",li );
			}
			System.out.println("-------套餐获得数值完毕");
			List lis =(List) session.getAttribute("li");
			Long project_sn =  (Long) lis.get(0);
			Long house_sn = (Long) lis.get(1);
			Long style_sn = (Long) lis.get(2);
			Long package_sn = (Long) lis.get(3);
			Long sn = (Long) lis.get(4);
			/**
			 * 把 户型套餐主键 发送到前台用于添加功能
			 */
			request.setAttribute("sn",sn);
			System.out.println("楼盘SN:"+project_sn+"户型SN:"+house_sn+"风格SN:"+style_sn+"套餐SN:"+package_sn+"主键:"+sn);
			
			/**
			 * 先通过主键的ID 查询 套餐类型表中是否有关联的套餐 类别 和 空间
			 */
			List<PanoProjectPackageType> select = typeService.getSelect(sn);
			System.out.println("套餐类型数值："+select.size());
			
			/**
			 * 判断原有表中查询是否为空 
			 */
			if(select.size()>0){
				System.out.println("不为空判断");
				/**
				 *  通过 户型套餐主键查询 空间Sn 和 套餐类型Sn
				 */
				System.out.println("户型套餐SN:"+sn);
				List<PanoProjectPackageType> selectType = typeService.getSelectType(sn);
				
				/**
				 * 	创建一个List集合 存放得到的数值集合 
				 *  得到一个或多个 空间Sn 和 分类Sn  
				 *  for输出 分类Sn 和 空间Sn
				 *  在把得到的 楼盘 空间 ....等值放到对象中  查询 要显示的内容
				 */
					List<PackageTypeList> typeList = new ArrayList<PackageTypeList>();
					PackageTypeList list = new PackageTypeList();
					list.setPackage_sn(package_sn);
					list.setStyle_sn(style_sn);
					list.setProject_sn(project_sn);
					list.setHouse_sn(house_sn);
					for(PanoProjectPackageType type:selectType){
						System.out.print("------分类SN:"+type.getSN()+"空间SN:"+type.getSpace_sn()+"--");
						list.setSpace_sn(type.getSpace_sn());
						list.setType_sn(type.getSN());
						PackageTypeList selectList = typeService.getSelectList(list);
						request.setAttribute("listType", selectList);
						System.out.println("查询到的分类信息为："+selectList.getPackage_name()+selectList.getProject_name());
						typeList.add(selectList);
					}
					request.setAttribute("listsType", typeList);
				
			}else{
				System.out.println("进入空值判断");
				/**
				 * 根据 户型套餐SN 得到套餐类型没有对应的 Sn 则只显示固定值的Name
				 */
				PackageTypeList list = new PackageTypeList();
				list.setHouse_sn(house_sn);
				list.setProject_sn(project_sn);
				list.setPackage_sn(package_sn);
				list.setStyle_sn(style_sn);
				list.setSn(sn);
				PackageTypeList list2 = typeService.getList(list);
				request.setAttribute("listType", list2);
			}
			/**
			 *  根据户型的SN  查询对应的 空间Name
			 */
			List<pano_project_space> space = typeService.getSpace(house_sn);
			request.setAttribute("space", space);
			
			
			return "/houses/classify";
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
			String sqace = request.getParameter("options");
			String text = request.getParameter("texts");
			System.out.println("得到户型套餐主键SN:"+sn+" 得到输入框的值："+text+" 得到空间的SN:"+sqace);
			/**
			 *  将得到的数值  添加到 套餐类型表中
			 */
			PanoProjectPackageType types = new PanoProjectPackageType();
			types.setSpace_sn(Long.parseLong(sqace));
			types.setHouse_package_sn(Long.parseLong(sn));
			types.setName(text);
			typeService.getAddType(types);
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
		public String delete(HttpServletRequest request){
			String sn = request.getParameter("sntype");
			System.out.println("删除ID"+sn);
			typeService.getDelete(Long.parseLong(sn));
			return "redirect:/type/selectList";
			
		}
}
