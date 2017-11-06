package com.chill;

public class book{
	String id;
	String author;
	String name;

	public book(String a,String b,String c)
	{
		id=a;author=b;name=c;
	}

	public String getId()
	{
		return id;
	}

	public String getAuthor()
	{
		return author;
	}

	public String getName()
	{
		return name;
	}

	public void setId(String id)
	{
		this.id=id;
	}
	public void setAuthor(String id)
	{
		this.author=id;
	}
	public void setName(String id)
	{
		this.name=id;
	}

}