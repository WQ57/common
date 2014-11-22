package com.wq.common.validator.rule.impl;

import java.lang.annotation.Annotation;

import com.wq.common.validator.ValidatorResult;
import com.wq.common.validator.annotation.Size;
import com.wq.common.validator.rule.IValidatorRule;

/**
 * 大小校验器.
 * 
 * @author qingwu
 * @date 2014-3-18 上午11:10:41
 */
public class SizeRule implements IValidatorRule {

	@Override
	public <T extends Annotation> ValidatorResult validate(Object field, T anno) {
		ValidatorResult result = new ValidatorResult();
		result.setSuccess(true);
		if (field == null) {
			return result;
		}
		if (anno instanceof Size) {
			String min = ((Size) anno).min();
			String max = ((Size) anno).max();
			if (field instanceof String) {
				result = stringSize(field, min, max);
			} else if (field instanceof Integer
					|| field.getClass().getName().equals("int")) {
				result = integerSize(field, min, max);
			} else if (field instanceof Long
					|| field.getClass().getName().equals("long")) {
				result = longSize(field, min, max);
			} else if (field instanceof Float
					|| field.getClass().getName().equals("float")) {
				result = floatSize(field, min, max);
			} else if (field instanceof Double
					|| field.getClass().getName().equals("double")) {
				result = doubleSize(field, min, max);
			} else {
				result.setSuccess(false);
				result.setErrorMsg("非数字类型!");
			}
		}
		return result;
	}

	/**
	 * 整形比较大小.
	 * 
	 * @param numS
	 * @param minS
	 * @param maxS
	 * @return
	 */
	private ValidatorResult stringSize(Object numS, String minS, String maxS) {
		ValidatorResult result = new ValidatorResult();
		result.setSuccess(true);
		Integer num = ((String) numS).length();
		Integer min = Integer.parseInt(minS);
		Integer max = Integer.parseInt(maxS);
		if (num < min) {
			result.setSuccess(false);
			result.setErrorMsg("不能小于" + min);
		}
		if (num > max) {
			result.setSuccess(false);
			result.setErrorMsg("不能大于" + max);
		}
		return result;
	}

	/**
	 * 整形比较大小.
	 * 
	 * @param numS
	 * @param minS
	 * @param maxS
	 * @return
	 */
	private ValidatorResult integerSize(Object numS, String minS, String maxS) {
		ValidatorResult result = new ValidatorResult();
		result.setSuccess(true);
		Integer num = (Integer) numS;
		Integer min = Integer.parseInt(minS);
		Integer max = Integer.parseInt(maxS);
		if (num < min) {
			result.setSuccess(false);
			result.setErrorMsg("不能小于" + min);
		}
		if (num > max) {
			result.setSuccess(false);
			result.setErrorMsg("不能大于" + max);
		}
		return result;
	}

	/**
	 * long比较大小.
	 * 
	 * @param numS
	 * @param minS
	 * @param maxS
	 * @return
	 */
	private ValidatorResult longSize(Object numS, String minS, String maxS) {
		ValidatorResult result = new ValidatorResult();
		result.setSuccess(true);
		Long num = (Long) numS;
		Long min = Long.parseLong(minS);
		Long max = Long.parseLong(maxS);
		if (num < min) {
			result.setSuccess(false);
			result.setErrorMsg("不能小于" + min);
		}
		if (num > max) {
			result.setSuccess(false);
			result.setErrorMsg("不能大于" + max);
		}
		return result;
	}

	/**
	 * float比较大小.
	 * 
	 * @param numS
	 * @param minS
	 * @param maxS
	 * @return
	 */
	private ValidatorResult floatSize(Object numS, String minS, String maxS) {
		ValidatorResult result = new ValidatorResult();
		result.setSuccess(true);
		Float num = (Float) numS;
		Float min = Float.parseFloat(minS);
		Float max = Float.parseFloat(maxS);
		if (num < min) {
			result.setSuccess(false);
			result.setErrorMsg("不能小于" + min);
		}
		if (num > max) {
			result.setSuccess(false);
			result.setErrorMsg("不能大于" + max);
		}
		return result;
	}

	/**
	 * double比较大小.
	 * 
	 * @param numS
	 * @param minS
	 * @param maxS
	 * @return
	 */
	private ValidatorResult doubleSize(Object numS, String minS, String maxS) {
		ValidatorResult result = new ValidatorResult();
		result.setSuccess(true);
		Double num = (Double) numS;
		Double min = Double.parseDouble(minS);
		Double max = Double.parseDouble(maxS);
		if (num < min) {
			result.setSuccess(false);
			result.setErrorMsg("不能小于" + min);
		}
		if (num > max) {
			result.setSuccess(false);
			result.setErrorMsg("不能大于" + max);
		}
		return result;
	}

	@Override
	public <T extends Annotation> String[] getGroups(T anno) {
		if (anno instanceof Size) {
			String[] groups = ((Size) anno).group();
			return groups;
		}
		return new String[] {};
	}
}
