package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdminStoryDAO;
import dao.AdminStoryDAOImpl;
import dto.AdminStoryDTO;
import dto.RestaurantDTO;
import service.AdminStoryService;
import service.AdminStoryServiceImpl;


public class AdminStoryController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		return null;
	}
	
   
	/**
	 * 관리자 스토리관리 부분 전체 목록 띄우는 메소드
	 * @return 나이 대비 추천 영화 리스트
	 * @throws Exception
	 */
	public ModelAndView selectByOption(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
		
		AdminStoryDAO dao = new AdminStoryDAOImpl();
		List<AdminStoryDTO> list = dao.selectAll();
		
		request.setAttribute("list", list);
		
		return new ModelAndView("adminStory/adminStoryList.jsp");
	}
	
}
