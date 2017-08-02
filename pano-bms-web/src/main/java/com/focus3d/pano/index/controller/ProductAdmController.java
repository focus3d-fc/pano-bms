package com.focus3d.pano.index.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.focus3d.pano.admin.service.IProductAdmService;

import com.focus3d.pano.common.controller.BaseController;
import com.focus3d.pano.model.PanoLoginModel;
import com.focus3d.pano.model.PanoProductFunc;
import com.focus3d.pano.model.PanoProductType;
import com.focus3d.pano.model.Product;
import com.focus3d.pano.model.ProductInfo;
import com.focus3d.pano.model.pano_project_style;
import com.focustech.cief.filemanage.client.api.IFileReadClient;
import com.focustech.cief.filemanage.client.constant.FileAttributeEnum;
import com.focustech.common.utils.EncryptUtil;
import com.focustech.common.utils.JsonUtils;

@Controller
@RequestMapping(value ="/productadm")
public class ProductAdmController extends BaseController{
	
	@Autowired
	private IProductAdmService productAdmService;
	@Autowired
	private IFileReadClient fileReadClient;//读取文件接口

	
	@RequestMapping("/listproduct")
	public String listproduct(HttpSession session,Model model,String proid,String styleSn,String funcSn
			,Integer pageNum,Integer pageSize){
		Map<String,Object> paramMap=new HashMap<String,Object>();
		
		System.out.println(proid);
		
		 paramMap.put("id", proid);
		 paramMap.put("styleSn", styleSn);
		 paramMap.put("funcSn", funcSn);
		 model.addAttribute("proid", proid);
		 model.addAttribute("scStyleSn", styleSn);
		 model.addAttribute("scFuncSn",funcSn);
		 
		/* if(pageNum==null){
				pageNum=1;
			}if(pageSize==null){
				pageSize=5;
			}
			   
		    int startRow = (pageNum - 1) * pageSize;
	        int offset = pageSize;
	        int allPageSize = productAdmService.countProductInfo(paramMap);
	        PageUtil page = new PageUtil(allPageSize, pageNum, pageSize);
		    paramMap.put("startNum", page.getSelectStart());
		    paramMap.put("pageSize", page.getPageShowSize());*/
		 
		 List<ProductInfo> productInfoList=null;
		 List<pano_project_style> proStyleList=null;
		 List<PanoProductFunc>  proFuncList=null;
		 List<PanoProductType> proTypeList=null;
		 
		 try {
			long dec=EncryptUtil.decode("TCoeyKUAXHup");
			//String file = fileReadClient.getFile(decode, FileAttributeEnum.VISIT_ADDR);
			System.out.println("*****"+dec);
			model.addAttribute("leftImgSn",dec);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 
		try {
			productInfoList = productAdmService.listProductInfo(paramMap);
			proStyleList=productAdmService.listAllProStyle();
			proFuncList=productAdmService.listAllProFunc();
			proTypeList=productAdmService.listAllProType();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  /* for(ProductInfo p:productInfoList){
			   System.out.println("---------"+p.getId()+p.getName()+p.getBrand()+p.getUpdateTime1());
		   }*/
		   
		   //产品详情显示首个
		   session.setAttribute("prodtInfo1", productInfoList.get(0));
		   session.setAttribute("productInfoList", productInfoList);
		   session.setAttribute("proStyleList", proStyleList);
		   session.setAttribute("proFuncList", proFuncList);
		   session.setAttribute("proTypeList", proTypeList);
		return "/panoadm/productadm/product";
	}
	
	
	
	@RequestMapping("/preaddpro")
	public String preaddpro(){
		System.out.println("*******88");
		return "/panoadm/productadm/addproduct";
	}
	
	
	@RequestMapping("/addproduct")
	public String addproduct(Product pro,HttpSession session,HttpServletRequest request,HttpServletResponse response
			){
		System.out.println("进入添加");
		pro.setStatus(1);
		/*PanoLoginModel login=(PanoLoginModel)session.getAttribute("login");
		long usn=login.getSn();
		pro.setAdderSn(usn);
		pro.setUpdaterSn(usn);*/
		
		
		System.out.println("----"+"******"+pro.getFullImgSn1()+pro.getDimension()+pro.getTypeSn());
		System.out.println(pro.getId()+pro.getName());
		String fullImgSn1=pro.getFullImgSn1();
		String leftImgSn1=pro.getMaterialImgSn1();
		String downImgSn1=pro.getDownImgSn1();
		String materialImgSn1=pro.getMaterialImgSn1();
		String fabricImgSn1=pro.getFabricImgSn1();
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
			productAdmService.addProduct(pro);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("-------------aaaaaaa");
			e.printStackTrace();
		}
		
		return redirect("/productadm/listproduct");
	}
	
	//修改
	@RequestMapping("/preupdateproduct")
	public void preupdateproduct(HttpSession session,HttpServletResponse response,Model model,String productsn){
//		Product prodt=productAdmService.getProductBySn(productsn);
//		  model.addAttribute("prodt", prodt);
		System.out.println("-----zzzzzzzzzz"+productsn);
		
		//Product prodt=null;
		Product prodt=null;
		try {
			prodt = productAdmService.getProductBySn(productsn);
	       
	       
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
		System.out.println(prodt.getId()+prodt.getName()+prodt.getTypeSn());
		
		
	  String jsonprodt=	JsonUtils.objectToJson(prodt);
	  System.out.println(jsonprodt);
	  try {
		this.ajaxOutput(response, jsonprodt);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
		//return this.redirect("/panoadm/productadm/product#product-update");
	}
	
	@RequestMapping("/updateproduct")
	public String updateproduct(Product pro,HttpSession session,HttpServletRequest request,HttpServletResponse response
			){
		System.out.println("进入执行修改product");
		
		/*Product pro=new Product();
		BigDecimal price=new BigDecimal("843.5");
		pro.setPrice(price);*/
    	 pro.setStatus(1);
		/*PanoLoginModel login=(PanoLoginModel)session.getAttribute("login");
		long usn=login.getSn();
		pro.setAdderSn(usn);
		pro.setUpdaterSn(usn);*/
		
		System.out.println("******"+pro.getDimension()+pro.getTypeSn());
		System.out.println(pro.getId()+pro.getName());
		
		String fullImgSn1=pro.getFullImgSn1();
		String leftImgSn1=pro.getMaterialImgSn1();
		String downImgSn1=pro.getDownImgSn1();
		String materialImgSn1=pro.getMaterialImgSn1();
		String fabricImgSn1=pro.getFabricImgSn1();
		
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
			productAdmService.updateProduct(pro);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("-------------aaaaaaa");
			e.printStackTrace();
		}
		
		
		return redirect("/productadm/listproduct");
		
	}
	
	@RequestMapping("/deleteproduct")
	public String deleteproduct(String productsn){
		try {
			System.out.println(productsn);
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
		  System.out.println(jsonprodt);
		  try {
			this.ajaxOutput(response, jsonprodt);
		} catch (IOException e) {
			// TODO Auto-generated catch blocks
			e.printStackTrace();
		}
	}
}
