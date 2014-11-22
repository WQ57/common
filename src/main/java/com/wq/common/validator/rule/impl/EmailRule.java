package com.wq.common.validator.rule.impl;

import java.lang.annotation.Annotation;

import com.wq.common.validator.ValidatorResult;
import com.wq.common.validator.annotation.Email;
import com.wq.common.validator.rule.IValidatorRule;

/**
 * email校验.
 * 
 * @author qingwu
 * @date 2014-3-19 下午2:41:16
 */
public class EmailRule implements IValidatorRule {

	@Override
	public <T extends Annotation> ValidatorResult validate(Object field, T anno) {
		ValidatorResult result = new ValidatorResult();
		result.setSuccess(true);
		if (field == null) {
			return result;
		}
		String domain = ((Email) anno).domain();
		String email = (String) field;
		if (email.split("@").length != 2) {
			result.setSuccess(false);
			result.setErrorMsg("不符合邮箱格式！");
			return result;
		}
		if (domain != null && !domain.equals("") && !email.endsWith(domain)) {
			result.setSuccess(false);
			result.setErrorMsg("邮箱必须以" + domain + "结尾！");
			return result;
		}
		return result;
	}

	@Override
	public <T extends Annotation> String[] getGroups(T anno) {
		if (anno instanceof Email) {
			String[] groups = ((Email) anno).group();
			return groups;
		}
		return new String[] {};
	}

}
