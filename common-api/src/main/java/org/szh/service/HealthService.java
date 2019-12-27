package org.szh.service;

import java.util.List;

import org.szh.beans.HealthData;

public interface HealthService extends BaseService<HealthData>{
	
	List<HealthData> getAllData();

}