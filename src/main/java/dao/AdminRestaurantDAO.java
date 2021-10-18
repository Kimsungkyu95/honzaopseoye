package dao;

import java.sql.SQLException;

import dto.RestaurantDTO;

public interface AdminRestaurantDAO {
	int insert(RestaurantDTO restaurantDTO)throws SQLException;
	int selectCategoryDetailsNo(String categoryDetailsName)throws SQLException;
}
