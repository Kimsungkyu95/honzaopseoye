package controller.servlet.adminMember;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.AdminMemberService;
import service.AdminMemberServiceImpl;

/**
 * Servlet implementation class ReviewDeleteServlet
 */
@WebServlet("/adminReviewDeleteServlet")
public class AdminReviewDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		int reviewNo = Integer.parseInt(request.getParameter("reviewNo"));
		AdminMemberService adminMemberService = new AdminMemberServiceImpl();
		PrintWriter out = response.getWriter();
		try {
			adminMemberService.adminDeleteReview(reviewNo);
			out.print("리뷰가 삭제되었습니다.");
		}catch (Exception e) {
			out.print(e.getMessage());
		}
		
	}

}
