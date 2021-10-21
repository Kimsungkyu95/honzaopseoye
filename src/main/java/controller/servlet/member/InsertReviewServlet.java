package controller.servlet.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.ReviewDTO;
import service.MemberService;
import service.MemberServiceImpl;

/**
 * Servlet implementation class InsertReviewServlet
 */
@WebServlet("/insertReviewServlet")
public class InsertReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		MemberService memberService = new MemberServiceImpl();
		
		String loginId = (String)request.getSession().getAttribute("loginId");
		int restaurantNo = Integer.parseInt(request.getParameter("restaurantNo"));
		String reviewContent = request.getParameter("reviewContent");
		int reviewScore = Integer.parseInt(request.getParameter("reviewScore"));
		
		
		ReviewDTO reviewDTO = new ReviewDTO();
		reviewDTO.setRestaurantNo(restaurantNo);
		reviewDTO.setReviewContent(reviewContent);
		reviewDTO.setReviewScore(reviewScore);
		PrintWriter out = response.getWriter();
		
		try {
			memberService.insertReview(loginId, reviewDTO);
			out.print("리뷰쓰기를 완료했습니다.");
		}catch (Exception e) {
			e.printStackTrace();
			out.print("리뷰를 쓰지 못했습니다.");
		}
		
	}

}
