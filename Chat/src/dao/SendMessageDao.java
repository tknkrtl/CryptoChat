package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import bean.MessageBean;
import dao.dbconnection;

public class SendMessageDao {
	
	public String usermessage(MessageBean messagebean) {
		String username = messagebean.getMusername();
		String date = messagebean.getMdate();
		String message = messagebean.getMmesage();
		
		Connection con=null;
		PreparedStatement preparedStatement = null;
		
		try {
			con = dbconnection.createconnection();
			String query = "insert into message(idmessage,username,date,message) values (NULL,?,?,?)";
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, date);
			preparedStatement.setString(3, message);
			int i= preparedStatement.executeUpdate();
			if (i!=0) {
				return "success";
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		 return "Oops.. Something went wrong there..!";
	}

}
