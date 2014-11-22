package com.wq.common.db.mapper;

/**
 * 字段映射信息VO.
 * 
 * @author wuqing
 * @date 2014年11月22日 下午2:35:32
 */
public class FieldMapperVO {

	/**
	 * 数据库字段名称.
	 */
	private String dbFieldName;

	/**
	 * 数据库字段类型(see:{@code java.sql.Types})
	 */
	private Integer dbFieldType;

	/**
	 * jdbc数据库默认对应的java类型名称.
	 */
	private String dbToJavaClassName;

	/**
	 * po字段名称.
	 */
	private String poFieldName;

	/**
	 * po字段类型.
	 */
	@SuppressWarnings("rawtypes")
	private Class poFieldType;

	/**
	 * @return the dbFieldName
	 */
	public String getDbFieldName() {
		return dbFieldName;
	}

	/**
	 * @param dbFieldName
	 *            the dbFieldName to set
	 */
	public void setDbFieldName(String dbFieldName) {
		this.dbFieldName = dbFieldName;
	}

	/**
	 * @return the poFieldName
	 */
	public String getPoFieldName() {
		return poFieldName;
	}

	/**
	 * @param poFieldName
	 *            the poFieldName to set
	 */
	public void setPoFieldName(String poFieldName) {
		this.poFieldName = poFieldName;
	}

	/**
	 * @return the poFieldType
	 */
	@SuppressWarnings("rawtypes")
	public Class getPoFieldType() {
		return poFieldType;
	}

	/**
	 * @param poFieldType
	 *            the poFieldType to set
	 */
	@SuppressWarnings("rawtypes")
	public void setPoFieldType(Class poFieldType) {
		this.poFieldType = poFieldType;
	}

	/**
	 * @return the dbFieldType
	 */
	public Integer getDbFieldType() {
		return dbFieldType;
	}

	/**
	 * @param dbFieldType
	 *            the dbFieldType to set
	 */
	public void setDbFieldType(Integer dbFieldType) {
		this.dbFieldType = dbFieldType;
	}

	/**
	 * @return the dbToJavaClassName
	 */
	public String getDbToJavaClassName() {
		return dbToJavaClassName;
	}

	/**
	 * @param dbToJavaClassName
	 *            the dbToJavaClassName to set
	 */
	public void setDbToJavaClassName(String dbToJavaClassName) {
		this.dbToJavaClassName = dbToJavaClassName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FieldMapperVO [dbFieldName=" + dbFieldName + ", dbFieldType="
				+ dbFieldType + ", dbToJavaClassName=" + dbToJavaClassName
				+ ", poFieldName=" + poFieldName + ", poFieldType="
				+ poFieldType + "]";
	}

}
