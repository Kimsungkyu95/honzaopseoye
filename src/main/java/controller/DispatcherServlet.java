package controller;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 모든 요청을 중앙집중적으로 관리하게될 Servlet
 * 	: 진입점 Controller이다. 
 */
@WebServlet(urlPatterns ="/front", loadOnStartup = 1)
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Map<String, Controller> map;
	Map<String, Class<?>> clzMap;
	@Override
		public void init() throws ServletException {
			ServletContext application =  super.getServletContext();
			map = (Map<String, Controller>)application.getAttribute("map");
			clzMap = (Map<String, Class<?>>)application.getAttribute("clzMap");
		}
      
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String key = request.getParameter("key");
		String methodName = request.getParameter("methodName");
			
			//이부분 수정 
			try {
			if(key==null || key.equals("")) {
				key="elec";
			}
			if(methodName==null || methodName.equals("")) {
				methodName = "select";
			}
		
			Class<?> clz = clzMap.get(key);//reflection개념을 적용하기 위한 객체를 구한다.
			//String을 하나의 메소드의 개념으로 만드는 과정 
			Method method = clz.getMethod(methodName, HttpServletRequest.class,  HttpServletResponse.class);
			
			Controller controller = map.get(key);
			
			//객체안에 들어있는 메소드들을 호출하는 과정(호출할때 인자값 전달) 
			ModelAndView mv=(ModelAndView)method.invoke(controller, request, response); //메소드호출 

			if(mv.isRedirect()) { //redirect방식이다. 
				response.sendRedirect(mv.getViewName());
			}else {
				request.getRequestDispatcher(mv.getViewName()).forward(request, response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMsg", e.getCause().getMessage());
			request.getRequestDispatcher("error/error.jsp").forward(request, response);
		}
			

		
	}//service끝 

}//클래스끝 
