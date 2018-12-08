package ajax;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import bean.MessageBean;
import dao.GetMessageDao;


public class JsonConvert {

	static GetMessageDao gm=new GetMessageDao();
	
	
	public static String convert(List<MessageBean> list) {
		
//		List<MessageBean> list=new ArrayList<>();
//		list=GetMessageDao.getMessage();
		//datayý json'a çevirme 

		String ajaxdata="";
		
		Gson gson=new GsonBuilder().create();
		ajaxdata=gson.toJson(list);
		
		list.removeAll(list);
		
		return ajaxdata;

	}


}
