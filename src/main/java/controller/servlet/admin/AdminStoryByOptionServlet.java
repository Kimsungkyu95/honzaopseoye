package controller.servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdminStoryDAO;
import dao.AdminStoryDAOImpl;
import dto.AdminStoryDTO;
import net.sf.json.JSONArray;

@WebServlet("/selectByOption")
public class AdminStoryByOptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String err ="검색어에 해당되는 스토리 정보가 없습니다.";
		
		String selectValue = request.getParameter("value");
		String selectKey = request.getParameter("option");
		
		
		AdminStoryDAO dao = new AdminStoryDAOImpl();
		List<AdminStoryDTO> list = dao.selectByOption(selectKey, selectValue);
		
		PrintWriter out = response.getWriter();
		
        if(list == null) {
        	out.print(err);
        }
        
		JSONArray arr = JSONArray.fromObject(list);
		out.print(arr);
	}

}
