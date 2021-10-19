package dao;

import java.sql.SQLException;
import java.util.List;

import dto.CategoryDTO;
import dto.CategoryDetailsDTO;
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
	
	List<ReviewDTO> selectReviewByModelNum(String restaurantNo) throws SQLException;
	
	
}
