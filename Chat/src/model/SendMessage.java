package model;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.jstl.core.Config;

import bean.MessageBean;
import controller.AESImpl;
import dao.SendMessageDao;
import dao.GetAllMessages;
import dao.GetMessageDao;

import com.google.gson.Gson;
import com.mysql.cj.Session;
import com.sun.scenario.Settings;

import ajax.JsonConvert;

@WebServlet("/SendMessage")
public class SendMessage extends HttpServlet {
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		String message = req.getParameter("message");
		
		message=AESImpl.encrypt(message);
		
		req.setAttribute("message",message);
		
		
		HttpSession session=req.getSession();
		session.setAttribute("date", new java.util.Date());
		java.util.Date uDate =(java.util.Date)session.getAttribute("date");
		DateFormat df = new SimpleDateFormat("dd/MM/YYYY - hh:mm:ss");
		Date date =convertUtilToSql(uDate);
		
		String convertedDate = convertStringToDate(date);
		
		String username= (String)session.getAttribute("username");
		
		
		//Mesaj formatýna çevir
		MessageBean messagebean= new MessageBean();
		messagebean.setMdate(convertedDate);
		messagebean.setMmesage(message);
		messagebean.setMusername(username);
		
		//mesajý veritabanýna yazdýr
	    SendMessageDao sendmessage = new SendMessageDao();
	    sendmessage.usermessage(messagebean);
	    
	    List<MessageBean> allMessageList= new ArrayList<>();		  
		allMessageList = GetAllMessages.getAllMessages();
		session.setAttribute("allMessageList",allMessageList);
		 
		RequestDispatcher dispatcher=req.getRequestDispatcher("home.jsp");
		dispatcher.forward(req, resp);
	    
//	    List<MessageBean> list=new ArrayList<>();
//	    list.add(messagebean);
//
//	    String ajaxdata="";
//	    ajaxdata=JsonConvert.convert(list);
//	    
//	    resp.setContentType("application/json");
//	    resp.setCharacterEncoding("UTF-8");
//	    resp.getWriter().write(ajaxdata);	    
	}
	 
	private static Date convertUtilToSql(java.util.Date uDate) 
	{
		 
		         java.sql.Date sDate = new java.sql.Date(uDate.getTime());		 
		         return sDate;
    }

	
	private String convertStringToDate(Date indate)
	{
	   String date = null;
	   SimpleDateFormat sdfr = new SimpleDateFormat("dd/MMM/yyyy");
	  
	   try{
		date = sdfr.format( indate );
	   }catch (Exception ex ){
		System.out.println(ex);
	   }
	   return date;
	}

}
