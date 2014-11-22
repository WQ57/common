package com.wq.common.db.mapper;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.wq.common.util.ReflectUtil;
import com.wq.common.util.UnCaughtException;

/**
 * 根据注解标签进行映射.
 * 
 * @author wuqing
 * @date 2014年11月22日 下午2:09:13
 */
public class AnnotionDBMapper implements IDBMapper {

	@Override
	public TableMapperVO tableMapper(Object po) {
		DBTable dbTable = po.getClass().getAnnotation(DBTable.class);
		if (dbTable == null) {
			throw new UnCaughtException(
					"Does not have Annotion of 'com.wq.common.db.mapper.DBTable'[in class '"
							+ po.getClass().getName() + "']");
		}
		TableMapperVO vo = new TableMapperVO();
		String clzName = ReflectUtil.getClassNameWithoutPackage(po.getClass());
		vo.setPoClass(po.getClass());
		vo.setPoName(clzName);
		if (dbTable.value() == null) {
			vo.setDbName(clzName);
			return vo;
		}
		if (dbTable.value().equals("")) {
			throw new UnCaughtException(
					"The value of Annotion of 'com.wq.common.db.mapper.DBTable is NULL'[in class '"
							+ po.getClass().getName() + "']");
		}
		vo.setDbName(dbTable.toString());
		return vo;
	}

	private <T> Map<String, FieldMapperVO> fieldMapper(Class<T> poClz, int type) {
		Map<String, FieldMapperVO> map = new HashMap<String, FieldMapperVO>();
		Map<String, Field> fieldMap = ReflectUtil.getFieldMap(poClz);
		Set<String> set = fieldMap.keySet();
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			String fieldName = it.next();
			Field field = fieldMap.get(fieldName);
			DBField dbField = field.getAnnotation(DBField.class);
			if (dbField == null) {
				continue;
			}
			FieldMapperVO vo = new FieldMapperVO();
			vo.setPoFieldName(fieldName);
			vo.setPoFieldType(field.getType());
			if (dbField.value() == null) {
				vo.setDbFieldName(fieldName);
			}
			if (dbField.value().equals("")) {
				throw new UnCaughtException(
						"The value of Annotion of 'com.wq.common.db.mapper.DBTable is NULL'[in class '"
								+ poClz.getName() + "']");
			}
			vo.setDbFieldName(dbField.value());
			if (type == 1) {
				map.put(fieldName, vo);
			} else {
				map.put(dbField.value(), vo);
			}
		}
		return map;
	}

	@Override
	public <T> Map<String, FieldMapperVO> fieldMapperPO2DB(Class<T> poClz) {
		return fieldMapper(poClz, 1);
	}

	@Override
	public <T> Map<String, FieldMapperVO> fieldMapperDB2PO(Class<T> poClz) {
		return fieldMapper(poClz, 2);
	}

}
