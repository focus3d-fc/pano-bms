package com.focus3d.pano.model.ibator;

import com.focus3d.pano.common.model.CommonModel;

public class PanoPerspectiveViewModel extends PanoPerspectiveView<PanoPerspectiveViewModel, PanoPerspectiveViewCriteria> implements CommonModel{
	public String mapid;

	public String getMapid() {
		return mapid;
	}

	public void setMapid(String mapid) {
		this.mapid = mapid;
	}
}
