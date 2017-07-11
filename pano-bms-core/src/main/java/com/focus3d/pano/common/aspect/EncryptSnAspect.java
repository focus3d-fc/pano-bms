package com.focus3d.pano.common.aspect;

import java.util.List;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.focus3d.pano.common.model.CommonModel;
import com.focustech.common.utils.EncryptUtil;

/**
 *
 * *
 * @author lihaijun
 *
 */
@Component
@Aspect
public class EncryptSnAspect {

	public static final String EXECUTION_PREFIX_SERVICE_LIST = "com.focus3d.pano..*.service.impl..*.list*(..)";
	public static final String EXECUTION_PREFIX_DAO_LIST = "com.focus3d.pano.*.dao..*.list*(..)";
	public static final String EXECUTION_PREFIX_DAO_SELECT = "com.focus3d.pano.*.dao..*.get*(..)";

	@Pointcut(value = "execution(* " + EXECUTION_PREFIX_SERVICE_LIST + ")")
	public void serviceList(){

	}
	@Pointcut(value = "execution(* " + EXECUTION_PREFIX_DAO_LIST + ")")
	public void daoList(){

	}
	@Pointcut(value = "execution(* " + EXECUTION_PREFIX_DAO_SELECT + ")")
	public void daoGet(){
		
	}

	@AfterReturning(value = "serviceList() || daoList() || daoGet()", returning = "retList")
	public void encryptSn(Object retList){
	/*	String methodName = jp.getSignature().getName();
		Object[] args = jp.getArgs();
		jp.getTarget();
		Object obj = args[0];
		if(obj instanceof CommonModel){

		}*/
		if(retList instanceof List){
			List<CommonModel> l = (List<CommonModel>)retList;
			for (CommonModel commonModel : l) {
				commonModel.setEncryptSn(EncryptUtil.encode(commonModel.getSn()));
			}
		} else {
			try {
				CommonModel commonModel = (CommonModel)retList;
				if(commonModel != null){
					commonModel.setEncryptSn(EncryptUtil.encode(commonModel.getSn()));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
