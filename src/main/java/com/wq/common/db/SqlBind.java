package com.wq.common.db;

import java.util.ArrayList;
import java.util.List;

import com.wq.common.db.param.Param;

/**
 * 绑定的sql.
 * 
 * @author wuqing
 * @date 2014年11月22日 下午2:53:28
 */
public class SqlBind {

	/**
	 * 源sql(未进行参数替换).
	 */
	private String sqlSource;

	/**
	 * 目标sql(已进行参数替换).
	 */
	private String sqlTarget;

	/**
	 * 参数列表.
	 */
	private List<Param> params = new ArrayList<Param>();

	/**
	 * @return the sqlSource
	 */
	public String getSqlSource() {
		return sqlSource;
	}

	/**
	 * @param sqlSource
	 *            the sqlSource to set
	 */
	public void setSqlSource(String sqlSource) {
		this.sqlSource = sqlSource;
	}

	/**
	 * @return the sqlTarget
	 */
	public String getSqlTarget() {
		return sqlTarget;
	}

	/**
	 * @param sqlTarget
	 *            the sqlTarget to set
	 */
	public void setSqlTarget(String sqlTarget) {
		this.sqlTarget = sqlTarget;
	}

	/**
	 * @return the params
	 */
	public List<Param> getParams() {
		return params;
	}

	/**
	 * @param params
	 *            the params to set
	 */
	public void setParams(List<Param> params) {
		this.params = params;
	}

	/**
	 * 添加参数.
	 * 
	 * @param param
	 * @author wuqing
	 * @date 2014年11月22日 下午3:46:35
	 */
	public void addParam(Param param) {
		this.params.add(param);
	}
}
