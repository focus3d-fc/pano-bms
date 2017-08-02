package com.focus3d.pano.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.focus3d.pano.admin.dao.PanoBmRoleDAO;
import com.focus3d.pano.admin.service.PanoBmRoleService;
import com.focus3d.pano.model.BackUpdate;
import com.focus3d.pano.model.PanoBmRoleResource;
import com.focus3d.pano.model.PanoRole;
import com.opensymphony.oscache.util.StringUtil;
@Service
public class PanoBmRoleServiceImpl implements PanoBmRoleService{
	@Autowired 
	private  PanoBmRoleDAO role;
	
	@Override
	public List<PanoRole> getPanoRole() {
		return role.getPanoRole();
	}

	@Override
	public Long getPRDelete(Long sn) {
		Long rpDelete = role.getRPDelete(sn);
		return rpDelete;
	}

	@Override
	public Long getPRInsert(String role_name) {
		return role.getRPInsert(role_name);
	}

	@Override
	public PanoRole getPRSelect(String role_name) {
		PanoRole panoRole= null;
		List<PanoRole> prSelect = role.getPRSelect(role_name);
		if(prSelect.size()>0){
		 panoRole = prSelect.get(0);
		}
		return panoRole;
	}

	@Override
	public Long getResource(PanoBmRoleResource p) {
		return role.getResource(p);
	}

	@Override
	public int getRPupdate(PanoRole pr) {
		return role.getRPupdate(pr);
	}

	@Override
	public int getPBRRUpdate(PanoBmRoleResource pbrr) {
		return role.getPBRRUpdate(pbrr);
	}

	@Override
	public BackUpdate getupdateBack(int sn) {
		BackUpdate panoRole= null;
	 List<BackUpdate> getupdateBack = role.getupdateBack(sn);
		if(getupdateBack.size()>0){
		 panoRole = getupdateBack.get(0);
		}
		return panoRole;
		
	}

	@Override
	public Long getPBRRDelete(Long role_sn) {
		Long rpDelete = role.getPBRRDelete(role_sn);
		return rpDelete;
	}

}


