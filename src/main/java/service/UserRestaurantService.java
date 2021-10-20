package service;

import java.sql.SQLException;
import java.util.List;

import dto.CategoryDTO;
import dto.CategoryDetailsDTO;
import dto.RestaurantDTO;

public interface UserRestaurantService {
	/**
	 * 카레고리상세별 식당목록 검색
	 * */
	List<RestaurantDTO> selectCategory(String categoryDetail) throws SQLException;
	
	/**
	 * 맛집상세정보
	 * */
	RestaurantDTO selectByRestaurantNo(String restaurantNo)throws SQLException;

	List<RestaurantDTO> selectByGu(String gu, String dong) throws SQLException;
}
