package com.wq.common.db;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class DBSessionTest {

	@Before
	public void init() {
		DBFactory.init();
	}

	/**
	 * 测试查询PO结果集.
	 * 
	 * @author wuqing
	 * @date 2014年11月23日 上午1:31:37
	 */
	@Test
	public void testSelect1() {
		System.out.println("====================================");
		// 传PO参数
		S1 s = new S1();
		s.setSid(11);
		s.setsNum(12);
		s.setsState(13);
		String sql = "select s_id,s_num,s_state from s1 where s_id = :sid and s_state = :sState and s_num = :sNum";
		DBSession session = DBFactory.getDBSession();
		List<S1> list = session.select(sql, s, S1.class);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		System.out.println("====================================");
		// 传MAP参数
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sid", 11);
		map.put("sNum", 12);
		map.put("sState", 13);
		session = DBFactory.getDBSession();
		list = session.select(sql, s, S1.class);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

	/**
	 * 测试查询Map结果集.
	 * 
	 * @author wuqing
	 * @date 2014年11月23日 上午1:31:49
	 */
	@Test
	public void testSelect2() {
		System.out.println("====================================");
		// 传PO参数
		S1 s = new S1();
		s.setSid(11);
		s.setsNum(12);
		s.setsState(13);
		String sql = "select s_id,s_num,s_state from s1 where s_id = :sid and s_state = :sState and s_num = :sNum";
		DBSession session = DBFactory.getDBSession();
		List<Map<String, Object>> list = session.select(sql, s);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		System.out.println("====================================");
		// 传MAP参数
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sid", 11);
		map.put("sNum", 12);
		map.put("sState", 13);
		session = DBFactory.getDBSession();
		list = session.select(sql, map);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

	/**
	 * 打印所有记录.
	 * 
	 * @author wuqing
	 * @date 2014年11月23日 上午1:53:21
	 */
	public void selectAll() {
		System.out.println("====================================");
		String sql = "select s_id,s_num,s_state from s1";
		DBSession session = DBFactory.getDBSession();
		List<S1> list = session.select(sql, null, S1.class);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

	/**
	 * 测试更新.
	 * 
	 * @author wuqing
	 * @date 2014年11月23日 上午1:53:30
	 */
	@Test
	public void testUpdate() {
		S1 s = new S1();
		s.setSid(11);
		s.setsNum(92);
		s.setsState(93);
		String sql = "update s1 set s_state = :sState, s_num = :sNum where s_id = :sid";
		DBSession session = DBFactory.getDBSession();
		System.out.println("====================================");
		System.out.println(session.update(sql, s));

		selectAll();

		s.setSid(11);
		s.setsNum(12);
		s.setsState(13);
		session = DBFactory.getDBSession();
		System.out.println("====================================");
		System.out.println(session.update(sql, s));

		selectAll();
	}

	/**
	 * 测试新增和删除.
	 * 
	 * @author wuqing
	 * @date 2014年11月23日 上午1:53:38
	 */
	@Test
	public void testInsertAndDelete() {
		S1 s = new S1();
		s.setSid(41);
		s.setsNum(42);
		s.setsState(43);
		String insertSql = "insert into s1(s_id,s_num,s_state) values(:sid,:sNum,:sState)";
		DBSession session = DBFactory.getDBSession();
		System.out.println("====================================");
		System.out.println(session.insert(insertSql, s));
		
		selectAll();
		
		String deleteSql = "delete from s1 where s_id = :sid";
		session = DBFactory.getDBSession();
		System.out.println("====================================");
		System.out.println(session.insert(deleteSql, s));
		
		selectAll();
	}
}
