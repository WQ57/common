package com.wq.common.db;

import com.wq.common.db.mapper.DBField;

public class S1 {
	@DBField("S_ID")
	private Integer sid;
	@DBField("S_NUM")
	private Integer sNum;
	@DBField("S_STATE")
	private Integer sState;

	/**
	 * @return the sid
	 */
	public Integer getSid() {
		return sid;
	}

	/**
	 * @param sid
	 *            the sid to set
	 */
	public void setSid(Integer sid) {
		this.sid = sid;
	}

	/**
	 * @return the sSum
	 */
	public Integer getsNum() {
		return sNum;
	}

	/**
	 * @param sSum
	 *            the sSum to set
	 */
	public void setsNum(Integer sNum) {
		this.sNum = sNum;
	}

	/**
	 * @return the sState
	 */
	public Integer getsState() {
		return sState;
	}

	/**
	 * @param sState
	 *            the sState to set
	 */
	public void setsState(Integer sState) {
		this.sState = sState;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "S1 [sid=" + sid + ", sNum=" + sNum + ", sState=" + sState + "]";
	}

}
