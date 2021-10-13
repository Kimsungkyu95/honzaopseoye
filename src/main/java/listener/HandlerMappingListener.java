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
    	
    	 //외부의 ~.properties파일 로딩한다. 
    	ResourceBundle rb = ResourceBundle.getBundle(fileName);//확장자는 생략한다. 
    		try {
    	//key와 value를 분리해서 value를 객체로 만들어서 Map에 넣는다. 
		    	for(String key :rb.keySet()) {
		    		String value = rb.getString(key);
		    		//System.out.println(key+"="+value);
		    		
		    		//String인 문자열을 객체로 만들어야한다!!!
		    		//Class<?>는 어떤객체가 가지고있는 필드,생성자,메소드의 정보를 동적으로 가져올수 있도록 도와주는 객체이다.
		    		//reflection 개념은 동적으로 즉 실행도중에 필요한 객체를 적절하게 생성하고 그 객체가 가지고있는 생성자나 메서드를 
		    		//동적으로 호출해줄수 있도록 하는 개념을 reflection이라고하고 자바에서 이개념을 적용해놓은 API가 Class<?>이다.
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








