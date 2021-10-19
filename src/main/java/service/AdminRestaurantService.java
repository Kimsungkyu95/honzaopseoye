package service;

import java.sql.SQLException;
import java.util.List;

import dto.RestaurantDTO;

public interface AdminRestaurantService {
	/**
	 * 맛집 데이터 insert
	 * */
	void insert(RestaurantDTO restaurantDTO, String categoryDetailsName) throws SQLException;
	
	/**
	 * 맛집 리스트 페이징 select
	 * */
	List<RestaurantDTO> pagingSelect(int pageNo, String selectKey, String selectValue) throws SQLException;
}
