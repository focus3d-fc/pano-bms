package com.focus3d.pano.admin.dao;

import java.util.List;

import com.focus3d.pano.model.BackUpdate;
import com.focus3d.pano.model.PanoBmRoleResource;
import com.focus3d.pano.model.PanoRole;

public interface PanoBmRoleDAO {
	public List<PanoRole> getPanoRole();
	public Long getRPDelete(Long sn);
	public Long getRPInsert(String role_name);
	public List<PanoRole> getPRSelect(String role_name);
	public Long getResource(PanoBmRoleResource p);
	public int getRPupdate(PanoRole pr);
	public int getPBRRUpdate(PanoBmRoleResource pbrr);
	public List<BackUpdate> getupdateBack(int sn);
	public Long getPBRRDelete(Long role_sn);
}
