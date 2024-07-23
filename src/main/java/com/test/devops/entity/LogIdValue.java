package com.test.devops.entity;

import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;
@Component
public class LogIdValue {
	static ConcurrentHashMap logIdValueMap = new ConcurrentHashMap<String, LogEntity>();

	public static ConcurrentHashMap getLogIdValueMap() {
		return logIdValueMap;
	}

	public static void setLogIdValueMap(ConcurrentHashMap logIdValueMap) {
		LogIdValue.logIdValueMap = logIdValueMap;
	}
	
	public Object addToMap(String key , LogEntity value) {
		return logIdValueMap.putIfAbsent(key, value);
		
	}
	
	public Object removeFromMap(String key) {
		return logIdValueMap.remove(key);
	}

}
