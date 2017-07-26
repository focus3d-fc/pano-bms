package com.focus3d.pano.index.controller;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.focus3d.pano.admin.service.IProductAdmService;
import com.focus3d.pano.common.controller.BaseController;
import com.focus3d.pano.model.Product;

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
		   for(Product p:productList){
			   System.out.println("---------"+p.getId()+p.getName()+p.getBrand());
		   }
		   
		   session.setAttribute("productList", productList);
		return "/panoadm/productadm/product";
	}
	
	
	@RequestMapping("/addproduct")
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
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("-------------aaaaaaa");
			e.printStackTrace();
		}
		
		
		
		return "/panoadm/productadm/product";
	}
	
	
	
}
