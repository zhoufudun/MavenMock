package com.zhoufudun.dao;

import com.zhoufudun.entity.Person;
/**
 * &&&&&&&&&&&&&&&&&
 * @author 19026404
 *
 */
public interface PersonDao {
	public Person fetchPerson(Integer personID);  
    public void update(Person person);  
    public void insert(Person person);
}
