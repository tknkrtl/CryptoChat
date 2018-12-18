package model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

import bean.MessageBean;
import bean.RegisterBean;
import dao.GetAllMessages;
import dao.GetMessageDao;
import dao.RegisterDao;

@WebServlet("/RegisterServlet/*")

public class RegisterServlet extends HttpServlet {
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		req.setCharacterEncoding("UTF-8");
		
		
		
		
		
		
		System.out.println(req.getPathInfo());
		String email =req.getParameter("email");
		String username =req.getParameter("username");
		String psw =req.getParameter("psw");
		
		RegisterBean registerBean = new RegisterBean();
		
		registerBean.setEmail(email);
		registerBean.setUsername(username);
		registerBean.setPsw(psw);
		
		
		// Kullanýcýnýn usernameini aldým * Atakan
		HttpSession session=req.getSession();
		session.setAttribute("username", username);
		
		
		RegisterDao registerDao = new RegisterDao();
		String userRegistered = registerDao.registerUser(registerBean);
		
		
		if (userRegistered.equals("success")) {
			
			
			  List<MessageBean> allMessageList= new ArrayList<>();		  
			  allMessageList = GetAllMessages.getAllMessages();
			  session.setAttribute("allMessageList",allMessageList);
			 
			RequestDispatcher dispatcher=req.getRequestDispatcher("home.jsp");
			dispatcher.forward(req, resp);
			
		}
		else
		{
			req.setAttribute("errMessage", userRegistered);
			RequestDispatcher dispatcher=req.getRequestDispatcher("register.jsp");
			dispatcher.forward(req, resp);
		}
	}
}
