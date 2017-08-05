package com.focus3d.pano.admin.dao;

import java.util.List;

import com.focus3d.pano.model.PanoProjectPackage;
import com.focus3d.pano.model.PanoProjectPackageStyle;
import com.focus3d.pano.model.PanoUserLongin;
import com.focus3d.pano.model.getListPano;

public interface PanoUserLongInDAO {
	public List<PanoUserLongin> getUserLongin(PanoUserLongin longin);
	public List<PanoProjectPackageStyle> getPPPSSelect(PanoProjectPackageStyle ppps);
	public List<getListPano> getpackage(getListPano sn);
	public int getdelete(PanoProjectPackageStyle sns);
	public List<PanoProjectPackage> getselect();
	public Long getinsert(PanoProjectPackageStyle pano);
	public List<getListPano> getselect1(getListPano pano);

}

