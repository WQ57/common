package com.wq.common.validator.rule.impl;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Map;

import com.wq.common.validator.ValidatorResult;
import com.wq.common.validator.annotation.Mobile;
import com.wq.common.validator.rule.IValidatorRule;

/**
 * 手机号码校验规则.
 * 
 * @author qingwu
 * @date 2014-3-19 下午3:11:35
 */
public class MobileRule implements IValidatorRule {

	private static Map<String, String> map = new HashMap<String, String>();

	static {
		map.put("0", "0");
		map.put("1", "1");
		map.put("2", "2");
		map.put("3", "3");
		map.put("4", "4");
		map.put("5", "5");
		map.put("6", "6");
		map.put("7", "7");
		map.put("8", "8");
		map.put("9", "9");
	}

	@Override
	public <T extends Annotation> ValidatorResult validate(Object field, T anno) {
		ValidatorResult result = new ValidatorResult();
		result.setSuccess(true);
		if (field == null) {
			return result;
		}
		String mobile = (String) field;
		if (!mobile.startsWith("1")) {
			result.setSuccess(false);
			result.setErrorMsg("手机号码格式不符合！");
			return result;
		}
		if (mobile.length() != 11) {
			result.setSuccess(false);
			result.setErrorMsg("手机号码格式不符合！");
			return result;
		}
		for (int i = 0; i < mobile.length(); i++) {
			String c = String.valueOf(mobile.charAt(i));
			if (!map.containsKey(c)) {
				result.setSuccess(false);
				result.setErrorMsg("手机号码格式不符合！");
				return result;
			}
		}
		return result;
	}

	@Override
	public <T extends Annotation> String[] getGroups(T anno) {
		if (anno instanceof Mobile) {
			String[] groups = ((Mobile) anno).group();
			return groups;
		}
		return new String[] {};
	}

}
