package com.focus3d.pano.index.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.focus3d.pano.admin.service.IPackageSetService;
import com.focus3d.pano.admin.service.IProductAdmService;
import com.focus3d.pano.admin.utils.PageInfo;
import com.focus3d.pano.common.controller.BaseController;
import com.focus3d.pano.model.PanoProductFunc;
import com.focus3d.pano.model.PanoProductType;
import com.focus3d.pano.model.PanoUserLongin;
import com.focus3d.pano.model.PjPackageItem;
import com.focus3d.pano.model.ProdtcateInPackage;
import com.focus3d.pano.model.ProductInfo;
import com.focus3d.pano.model.pano_project_style;
import com.focustech.cief.filemanage.client.api.IFileReadClient;
import com.focustech.cief.filemanage.client.constant.FileAttributeEnum;
import com.focustech.common.utils.JsonUtils;

/**
 * 
 * @author jing
 *
 */
/**
 *增加套餐，展示展品
 *
 */

@Controller
@RequestMapping(value ="/packageset")
public class PackageSetController extends BaseController{

	@Autowired 
	private IProductAdmService productAdmService;
	@Autowired
	private IFileReadClient fileReadClient;//读取文件接口    
	@Autowired
	private IPackageSetService packageSetService;
	
	@RequestMapping("/chooseprodt")
    public String chooseprodt(HttpSession session,Long pgsn,Model model,String proid,String styleSn,String funcSn
			,Integer pageNum,Integer pageSize,String ifscfy){
		
		
		Map<String,Object> paramMap=new HashMap<String,Object>();
		System.out.println("产品列表分类获得类型SN："+pgsn);
		session.setAttribute("pgsn", pgsn);
		 paramMap.put("id", proid);
		
		 paramMap.put("styleSn", styleSn);
		 paramMap.put("funcSn", funcSn);
		
		 model.addAttribute("proid", proid);
		 model.addAttribute("scStyleSn", styleSn);
		 model.addAttribute("scFuncSn",funcSn);
		 model.addAttribute("ifscfy", ifscfy);
		
		 PageInfo page=new PageInfo();
		  int allPageSize = productAdmService.countProductInfo(paramMap);
		    System.out.println("zzzzzzzzzzz"+allPageSize);
		    page.setTotalRecords(allPageSize);
		    page.setPerPageInt(pageSize);
		    page.setCurrentPage(pageNum);
		    page.pageInfoInvoke(allPageSize, pageSize);
		   
		    paramMap.put("startNum", page.getStartRecord());
		    paramMap.put("pageSize", page.getPerPageInt());
		 
		    session.setAttribute("page", page);
		 List<ProductInfo> productInfoList=null;
		 List<pano_project_style> proStyleList=null;
		 List<PanoProductFunc>  proFuncList=null;
		 List<PanoProductType> proTypeList=null;
		 
		 List<ProdtcateInPackage> prodtcateInpgList=null;
		try {
			productInfoList = productAdmService.listProductInfo(paramMap);
			proStyleList=productAdmService.listAllProStyle();
			proFuncList=productAdmService.listAllProFunc();
			proTypeList=productAdmService.listAllProType();
			
		    prodtcateInpgList=packageSetService.listProdtcateInPackage();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   
		   //产品详情显示首个
		   session.setAttribute("prodtInfo1", productInfoList.get(0));
		   if(productInfoList!=null&&productInfoList.size()>0){
		   session.setAttribute("productInfoList", productInfoList);
		   }
		   session.setAttribute("proStyleList", proStyleList);
		   session.setAttribute("proFuncList", proFuncList);
		   session.setAttribute("proTypeList", proTypeList);
		   
		   session.setAttribute("prodtcateInpgList", prodtcateInpgList);
		
		
    	return "/houses/combo-add";
    }

	
	@RequestMapping("/addpackage")
	    public String addpackage(){
	    	return null;
	    }
	
	@RequestMapping("/getprodtinpgdetail")
    public String getprodtinpgdetail(String prodtsn,Model model){
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
	
	
	@RequestMapping("/getselectedprodt")
    public void getselectedprodt(HttpServletResponse response,HttpServletRequest request,String[] selsns){
		Map<String,Object> paramMap=new HashMap<String,Object>();
		
	//System.out.println("sssssssssssssss"+selsns.length);
		if(selsns!=null&&selsns.length>0){
		paramMap.put("selsns", selsns);
		List<ProductInfo> seledProdtList=packageSetService.getSelectedProdt(paramMap);
		String jsonprodt=	JsonUtils.objectToJson(seledProdtList);
		  System.out.println(jsonprodt);
		  try {
				this.ajaxOutput(response, jsonprodt);
			} catch (IOException e) {
				// TODO Auto-generated catch blocks
				e.printStackTrace();
			}
		}
    }
	
	
	@RequestMapping("/addpgrelitem")
    public String addpgrelitem(HttpSession session,Long[] productSn,Long[] itemTypeSn){
		  PanoUserLongin userLongin = (PanoUserLongin)session.getAttribute("user");
		   long lsn=userLongin.getSn();
		   System.out.println("lllllllll"+lsn);
		   Long packageSn=(Long)session.getAttribute("pgsn");
		   System.out.println("ppppppp"+packageSn);
		   if(productSn!=null&&productSn.length>0){
		   for(int i = 0; i <productSn.length; i++ ){
		   PjPackageItem pgitem=new PjPackageItem(); 
		   pgitem.setPackageSn(packageSn);
		   pgitem.setProductSn(productSn[i]);
		   pgitem.setItemTypeSn(itemTypeSn[i]);
		   pgitem.setAdderSn(lsn);
		   pgitem.setUpdaterSn(lsn);
		   packageSetService.savePjPackageItem(pgitem);
		   }
		 }
    	return redirect("/housess/packageSet");
    }
	
	/* @RequestMapping("/addpackage")
	    public String addpackage(){
	    	return null;
	    }*/
	 
}
