package com.chill;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.*;



public class connectdb extends HttpServlet{
	
	dbutil db;
	RequestDispatcher view;
	public void init() throws ServletException
	{
		super.init();
		db=new dbutil();
	}

	
	public LinkedList<book> listbook()
	{
		LinkedList<book> temp=null;
		try{
			temp=db.listbooks();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return temp;

	}

	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException{
		PrintWriter out=res.getWriter();
		String cmd=req.getParameter("cmd");
		try{
					switch(cmd)
				{
					case "listbook":LinkedList<book> temp=listbook();
					req.setAttribute("list",temp);
					req.getRequestDispatcher("listbooks.jsp").forward(req,res);
					break;
					default:
					req.getRequestDispatcher("error.html").forward(req,res);
				}
			//req.getRequestDispatcher("error.html").forward(req,res);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	return;

	}
}


// C:\Program Files\Apache Software Foundation\Tomcat 9.0\webapps\db>javac -cp "C:\Program Files\Apache
//  Software Foundation\Tomcat 9.0\lib\servlet-api.jar"; src/connectdb.java