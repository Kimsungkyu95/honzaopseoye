package service;

import java.sql.SQLException;
import java.util.List;

import dao.UserRestaurantDAO;
import dao.UserRestaurantDAOImpl;
import dto.CategoryDTO;
import dto.CategoryDetailsDTO;
import dto.RestaurantDTO;

public class UserRestaurantServiceImpl implements UserRestaurantService {
	private UserRestaurantDAO urDao = new UserRestaurantDAOImpl();

	@Override
	public List<RestaurantDTO> selectCategory(String categoryDetail) throws SQLException {
		return urDao.selectCategory(categoryDetail);
	}

	@Override
	public RestaurantDTO selectByRestaurantNo(String restaurantNo) throws SQLException {
		RestaurantDTO restaurantDTO = urDao.selectByRestaurantNo(restaurantNo);
		return restaurantDTO;
	}

}
