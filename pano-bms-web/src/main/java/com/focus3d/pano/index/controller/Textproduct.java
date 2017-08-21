package com.focus3d.pano.index.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tools.ant.taskdefs.condition.Http;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.focus3d.pano.admin.service.IProductAdmService;
import com.focus3d.pano.admin.service.PackageTypeService;
import com.focus3d.pano.common.controller.BaseController;
import com.focus3d.pano.model.GetproductList;
import com.focus3d.pano.model.Package_Product;
import com.focus3d.pano.model.Paging;
import com.focus3d.pano.model.Product;
import com.focus3d.pano.model.ProductInfo;
import com.focus3d.pano.model.ProductList;
import com.focustech.cief.filemanage.client.api.IFileReadClient;
import com.focustech.cief.filemanage.client.constant.FileAttributeEnum;
import com.focustech.common.utils.JsonUtils;
import com.opensymphony.oscache.util.StringUtil;

@Controller
@RequestMapping("/typeproduct")
public class Textproduct extends BaseController{
	
	@Autowired
	private PackageTypeService service;
	@Autowired 
	private IProductAdmService productAdmService;
	@Autowired
	private IFileReadClient fileReadClient;//读取文件接口    
	Long package_sn;
	Long project_sn;
	Long house_sn;
	Long style_sn;
	Long type_sn;
	
	/**
	 * 			前台分页模糊查询传过来的值
	 * @param request
	 * @param pageNum
	 * @param style_name
	 * @param func_name
	 * @param type_name
	 * @return
	 */
	@RequestMapping("/select")
	public String selectProduct(HttpServletRequest request, HttpServletResponse response){
		
			/**
			 * 获得当前页数
			 * pagenum 当前页数
			 */
			String page = request.getParameter("pagenum"); 
			String product_id = request.getParameter("productid"); 
			String style_name = request.getParameter("style"); 
			String type_name = request.getParameter("typepr"); 
			String func_name = request.getParameter("func"); 
			System.out.println(" /id："+product_id+" /风格："+style_name+" /类型："+type_name+" /功能："+func_name);
			if(style_name != null){
		     if(style_name.equals("不限")){
		    	 style_name = null;
		     }
		     if(type_name.equals("不限")){
		    	 type_name = null;
		     }
		     if(func_name.equals("不限")){
		    	 func_name = null;
		     }
			}	 
			
			/**
			 * 通过分类页面 得到传过来的 楼盘 风格 户型 套餐 分类的Sn
			 */
			if(request.getParameter("type") != null){
			 package_sn = Long.parseLong(request.getParameter("type"));
			 project_sn = Long.parseLong(request.getParameter("type1"));
			 house_sn = Long.parseLong(request.getParameter("type2"));
			 style_sn = Long.parseLong(request.getParameter("type3"));
			 type_sn = Long.parseLong(request.getParameter("type4"));
			 System.out.println("楼盘SN："+project_sn+" /户型SN："+house_sn+" /风格SN："+style_sn+" /套餐SN："+package_sn+" /分类SN："+type_sn);
			}
			/**
			 * 通过前台的SN 获得当前固定的值
			 */
			GetproductList lists = new GetproductList();
			lists.setHouse_sn(house_sn);
			lists.setStyle_sn(style_sn);
			lists.setType_sn(type_sn);
			lists.setPackage_sn(package_sn);
			lists.setProject_sn(project_sn);
			GetproductList listProduct = service.getListProduct(lists);
			request.setAttribute("getListProduct", listProduct);
			
			/**
			 * 模糊查询若为空咋 为%查询所有
			 */
			if(StringUtil.isEmpty(product_id)){
				product_id ="%";
			}
			System.out.println("模糊查询proName："+product_id);
			/**
			 * 当前页若为空则设置为1
			 */
			int upPage=0;
			int nextPage=0;
			int pageNum = 1;
			if(!StringUtil.isEmpty(page)){
				pageNum = Integer.parseInt(page);
			}if(pageNum==1){
				upPage=1;
				nextPage=2;
			}
			
			/**
			 * 将模糊查询 下拉框的值 放在Map里面 在发送后台
			 */
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("product_id", product_id);
			map.put("style_name", style_name);
			map.put("func_name", func_name);
			map.put("type_name", type_name);
			/**
			 *   产品页面进来显示所有的  pano_product(产品表)的值 分页查询模糊查询
			 */
			System.out.println("开始执行SQL语句");
			Paging productLists = service.getProductList(map, pageNum);
			request.setAttribute("prList", productLists);
			int totalPages=productLists.getTotalPages();

			if(pageNum==totalPages){
				upPage=pageNum-1;
				nextPage=totalPages;
			}else if(pageNum>1){
				upPage=pageNum-1;
				nextPage=pageNum+1;
			}
			request.setAttribute("upPage", upPage);
			request.setAttribute("nextPage",nextPage);
			
			/**
			 * 将产品值从page类里面的产品List提取出来 转发出去
			 */
			List<ProductList> productList =	(List<ProductList>)productLists.getList();
			request.setAttribute("product",productList );
			/**
			 * 将 风格 功能 类型查询提取出来 转发出去
			 */
			List<ProductList> type = service.getType();
			List<ProductList> func = service.getFunc();
			List<ProductList> style = service.getStyle();
			request.setAttribute("type", type);
			request.setAttribute("func", func);	
			request.setAttribute("style", style);
			/**
			 *  第一次进页面时 无数据 显示固定数值    有数值 则在产品列表显示对应的产品
			 */
			List<Package_Product> product = service.getProduct(type_sn);
			/**
			 * 	判断 pano_project_package_product（套餐分类下的产品）
			 * 		是否有对应的分类的数据
			 */
			System.out.println("是否有无数据："+product.size());
			if(product.size()>0){
				List list = new ArrayList();
			 Long product_sn =null;
			    for(Package_Product p:product){
			    	product_sn =p.getProduct_sn();
			    	System.out.println("产品的SN："+product_sn);
			    	List<Product> productSn = service.getProductSn(product_sn);
			    	for(Product pr:productSn){
			    		System.out.println("sn："+pr.getSn()+" /////////类型"+pr.getTypeSn()+" /功能："+pr.getFuncSn()+" /风格："+pr.getStyleSn());
			    		Map map1 = new HashMap();
			    		map1.put("sn", pr.getSn());
			    		map1.put("type_sn",pr.getTypeSn());
			    		map1.put("func_sn", pr.getFuncSn());
			    		map1.put("style_sn", pr.getStyleSn());
			    		
			    		list.add( service.GetMap(map1));
			    		
			    		
			    	}
			    }
			    request.setAttribute("getMap", list);
				
			}else{
				
			}
			
			
		return "/houses/combo-add1";
		
	}
	
