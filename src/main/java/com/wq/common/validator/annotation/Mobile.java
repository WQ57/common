package com.wq.common.validator.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 手机校验.
 * 
 * @author qingwu
 * @date 2014-3-19 下午3:09:51
 */
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Mobile {

	/**
	 * 组.
	 * 
	 * @return
	 * @author qingwu
	 * @date 2014-3-18 上午10:51:37
	 */
	String[] group() default {};

}
