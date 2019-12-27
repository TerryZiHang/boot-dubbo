package org.szh.service.impl;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.szh.beans.HealthData;
import org.szh.mapper.HealthDataMapper;
import org.szh.service.HealthService;

@Service("healthService")
public class HealthServiceImpl implements HealthService {
	
	@Resource
	private HealthDataMapper healthDataMapper;

	@Override
	public int addData(HealthData data) {
		data.setMarkId(UUID.randomUUID().toString());
		return healthDataMapper.insertSelective(data);
	}

	@Override
	public int modifyData(HealthData data) {
		return healthDataMapper.updateByPrimaryKeySelective(data);
	}

	@Override
	public HealthData getDataByMarkId(String markId) {
		return healthDataMapper.selectByPrimaryKey(markId);
	}

	@Override
	public int deleteData(String markId) {
		return healthDataMapper.deleteByPrimaryKey(markId);
	}

	@Override
	public List<HealthData> getAllData() {
		return healthDataMapper.selectAll();
	}

}
