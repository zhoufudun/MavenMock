package com.zhoufudun.mock.service;
/**
 * Mock普通类的静态方法
 * @author 19026404
 *
 */
public class FlySumServiceFive {
	public boolean callStaticMethod() {
        return ClassDependency.isStatic();
    }
}
