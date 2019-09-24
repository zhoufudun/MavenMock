package com.zhoufudun.mock.service;

import java.io.File;

public class FlySunServiceTwo {
	public boolean callArgumentInstance(String path) {
        File file = new File(path); 
        return file.exists();
    }
}
