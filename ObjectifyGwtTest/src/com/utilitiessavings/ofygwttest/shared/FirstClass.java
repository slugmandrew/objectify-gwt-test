package com.utilitiessavings.ofygwttest.shared;

import java.io.Serializable;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class FirstClass implements Serializable
{
	@Id
	private Long id;
	
	private String name;
	
	private Key<SecondClass> secondClassKey;	
	
	
	public FirstClass()
	{
		
	}
	
	public FirstClass(String name)
	{
		this.name = name;
	}

	
	
	
	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Key<SecondClass> getSecondClassKey()
	{
		return secondClassKey;
	}

	public void setSecondClassKey(Key<SecondClass> secondClassKey)
	{
		this.secondClassKey = secondClassKey;
	}
	
	
	
	
	
}
