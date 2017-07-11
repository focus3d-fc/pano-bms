package com.focus3d.pano.common.service.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import com.focus3d.pano.common.dao.CommonDao;
/**
 *
 * *
 * @author lihaijun
 *
 */
public abstract class CommonServiceImpl<T> {

	public abstract CommonDao<T> getDao();

	public void insert(T t) {
		getDao().insert(t);
	}

	public T get(T t) {
		return getDao().selectByKey(t);
	}

	public int update(T t) {
		return getDao().updateByKeySelective(t);
	}

	public int count(Object u) {
		return getDao().countByCriteria(u);
	}

	public int delete(Object u) {
		return getDao().deleteByCriteria(u);
	}

	public List<T> get(Object u, Class<?> targetClass) {
		return getDao().selectByCriteria(u, targetClass);
	}

	public T getFirstByExample(Object u, Class<?> targetClass) {
		return getDao().selectFirstByExample(u, targetClass);
	}

	public int updateByCriteriaSelective(Object u) {
		return getDao().updateByCriteriaSelective(u);
	}

	public T getBySn(Long sn, Class<?> cls){

		return getDao().getBySn(sn, cls);
	}

	public List<T> list(){
		ParameterizedType genericType = (ParameterizedType)this.getClass().getGenericSuperclass();
		Class<T> targetClass = (Class<T>)genericType.getActualTypeArguments()[0];
		Class<? super T> targetSuperClass = targetClass.getSuperclass();
		Object u = null;
		try {
			u = Class.forName(targetSuperClass.getName() + "Criteria");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return get(u, targetClass);
	}
	public T getBySn(Long sn){
		ParameterizedType genericType = (ParameterizedType)this.getClass().getGenericSuperclass();
		Class<T> targetClass = (Class<T>)genericType.getActualTypeArguments()[0];
		return getBySn(sn, targetClass);
	}

	public void insertBySystem(T t){
		getDao().insertBySystem(t);
	}
}
