package com.wq.common.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Map;

import com.wq.common.db.param.Param;
import com.wq.common.db.param.ParamParase;
import com.wq.common.util.ReflectUtil;

/**
 * Statement工具类.
 * 
 * @author wuqing
 * @date 2014年11月22日 下午4:27:38
 */
public class StatementUtil {

	/**
	 * 获得PreparedStatement.
	 * 
	 * @param conn
	 *            数据库连接
	 * @param po
	 *            参数po
	 * @param sql
	 *            sql语句
	 * @return
	 * @throws Exception
	 * @author wuqing
	 * @date 2014年11月23日 上午12:16:54
	 */
	public static PreparedStatement getPreparedStatement(Connection conn,
			Object po, String sql) throws Exception {
		ParamParase parase = new ParamParase();
		SqlBind sqlBind = parase.parase(sql);
		PreparedStatement pst = conn.prepareStatement(sqlBind.getSqlTarget());
		setParams(pst, po, sqlBind);
		return pst;
	}

	/**
	 * 设置参数.
	 * 
	 * @param pst
	 *            PreparedStatement
	 * @param po
	 *            参数po
	 * @param sqlBind
	 *            绑定sql
	 * @author wuqing
	 * @throws Exception
	 * @date 2014年11月22日 下午4:29:55
	 */
	private static void setParams(PreparedStatement pst, Object po,
			SqlBind sqlBind) throws Exception {
		for (int i = 0; i < sqlBind.getParams().size(); i++) {
			Param param = sqlBind.getParams().get(i);
			Object value = ReflectUtil.getFieldValue(po, param.getField()
					.getPoFieldName());
			pst.setObject(param.getIndex(), value);
		}
	}

	/**
	 * 获得PreparedStatement.
	 * 
	 * @param conn
	 *            数据库连接
	 * @param paramMap
	 *            参数map
	 * @param sql
	 *            sql语句
	 * @return
	 * @throws Exception
	 * @author wuqing
	 * @date 2014年11月23日 上午12:24:22
	 */
	public static PreparedStatement getPreparedStatement(Connection conn,
			Map<String, Object> paramMap, String sql) throws Exception {
		ParamParase parase = new ParamParase();
		SqlBind sqlBind = parase.parase(sql);
		PreparedStatement pst = conn.prepareStatement(sqlBind.getSqlTarget());
		setParams(pst, paramMap, sqlBind);
		return pst;
	}

	/**
	 * 设置参数.
	 * 
	 * @param pst
	 *            PreparedStatement
	 * @param po
	 *            参数po
	 * @param sqlBind
	 *            绑定sql
	 * @author wuqing
	 * @throws Exception
	 * @date 2014年11月22日 下午4:29:55
	 */
	public static void setParams(PreparedStatement pst,
			Map<String, Object> paramMap, SqlBind sqlBind) throws Exception {
		for (int i = 0; i < sqlBind.getParams().size(); i++) {
			Param param = sqlBind.getParams().get(i);
			Object value = paramMap.get(param.getField().getPoFieldName());
			pst.setObject(param.getIndex(), value);
		}
	}
}
