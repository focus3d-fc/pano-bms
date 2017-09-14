package com.focus3d.pano.index.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.focus3d.pano.admin.service.IProductAdmService;
import com.focus3d.pano.admin.utils.PageInfo;
import com.focus3d.pano.common.controller.BaseController;
import com.focus3d.pano.model.PanoVender;
import com.focus3d.pano.model.Product;
import com.focus3d.pano.model.ProductClassify;
import com.focus3d.pano.model.ProductFeature;
import com.focus3d.pano.model.ProductInfo;
import com.focus3d.pano.model.pano_project_style;
import com.focustech.cief.filemanage.client.api.IFileReadClient;
import com.focustech.cief.filemanage.client.constant.FileAttributeEnum;
import com.focustech.common.utils.EncryptUtil;
import com.focustech.common.utils.JsonUtils;


/**
 * 
 * @author jing
 *
 */
@Controller
@RequestMapping(value ="/productadm")
public class ProductAdmController extends BaseController{
	
	@Autowired
	private IProductAdmService productAdmService;
	@Autowired
	private IFileReadClient fileReadClient;//读取文件接口

	//查询列表
	@RequestMapping("/listproduct")
	public String listproduct(HttpSession session, ModelMap model,String proid,String productName,String styleSn,String funcSn
			,Integer pageNum,Integer pageSize,String ifscfy){
		Map<String,Object> paramMap=new HashMap<String,Object>();
		
		 paramMap.put("id", proid);
		 paramMap.put("styleSn", styleSn);
		 paramMap.put("funcSn", funcSn);
		 paramMap.put("productName", productName);
		
		 model.put("proid", proid);
		 model.put("scStyleSn", styleSn);
		 model.put("scFuncSn",funcSn);
		 model.put("ifscfy", ifscfy);
		
		  PageInfo page=new PageInfo();
		  int allPageSize = productAdmService.countProductInfo(paramMap);
		    page.setTotalRecords(allPageSize);
		    page.setPerPageInt(pageSize);
		    page.setCurrentPage(pageNum);
		    page.pageInfoInvoke(allPageSize, pageSize);
    /* 	    int startRow = (pageNum - 1) * pageSize;
	        int offset = pageSize;
	        PageUtil page = new PageUtil(allPageSize, pageNum, pageSize);*/
		   
		    paramMap.put("startNum", page.getStartRecord());
		    paramMap.put("pageSize", page.getPerPageInt());
		    
		    model.put("total", page.getTotalPage());
		    model.put("current_index",page.getCurrentPage());
		    List<ProductInfo> productInfoList=null;
		    List<pano_project_style> proStyleList=null;
		    List<ProductFeature>  proFuncList=null;
		    List<ProductClassify> proTypeList=null;
		    List<PanoVender> proVenderList=null;
		    
		    
			try {
				productInfoList = productAdmService.listProductInfo(paramMap);
				proStyleList=productAdmService.listAllProStyle();
				proFuncList=productAdmService.listAllProFunc();
				proTypeList=productAdmService.listAllProType();
				proVenderList = productAdmService.listAllVender();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		   //产品详情显示首个
		   session.setAttribute("productInfoList", productInfoList);
			   if(productInfoList!=null&&productInfoList.size()>0){
			   session.setAttribute("prodtInfo1", productInfoList.get(0));
		   }
		   session.setAttribute("proStyleList", proStyleList);
		   session.setAttribute("proFuncList", proFuncList);
		   session.setAttribute("proTypeList", proTypeList);
		   session.setAttribute("proVenderList", proVenderList);
		   return "/panoadm/productadm/product";
	}
	
	@RequestMapping("/validateProductId")
	public void ValidateProductId(HttpServletResponse response,String productId){
		try{
			
			int value = productAdmService.ValidateProductId(productId);
			
			JSONObject json = new JSONObject();
			json.put("info", value);
			ajaxOutput(response, json.toString());
		}catch(IOException e){
			e.printStackTrace();
		}
		
	}
	
	@RequestMapping("/preaddpro")
	public String preaddpro(){
		return "/panoadm/productadm/addproduct";
	}
	
	//添加
	@RequestMapping("/addproduct")
	public String addproduct(Product pro,HttpSession session,HttpServletRequest request,HttpServletResponse response){
		pro.setStatus(1);
		/*PanoLoginModel login=(PanoLoginModel)session.getAttribute("login");
		long usn=login.getSn();
		pro.setAdderSn(usn);
		pro.setUpdaterSn(usn);*/
		String fullImgSn1=pro.getFullImgSn1();
		String leftImgSn1=pro.getLeftImgSn1();
		String downImgSn1=pro.getDownImgSn1();
		String materialImgSn1=pro.getMaterialImgSn1();
		String fabricImgSn1=pro.getFabricImgSn1();
		String longImgSn1 = pro.getLongImgSn1();
		try {
			if(fullImgSn1!=null&&!"".equals(fullImgSn1)){
			long fimgsn = EncryptUtil.decode(fullImgSn1);
			pro.setFullImgSn(fimgsn);
			}
			
			if(leftImgSn1!=null&&!"".equals(leftImgSn1)){
				long limgsn = EncryptUtil.decode(leftImgSn1);
				pro.setLeftImgSn(limgsn);
				}
			if(downImgSn1!=null&&!"".equals(downImgSn1)){
				long dimgsn = EncryptUtil.decode(downImgSn1);
				pro.setDownImgSn(dimgsn);
				}
			
			if(materialImgSn1!=null&&!"".equals(materialImgSn1)){
				long mtimgsn = EncryptUtil.decode(materialImgSn1);
				pro.setMaterialImgSn(mtimgsn);
				}
			if(fabricImgSn1!=null&&!"".equals(fabricImgSn1)){
				long fbcimgsn = EncryptUtil.decode(fabricImgSn1);
				pro.setFabricImgSn(fbcimgsn);
			}
			
			if(longImgSn1!=null&&!"".equals(longImgSn1)){
				long longimgsn = EncryptUtil.decode(longImgSn1);
				pro.setLongImgSn(longimgsn);
			}
			productAdmService.addProduct(pro);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return redirect("/productadm/listproduct");
	}
	
	//预修改
	@RequestMapping("/preupdateproduct")
	public void preupdateproduct(HttpSession session,HttpServletResponse response,Model model,String productsn){
		
		Product prodt=null;
		try {
			prodt = productAdmService.getProductBySn(productsn);
			Long fullImgSn=prodt.getFullImgSn();
			Long leftImgSn=prodt.getLeftImgSn();
			Long downImgSn=prodt.getDownImgSn();
			Long materialImgSn=prodt.getMaterialImgSn();
			Long fabricImgSn=prodt.getFabricImgSn();
			if(fullImgSn!=null){
			 String fullImgUrl=fileReadClient.getFile(fullImgSn, FileAttributeEnum.VISIT_ADDR);
			 prodt.setFullImgUrl(fullImgUrl);
			}
		     if(leftImgSn!=null){ 
			  String leftImgUrl=fileReadClient.getFile(prodt.getLeftImgSn(), FileAttributeEnum.VISIT_ADDR);
			  prodt.setLeftImgUrl(leftImgUrl);
		      }
		     if(downImgSn!=null){
			  String downImgUrl=fileReadClient.getFile(prodt.getDownImgSn(),FileAttributeEnum.VISIT_ADDR);
			  prodt.setDownImgUrl(downImgUrl);
		     }
		      if(materialImgSn!=null){ 
		     String materialImgUrl=fileReadClient.getFile(prodt.getMaterialImgSn(), FileAttributeEnum.VISIT_ADDR);
		     prodt.setMaterialImgUrl(materialImgUrl);
		      }
		      if(fabricImgSn!=null){
		     String fabricImgUrl=fileReadClient.getFile(prodt.getFabricImgSn(), FileAttributeEnum.VISIT_ADDR);
		     prodt.setFabricImgUrl(fabricImgUrl);
		      }
	       
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	  String jsonprodt=	JsonUtils.objectToJson(prodt);
	  try {
		this.ajaxOutput(response, jsonprodt);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
		//return this.redirect("/panoadm/productadm/product#product-update");
	}
	
	//修改
	@RequestMapping("/updateproduct")
	public String updateproduct(Product pro,HttpSession session,HttpServletRequest request,HttpServletResponse response
			){
		/*Product pro=new Product();
		BigDecimal price=new BigDecimal("843.5");
		pro.setPrice(price);*/
    	 pro.setStatus(1);
		/*PanoLoginModel login=(PanoLoginModel)session.getAttribute("login");
		long usn=login.getSn();
		pro.setAdderSn(usn);
		pro.setUpdaterSn(usn);*/
		String fullImgSn1=pro.getFullImgSn1();
		String leftImgSn1=pro.getLeftImgSn1();
		String downImgSn1=pro.getDownImgSn1();
		String materialImgSn1=pro.getMaterialImgSn1();
		String fabricImgSn1=pro.getFabricImgSn1();
		String longImgSn1 = pro.getLongImgSn1();
		
		try {
			if(fullImgSn1!=null&&!"".equals(fullImgSn1)){
				long fimgsn = EncryptUtil.decode(fullImgSn1);
				pro.setFullImgSn(fimgsn);
				}
				
				if(leftImgSn1!=null&&!"".equals(leftImgSn1)){
					long limgsn = EncryptUtil.decode(leftImgSn1);
					pro.setLeftImgSn(limgsn);
					}
				if(downImgSn1!=null&&!"".equals(downImgSn1)){
					long dimgsn = EncryptUtil.decode(downImgSn1);
					pro.setDownImgSn(dimgsn);
					}
				
				if(materialImgSn1!=null&&!"".equals(materialImgSn1)){
					long mtimgsn = EncryptUtil.decode(materialImgSn1);
					pro.setMaterialImgSn(mtimgsn);
					}
				if(fabricImgSn1!=null&&!"".equals(fabricImgSn1)){
					long fbcimgsn = EncryptUtil.decode(fabricImgSn1);
					pro.setFabricImgSn(fbcimgsn);
				}
				if(longImgSn1!=null&&!"".equals(longImgSn1)){
					long longimgsn = EncryptUtil.decode(longImgSn1);
					pro.setLongImgSn(longimgsn);
				}
			boolean bo=productAdmService.updateProduct(pro);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return redirect("/productadm/listproduct");
		
	}
	
	@RequestMapping("/deleteproduct")
	public String deleteproduct(String productsn){
		try {
			productAdmService.deleteProduct(productsn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return redirect("/productadm/listproduct");
	}
	 
	//查看产品详情
	@RequestMapping("/getproductdetail")
	public void getproductdetail(HttpServletResponse response,String productsn){
		ProductInfo prodtInfo=null;
		try {
			prodtInfo = productAdmService.getProductDetail(productsn);
			Long fullImgSn=prodtInfo.getFullImgSn();
			Long leftImgSn=prodtInfo.getLeftImgSn();
			Long downImgSn=prodtInfo.getDownImgSn();
			Long materialImgSn=prodtInfo.getMaterialImgSn();
			Long fabricImgSn=prodtInfo.getFabricImgSn();
			Long longImgSn = prodtInfo.getLongImgSn();
			
			if(longImgSn!=null){
				 String longImgUrl=fileReadClient.getFile(longImgSn, FileAttributeEnum.VISIT_ADDR);
				 prodtInfo.setLongImgUrl(longImgUrl);
			}
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
		   
		    
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		 String jsonprodt=	JsonUtils.objectToJson(prodtInfo);
		  try {
			this.ajaxOutput(response, jsonprodt);
		} catch (IOException e) {
			// TODO Auto-generated catch blocks
			e.printStackTrace();
		}
	}
}
