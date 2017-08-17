package com.focus3d.pano.admin.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.focus3d.pano.common.dao.CommonDao;
import com.focus3d.pano.model.ibator.PanoProjectSpace;
import com.focus3d.pano.model.ibator.PanoProjectSpaceCriteria;
import com.focus3d.pano.model.ibator.PanoProjectSpaceModel;

@Repository
public class PerspectiveSpaceDAOImpl extends CommonDao<PanoProjectSpaceModel>{
	public List<Map<String, Object>> QuerySpace(Long key) throws SQLException{
		List<Map<String, Object>>list = (List<Map<String, Object>>)getSqlMapClient().queryForList("pano_project_space.house_space",key);
		return list;
	}
}
