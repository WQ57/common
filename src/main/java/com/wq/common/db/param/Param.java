package com.wq.common.db.param;

import com.wq.common.db.mapper.FieldMapperVO;

/**
 * set参数VO.
 * 
 * @author wuqing
 * @date 2014年11月22日 下午2:55:20
 */
public class Param {

	/**
	 * 参数位置.
	 */
	private int index;

	/**
	 * 参数信息.
	 */
	private FieldMapperVO field;

	/**
	 * @return the index
	 */
	public int getIndex() {
		return index;
	}

	/**
	 * @param index
	 *            the index to set
	 */
	public void setIndex(int index) {
		this.index = index;
	}

	/**
	 * @return the field
	 */
	public FieldMapperVO getField() {
		return field;
	}

	/**
	 * @param field
	 *            the field to set
	 */
	public void setField(FieldMapperVO field) {
		this.field = field;
	}

}
