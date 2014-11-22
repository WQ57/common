package com.wq.common.vo;

import java.io.Serializable;

import com.wq.common.validator.annotation.Email;
import com.wq.common.validator.annotation.Mobile;
import com.wq.common.validator.annotation.NotNull;
import com.wq.common.validator.annotation.Size;

/**
 * 测试类A.
 * 
 * @author wuqing
 * 
 */
public class TestA implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8674768910920548219L;

	@NotNull
	@Size(min = "1", max = "10")
	private String name;

	@NotNull
	@Size(min = "1", max = "99", group = { "group1", "group2" })
	private Integer age;

	@NotNull
	@Size(min = "1", max = "9999")
	private Long a;

	@NotNull
	@Size(min = "1.1", max = "10.0")
	private Float b;

	@NotNull
	@Size(min = "1.1", max = "11111.111")
	private Double c;

	@Email(domain = "163.com")
	private String email;

	@Mobile
	private String mobile;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Long getA() {
		return a;
	}

	public void setA(Long a) {
		this.a = a;
	}

	public Float getB() {
		return b;
	}

	public void setB(Float b) {
		this.b = b;
	}

	public Double getC() {
		return c;
	}

	public void setC(Double c) {
		this.c = c;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

}
