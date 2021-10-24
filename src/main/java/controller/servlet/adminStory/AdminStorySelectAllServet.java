package controller.servlet.adminStory;

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

/**
 * 관리자 스토리페이지 관련 클래스
 * 스토리 전체 검색 서블릿
 * @return 전체 스토리 리스트
 * */
@WebServlet("/adminStorySelectAll")
public class AdminStorySelectAllServet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		AdminStoryDAO dao = new AdminStoryDAOImpl();
		List<AdminStoryDTO> list = dao.selectAll();
		
		JSONArray arr = JSONArray.fromObject(list);
		
		PrintWriter out = response.getWriter();
		out.print(arr);
	}

}
