package ajax;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import bean.MessageBean;
import controller.AESImpl;
import dao.GetAllMessages;

@WebServlet("/decryptAll")

public class DecryptAll extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<MessageBean> allMessageList=new ArrayList<>();
		
		String ajaxdata="";
		allMessageList=GetAllMessages.getAllMessages();
		
		for(int i=0;i<allMessageList.size();i++)
		{
			allMessageList.get(i).setMmesage(AESImpl.decrypt(allMessageList.get(i).getMmesage(), AESImpl.keyList.get(i) ,AESImpl.initVectorList.get(i) ));
		}
		ajaxdata=JsonConvert.convert(allMessageList);
		
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().write(ajaxdata);
		
	}
	
	
	
}
