package com.focus3d.pano.admin.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.focus3d.pano.admin.dao.PanoBmRoleDAO;
import com.focus3d.pano.model.BackUpdate;
import com.focus3d.pano.model.PanoBmRoleResource;
import com.focus3d.pano.model.PanoRole;
@Repository
public class PanoBmRoleDAOImpl extends BaseDao implements PanoBmRoleDAO{

	@Override
	public List<PanoRole> getPanoRole() {
		List<PanoRole> productList =(List<PanoRole>)getSqlMapClientTemplate().queryForList("pano_bm_role.getPanoRole");
		return productList;
	}

	@Override
	public Long getRPDelete(Long sn) {
	     return  (long) getSqlMapClientTemplate().delete("pano_bm_role.getPRDelete",sn);
	    
	}

	@Override
	public Long getRPInsert(String role_name) {
		Long i = (Long) getSqlMapClientTemplate().insert("pano_bm_role.getRPInsert",role_name);
		 return i;
	}

	@Override
	public List<PanoRole> getPRSelect(String role_name) {
		List<PanoRole>	productList =(List<PanoRole>)getSqlMapClientTemplate().queryForList("pano_bm_role.getPRSelect",role_name);
		return productList;
	}

	@Override
	public Long getResource(PanoBmRoleResource p) {
		Long i  = (Long) getSqlMapClientTemplate().insert("pano_bm_role.getResource",p);
		return i;
	}

	@Override
	public int getRPupdate(PanoRole pr) {
		int i  =  getSqlMapClientTemplate().update("pano_bm_role.getRPupdate",pr);
		return i;
	}

	@Override
	public int getPBRRUpdate(PanoBmRoleResource pbrr) {
		int i  =  getSqlMapClientTemplate().update("pano_bm_role.getPBRRUpdate",pbrr);
		return i;
	}

	@Override
	public List<BackUpdate> getupdateBack(int sn) {
		List<BackUpdate> productList =(List<BackUpdate>)getSqlMapClientTemplate().queryForList("pano_bm_role.updateBack",sn);
		return productList;
	}

	@Override
	public Long getPBRRDelete(Long role_sn) {
		 return  (long) getSqlMapClientTemplate().delete("pano_bm_role.getPBRRDelete",role_sn);
	}

	

}
