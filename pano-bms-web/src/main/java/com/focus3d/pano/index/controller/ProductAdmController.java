package com.focus3d.pano.index.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.focus3d.pano.common.controller.BaseController;

@Controller
@RequestMapping(value ="/productadm")
public class ProductAdmController extends BaseController{
	
	@RequestMapping("/listproduct")
	public String listproduct(){
		
		
		System.out.println("aaaaaaaaa");
		
		
		return "/panoadm/productadm/product";
	}
	
	
}
