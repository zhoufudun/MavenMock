package com.zhoufudun.mock.service;

import com.zhoufudun.dao.PersonDao;
import com.zhoufudun.entity.Person;

public class PersonService {
	private final PersonDao personDao;  
    public PersonService( PersonDao personDao )  
    {  
        this.personDao = personDao;  
    }  
    public boolean update(Integer personID,String name){
    	Person person=personDao.fetchPerson(personID);
    	if(person!=null){
    		Person updatePerson=new Person(person.getPersonID(),name);
    		personDao.update(updatePerson);
    		return true;
    	}
    	else{
    		return false;
    	}
    }
    public boolean insert(Person person){
    	personDao.insert(person);
		return true;
    }
}
