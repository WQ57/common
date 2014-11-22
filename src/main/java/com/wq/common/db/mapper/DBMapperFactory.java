package com.wq.common.db.mapper;

/**
 * DB映射器工厂.
 * 
 * @author wuqing
 * @date 2014年11月22日 下午3:03:26
 */
public class DBMapperFactory {

	/**
	 * 获取DB映射器.
	 * 
	 * @return
	 * @author wuqing
	 * @date 2014年11月22日 下午3:02:51
	 */
	public static IDBMapper getDBMapper() {
		return new AnnotionDBMapper();
	}

}
