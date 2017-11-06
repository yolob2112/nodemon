package com.chill;
import java.sql.*;
import java.util.*;
//import oracle.jdbc.driver.OracleDriver;


public class dbutil{
	
	LinkedList<book> list=null;
	Connection con;
	//

	public dbutil()
	{
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","chemistry");
			System.out.println("connection successfull");
		}

		catch(Exception e)
		{
			System.out.println("DATABASE CONNC FAILED");
			e.printStackTrace();
		}
		
	}

	public LinkedList<book> listbooks() throws Exception
	{
		book temp;
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery("select * from books");
		ResultSetMetaData meta=rs.getMetaData();
		if(list==null)
		{
			list=new LinkedList<book>();
			System.out.println("here a new list is being created");
		}
		while(rs.next())
		{
			System.out.println(rs.getString(1)+rs.getString(2)+rs.getString(3));
			temp=new book(rs.getString(1),rs.getString(2),rs.getString(3));
			list.add(temp);

			System.out.println("hell yeah hell yeah");
		}
	return list;
	}
}