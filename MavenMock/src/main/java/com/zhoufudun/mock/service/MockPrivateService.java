package com.zhoufudun.mock.service;

public class MockPrivateService {
	public String mockPrivateFunc() {
        return  privateFunc();
    }

    private String privateFunc() {
        return "private func";
    }
}
