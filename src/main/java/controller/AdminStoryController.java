package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.AdminStoryDTO;
import dto.RestaurantDTO;
import dto.ReviewDTO;
import service.AdminStoryService;
import service.AdminStoryServiceImpl;


public class AdminStoryController implements Controller {

	private AdminStoryService service = new AdminStoryServiceImpl();

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		return null;
	}
	
	/**
	 * 관리자 스토리 목록 페이징
	 * */
	public ModelAndView selectPage(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
		String pageNo = request.getParameter("pageNo");
		if(pageNo == null || pageNo.equals("")) {
			pageNo = "1";
		}
		String selectKey = request.getParameter("selectKey");
		if(selectKey == null || selectKey.equals("")) {
			selectKey = "selectByStoryTitle";
		}
		String selectValue = request.getParameter("selectValue");
		if(selectValue == null || selectValue.equals("")) {
			selectValue = "";
		}
		
		List<AdminStoryDTO> list = service.selectPage(Integer.parseInt(pageNo), selectKey, selectValue);
		
		request.setAttribute("pageNo", pageNo);
		request.setAttribute("selectKey", selectKey);
		request.setAttribute("selectValue", selectValue);
		request.setAttribute("list", list);
		
		ModelAndView mv = new ModelAndView("adminStory/adminStoryList.jsp");	
		return mv;
	}
	
}
