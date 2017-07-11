package com.focus3d.pano.utils.cache;

import java.util.HashMap;

import org.springframework.stereotype.Component;

/**
 *
 * *
 * @author lihaijun
 *
 */
@Component
public class CacheHandler {
	//private static String TEMP_KEY = "focus3d.mxj.appconfig.get";
	private static String[] methodKeyAry = {
		"focus3d.mxj.appmenu.identify.get"
		, "focus3d.mxj.appmenu.data.get"
		, "focus3d.mxj.appmenu.data.list.get"
		, "focus3d.mxj.appmenu.item.list.get"
		, "focus3d.mxj.appconfig.get"
		, "focus3d.mxj.appconfig.type.get"
		, "focus3d.mxj.book.get"
		, "focus3d.mxj.ad.of.device.list"
	};

	private static Cache cache = new LruCache(500);

	static {
		for (String key : methodKeyAry) {
			HashMap<String, String> value = new HashMap<String, String>();
			/*if(TEMP_KEY.equals(key)){
				try {
					byte[] sha1Digest2 = SHAUtil.getSHA1Digest((key + "_" + ""));
					String serviceUkey = SHAUtil.byte2Hex(sha1Digest2);
					JSONObject jo = new JSONObject();
					jo.put("ath", Boolean.FALSE);
					value.put(serviceUkey, jo.toString());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}*/
			cache.put(key, value);
		}
	}

	public Cache getCache() {
		return cache;
	}


	public static boolean containServiceName(String name, String prefix){
		for (String str : methodKeyAry) {
			if((str + prefix).equals(name)){
				return true;
			}
		}
		return false;
	}
}