	/**
	 * 	删除分类下的产品
	 *  删除产品Sn  和 分类的Sn
	 */
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request){
		String sn = request.getParameter("sn");
		System.out.println("产品SN:"+sn+" /分类SN:"+type_sn);
		Package_Product product = new Package_Product();
		product.setPackage_type_sn(type_sn);
		product.setProduct_sn(Long.parseLong(sn));
		int getdelete = service.getdelete(product);
		return "redirect:/typeproduct/select";
		
	}
	
	/**
	 *  获取 添加复选框中选中的产品Sn  和 分类Sn  添加到分类产品表中
	 */
	@RequestMapping("/insert")
	public String insert(HttpServletRequest request){
		System.out.println("进入添加用户界面");
			String[] parameterValues = request.getParameterValues("name");
			for(String product_sn:parameterValues){
				List<Package_Product> selectProduct = service.getSelectProduct(type_sn);
				if(selectProduct.size()>0){
				boolean boo = true;
				for(Package_Product s:selectProduct){
					if(Long.parseLong(product_sn) == s.getProduct_sn()){
						boo = false;
					}
				}
				if(boo){
					Package_Product product = new Package_Product();
					product.setPackage_type_sn(type_sn);
					product.setProduct_sn(Long.parseLong(product_sn));
					service.getinsert(product);
				}
				System.out.println("循环结束");
				}else{
							System.out.println("空");
							Package_Product product = new Package_Product();
							product.setPackage_type_sn(type_sn);
							product.setProduct_sn(Long.parseLong(product_sn));
							 service.getinsert(product);
				}
			}
		     System.out.println("执行完毕");
			return "redirect:/typeproduct/select";
		
	}
	
	@RequestMapping("/getprodtinpgdetail")
    public String getprodtinpgdetail(HttpServletRequest request,Model model){
		String prodtsn = request.getParameter("prodtsn");
    	  System.out.println("ppppppppp"+prodtsn);
    	  
    	  ProductInfo prodtInfo=null;
  		try {
  			prodtInfo = productAdmService.getProductDetail(prodtsn);
  			Long fullImgSn=prodtInfo.getFullImgSn();
  			Long leftImgSn=prodtInfo.getLeftImgSn();
  			Long downImgSn=prodtInfo.getDownImgSn();
  			Long materialImgSn=prodtInfo.getMaterialImgSn();
  			Long fabricImgSn=prodtInfo.getFabricImgSn();
  			if(fullImgSn!=null){
  			 String fullImgUrl=fileReadClient.getFile(fullImgSn, FileAttributeEnum.VISIT_ADDR);
  			 prodtInfo.setFullImgUrl(fullImgUrl);
  			}
  		     if(leftImgSn!=null){ 
  			  String leftImgUrl=fileReadClient.getFile(prodtInfo.getLeftImgSn(), FileAttributeEnum.VISIT_ADDR);
  			  prodtInfo.setLeftImgUrl(leftImgUrl);
  		      }
  		     if(downImgSn!=null){
  			  String downImgUrl=fileReadClient.getFile(prodtInfo.getDownImgSn(),FileAttributeEnum.VISIT_ADDR);
  			  prodtInfo.setDownImgUrl(downImgUrl);
  		     }
  		      if(materialImgSn!=null){ 
  		     String materialImgUrl=fileReadClient.getFile(prodtInfo.getMaterialImgSn(), FileAttributeEnum.VISIT_ADDR);
  		     prodtInfo.setMaterialImgUrl(materialImgUrl);
  		      }
  		      if(fabricImgSn!=null){
  		     String fabricImgUrl=fileReadClient.getFile(prodtInfo.getFabricImgSn(), FileAttributeEnum.VISIT_ADDR);
  		     prodtInfo.setFabricImgUrl(fabricImgUrl);
  		      }
  		   
  		    model.addAttribute("prodtDetail", prodtInfo);
  		} catch (Exception e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		}
    	  
		return "/houses/pro-details";
    }
	
}
