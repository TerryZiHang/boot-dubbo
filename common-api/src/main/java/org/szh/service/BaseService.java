package org.szh.service;

public interface BaseService<T> {
	
	int addData(T data);
	
	int modifyData(T data);
	
	T getDataByMarkId(String markId);
	
	int deleteData(String markId);
}
