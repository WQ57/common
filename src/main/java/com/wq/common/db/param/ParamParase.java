package com.wq.common.db.param;

import com.wq.common.db.SqlBind;
import com.wq.common.db.mapper.FieldMapperVO;

/**
 * 参数解析器.
 * 
 * @author wuqing
 * @date 2014年11月22日 下午1:46:01
 */
public class ParamParase {

	/**
	 * 参数标识前缀.
	 */
	private static String PREFIX_PARAM = ":";

	/**
	 * 设置参数标识前缀.
	 * 
	 * @param prefixParam
	 *            参数标识前缀
	 * @author wuqing
	 * @date 2014年11月22日 下午1:52:45
	 */
	public void setPrefixParam(String prefixParam) {
		PREFIX_PARAM = prefixParam;
	}

	/**
	 * sql预解析.
	 * 
	 * @param sql
	 * @return
	 * @author wuqing
	 * @date 2014年11月22日 下午3:17:01
	 */
	public SqlBind parase(String sql) {
		SqlBind sqlBind = new SqlBind();
		sqlBind.setSqlSource(sql);
		sql = sql.replace("\\n", "");
		sql = sql.replace("\\t", "");
		int num = 0;
		int flagIndex = sql.indexOf(PREFIX_PARAM);
		while (flagIndex != -1) {
			num++;
			String paramName = getParamName(sql, flagIndex);
			Param param = new Param();
			param.setIndex(num);
			FieldMapperVO vo = new FieldMapperVO();
			vo.setPoFieldName(paramName);
			param.setField(vo);
			sqlBind.addParam(param);
			sql = sql.replaceFirst(PREFIX_PARAM + paramName, "?");
			flagIndex = sql.indexOf(PREFIX_PARAM);
		}
		sqlBind.setSqlTarget(sql);
		return sqlBind;
	}

	/**
	 * 获得参数名称.
	 * 
	 * @param sql
	 *            sql语句
	 * @param flagIndex
	 *            前缀标识符位置
	 * @return
	 * @author wuqing
	 * @date 2014年11月22日 下午3:36:37
	 */
	private String getParamName(String sql, int flagIndex) {
		int[] endIndexs = new int[3];
		endIndexs[0] = sql.indexOf(" ", flagIndex);
		endIndexs[1] = sql.indexOf(",", flagIndex);
		endIndexs[2] = sql.indexOf(")", flagIndex);
		int endIndex = endIndexs[0];
		for (int i = 1; i < endIndexs.length; i++) {
			if (endIndex == -1
					|| (endIndex > endIndexs[i] && endIndexs[i] != -1)) {
				endIndex = endIndexs[i];
			}
		}
		if (endIndex == -1) {
			endIndex = sql.length();
		}
		String paramName = sql.substring(flagIndex + 1, endIndex);
		return paramName;
	}

}
