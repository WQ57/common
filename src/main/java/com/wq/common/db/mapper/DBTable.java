package com.wq.common.db.mapper;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 数据库表名映射.
 * 
 * @author wuqing
 * @date 2014年11月22日 下午1:51:04
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE })
public @interface DBTable {

	String value();

}
