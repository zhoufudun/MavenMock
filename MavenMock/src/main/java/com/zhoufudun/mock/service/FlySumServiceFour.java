package com.zhoufudun.mock.service;
/**
 * Mock普通对象的final方法
 * @author 19026404
 *
 */
public class FlySumServiceFour {
	public boolean callFinalMethod(ClassDependency refer) {
        return refer.isAlive();
    }
}
