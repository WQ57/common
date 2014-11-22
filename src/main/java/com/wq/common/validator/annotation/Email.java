package com.wq.common.validator.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * email校验.
 * 
 * @author qingwu
 * @date 2014-3-19 下午2:35:51
 */
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Email {

	/**
	 * 组.
	 * 
	 * @return
	 * @author qingwu
	 * @date 2014-3-18 上午10:51:37
	 */
	String[] group() default {};

	/**
	 * 服务器，即@后面的值.
	 * 
	 * @return
	 * @author qingwu
	 * @date 2014-3-19 下午2:38:41
	 */
	String domain() default "";
}
