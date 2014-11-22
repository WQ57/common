package com.wq.common.db.resultset;

import java.util.HashMap;
import java.util.Map;

import com.wq.common.db.mapper.FieldMapperVO;
import com.wq.common.db.resultset.type.DefaultType;
import com.wq.common.db.resultset.type.IResultType;

/**
 * 结果类型工厂.
 * 
 * @author wuqing
 * @date 2014年11月22日 下午7:49:13
 */
public class ResultTypeFactory {

	/**
	 * 特殊的字段类型映射器.
	 */
	private static Map<Integer, IResultType> resultTypeMap = new HashMap<Integer, IResultType>();

	/**
	 * 注册结果类型.
	 * 
	 * @param resultFieldVO
	 * @author wuqing
	 * @date 2014年11月22日 下午7:52:43
	 */
	public void registerResultType(IResultType resultType) {
		resultTypeMap.put(resultType.sqlType(), resultType);
	}

	/**
	 * 获得结果类型.
	 * 
	 * @param resultFieldVO
	 * @return
	 * @author wuqing
	 * @date 2014年11月22日 下午7:50:18
	 */
	public static IResultType getResultType(FieldMapperVO resultFieldVO) {
		if (resultTypeMap.containsKey(resultFieldVO.getDbFieldType())) {
			return resultTypeMap.get(resultFieldVO.getDbFieldType());
		}
		return new DefaultType();
	}
}
