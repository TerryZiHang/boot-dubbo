package org.szh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.szh.beans.HealthData;

public interface HealthDataMapper extends BaseMapper<HealthData> {
	
	@Select("select * from t_health_data")
	@ResultMap("BaseResultMap")
	List<HealthData> selectAll();
}