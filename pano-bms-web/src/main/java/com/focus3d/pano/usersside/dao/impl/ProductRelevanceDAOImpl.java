package com.focus3d.pano.usersside.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.focus3d.pano.admin.dao.impl.BaseDao;
import com.focus3d.pano.model.ProductRelevance;
import com.focus3d.pano.usersside.dao.ProductRelevanceDAO;

@Repository
public class ProductRelevanceDAOImpl extends BaseDao implements
		ProductRelevanceDAO {

	@Override
	public int selProCount(Long PACKAGETYPE_SN) {
		int count = (Integer) getSqlMapClientTemplate().queryForObject(
				"ProductRelevance.selProCount", PACKAGETYPE_SN);
		return count;
	}

	@Override
	public List<ProductRelevance> selPro(Map map) {
		List<ProductRelevance> list = (List<ProductRelevance>) getSqlMapClientTemplate()
				.queryForList("ProductRelevance.selPro", map);
		return list;
	}

	@Override
	public List<ProductRelevance> selProbySN(Long PRODUCT_SN) {
		List<ProductRelevance> list = (List<ProductRelevance>) getSqlMapClientTemplate()
				.queryForList("ProductRelevance.selProbySN", PRODUCT_SN);
		return list;
	}

	@Override
	public List<ProductRelevance> selImgbySN(Long PRODUCT_SN) {
		List<ProductRelevance> list = null;
		try{
			 System.out.println("DAO");
		 list = (List<ProductRelevance>) getSqlMapClientTemplate()
				.queryForList("ProductRelevance.selImgbySN", PRODUCT_SN);
		 System.out.println("DAO1");
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}

}
