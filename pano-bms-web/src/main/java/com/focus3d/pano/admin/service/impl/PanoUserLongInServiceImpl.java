package com.focus3d.pano.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.focus3d.pano.admin.dao.PanoUserLongInDAO;
import com.focus3d.pano.admin.service.PanoUserLongInService;
import com.focus3d.pano.model.PanoUserLongin;
@Service 
public class PanoUserLongInServiceImpl implements PanoUserLongInService{
	 @Autowired
	private PanoUserLongInDAO userlongin;
	@Override
	public PanoUserLongin getUserLongin(PanoUserLongin longin) {
		PanoUserLongin panoUserLongin = null;
		List<PanoUserLongin> user = userlongin.getUserLongin(longin);
		if(user.size()>0){
			System.out.println("service");
		 panoUserLongin = user.get(0);
		}
		return panoUserLongin;
	}

}
