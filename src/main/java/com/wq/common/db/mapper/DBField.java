package com.wq.common.db.mapper;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 数据库字段映射.
 * 
 * @author wuqing
 * @date 2014年11月22日 下午1:51:04
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD })
public @interface DBField {

	String value();

}
