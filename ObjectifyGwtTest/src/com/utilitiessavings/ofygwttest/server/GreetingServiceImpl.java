package com.utilitiessavings.ofygwttest.server;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.util.ArrayList;

import com.utilitiessavings.ofygwttest.client.GreetingService;
import com.utilitiessavings.ofygwttest.shared.FirstClass;
import com.utilitiessavings.ofygwttest.shared.SecondClass;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.cmd.QueryKeys;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements GreetingService
{
	
	static
	{
		ObjectifyService.register(FirstClass.class);
		ObjectifyService.register(SecondClass.class);
	}
	
	public void fillDatastore()
	{
		emptyDatastore();
		
		FirstClass firstClass1 = new FirstClass("One");
		FirstClass firstClass2 = new FirstClass("Two");
		FirstClass firstClass3 = new FirstClass("Three");
		
		ofy().save().entity(firstClass1).now();
		ofy().save().entity(firstClass2).now();
		ofy().save().entity(firstClass3).now();
		
		SecondClass secondClass1 =  new SecondClass("Data one");
		SecondClass secondClass2 =  new SecondClass("Data two");
		SecondClass secondClass3 =  new SecondClass("Data three");
		SecondClass secondClass4 =  new SecondClass("Data four");
		SecondClass secondClass5 =  new SecondClass("Data five");
		
		Key<SecondClass> key1 = ofy().save().entity(secondClass1).now();
		Key<SecondClass> key2 = ofy().save().entity(secondClass2).now();
		Key<SecondClass> key3 = ofy().save().entity(secondClass3).now();
		Key<SecondClass> key4 = ofy().save().entity(secondClass4).now();
		Key<SecondClass> key5 = ofy().save().entity(secondClass5).now();
		
		// set keys
		firstClass1.setSecondClassKey(key1);
		firstClass2.setSecondClassKey(key2);
		firstClass3.setSecondClassKey(key3);
		
		// save again
		ofy().save().entity(firstClass1).now();
		ofy().save().entity(firstClass2).now();
		ofy().save().entity(firstClass3).now();
		
		
	}
	
	
	public ArrayList<FirstClass> getFirstClass()
	{
		ArrayList<FirstClass> list = new ArrayList<FirstClass>();
		
		list.addAll(ofy().load().type(FirstClass.class).list());
		
		return list;
	}
	
	public ArrayList<SecondClass> getSecondClass()
	{
		ArrayList<SecondClass> list = new ArrayList<SecondClass>();
		
		list.addAll(ofy().load().type(SecondClass.class).list());
		
		return list;
	}
	
	
	public void emptyDatastore()
	{

		QueryKeys<FirstClass> firstKeys = ofy().load().type(FirstClass.class).keys();
		QueryKeys<SecondClass> secondKeys = ofy().load().type(SecondClass.class).keys();
		
		ofy().delete().entities(firstKeys).now();
		ofy().delete().entities(secondKeys).now();
		
	}
	
}
