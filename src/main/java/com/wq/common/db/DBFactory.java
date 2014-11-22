package com.wq.common.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.wq.common.util.PropertiesUtil;
import com.wq.common.util.UnCaughtException;

/**
 * JDBC连接工具类.
 * 
 * @author wuqing
 * @date 2014年10月14日 下午1:00:55
 */
public class DBFactory {

	private static String driver;

	private static String url;

	private static String user;

	private static String pwd;

	public static void init() {
		PropertiesUtil p = new PropertiesUtil("/jdbc.properties");
		driver = p.getProperties("driverClass");
		url = p.getProperties("jdbcUrl");
		user = p.getProperties("user");
		pwd = p.getProperties("password");
	}

	/**
	 * 获取数据库连接.
	 * 
	 * @return
	 * @author wuqing
	 * @date 2014年10月14日 下午1:01:05
	 */
	public static Connection getConn() {
		Connection conn;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, pwd);
			return conn;
		} catch (ClassNotFoundException e) {
			throw new UnCaughtException(e);
		} catch (SQLException e) {
			throw new UnCaughtException(e);
		}
	}

	/**
	 * 关闭数据库连接.
	 * 
	 * @param conn
	 * @author wuqing
	 * @date 2014年10月14日 下午1:01:13
	 */
	public static void close(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				throw new UnCaughtException(e);
			}
		}
	}

	/**
	 * 关闭语句.
	 * 
	 * @param pst
	 * @author wuqing
	 * @date 2014年10月14日 下午2:11:26
	 */
	public static void close(PreparedStatement pst) {
		if (pst != null) {
			try {
				pst.close();
			} catch (SQLException e) {
				throw new UnCaughtException(e);
			}
		}
	}

	/**
	 * 关闭.
	 * 
	 * @param conn
	 * @param pst
	 * @author wuqing
	 * @date 2014年10月14日 下午2:13:02
	 */
	public static void close(Connection conn, PreparedStatement... pst) {
		for (PreparedStatement p : pst) {
			close(p);
		}
		close(conn);
	}

	/**
	 * 关闭结果集.
	 * 
	 * @param rs
	 * @author wuqing
	 * @date 2014年10月14日 下午9:05:08
	 */
	public static void close(ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			throw new UnCaughtException(e);
		}
	}

	/**
	 * 关闭.
	 * 
	 * @param conn
	 * @param pst
	 * @param rs
	 * @author wuqing
	 * @date 2014年10月14日 下午9:04:09
	 */
	public static void close(Connection conn, PreparedStatement pst,
			ResultSet rs) {
		close(rs);
		close(pst);
		close(conn);
	}

	/**
	 * 提交事务.
	 * 
	 * @param conn
	 * @author wuqing
	 * @date 2014年10月14日 下午1:16:32
	 */
	public static void commit(Connection conn) {
		try {
			if (conn.getAutoCommit() == false) {
				conn.commit();
			}
		} catch (SQLException e) {
			throw new UnCaughtException(e);
		}
	}

	/**
	 * 回滚.
	 * 
	 * @param conn
	 * @author wuqing
	 * @date 2014年10月14日 下午1:11:34
	 */
	public static void rollback(Connection conn) {
		try {
			if (conn.getAutoCommit() == false) {
				conn.rollback();
			}
		} catch (SQLException e) {
			throw new UnCaughtException(e);
		}
	}

	/**
	 * 获得DBSession.
	 * 
	 * @return
	 * @author wuqing
	 * @date 2014年11月23日 上午1:20:29
	 */
	public static DBSession getDBSession() {
		return new DBSession();
	}
}
