package service;

import java.sql.SQLException;
import java.util.List;

import dao.UserRestaurantDAO;
import dao.UserRestaurantDAOImpl;
import dto.RestaurantDTO;

public class UserRestaurantServiceImpl implements UserRestaurantService {
	private UserRestaurantDAO urDao = new UserRestaurantDAOImpl();
	@Override
	public List<RestaurantDTO> selectByCategory() throws SQLException {
		// TODO Auto-generated method stub
		return urDao.selectByCategory();
	}

	@Override
	public List<RestaurantDTO> selectByCategoryDetail() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
