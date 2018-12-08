package dao;


import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.http.HttpServlet;

public class dbconnection extends HttpServlet {

		public static Connection createconnection()
		{
			Connection conn=null;
			
			String url="jdbc:mysql://localhost:3306/servletjdbc?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey";
			String user="root";
			String password="12345677";
			try 
			{	
				Class.forName("com.mysql.jdbc.Driver");
				conn=DriverManager.getConnection(url,user,password);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return conn;	
		}
	}
