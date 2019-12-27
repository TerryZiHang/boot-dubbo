package org.szh.mapper;

/**
 * 通用数据库操作mapper
 * 
 * @author Terry
 *
 * @param <T>
 */
public interface BaseMapper<T> {
	
	 	int deleteByPrimaryKey(String markId);

	    int insert(T record);

	    int insertSelective(T record);

	    T selectByPrimaryKey(String markId);

	    int updateByPrimaryKeySelective(T record);

	    int updateByPrimaryKey(T record);

}
