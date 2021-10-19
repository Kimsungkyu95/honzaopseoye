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
		List<RestaurantDTO>restaurantList = new ArrayList<RestaurantDTO>();
		
		String categoryDetail = request.getParameter("categoryDetail"); //meat, sushi...
		
		restaurantList= urService.selectCategory(categoryDetail);
		
		request.setAttribute("list", restaurantList); //뷰에서 ${requestScope.list} 
		
		ModelAndView mv = new ModelAndView("userCategory/categoryByRestaurant.jsp");
		
		return mv;
	}
	
	/**
	 * 맛집상세정보 
	 * */
	public ModelAndView selectByRestaurantNo(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String restaurantNo = request.getParameter("restaurantNo");
		RestaurantDTO restaurantDTO = urService.selectByRestaurantNo(restaurantNo);
		request.setAttribute("restaurant",restaurantDTO);
		
		return new ModelAndView("restaurant.jsp");
	}

}
