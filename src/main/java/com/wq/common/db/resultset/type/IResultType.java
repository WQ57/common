package com.wq.common.db.resultset.type;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 结果类型接口(用于比较特殊的数据库字段类型).
 * 
 * @author wuqing
 * @date 2014年11月22日 下午7:29:13
 */
public interface IResultType {

	/**
	 * 返回sql类型(see:{@code}java.sql.Types).
	 * 
	 * @return
	 * @author wuqing
	 * @date 2014年11月22日 下午7:29:50
	 */
	public int sqlType();

	/**
	 * 获得结果集的值.
	 * 
	 * @param rs
	 * @param colName
	 * @return
	 * @author wuqing
	 * @date 2014年11月22日 下午7:30:59
	 */
	public Object getValue(ResultSet rs, String colName) throws SQLException;

}
