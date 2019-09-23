package com.zhoufudun.dao;

import com.zhoufudun.entity.Person;

public interface PersonDao {
	public Person fetchPerson(Integer personID);  
    public void update(Person person);  
    public void insert(Person person);
}
