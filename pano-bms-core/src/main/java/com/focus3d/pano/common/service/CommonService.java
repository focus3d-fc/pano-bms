package com.focus3d.pano.common.service;

import java.util.List;

/**
 *
 * *
 * @author lihaijun
 *
 */
public interface CommonService<T> {


	public void insert(T t);
	public void insertBySystem(T t);

	public T get(T t);

	public int update(T t);

	public int count(Object u);

	public int delete(Object u);

	public List<T> get(Object u, Class<?> targetClass);

	public List<T> list();

	public T getFirstByExample(Object u, Class<?> targetClass);

	public int updateByCriteriaSelective(Object u);

	public T getBySn(Long sn, Class<?> targetClass);
	public T getBySn(Long sn);

}
