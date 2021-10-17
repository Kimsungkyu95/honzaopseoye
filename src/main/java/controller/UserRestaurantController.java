package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	 * 카테고리로 맛집목록검색
	 * */
	public ModelAndView selectByCategory(HttpServletRequest request, HttpServletResponse response)
			throws Exception{
		String pageNo = request.getParameter("pageNo");
		if(pageNo==null || pageNo.equals("")) {
			pageNo="1";
		}
		List<RestaurantDTO>restaurantList = new ArrayList<RestaurantDTO>();
		restaurantList= urService.selectByCategory();
	
		return null;
	}
	/**
	 * 카테고리상세로 맛집목록검색
	 * */
	public ModelAndView selectByCategoryDetail(HttpServletRequest request, HttpServletResponse response)
			throws Exception{
		
		List<RestaurantDTO>restaurantList = new ArrayList<RestaurantDTO>();
		restaurantList= urService.selectByCategoryDetail();
		
		return null;
	}

}
