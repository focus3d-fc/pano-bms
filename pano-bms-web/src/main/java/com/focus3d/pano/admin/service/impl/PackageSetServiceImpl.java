package com.focus3d.pano.admin.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.focus3d.pano.admin.dao.IPackageSetDAO;
import com.focus3d.pano.admin.service.IPackageSetService;
import com.focus3d.pano.model.PjPackageItem;
import com.focus3d.pano.model.ProdtcateInPackage;
import com.focus3d.pano.model.ProductInfo;
@Service
public class PackageSetServiceImpl implements IPackageSetService{

	@Autowired
	private IPackageSetDAO packageSetDAO;
	@Override
	public List<ProdtcateInPackage> listProdtcateInPackage() {
		// TODO Auto-generated method stub
		return packageSetDAO.listProdtcateInPackage();
	}
	@Override
	public List<ProductInfo> getSelectedProdt(Map<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return packageSetDAO.getSelectedProdt(paramMap);
	}
	@Override
	public int savePjPackageItem(PjPackageItem pgitem) {
		// TODO Auto-generated method stub
		return packageSetDAO.savePjPackageItem(pgitem);
	}
  
	 
}
