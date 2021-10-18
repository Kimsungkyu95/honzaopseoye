package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.CategoryDTO;
import dto.CategoryDetailsDTO;
import dto.RestaurantDTO;
import service.UserRestaurantService;
import service.UserRestaurantServiceImpl;


public class UserRestaurantController implements Controller {
	
	private UserRestaurantService urService = new UserRestaurantServiceImpl();

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		return null;
	}
	/**
	 * 카테고리 목록 검색
	 * */
	public ModelAndView selectCategory(HttpServletRequest request, HttpServletResponse response)
			throws Exception{
		String category = request.getParameter("category"); //한식 
		String categoryDetail = request.getParameter("categoryDetail"); //고기,국밥 

		List<CategoryDTO>restaurantList = new ArrayList<CategoryDTO>();
		
		restaurantList= urService.selectCategory(category,categoryDetail);
		
		request.setAttribute("list", restaurantList); //뷰에서 ${requestScope.list} 
		
		ModelAndView mv = new ModelAndView("categoryByRestaurant.jsp");
		
		return null;
	}

}
