package service;

import java.sql.SQLException;

import dto.RestaurantDTO;

public interface AdminRestaurantService {
	void insert(RestaurantDTO restaurantDTO, String categoryDetailsName) throws SQLException;
}
