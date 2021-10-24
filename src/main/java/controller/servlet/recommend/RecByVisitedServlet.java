package controller.servlet.recommend;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RecommendDAO;
import dao.RecommendDAOImpl;
import dto.RecommendDTO;
import net.sf.json.JSONArray;

/**
 * 추천페이지 관련 클래스
 * 높은 조회수에 따른 추천 리스트 검색 서블릿
 * */
@WebServlet("/recByVisited")
public class RecByVisitedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
response.setContentType("text/html;charset=UTF-8");
		
		RecommendDAO dao = new RecommendDAOImpl();
		List<RecommendDTO> list = dao.recByVisited();
		
		request.setAttribute("list", list);
		JSONArray arr = JSONArray.fromObject(list);
		
		PrintWriter out = response.getWriter();
		out.print(arr);
	}

}
