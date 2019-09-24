package com.MockTest;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.zhoufudun.dao.PersonDao;
import com.zhoufudun.entity.Person;
import com.zhoufudun.mock.service.PersonService;

import static org.junit.Assert.*;
import static org.powermock.api.mockito.PowerMockito.*;
import static org.mockito.Mockito.verify; 

@RunWith(PowerMockRunner.class)
@PrepareForTest({PersonServiceTest.class})//当需要使用PowerMock强大功能（Mock静态、final、私有方法等）的时候
@PowerMockIgnore("javax.management.*") //为了解决使用powermock后，提示classloader错误
public class PersonServiceTest {
	
	private PersonService personService;//被测类
	@Mock 
	private PersonDao personDao;//模拟对象
	
	//所有的测试方法执行之前执行
	@BeforeClass
	public static void setUpClass(){
		
	}
	//所有的测试方法执行之后执行
	@AfterClass
	public static void tearDownClass(){
		
	}
	// 在@Test标注的测试方法之前运行  
    @Before 
	public void setup(){
		// 初始化测试用例类中由Mockito的注解标注的所有模拟对象  
		MockitoAnnotations.initMocks(personDao);
		// 用模拟对象创建被测类对象
		personService =new PersonService(personDao);
	}
    // 在@Test标注的测试方之后运行  
	@After  
	public void tearDown() {  
	}
	@Test
	public void sholdUpdatePersonName(){
		Person person = new Person(1, "Phillip"); //模拟查询到的数据
		Person person2 = new Person(2, "hahaha"); //模拟插入的数据
		//设置模拟对象的返回值
		when(personDao.fetchPerson(1)).thenReturn(person); 
		//执行测试
		boolean updated=personService.update(1, "dava");
		//验证更新是否成功  
		assertTrue(updated);
		//执行测试
		boolean inserted=personService.insert(person2);
		//验证插入是否成功  
		assertTrue(inserted);
		//验证模拟对象的insert()方法是否被调用了一次
		verify(personDao).insert(person2);
		//验证模拟对象的fetchPerson(1)方法是否被调用了一次
		verify(personDao).fetchPerson(1);
		//得到一个抓取器
		ArgumentCaptor<Person> personCaptor=ArgumentCaptor.forClass(Person.class);
		//验证模拟对象的update()是否被调用过一次，并且抓取调用时的参数的参数值
		verify(personDao).update(personCaptor.capture());
		//获取抓取到的参数值
		Person updatePerson=personCaptor.getValue();
		//验证调用时的参数
		assertEquals("dava", updatePerson.getPersonName());
		//检查模拟对象上是否还有未验证的交互  
		verifyNoMoreInteractions(personDao);
	}
	
	@Test
	public void shouldNotUpdatePersonNotFound(){
		//设置模拟对象的返回值为null
		when(personDao.fetchPerson(1)).thenReturn(null);
		//执行测试
		boolean updated=personService.update(1, "new name");
		//验证跟新是否失败
		assertFalse(updated);
		//验证模拟对象的fetchPerson(1)方法是否被调用了一次  
		verify(personDao).fetchPerson(1);
		// 验证模拟对象是否没有发生任何交互 
		verifyZeroInteractions(personDao);
		// 检查模拟对象上是否还有未验证的交互  
        verifyNoMoreInteractions(personDao);  
	}
	
	
	
}
