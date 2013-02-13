package com.utilitiessavings.ofygwttest.client;

import java.util.ArrayList;

import com.utilitiessavings.ofygwttest.shared.FieldVerifier;
import com.utilitiessavings.ofygwttest.shared.FirstClass;
import com.utilitiessavings.ofygwttest.shared.SecondClass;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class ObjectifyGwtTest implements EntryPoint
{
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while " + "attempting to contact the server. Please check your network "
			+ "connection and try again.";
	
	/**
	 * Create a remote service proxy to talk to the server-side Greeting service.
	 */
	private final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);
	
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad()
	{
		Button button1 = new Button("Fill Datastore");
		Button button2 = new Button("Get First Class (contains key)");
		Button button3 = new Button("Get Second Class (no key inside)");
		
		HorizontalPanel hPanel = new HorizontalPanel();
		hPanel.add(button1);
		hPanel.add(button2);
		hPanel.add(button3);
		
		RootPanel.get("nameFieldContainer").add(hPanel);

		button1.addClickHandler(new ClickHandler()
		{
			
			@Override
			public void onClick(ClickEvent event)
			{
				greetingService.fillDatastore(new AsyncCallback<Void>()
				{

					@Override
					public void onFailure(Throwable caught)
					{
						Window.alert("Filling datastore - Failed");
					}

					@Override
					public void onSuccess(Void result)
					{
						Window.alert("Filling datastore - Succeeded");
					}
				});
			}
		});
		
		button2.addClickHandler(new ClickHandler()
		{
			@Override
			public void onClick(ClickEvent event)
			{
				greetingService.getFirstClass(new AsyncCallback<ArrayList<FirstClass>>()
				{
					@Override
					public void onFailure(Throwable caught)
					{
						caught.printStackTrace();

						VerticalPanel panel =  new VerticalPanel();
						
						panel.add(new Label("FAILED, see stack trace"));
						
						RootPanel.get("errorLabelContainer").clear();
						RootPanel.get("errorLabelContainer").add(panel);
					}
					@Override
					public void onSuccess(ArrayList<FirstClass> result)
					{
						// this won't happen
					}
				});
			}
		});
		
		button3.addClickHandler(new ClickHandler()
		{
			@Override
			public void onClick(ClickEvent event)
			{
				greetingService.getSecondClass(new AsyncCallback<ArrayList<SecondClass>>()
				{
					@Override
					public void onFailure(Throwable caught)
					{
						// this won't happen
					}
					@Override
					public void onSuccess(ArrayList<SecondClass> result)
					{
						VerticalPanel panel =  new VerticalPanel();
						
						for(SecondClass object : result)
						{
							panel.add(new Label("Data:" + object.getData()));							
						}
						
						RootPanel.get("errorLabelContainer").clear();
						RootPanel.get("errorLabelContainer").add(panel);
					}
				});
			}
		});
		
		
		
		

	}
}
