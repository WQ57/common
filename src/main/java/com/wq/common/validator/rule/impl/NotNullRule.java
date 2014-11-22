package com.wq.common.validator.rule.impl;

import java.lang.annotation.Annotation;

import com.wq.common.validator.ValidatorResult;
import com.wq.common.validator.annotation.NotNull;
import com.wq.common.validator.rule.IValidatorRule;

/**
 * 非空校验.
 * 
 * @author qingwu
 * @date 2014-3-18 上午10:56:27
 */
public class NotNullRule implements IValidatorRule {

	@Override
	public <T extends Annotation> ValidatorResult validate(Object field, T anno) {
		ValidatorResult result = new ValidatorResult();
		result.setSuccess(true);
		if (field == null) {
			result.setSuccess(false);
			result.setErrorMsg("不能为空!");
		}
		return result;
	}

	@Override
	public <T extends Annotation> String[] getGroups(T anno) {
		if (anno instanceof NotNull) {
			String[] groups = ((NotNull) anno).group();
			return groups;
		}
		return new String[] {};
	}
}
