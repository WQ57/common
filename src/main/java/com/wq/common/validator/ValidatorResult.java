package com.wq.common.validator;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 校验结果.
 * 
 * @author wuqing
 * 
 */
public class ValidatorResult {

	/**
	 * 校验是否通过.
	 */
	private boolean isSuccess = true;

	/**
	 * 校验不通过的字段map映射.
	 */
	private Map<String, String> fieldValidateMap = new HashMap<String, String>();

	/**
	 * 错误信息.
	 */
	private String errorMsg;

	public boolean isSuccess() {
		return isSuccess;
	}

	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	public Map<String, String> getFieldValidateMap() {
		return fieldValidateMap;
	}

	public void setFieldValidateMap(Map<String, String> fieldValidateMap) {
		this.fieldValidateMap = fieldValidateMap;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	/**
	 * 获得错误提示.
	 * 
	 * @return
	 */
	public String getAllMsg() {
		String str = "";
		Set<String> set = this.fieldValidateMap.keySet();
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			if (!str.equals("")) {
				str += "\n";
			}
			String fieldName = it.next();
			str += fieldName + ":" + this.fieldValidateMap.get(fieldName);
		}
		return str;
	}
}
