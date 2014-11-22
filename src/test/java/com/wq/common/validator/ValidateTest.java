package com.wq.common.validator;

import org.junit.Test;

import com.wq.common.validator.ValidatorFactory;
import com.wq.common.validator.ValidatorResult;
import com.wq.common.vo.TestA;
import com.wq.common.vo.TestB;

/**
 * 测试类.
 * 
 * @author wuqing
 * 
 */
public class ValidateTest {

	@Test
	public void testA() {
		TestA a = new TestA();
		a.setName("name");
		a.setA(2L);
		a.setB(2f);
		a.setC(2d);
		a.setAge(2);
		a.setEmail("ddddddd@163.com");
		a.setMobile("15806011561");
		ValidatorFactory validatorFactory = new ValidatorFactory();
		ValidatorResult result = validatorFactory.validate(a);
		if (result.isSuccess() == false) {
			System.out.println(result.getAllMsg());
		} else {
			System.out.println("校验通过!");
		}
	}

	@Test
	public void testB() {
		TestB b = new TestB();
		b.setName(null);
		b.setA(0L);
		b.setB(2f);
		b.setC(2d);
		b.setAge(0);
		ValidatorFactory validatorFactory = new ValidatorFactory();
		ValidatorResult result = validatorFactory.validate(b);
		if (result.isSuccess() == false) {
			System.out.println(result.getAllMsg());
		} else {
			System.out.println("校验通过!");
		}
	}
}
