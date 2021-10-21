package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.AdminStoryDTO;
import dto.RestaurantDTO;
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
	 * 검색옵션에 따라 검색하기
	 * */
	public ModelAndView selectByOption(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
		
		String selectKey = request.getParameter("selectKey");
		String selectValue = request.getParameter("selectValue");
		
		List<AdminStoryDTO> list = service.selectByOption(selectKey, selectValue);
		
		request.setAttribute("selectKey", selectKey);
		request.setAttribute("selectValue", selectValue);
		request.setAttribute("adminStoryList", list);
			
		return new ModelAndView("adminStory/adminStoryList.jsp");
	}
	
}
