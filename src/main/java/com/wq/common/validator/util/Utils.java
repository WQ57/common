package com.wq.common.validator.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * 工具类.
 * 
 * @author wuqing
 * 
 */
public class Utils {

	/**
	 * 执行某个对象的方法(包括父类的方法).
	 * 
	 * @param owner
	 *            对象
	 * @param methodName
	 *            方面名称
	 * @param args
	 *            方法参数
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings({ "rawtypes" })
	public static Object invokeMethod(Object owner, String methodName,
			Object[] args) throws Exception {
		Class ownerClass = owner.getClass();
		Class[] argsClass = new Class[args.length];
		for (int i = 0, j = args.length; i < j; i++) {
			argsClass[i] = args[i].getClass();
		}
		Method method = getMethod(ownerClass, argsClass, methodName);
		if (method == null) {
			throw new Exception("没有该方法(" + methodName + ")");
		}
		return method.invoke(owner, args);
	}

	/**
	 * 递归父类查找方法.
	 * 
	 * @param ownerClass
	 * @param argsClass
	 * @param methodName
	 * @return
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Method getMethod(Class ownerClass, Class[] argsClass,
			String methodName) throws SecurityException {
		if (ownerClass == null) {
			return null;
		}
		Method method = null;
		try {
			method = ownerClass.getDeclaredMethod(methodName, argsClass);
			method.setAccessible(true);
		} catch (NoSuchMethodException e) {
			return getMethod(ownerClass.getSuperclass(), argsClass, methodName);
		}
		return method;
	}

	/**
	 * 获得字段值.
	 * 
	 * @param obj
	 * @param fieldName
	 * @return
	 * @throws Exception
	 */
	public static Object getFieldValue(Object obj, String fieldName)
			throws Exception {
		String methodName = "get"
				+ String.valueOf(fieldName.charAt(0)).toUpperCase()
				+ fieldName.substring(1);
		return invokeMethod(obj, methodName, new Object[] {});
	}

	/**
	 * 获得一个类的所有成员对象（包括父类）
	 * 
	 * @param obj
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static Field[] getFields(Class c) {
		List<Field> list = new ArrayList<Field>();
		Field[] fields = c.getDeclaredFields();
		for (Field field : fields) {
			list.add(field);
		}
		getFieldList(c, list);
		Field[] arry = new Field[list.size()];
		for (int i = 0; i < list.size(); i++) {
			arry[i] = list.get(i);
		}
		return arry;
	}

	/**
	 * 递归执行查找父类的字段.
	 * 
	 * @param c
	 * @param subFieldList
	 */
	@SuppressWarnings("rawtypes")
	private static void getFieldList(Class c, List<Field> subFieldList) {
		Class superClass = c.getSuperclass();
		if (superClass != null) {
			Field[] fields = superClass.getDeclaredFields();
			for (Field field : fields) {
				field.setAccessible(true);
				subFieldList.add(field);
			}
			getFieldList(superClass, subFieldList);
		}
	}
}
