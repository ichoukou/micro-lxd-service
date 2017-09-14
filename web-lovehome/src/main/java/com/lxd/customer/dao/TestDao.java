package com.lxd.customer.dao;

import java.io.Serializable;

public class TestDao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer testId;

	private String testName;
	
	public TestDao() {
		
	}

	public TestDao(Integer testId, String testName) {
		super();
		this.testId = testId;
		this.testName = testName;
	}

	public Integer getTestId() {
		return testId;
	}

	public void setTestId(Integer testId) {
		this.testId = testId;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	@Override
	public String toString() {
		return "TestDao [testId=" + testId + ", testName=" + testName + "]";
	}

}
