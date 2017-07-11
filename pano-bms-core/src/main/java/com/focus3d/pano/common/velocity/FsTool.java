package com.focus3d.pano.common.velocity;

import com.focustech.cief.filemanage.client.api.IFileReadClient;
import com.focustech.cief.filemanage.client.api.impl.FileReadClient;
import com.focustech.cief.filemanage.client.constant.FileAttributeEnum;
import com.focustech.common.utils.SpringContextUtil;



/**
 * 文件服务器velocity工具
 * *
 * @author lihaijun
 *
 */
public class FsTool {
	private IFileReadClient fileReadClient = (FileReadClient)SpringContextUtil.getBean("fileReadClient");
	/**
	 * 
	 * *
	 * @param id
	 * @return
	 */
	public String url(Long id){
		if(id != null && id > 0){
			return fileReadClient.getFile(id, FileAttributeEnum.VISIT_ADDR);
		}
		return "";
	}
	
}
