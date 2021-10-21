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

@WebServlet("/recByScore")
public class RecByScoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		RecommendDAO dao = new RecommendDAOImpl();
		List<RecommendDTO> list = dao.recByScore();
		
		request.setAttribute("list", list);
		JSONArray arr = JSONArray.fromObject(list);
		
		PrintWriter out = response.getWriter();
		out.print(arr);
	}

}
