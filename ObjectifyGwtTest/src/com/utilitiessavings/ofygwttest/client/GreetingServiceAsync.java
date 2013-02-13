package com.utilitiessavings.ofygwttest.client;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.utilitiessavings.ofygwttest.shared.FirstClass;
import com.utilitiessavings.ofygwttest.shared.SecondClass;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface GreetingServiceAsync
{

	void fillDatastore(AsyncCallback<Void> callback);
	
	void getFirstClass(AsyncCallback<ArrayList<FirstClass>> callback);
	
	void getSecondClass(AsyncCallback<ArrayList<SecondClass>> callback);

	

	
}
