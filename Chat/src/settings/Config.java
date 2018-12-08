package settings;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import model.SendMessage;

@WebListener
public class Config implements ServletContextListener{

	public static boolean alreadyexecuted;
	
	@Override
	public void contextInitialized(ServletContextEvent event) {
		
		alreadyexecuted=false;

	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {

	
	
	}
	
}
