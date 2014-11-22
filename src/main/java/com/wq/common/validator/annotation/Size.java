package com.wq.common.validator.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 大小.
 * 
 * @author qingwu
 * @date 2014-3-18 上午11:00:41
 */
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Size {

	/**
	 * 组.
	 * 
	 * @return
	 * @author qingwu
	 * @date 2014-3-18 上午10:51:37
	 */
	String[] group() default {};

	/**
	 * 最小值.
	 * 
	 * @return
	 * @author qingwu
	 * @date 2014-3-18 上午11:02:31
	 */
	String min() default "0";

	/**
	 * 最大值.
	 * 
	 * @return
	 * @author qingwu
	 * @date 2014-3-18 上午11:02:53
	 */
	String max();
}
