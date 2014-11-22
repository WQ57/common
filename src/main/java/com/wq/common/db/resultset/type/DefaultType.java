package com.wq.common.db.resultset.type;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 默认的jdbc封装的数据库字段对应的java类型.
 * 
 * @author wuqing
 * @date 2014年11月22日 下午7:48:08
 */
public class DefaultType implements IResultType {

	@Override
	public int sqlType() {
		return -9999;
	}

	@Override
	public Object getValue(ResultSet rs, String colName) throws SQLException {
		return rs.getObject(colName);
	}

}
