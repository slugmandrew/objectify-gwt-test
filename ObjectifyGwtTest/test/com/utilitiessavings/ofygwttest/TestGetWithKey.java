package com.utilitiessavings.ofygwttest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;
import com.utilitiessavings.ofygwttest.server.GreetingServiceImpl;
import com.utilitiessavings.ofygwttest.shared.FirstClass;
import com.utilitiessavings.ofygwttest.shared.SecondClass;

public class TestGetWithKey
{
	private final LocalServiceTestHelper helper = new LocalServiceTestHelper(new LocalDatastoreServiceTestConfig());
	
	private GreetingServiceImpl service = new GreetingServiceImpl();
	
	@Before
	public void setUp() throws Exception
	{
		helper.setUp();
		
		service.fillDatastore();
	}
	
	@After
	public void tearDown() throws Exception
	{
		helper.tearDown();
	}
	
	// this passes now, but when using the actual datastore it fails
	@Test
	public void testFirstClass()
	{
		List<FirstClass> firstClassList = service.getFirstClass();
		
		// there should be 3 items
		assertEquals(firstClassList.size(), 3);
		assertNotSame(firstClassList.size(), 5);
		
	}
	
	@Test
	public void testSecondClass()
	{
		List<SecondClass> secondClassList = service.getSecondClass();
		
		// there should be 5 items
		assertEquals(secondClassList.size(), 5);
		assertNotSame(secondClassList.size(), 3);
		
	}
	
}
