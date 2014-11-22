package com.wq.common.db.mapper;

import java.util.Map;

/**
 * 数据库映射器接口.
 * 
 * @author wuqing
 * @date 2014年11月22日 下午2:05:13
 */
public interface IDBMapper {

	/**
	 * 数据库表名称映射.
	 * 
	 * @param po
	 *            PO对象
	 * @return 数据的表名映射信息
	 * @author wuqing
	 * @date 2014年11月22日 下午2:06:53
	 */
	public TableMapperVO tableMapper(Object po);

	/**
	 * 数据库表字段名称映射.
	 * 
	 * @param poClz
	 *            po类型
	 * @return Map[poFieldName,数据库表字段映射信息]
	 * @author wuqing
	 * @date 2014年11月22日 下午2:07:20
	 */
	public <T> Map<String, FieldMapperVO> fieldMapperPO2DB(Class<T> poClz);

	/**
	 * 数据库表字段名称映射.
	 * 
	 * @param poClz
	 *            po类型
	 * @return Map[dbFieldName,数据库表字段映射信息]
	 * @author wuqing
	 * @date 2014年11月22日 下午2:07:20
	 */
	public <T> Map<String, FieldMapperVO> fieldMapperDB2PO(Class<T> poClz);

}
