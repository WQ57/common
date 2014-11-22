package com.wq.common.db.mapper;

/**
 * 表名映射信息VO.
 * 
 * @author wuqing
 * @date 2014年11月22日 下午2:38:03
 */
public class TableMapperVO {

	/**
	 * 数据库表名称.
	 */
	private String dbName;

	/**
	 * PO类名称.
	 */
	private String poName;

	/**
	 * PO类型.
	 */
	@SuppressWarnings("rawtypes")
	private Class poClass;

	/**
	 * @return the dbName
	 */
	public String getDbName() {
		return dbName;
	}

	/**
	 * @param dbName
	 *            the dbName to set
	 */
	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	/**
	 * @return the poName
	 */
	public String getPoName() {
		return poName;
	}

	/**
	 * @param poName
	 *            the poName to set
	 */
	public void setPoName(String poName) {
		this.poName = poName;
	}

	/**
	 * @return the poClass
	 */
	@SuppressWarnings("rawtypes")
	public Class getPoClass() {
		return poClass;
	}

	/**
	 * @param poClass
	 *            the poClass to set
	 */
	@SuppressWarnings("rawtypes")
	public void setPoClass(Class poClass) {
		this.poClass = poClass;
	}

}
