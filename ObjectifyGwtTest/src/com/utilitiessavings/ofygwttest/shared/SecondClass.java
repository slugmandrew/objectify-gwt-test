package com.utilitiessavings.ofygwttest.shared;

import java.io.Serializable;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class SecondClass implements Serializable
{
	@Id
	private Long id;
	
	private String data;
	

	public SecondClass()
	{
		
	}
	
	public SecondClass(String data)
	{
		this.data = data;
	}

	
	
	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getData()
	{
		return data;
	}

	public void setData(String data)
	{
		this.data = data;
	}

	

	
	
	
}
