package dao;

import java.sql.SQLException;
import java.util.List;

import dto.CategoryDTO;
import dto.CategoryDetailsDTO;
import dto.MenuDTO;
import dto.RestaurantDTO;
import dto.ReviewDTO;


public interface UserRestaurantDAO {
	
	/**
	 * 카레고리상세별 식당목록 검색
	 * */
	List<RestaurantDTO> selectCategory(String categoryDetail) throws SQLException;
	
	/**
	 * 맛집상세 
	 * */
	RestaurantDTO selectByRestaurantNo(String restaurantNo) throws SQLException;
	
	/**
	 * 맛집에 따른 리뷰리스트
	 * */
	List<ReviewDTO> selectReviewByRestaurantNo(String restaurantNo) throws SQLException;
	
	/**
	 * 맛집에 따른 메뉴리스트
	 * */
	List<MenuDTO> selectMenuByRestaurantNo(String restaurantNo) throws SQLException;

	/**
	 * 카테고리이름 가져오기 
	 * @throws SQLException 
	 * */
	String selectCategoryDetailName(String restaurantNo) throws SQLException;
	
	/**
	 * 구랑 동에 따라 좌표 가져오기 
	 * */
	List<RestaurantDTO> selectByGu(String gu, String dong) throws SQLException;

	
	
}
