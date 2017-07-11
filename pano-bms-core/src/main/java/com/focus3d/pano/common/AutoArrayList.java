package com.focus3d.pano.common;

import java.util.ArrayList;
/**
 *
 * *
 * @author lihaijun
 *
 */
public class AutoArrayList<T> extends ArrayList<T>{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Class<T> itemClass;

	public AutoArrayList(Class<T> itemClass){
		this.itemClass = itemClass;
	}

	@Override
	public T get(int index) {
		try {
			while(index >= size()){
				add((T) itemClass.newInstance());
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return super.get(index);
	}



}
