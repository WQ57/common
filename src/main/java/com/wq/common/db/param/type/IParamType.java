package com.wq.common.db.param.type;

import java.sql.PreparedStatement;

/**
 * PreparedStatement参数set接口.
 * 
 * @author wuqing
 * @date 2014年11月22日 下午1:38:55
 */
public interface IParamType {

	/**
	 * set空值.
	 * 
	 * @param pst
	 *            PreparedStatement
	 * @param index
	 *            参数位置索引
	 * @author wuqing
	 * @date 2014年11月22日 下午1:41:32
	 */
	public void setNull(PreparedStatement pst, int index);

	/**
	 * set值.
	 * 
	 * @param pst
	 *            PreparedStatement
	 * @param param
	 *            参数
	 * @param index
	 *            参数位置索引
	 * @author wuqing
	 * @date 2014年11月22日 下午1:42:05
	 */
	public void setParam(PreparedStatement pst, Object param, int index);

}
