package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.AdminStoryDTO;
import dto.StoryDTO;
import service.UserStoryService;
import service.UserStoryServiceImpl;

public class AdminStoryController implements Controller {

	private AdminStoryService adminStoryService = new AdminStoryServiceImpl();

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		return null;
	}
	
	/**
	 * 스토리 제목으로 검색하기
	 * */
	public ModelAndView selectByStoryTitle(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
		String storyTitle =  request.getParameter("storyTitle");
		AdminStoryDTO adminStoryDTO = adminStoryService.selectByStoryTitle(Integer.parseInt(storyTitle), true);
    	
    	request.setAttribute("adminStory", AdminStoryDTO);
    	
    	return new ModelAndView(request.getServletContext().getContextPath() + "/userStory/userStoryList.jsp");
	}
	
	/**
	 * 작성자 번호로 검색하기
	 * */
	public ModelAndView selectByMemberNo(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
		String storyNo =  request.getParameter("modelNum");
		AdminStoryDTO adminStoryDTO = adminStoryService.selectByMemberNo(Integer.parseInt(storyNo), true);
    	
    	request.setAttribute("adminStory", AdminStoryDTO);
    	
    	return new ModelAndView(request.getServletContext().getContextPath() + "/userStory/userStoryList.jsp");
	}

}
