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
	public List<CategoryDTO> selectCategory(String category,String categoryDetail) throws SQLException {
		return urDao.selectCategory(category,categoryDetail);
	}

}
