package ajax;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.MessageBean;
import dao.GetMessageDao;

@WebServlet("/ajaxCall")

public class AjaxCall extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
			String ajaxdata="";
			
			List<MessageBean> list=new ArrayList<>();
			list=GetMessageDao.getMessage();
			
			if(!list.isEmpty()) {
			ajaxdata=JsonConvert.convert(list);	
			list.removeAll(list);	
			
			resp.setContentType("application/json");
			resp.setCharacterEncoding("UTF-8");
			resp.getWriter().write(ajaxdata);
			}
			
			
		
	}
	
	
}
