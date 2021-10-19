package controller.servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdminStoryDAO;
import dao.AdminStoryDAOImpl;

@WebServlet("/adminStoryDelete")
public class AdminStoryDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   try {
			String storyNo = request.getParameter("no");
			
			AdminStoryDAO dao = new AdminStoryDAOImpl();
			int result = dao.deleteByStoryNo(Integer.parseInt(storyNo));
			
			PrintWriter out = response.getWriter();
			out.print(result);
	   }catch(NumberFormatException e) {
		   e.printStackTrace();
	   }
		
		
      
	}

}
