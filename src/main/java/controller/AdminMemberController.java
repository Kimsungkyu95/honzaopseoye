package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.ReviewDTO;
import service.AdminMemberService;
import service.AdminMemberServiceImpl;

public class AdminMemberController implements Controller {

	private AdminMemberService adminMemberService = new AdminMemberServiceImpl();
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 리뷰리스트 페이징해서 출력
	 * */
	public ModelAndView pagingSelectReview(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		String pageNo = request.getParameter("pageNo");
		if(pageNo == null || pageNo.equals("")) {
			pageNo = "1";
		}
		String selectKey = request.getParameter("selectKey");
		if(selectKey == null || selectKey.equals("")) {
			selectKey = "memberName";
		}
		String selectValue = request.getParameter("selectValue");
		if(selectValue == null || selectValue.equals("")) {
			selectValue = "";
		}
		
		List<ReviewDTO> reviewList = adminMemberService.pagingSelectReview(Integer.parseInt(pageNo), selectKey, selectValue);
		
		request.setAttribute("pageNo", pageNo);
		request.setAttribute("selectKey", selectKey);
		request.setAttribute("selectValue", selectValue);
		request.setAttribute("reviewList", reviewList);
		
		ModelAndView mv = new ModelAndView("adminMember/adminReviewList.jsp");	
		return mv;
		
	}
	

}
