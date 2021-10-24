package controller;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RecommendCategoryDAO;
import dto.CategoryDTO;
import dto.CategoryDetailsDTO;
import dto.RestaurantDTO;
import service.UserRestaurantService;
import service.UserRestaurantServiceImpl;

/**
 * 유저 맛집 컨트롤러 
 * */
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
			       		 imgList.add(fileName.substring(fileName.lastIndexOf("\\")+1));
			       	 }
				}else {
//					imgList.add("img/tray1.png");
				}
			}else {
//				imgList.add("img/tray1.png");
			}
			restaurantDTO.setImgList(imgList);
			restaurantDTO.setCategoryName(category);
			restaurantDTO.setCategoryDetailsName(categoryDetail);
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
		
		//맛집 번호로 카테고리 들고오기
		System.out.println(restaurantNo);
		RecommendCategoryDAO rcDAO = new RecommendCategoryDAO();
		RestaurantDTO temp = rcDAO.selectCategoryByRestaurantNo(Integer.parseInt(restaurantNo));
		
		
		File file = new File(request.getServletContext().getRealPath("/img/restaurantImage")+"/" + temp.getCategoryName()+"/"+temp.getCategoryDetailsName()+"/"+restaurantName);
		System.out.println(file.toString());
		if(file.exists()) {
			File files [] = file.listFiles();
			if(files.length>=1) {
				for(int i = 0; i < 2; i++) {
		       		 String fileName = files[i].toString();
//		     		System.out.println(fileName.substring(fileName.lastIndexOf("\\")+1));
		       		 imgList.add(fileName.substring(fileName.lastIndexOf("\\")+1));
		       	 }

			}else {
//				imgList.add("img/tray1.png");

			}
		}else {
//			imgList.add("img/tray1.png");

		}
		restaurantDTO.setCategoryName(temp.getCategoryName());
		restaurantDTO.setImgList(imgList);
		
		request.setAttribute("restaurant",restaurantDTO);
		
		return new ModelAndView("restaurant.jsp");
	}
	
	/**
	 * 구와동을 통해서 좌표를 구해 맛집위치출력 
	 * */
	public ModelAndView selectByGu(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String gu = request.getParameter("gu");
		String dong = request.getParameter("dong");
		System.out.println(gu+","+dong);
		List<RestaurantDTO> reList = new ArrayList<RestaurantDTO>();

		reList= urService.selectByGu(gu,dong);
		
		request.setAttribute("list", reList);
		
		return new ModelAndView("main.jsp");
	}


}
