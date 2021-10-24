package listener;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import controller.Controller;

@WebListener
public class HandlerMappingListener implements ServletContextListener {

   /**
    * 서버가 start될때 미리 필요한 객체를 생성해서 Map에 저장하고 application영역에 저장한다.
    * */
    public void contextInitialized(ServletContextEvent e)  { 
    	ServletContext application=e.getServletContext();
    	String fileName = application.getInitParameter("fileName");
    	
    	Map<String, Controller> map = new HashMap<String, Controller>();
    	Map<String, Class<?>> clzMap = new HashMap<String, Class<?>>();
    	
    	 //외부의 ~.properties파일 로딩. 
    	ResourceBundle rb = ResourceBundle.getBundle(fileName);//확장자 생략
    		try {
		    	for(String key :rb.keySet()) {
		    		String value = rb.getString(key);
		    		//System.out.println(key+"="+value);
		    		
		    		Class<?>className = Class.forName(value);
		    		Controller controller = (Controller)className.getDeclaredConstructor().newInstance();
		    		
		    		System.out.println(key+" = "+value + ", controller=" + controller);
		    		//System.out.println(key+" = "+className + ", className=" + className);
		    		map.put(key, controller);
		    		clzMap.put(key, className);
		    	} //for문끝 
		    	application.setAttribute("map", map);
		    	application.setAttribute("clzMap", clzMap);
		    	application.setAttribute("path", application.getContextPath());  // 모든뷰에서 ${path}
    		} 	
			catch (Exception e1) {
				e1.printStackTrace();
			}
    	
    }
	
}








