package com.focus3d.pano.utils.cache;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class LruCache implements Cache {

	private Map<Object, Object> store;

	public LruCache(final int max){
		this.store = new LinkedHashMap<Object, Object>(){
			private static final long serialVersionUID = 1L;
			@Override
			protected boolean removeEldestEntry(Entry<Object, Object> eldest) {
				return size() > max;
			}
		};
	}

	@Override
	public void put(String key, Object value) {
		synchronized (store) {
			store.put(key, value);
		}
	}

	@Override
	public Object get(String key) {
		synchronized (store) {
			return store.get(key);
		}
	}

	@Override
	public boolean containsKey(String key) {
		synchronized (store) {
			return store.containsKey(key);
		}
	}

	@Override
	public void remove(String key) {
		synchronized (store) {
			store.remove(key);
		}
	}

}
