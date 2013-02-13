package com.utilitiessavings.ofygwttest.client;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.utilitiessavings.ofygwttest.shared.FirstClass;
import com.utilitiessavings.ofygwttest.shared.SecondClass;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("greet")
public interface GreetingService extends RemoteService
{
	void fillDatastore();
	
	ArrayList<FirstClass> getFirstClass();
	
	ArrayList<SecondClass> getSecondClass();
	
}
