package service;

import java.sql.SQLException;
import java.util.List;

import dto.CategoryDTO;
import dto.CategoryDetailsDTO;
import dto.RestaurantDTO;
/**
 * 유저맛집서비스
 * */
public interface UserRestaurantService {
	/**
	 * 카레고리상세별 식당목록 검색
	 * */
	List<RestaurantDTO> selectCategory(String categoryDetail) throws SQLException;
	
	/**
	 * 맛집상세정보
	 * */
	RestaurantDTO selectByRestaurantNo(String restaurantNo)throws SQLException;
	
	/**
	 * 구랑 동에 따라 좌표 가져오기 
	 * */
	List<RestaurantDTO> selectByGu(String gu, String dong) throws SQLException;
}
