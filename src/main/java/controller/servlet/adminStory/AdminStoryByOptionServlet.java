package controller.servlet.adminStory;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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

/**
 * 관리자 스토리페이지 관련 클래스
 * select 옵션 key에 따른 스토리 검색 서블릿
 * @param 옵션 key, 검색어 value
 * @return 해당 스토리 리스트
 * */
@WebServlet("/selectByOption")
public class AdminStoryByOptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String err="다시 한 번 시도해주세요.";
		
		String selectValue = request.getParameter("value");
		String selectKey = request.getParameter("option");
		
		AdminStoryDAO dao = new AdminStoryDAOImpl();
		List<AdminStoryDTO> list = dao.selectByOption(selectKey, selectValue);
		
		System.out.println(list);
		
		PrintWriter out = response.getWriter();
		
        if(list == null) {
        	out.print(err);
        }
        
		JSONArray arr = JSONArray.fromObject(list);
		out.print(arr);
		
	}

}
