package dao;

import java.sql.SQLException;
import java.util.List;

import dto.RestaurantDTO;

public interface UserRestaurantDAO {
	/**
	 * 카테고리별 식당목록 검색 
	 * */
	List<RestaurantDTO> selectByCategory() throws SQLException;
	
	/**
	 * 카레고리상세별 식당목록 검색
	 * */
	List<RestaurantDTO> selectByCategoryDetail() throws SQLException;
}
