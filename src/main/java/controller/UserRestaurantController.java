package controller;

import java.io.File;
import java.io.FileFilter;
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
	String category;
	String categoryDetail;
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
		category = request.getParameter("category");
		categoryDetail = request.getParameter("categoryDetail"); 
		
		List<RestaurantDTO>restaurantList = new ArrayList<RestaurantDTO>();
		
		RestaurantDTO restaurant = new RestaurantDTO();
		restaurantList= urService.selectCategory(categoryDetail);
		
		for(RestaurantDTO restaurantDTO : restaurantList) {
			List<String>imgList=new ArrayList<String>();
			String restaurantName = restaurantDTO.getRestaurantName();
			File file = new File(request.getServletContext().getRealPath("/img/restaurantImage")+"/" + category+"/"+categoryDetail+"/"+restaurantName);
			
			if(file.exists()) {
				File files [] = file.listFiles();
				if(files.length>=1) {
					for(int i = 0; i < 1; i++) {
			       		 String fileName = files[i].toString();
//			     		System.out.println(fileName.substring(fileName.lastIndexOf("\\")+1));
			       		 imgList.add("img/restaurantImage"+"/" + category+"/"+categoryDetail+"/"+restaurantName+"/"+fileName.substring(fileName.lastIndexOf("/")+1));
			       	 }
				}else {
					imgList.add("img/삼겹살.jpeg");
				}
			}else {
				imgList.add("img/삼겹살.jpeg");
			}
			restaurantDTO.setImgList(imgList);
		}
		
		request.setAttribute("list", restaurantList); //뷰에서 ${requestScope.list} 
		
		ModelAndView mv = new ModelAndView("userCategory/categoryByRestaurant.jsp");
		
		return mv;
	}
	
	/**
	 * 맛집상세정보 
	 * */
	public ModelAndView selectByRestaurantNo(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		//System.out.println(category);
		//System.out.println(categoryDetail);
		
		String restaurantNo = request.getParameter("restaurantNo");
		RestaurantDTO restaurantDTO = urService.selectByRestaurantNo(restaurantNo);
		String restaurantName = restaurantDTO.getRestaurantName();
		//System.out.println(restaurantDTO.getRestaurantName());
		List<String>imgList=new ArrayList<String>();
		
		File file = new File(request.getServletContext().getRealPath("/img/restaurantImage")+"/" + category+"/"+categoryDetail+"/"+restaurantName);
		
		if(file.exists()) {
			File files [] = file.listFiles();
			if(files.length>=1) {
				for(int i = 0; i < 2; i++) {
		       		 String fileName = files[i].toString();
//		     		System.out.println(fileName.substring(fileName.lastIndexOf("\\")+1));
		       		 imgList.add("img/restaurantImage"+"/" + category+"/"+categoryDetail+"/"+restaurantName+"/"+fileName.substring(fileName.lastIndexOf("/")+1));
		       	 }
			}else {
				imgList.add("img/삼겹살.jpeg");
			}
		}else {
			imgList.add("img/삼겹살.jpeg");
		}
		restaurantDTO.setImgList(imgList);
		
		request.setAttribute("restaurant",restaurantDTO);
		
		return new ModelAndView("restaurant.jsp");
	}


}
