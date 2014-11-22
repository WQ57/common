package com.wq.common.validator.rule;

import java.lang.annotation.Annotation;

import com.wq.common.validator.ValidatorResult;

/**
 * 校验规则接口(所有规则的校验都要实现该接口).
 * 
 * @author qingwu
 * @date 2014-3-18 上午10:15:35
 */
public interface IValidatorRule {

	/**
	 * 校验.
	 * 
	 * @param field
	 *            校验字段
	 * @param anno
	 *            校验注解
	 * @return
	 */
	public <T extends Annotation> ValidatorResult validate(Object field, T anno);

	/**
	 * 获得组.
	 * 
	 * @param anno
	 *            注解
	 * @return
	 * @author qingwu
	 * @date 2014-3-19 下午2:14:13
	 */
	public <T extends Annotation> String[] getGroups(T anno);
}
