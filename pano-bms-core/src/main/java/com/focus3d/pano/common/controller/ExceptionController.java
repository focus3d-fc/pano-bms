package com.focus3d.pano.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 错误统一处理
 * *
 * @author lihaijun
 *
 */
@Controller
@RequestMapping(value = "/error")
public class ExceptionController {
	
	@RequestMapping(value = "/default")
	public String defaults(){
		
		return "/error/default";
	}

}
