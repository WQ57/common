package com.wq.common.db;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.wq.common.db.mapper.FieldMapperVO;
import com.wq.common.db.resultset.ResultSetParase;
import com.wq.common.db.resultset.ResultTypeFactory;
import com.wq.common.db.resultset.type.IResultType;
import com.wq.common.util.ReflectUtil;
import com.wq.common.util.ValueUtil;

/**
 * 结果集工具类.
 * 
 * @author wuqing
 * @date 2014年11月22日 下午6:40:07
 */
public class ResultSetUtil {

	/**
	 * 获得结果集的列信息(数据层级的信息,此时还未和PO对应映射).
	 * 
	 * @param rs
	 *            ResultSet
	 * @return
	 * @throws SQLException
	 * @author wuqing
	 * @date 2014年11月22日 下午6:59:15
	 */
	public static List<FieldMapperVO> getResultColumnsInfo(ResultSet rs)
			throws SQLException {
		List<FieldMapperVO> list = new ArrayList<FieldMapperVO>();
		ResultSetMetaData resultSetMetaData = rs.getMetaData();
		for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
			FieldMapperVO vo = new FieldMapperVO();
			vo.setDbFieldName(resultSetMetaData.getColumnName(i));
			vo.setDbFieldType(resultSetMetaData.getColumnType(i));
			vo.setDbToJavaClassName(resultSetMetaData.getColumnClassName(i));
			list.add(vo);
		}
		return list;
	}

	/**
	 * 获得Map[数据库字段名称,字段对象]结果集.
	 * 
	 * @param rs
	 *            ResultSet
	 * @return
	 * @throws SQLException
	 * @author wuqing
	 * @date 2014年11月22日 下午6:59:33
	 */
	public static List<Map<String, Object>> getMapResult(ResultSet rs)
			throws SQLException {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		List<FieldMapperVO> heads = getResultColumnsInfo(rs);
		while (rs.next()) {
			Map<String, Object> row = new HashMap<String, Object>();
			for (int i = 0; i < heads.size(); i++) {
				FieldMapperVO head = heads.get(i);
				row.put(head.getDbFieldName(),
						rs.getObject(head.getDbFieldName()));
			}
			list.add(row);
		}
		return list;
	}

	/**
	 * 获得结果集对应具体PO的列表.
	 * 
	 * @param rs
	 *            ResultSet
	 * @param clz
	 *            PO类型
	 * @return
	 * @author wuqing
	 * @throws SQLException
	 * @date 2014年11月22日 下午8:22:56
	 */
	public static <T> List<T> getObjectResult(ResultSet rs, Class<T> clz)
			throws SQLException {
		List<T> list = new ArrayList<T>();
		ResultSetParase parase = new ResultSetParase();
		List<FieldMapperVO> fieldMappers = parase.parase(rs, clz);
		while (rs.next()) {
			T row = ReflectUtil.newInstance(clz);
			for (int i = 0; i < fieldMappers.size(); i++) {
				FieldMapperVO fieldMapper = fieldMappers.get(i);
				IResultType resultType = ResultTypeFactory
						.getResultType(fieldMapper);
				Object value = resultType.getValue(rs,
						fieldMapper.getDbFieldName());
				value = ValueUtil
						.castValue(value, fieldMapper.getPoFieldType());
				ReflectUtil.setFieldValue(row, fieldMapper.getPoFieldName(),
						value);
			}
			list.add(row);
		}
		return list;
	}
}
