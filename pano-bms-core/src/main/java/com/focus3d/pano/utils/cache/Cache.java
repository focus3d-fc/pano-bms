package com.focus3d.pano.utils.cache;
/**
 *
 * *
 * @author lihaijun
 *
 */
public interface Cache {
	/**
	 *
	 * *
	 * @param key
	 * @param value
	 */
	public void put(String key, Object value);
	/**
	 * *
	 * @param key
	 * @return
	 */
	public Object get(String key);
	/**
	 * *
	 * @param key
	 * @return
	 */
	public boolean containsKey(String key);
	/**
	 * *
	 * @param key
	 */
	public void remove(String key);
}
