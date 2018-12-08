package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;

import bean.MessageBean;
import model.RegisterServlet;

public class GetAllMessages {
	
	public static List<MessageBean> getAllMessages () {	
	
		List<MessageBean> allMessageList= new ArrayList<>();

		try {
			
			String username="";
			String date="";
			String message="";
			
			Connection con =null;
			con = dbconnection.createconnection();
			ResultSet rs;		
			PreparedStatement ps=con.prepareStatement("SELECT username,date,message,idmessage FROM message");
			rs=ps.executeQuery();
			while(rs.next()) {
						
				username=rs.getString("username");
				date=rs.getString("date");
				message=rs.getString("message");
				
				MessageBean mb=new MessageBean(username,date,message);
				allMessageList.add(mb);
				
				}
			ps.close();
			con.close();
			rs.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return allMessageList;

	}
	
	
	
	
}
