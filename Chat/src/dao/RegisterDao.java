package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import bean.RegisterBean;
import dao.dbconnection;

public class RegisterDao {
	

	public String registerUser(RegisterBean registerbean) {
		String email = registerbean.getEmail();
		String username = registerbean.getUsername();
		String psw = registerbean.getPsw();
		
		Connection con=null;
		PreparedStatement preparedStatement = null;
		
		try {
			con = dbconnection.createconnection();
			String query = "insert into chatusers(idChatUsers,email,username,psw) values (NULL,?,?,?)";
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, username);
			preparedStatement.setString(3, psw);
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
