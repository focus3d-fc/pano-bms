package com.focus3d.pano.admin.service;

import java.util.List;

import com.focus3d.pano.model.BackUpdate;
import com.focus3d.pano.model.PanoBmRoleResource;
import com.focus3d.pano.model.PanoRole;

public interface PanoBmRoleService {
	public List<PanoRole> getPanoRole();
	public Long getPRDelete(Long sn);
	public Long getPRInsert(String role_name);
	public PanoRole getPRSelect(String role_name);
	public Long getResource(PanoBmRoleResource p);
	public int getRPupdate(PanoRole pr);
	public int getPBRRUpdate(PanoBmRoleResource pbrr);
	public BackUpdate getupdateBack(int sn);
	public Long getPBRRDelete(Long role_sn);
}
