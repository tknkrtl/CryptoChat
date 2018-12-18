package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.RegisterServlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.eclipse.jdt.internal.compiler.ast.LabeledStatement;

import com.mysql.cj.Session;

import bean.MessageBean;
import dao.dbconnection;

public class GetMessageDao extends HttpServlet{
	
	static List<MessageBean> messageList= new ArrayList<>();
	static int lastmessagesent=-1;
	
	public static List<MessageBean> getMessage () {	
	
//		int id=GetAllMessages.getId();	
//		System.out.println(id);
		
		try {
			
			
			String username="";
			String date="";
			String message="";
			
			Connection con =null;
			con = dbconnection.createconnection();
			ResultSet rs;		
			PreparedStatement ps=con.prepareStatement("SELECT idmessage,username,date,message FROM message ");
			rs=ps.executeQuery();
			
			while(rs.next()) {
				
				if(rs.isLast() && (lastmessagesent!=rs.getInt("idmessage")))
				{
				username=rs.getString("username");
				date=rs.getString("date");
				message=rs.getString("message");
				lastmessagesent=rs.getInt("idmessage");
				
				MessageBean mb=new MessageBean(username,date,message);
				messageList.add(mb); 
				}
				
				}
			ps.close();
			con.close();
			rs.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return messageList;
		
		
		
	}

	
}
