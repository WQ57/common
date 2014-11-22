package com.wq.common.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.wq.common.util.ReflectUtil;
import com.wq.common.util.UnCaughtException;

/**
 * 数据库操作session.
 * 
 * @author wuqing
 * @date 2014年11月23日 上午12:44:38
 */
public class DBSession {

	/**
	 * 获得PreparedStatement.
	 * 
	 * @param conn
	 *            数据库连接
	 * @param param
	 *            参数
	 * @param sql
	 *            sql语句
	 * @return 封装好的PreparedStatement
	 * @throws Exception
	 * @author wuqing
	 * @date 2014年11月23日 上午1:38:10
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private PreparedStatement getPreparedStatement(Connection conn,
			Object param, String sql) throws Exception {
		PreparedStatement pst;
		if (param != null
				&& ReflectUtil.isImplementsInterface(param.getClass(),
						Map.class)) {
			pst = StatementUtil.getPreparedStatement(conn, (Map) param, sql);
		} else {
			pst = StatementUtil.getPreparedStatement(conn, param, sql);
		}
		return pst;
	}

	/**
	 * 查询.
	 * 
	 * @param sql
	 *            sql语句
	 * @param param
	 *            查询参数
	 * @param targetClz
	 *            目标PO类型
	 * @return 指定PO类型列表
	 * @author wuqing
	 * @date 2014年11月23日 上午1:13:10
	 */
	public <T> List<T> select(String sql, Object param, Class<T> targetClz) {
		try {
			Connection conn = DBFactory.getConn();
			PreparedStatement pst = getPreparedStatement(conn, param, sql);
			ResultSet rs = pst.executeQuery();
			List<T> list = ResultSetUtil.getObjectResult(rs, targetClz);
			DBFactory.close(conn, pst, rs);
			return list;
		} catch (SQLException e) {
			throw new UnCaughtException(e);
		} catch (Exception e) {
			throw new UnCaughtException(e);
		}
	}

	/**
	 * 查询.
	 * 
	 * @param sql
	 *            sql语句
	 * @param param
	 *            查询参数
	 * @return Map[数据库字段名称,JDBC默认返回字段对象]类型结果列表
	 * @author wuqing
	 * @date 2014年11月23日 上午1:17:31
	 */
	public List<Map<String, Object>> select(String sql, Object param) {
		try {
			Connection conn = DBFactory.getConn();
			PreparedStatement pst = getPreparedStatement(conn, param, sql);
			ResultSet rs = pst.executeQuery();
			List<Map<String, Object>> list = ResultSetUtil.getMapResult(rs);
			DBFactory.close(conn, pst, rs);
			return list;
		} catch (SQLException e) {
			throw new UnCaughtException(e);
		} catch (Exception e) {
			throw new UnCaughtException(e);
		}
	}

	/**
	 * 跟新.
	 * 
	 * @param sql
	 *            sql语句
	 * @param param
	 *            参数
	 * @return
	 * @author wuqing
	 * @date 2014年11月23日 上午1:42:04
	 */
	public int update(String sql, Object param) {
		try {
			Connection conn = DBFactory.getConn();
			PreparedStatement pst = getPreparedStatement(conn, param, sql);
			int num = pst.executeUpdate();
			DBFactory.close(conn, pst);
			return num;
		} catch (SQLException e) {
			throw new UnCaughtException(e);
		} catch (Exception e) {
			throw new UnCaughtException(e);
		}
	}

	/**
	 * 新增.
	 * 
	 * @param sql
	 *            sql语句
	 * @param param
	 *            参数
	 * @return
	 * @author wuqing
	 * @date 2014年11月23日 上午1:44:36
	 */
	public int insert(String sql, Object param) {
		return update(sql, param);
	}

	/**
	 * 删除.
	 * 
	 * @param sql
	 *            sql语句
	 * @param param
	 *            参数
	 * @return
	 * @author wuqing
	 * @date 2014年11月23日 上午1:44:49
	 */
	public int delete(String sql, Object param) {
		return update(sql, param);
	}
}
