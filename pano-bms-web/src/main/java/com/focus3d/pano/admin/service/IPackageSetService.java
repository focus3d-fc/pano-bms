package com.focus3d.pano.admin.service;

import java.util.List;
import java.util.Map;

import com.focus3d.pano.model.PjPackageItem;
import com.focus3d.pano.model.ProdtcateInPackage;
import com.focus3d.pano.model.ProductInfo;

public interface IPackageSetService {
	public List<ProdtcateInPackage> listProdtcateInPackage();
    public List<ProductInfo> getSelectedProdt(Map<String,Object> paramMap);
    public int savePjPackageItem(PjPackageItem pgitem);
    
    
}
