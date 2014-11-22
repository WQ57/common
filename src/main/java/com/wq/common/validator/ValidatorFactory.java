package com.wq.common.validator;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.wq.common.validator.annotation.Email;
import com.wq.common.validator.annotation.Mobile;
import com.wq.common.validator.annotation.NotNull;
import com.wq.common.validator.annotation.Size;
import com.wq.common.validator.rule.IValidatorRule;
import com.wq.common.validator.rule.impl.EmailRule;
import com.wq.common.validator.rule.impl.MobileRule;
import com.wq.common.validator.rule.impl.NotNullRule;
import com.wq.common.validator.rule.impl.SizeRule;
import com.wq.common.validator.util.Utils;

/**
 * 校验工厂.
 * 
 * @author qingwu
 * @date 2014-3-18 上午10:42:45
 */
public class ValidatorFactory {

	/**
	 * 校验规则器Map<注解类,校验器>.
	 */
	@SuppressWarnings("rawtypes")
	private static Map<Class, IValidatorRule> ruleMap = new HashMap<Class, IValidatorRule>();

	/**
	 * 已实现的校验规则.
	 */
	static {
		addRule(NotNull.class, new NotNullRule());// 非空校验
		addRule(Size.class, new SizeRule());// 大小校验
		addRule(Email.class, new EmailRule());// 邮箱校验
		addRule(Mobile.class, new MobileRule());// 手机校验
	}

	/**
	 * 添加校验规则.
	 * 
	 * @param annotation
	 *            注解
	 * @param validateRule
	 *            校验器
	 */
	public static <T extends Annotation> void addRule(Class<T> annotation,
			IValidatorRule validateRule) {
		ruleMap.put(annotation, validateRule);
	}

	/**
	 * 执行校验.
	 * 
	 * @param obj
	 *            校验对象
	 * @return
	 */
	public ValidatorResult validate(Object obj) {
		return validate(obj, null);
	}

	/**
	 * 执行校验.
	 * 
	 * @param obj
	 *            校验对象
	 * @param group
	 *            所属组
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ValidatorResult validate(Object obj, String group) {
		ValidatorResult result = new ValidatorResult();
		Field[] fields = Utils.getFields(obj.getClass());
		for (Field field : fields) {
			String fieldName = field.getName();
			Set<Class> set = ruleMap.keySet();
			Iterator<Class> it = set.iterator();
			while (it.hasNext()) {
				Class annoClass = it.next();
				IValidatorRule validator = ruleMap.get(annoClass);
				Annotation anno = field.getAnnotation(annoClass);
				if (anno != null) {
					Object value;
					try {
						String[] groups = validator.getGroups(anno);
						if (groups == null) {
							groups = new String[] {};
						}
						if (isValidate(group, groups) == false) {
							continue;
						}
						value = Utils.getFieldValue(obj, fieldName);
						ValidatorResult _result = validator.validate(value,
								anno);
						if (_result.isSuccess() == false) {
							result.setSuccess(false);
							result.getFieldValidateMap().put(fieldName,
									_result.getErrorMsg());
						}
					} catch (Exception e) {
						e.printStackTrace();
						result.setSuccess(false);
						result.getFieldValidateMap().put(fieldName,
								"程序出错!错误信息:\n" + e.getMessage());
					}
				}
			}
		}
		return result;
	}

	/**
	 * 是否属于分组.
	 * 
	 * @param group
	 *            组参数
	 * @param groups
	 *            注解上的标注的分组
	 * @return [true:需要校验，false:不需要校验]
	 * @author qingwu
	 * @date 2014-3-19 下午2:18:50
	 */
	public boolean isValidate(String group, String[] groups) {
		if (group == null && groups.length == 0) {// 没有组，需要校验
			return true;
		}
		if (group == null && groups.length > 0) {// 有分组，但是没传组值，需要校验
			return true;
		}
		for (String s : groups) {
			if (s.equals(group)) {
				return true;
			}
		}
		return false;
	}

}
