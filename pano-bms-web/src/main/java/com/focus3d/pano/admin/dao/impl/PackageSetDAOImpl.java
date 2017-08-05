package com.focus3d.pano.admin.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.focus3d.pano.admin.dao.IPackageSetDAO;
import com.focus3d.pano.model.PjPackageItem;
import com.focus3d.pano.model.ProdtcateInPackage;
import com.focus3d.pano.model.ProductInfo;
@Repository
public class PackageSetDAOImpl extends BaseDao implements IPackageSetDAO {

	@Override
	public List<ProdtcateInPackage> listProdtcateInPackage() {
		// TODO Auto-generated method stub
		List<ProdtcateInPackage> prodtcateInPgList=(List<ProdtcateInPackage>)getSqlMapClientTemplate().queryForList("pano_packageset.getAllProdtcateInPackage");
		return prodtcateInPgList;
	}

	@Override
	public List<ProductInfo> getSelectedProdt(Map<String, Object> paramMap) {
		// TODO Auto-generated method stub
		List<ProductInfo> productInfoList=(List<ProductInfo>)getSqlMapClientTemplate().queryForList("pano_packageset.getSelectedProdt",paramMap);
		return productInfoList;
	}

	@Override
	public int savePjPackageItem(PjPackageItem pgitem) {
		// TODO Auto-generated method stub
		return (Integer)getSqlMapClientTemplate().insert("pano_packageset.savePjPackageItem",pgitem);
	}

	
	
}
