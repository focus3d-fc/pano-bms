package com.focus3d.pano.index.controller;

<<<<<<< HEAD
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
=======
import java.math.BigDecimal;
import java.util.List;

>>>>>>> 52bf08c4abab5c5ea0085a0d2f74e03c60009ab5
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
<<<<<<< HEAD
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.focus3d.pano.admin.service.IProductAdmService;
import com.focus3d.pano.common.controller.BaseController;
import com.focus3d.pano.model.PanoLoginModel;
import com.focus3d.pano.model.Product;
import com.focustech.common.utils.JsonUtils;
=======
import org.springframework.web.bind.annotation.RequestMapping;

import com.focus3d.pano.admin.service.IProductAdmService;
import com.focus3d.pano.common.controller.BaseController;
import com.focus3d.pano.model.Product;
>>>>>>> 52bf08c4abab5c5ea0085a0d2f74e03c60009ab5

@Controller
@RequestMapping(value ="/productadm")
public class ProductAdmController extends BaseController{
	
	@Autowired
	private IProductAdmService productAdmService;
	
	@RequestMapping("/listproduct")
	public String listproduct(HttpSession session){
		 List<Product> productList=null;
		try {
			productList = productAdmService.listProducts();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
<<<<<<< HEAD
		   /*for(Product p:productList){
			   System.out.println("---------"+p.getId()+p.getName()+p.getBrand());
		   }*/
=======
		   for(Product p:productList){
			   System.out.println("---------"+p.getId()+p.getName()+p.getBrand());
		   }
>>>>>>> 52bf08c4abab5c5ea0085a0d2f74e03c60009ab5
		   
		   session.setAttribute("productList", productList);
		return "/panoadm/productadm/product";
	}
	
	
	@RequestMapping("/addproduct")
<<<<<<< HEAD
	public String addproduct(Product pro,HttpSession session,HttpServletRequest request,HttpServletResponse response
			,@RequestParam("t1") MultipartFile uploadImg1,@RequestParam("t2") MultipartFile uploadImg2
			,@RequestParam("t3") MultipartFile uploadImg3,@RequestParam("t4") MultipartFile uploadImg4
			,@RequestParam("t5") MultipartFile uploadImg5
			){
		
    	 String imgname1=uploadImg1.getOriginalFilename();
    	 String imgname2=uploadImg2.getOriginalFilename();
    	 String imgname3=uploadImg3.getOriginalFilename();
    	 String imgname4=uploadImg4.getOriginalFilename();
    	 String imgname5=uploadImg5.getOriginalFilename();
    	System.out.println("-----------"+imgname1+imgname2+imgname3);
    	 InputStream in1=null;
    	 InputStream in2=null;
    	 InputStream in3=null;
    	 InputStream in4=null;
    	 InputStream in5=null;
    	
    	 FileOutputStream fos=null;
		/*Product pro=new Product();
		BigDecimal price=new BigDecimal("843.5");
		pro.setPrice(price);*/
		PanoLoginModel login=(PanoLoginModel)session.getAttribute("login");
		long usn=login.getSn();
		pro.setStatus(1);
		long a=10000;
		pro.setLeftImgSn(a);
		pro.setDownImgSn(a);
		pro.setFullImgSn(a);
		pro.setTypeSn(a);
		pro.setSpaceSn(a);
		pro.setFuncSn(a);
		pro.setStyleSn(a);
		pro.setAdderSn(usn);
		pro.setUpdaterSn(usn);
		
		pro.setFullImg(imgname1);
		pro.setLeftImg(imgname2);
		pro.setDownImg(imgname3);
		pro.setMaterialImg(imgname4);
		pro.setFabricImg(imgname5);
		
		System.out.println("aaaaaaaaa");
		System.out.println(pro.getId()+pro.getName());
		
		try {
			productAdmService.addProduct(pro);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("-------------aaaaaaa");
			e.printStackTrace();
		}
		
		
		 try {
	    	
	    	 ServletContext sc=request.getSession().getServletContext();
	    	 String imgpath=sc.getRealPath(sc.getInitParameter("uploadImgPath"));
				
				 File f = new File(imgpath); 
				
			        if (!f.exists()){  
			            f.mkdirs(); 
			        }
			      
	    	
				
				byte[] buff=new byte[1024];
				int readLen=-1;
				File targetimg1=new File(imgpath,imgname1);
				if(!targetimg1.exists()){
					try {
						/*in = uploadImg.getInputStream();
						FileUtils.copyInputStreamToFile(in, targetimg);	*/
						in1=uploadImg1.getInputStream();
						fos=new FileOutputStream(targetimg1);
						while((readLen=in1.read(buff))!=-1){
							fos.write(buff,0,readLen);
						 }
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else{
					response.setContentType("text/html;charset=utf-8");
					PrintWriter pw =response.getWriter();
					pw.println(imgname1+"已存在！");
					pw.close();
				}
				
				File targetimg2=new File(imgpath,imgname2);
				if(!targetimg2.exists()){
					try {
						/*in = uploadImg.getInputStream();
						FileUtils.copyInputStreamToFile(in, targetimg);	*/
						in2=uploadImg2.getInputStream();
						fos=new FileOutputStream(targetimg2);
						while((readLen=in2.read(buff))!=-1){
							fos.write(buff,0,readLen);
						 }
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else{
					response.setContentType("text/html;charset=utf-8");
					PrintWriter pw =response.getWriter();
					pw.println(imgname2+"已存在！");
					pw.close();
				}
				
				File targetimg3=new File(imgpath,imgname3);
				if(!targetimg3.exists()){
					try {
						/*in = uploadImg.getInputStream();
						FileUtils.copyInputStreamToFile(in, targetimg);	*/
						in3=uploadImg3.getInputStream();
						fos=new FileOutputStream(targetimg3);
						while((readLen=in3.read(buff))!=-1){
							fos.write(buff,0,readLen);
						 }
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else{
					response.setContentType("text/html;charset=utf-8");
					PrintWriter pw =response.getWriter();
					pw.println(imgname3+"已存在！");
					pw.close();
				}
				
				File targetimg4=new File(imgpath,imgname4);
				if(!targetimg4.exists()){
					try {
						/*in = uploadImg.getInputStream();
						FileUtils.copyInputStreamToFile(in, targetimg);	*/
						in4=uploadImg4.getInputStream();
						fos=new FileOutputStream(targetimg4);
						while((readLen=in4.read(buff))!=-1){
							fos.write(buff,0,readLen);
						 }
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else{
					response.setContentType("text/html;charset=utf-8");
					PrintWriter pw =response.getWriter();
					pw.println(imgname4+"已存在！");
					pw.close();
				}
				
				File targetimg5=new File(imgpath,imgname5);
				if(!targetimg5.exists()){
					try {
						/*in = uploadImg.getInputStream();
						FileUtils.copyInputStreamToFile(in, targetimg);	*/
						in5=uploadImg5.getInputStream();
						fos=new FileOutputStream(targetimg5);
						while((readLen=in5.read(buff))!=-1){
							fos.write(buff,0,readLen);
						 }
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else{
					response.setContentType("text/html;charset=utf-8");
					PrintWriter pw =response.getWriter();
					pw.println(imgname5+"已存在！");
					pw.close();
				}
				/*File targetFile=new File(storeDir,fileName);
				if(!targetFile.exists()){
				in1=uploadFile.getInputStream();
				fos=new FileOutputStream(targetFile);
				while((readLen=in1.read(buff))!=-1){
					fos.write(buff,0,readLen);
				 }
			  }else{
					response.setContentType("text/html;charset=utf-8");
					PrintWriter pw =response.getWriter();
					pw.println(fileName+"文件已存在！");
					pw.close();
				}*/
	    	  
	    	 
	    	 } catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				try {
					if(fos!=null)fos.close();
					if(in1!=null)in1.close();
					if(in2!=null)in2.close();
					if(in3!=null)in3.close();
					if(in4!=null)in4.close();
					if(in5!=null)in5.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
		
		
		
		
		
		
		
		
		
		
		return this.redirect("/productadm/listproduct");
	}
	
	
	@RequestMapping("/preupdateproduct")
	@ResponseBody
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
			,@RequestParam("t1") MultipartFile uploadImg1,@RequestParam("t2") MultipartFile uploadImg2
			,@RequestParam("t3") MultipartFile uploadImg3,@RequestParam("t4") MultipartFile uploadImg4
			,@RequestParam("t5") MultipartFile uploadImg5){
		System.out.println("进入执行修改product");
		
		
		/* String imgname1=uploadImg1.getOriginalFilename();
    	 String imgname2=uploadImg2.getOriginalFilename();
    	 String imgname3=uploadImg3.getOriginalFilename();
    	 String imgname4=uploadImg4.getOriginalFilename();
    	 String imgname5=uploadImg5.getOriginalFilename();
    	System.out.println("-----------"+imgname1+imgname2+imgname3);
    	 InputStream in1=null;
    	 InputStream in2=null;
    	 InputStream in3=null;
    	 InputStream in4=null;
    	 InputStream in5=null;
    	
    	 FileOutputStream fos=null;
		Product pro=new Product();
		BigDecimal price=new BigDecimal("843.5");
		pro.setPrice(price);
		PanoLoginModel login=(PanoLoginModel)session.getAttribute("login");
		long usn=login.getSn();
		pro.setStatus(1);
		long a=10000;
		pro.setLeftImgSn(a);
		pro.setDownImgSn(a);
		pro.setFullImgSn(a);
		pro.setTypeSn(a);
		pro.setSpaceSn(a);
		pro.setFuncSn(a);
		pro.setStyleSn(a);
		pro.setAdderSn(usn);
		pro.setUpdaterSn(usn);
		
		pro.setFullImg(imgname1);
		pro.setLeftImg(imgname2);
		pro.setDownImg(imgname3);
		pro.setMaterialImg(imgname4);
		pro.setFabricImg(imgname5);
		
		System.out.println("修改aaaaaaaaa");
		System.out.println(pro.getId()+pro.getName());
		
		try {
			productAdmService.updateProduct(pro);
=======
	public String addproduct(){
		
	/*	List<ProductModel> productList=productAdmService.listproducts();
		for(ProductModel p:productList){
			  System.out.println(p.getBrand()+p.getName());
		  }*/
		Product pro=new Product();
		pro.setId("h38283");
		pro.setName("欧式");
		pro.setBrand("万达");
		BigDecimal price=new BigDecimal("843.5");
		pro.setPrice(price);
		System.out.println("aaaaaaaaa");
		try {
			productAdmService.insert(pro);
>>>>>>> 52bf08c4abab5c5ea0085a0d2f74e03c60009ab5
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("-------------aaaaaaa");
			e.printStackTrace();
		}
		
		
<<<<<<< HEAD
		 try {
	    	
	    	 ServletContext sc=request.getSession().getServletContext();
	    	 String imgpath=sc.getRealPath(sc.getInitParameter("uploadImgPath"));
				
				 File f = new File(imgpath); 
				
			        if (!f.exists()){  
			            f.mkdirs(); 
			        }
			      
	    	
				
				byte[] buff=new byte[1024];
				int readLen=-1;
				File targetimg1=new File(imgpath,imgname1);
				if(!targetimg1.exists()){
					try {
						in = uploadImg.getInputStream();
						FileUtils.copyInputStreamToFile(in, targetimg);	
						in1=uploadImg1.getInputStream();
						fos=new FileOutputStream(targetimg1);
						while((readLen=in1.read(buff))!=-1){
							fos.write(buff,0,readLen);
						 }
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else{
					response.setContentType("text/html;charset=utf-8");
					PrintWriter pw =response.getWriter();
					pw.println(imgname1+"已存在！");
					pw.close();
				}
				
				File targetimg2=new File(imgpath,imgname2);
				if(!targetimg2.exists()){
					try {
						in = uploadImg.getInputStream();
						FileUtils.copyInputStreamToFile(in, targetimg);	
						in2=uploadImg2.getInputStream();
						fos=new FileOutputStream(targetimg2);
						while((readLen=in2.read(buff))!=-1){
							fos.write(buff,0,readLen);
						 }
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else{
					response.setContentType("text/html;charset=utf-8");
					PrintWriter pw =response.getWriter();
					pw.println(imgname2+"已存在！");
					pw.close();
				}
				
				File targetimg3=new File(imgpath,imgname3);
				if(!targetimg3.exists()){
					try {
						in = uploadImg.getInputStream();
						FileUtils.copyInputStreamToFile(in, targetimg);	
						in3=uploadImg3.getInputStream();
						fos=new FileOutputStream(targetimg3);
						while((readLen=in3.read(buff))!=-1){
							fos.write(buff,0,readLen);
						 }
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else{
					response.setContentType("text/html;charset=utf-8");
					PrintWriter pw =response.getWriter();
					pw.println(imgname3+"已存在！");
					pw.close();
				}
				
				File targetimg4=new File(imgpath,imgname4);
				if(!targetimg4.exists()){
					try {
						in = uploadImg.getInputStream();
						FileUtils.copyInputStreamToFile(in, targetimg);	
						in4=uploadImg4.getInputStream();
						fos=new FileOutputStream(targetimg4);
						while((readLen=in4.read(buff))!=-1){
							fos.write(buff,0,readLen);
						 }
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else{
					response.setContentType("text/html;charset=utf-8");
					PrintWriter pw =response.getWriter();
					pw.println(imgname4+"已存在！");
					pw.close();
				}
				
				File targetimg5=new File(imgpath,imgname5);
				if(!targetimg5.exists()){
					try {
						in = uploadImg.getInputStream();
						FileUtils.copyInputStreamToFile(in, targetimg);	
						in5=uploadImg5.getInputStream();
						fos=new FileOutputStream(targetimg5);
						while((readLen=in5.read(buff))!=-1){
							fos.write(buff,0,readLen);
						 }
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else{
					response.setContentType("text/html;charset=utf-8");
					PrintWriter pw =response.getWriter();
					pw.println(imgname5+"已存在！");
					pw.close();
				}
				File targetFile=new File(storeDir,fileName);
				if(!targetFile.exists()){
				in1=uploadFile.getInputStream();
				fos=new FileOutputStream(targetFile);
				while((readLen=in1.read(buff))!=-1){
					fos.write(buff,0,readLen);
				 }
			  }else{
					response.setContentType("text/html;charset=utf-8");
					PrintWriter pw =response.getWriter();
					pw.println(fileName+"文件已存在！");
					pw.close();
				}
	    	  
	    	 
	    	 } catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				try {
					if(fos!=null)fos.close();
					if(in1!=null)in1.close();
					if(in2!=null)in2.close();
					if(in3!=null)in3.close();
					if(in4!=null)in4.close();
					if(in5!=null)in5.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}*/
		
		
		
		return this.redirect("/productadm/listproduct");
		
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
		
		return this.redirect("/productadm/listproduct");
	}
	
	@RequestMapping("/getproductdetail")
	public void getproductdetail(HttpServletResponse response,String productsn){
		Product prodt=null;
		try {
			prodt = productAdmService.getProductBySn(productsn);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		 String jsonprodt=	JsonUtils.objectToJson(prodt);
		  System.out.println(jsonprodt);
		  try {
			this.ajaxOutput(response, jsonprodt);
		} catch (IOException e) {
			// TODO Auto-generated catch blocks
			e.printStackTrace();
		}
	}
=======
		
		return "/panoadm/productadm/product";
	}
	
	
	
>>>>>>> 52bf08c4abab5c5ea0085a0d2f74e03c60009ab5
}
