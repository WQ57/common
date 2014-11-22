package com.wq.common.db.resultset;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.wq.common.db.ResultSetUtil;
import com.wq.common.db.mapper.DBMapperFactory;
import com.wq.common.db.mapper.FieldMapperVO;
import com.wq.common.db.mapper.IDBMapper;
import com.wq.common.util.UnCaughtException;

/**
 * 结果集解析.
 * 
 * @author wuqing
 * @date 2014年11月22日 下午6:37:49
 */
public class ResultSetParase {

	/**
	 * 获得完整的rs和po的映射.
	 * 
	 * @param rs
	 * @param po
	 * @return
	 * @throws SQLException
	 * @author wuqing
	 * @date 2014年11月22日 下午8:20:39
	 */
	public <T> List<FieldMapperVO> parase(ResultSet rs, Class<T> poClz)
			throws SQLException {
		List<FieldMapperVO> list = ResultSetUtil.getResultColumnsInfo(rs);
		IDBMapper dbMapper = DBMapperFactory.getDBMapper();
		Map<String, FieldMapperVO> map = dbMapper.fieldMapperDB2PO(poClz);
		for (int i = 0; i < list.size(); i++) {
			if (!map.containsKey(list.get(i).getDbFieldName())) {
				throw new UnCaughtException("There is no mapper of dbField '"
						+ list.get(i).getDbFieldName() + "'(PO:"
						+ poClz.getName() + ")");
			}
			FieldMapperVO vo = map.get(list.get(i).getDbFieldName());
			list.get(i).setPoFieldName(vo.getPoFieldName());
			list.get(i).setPoFieldType(vo.getPoFieldType());
		}
		return list;
	}
}
