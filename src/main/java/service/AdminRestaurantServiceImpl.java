package service;

import dao.AdminRestaurantDAO;
import dao.AdminRestaurantDAOImpl;
import dto.RestaurantDTO;

public class AdminRestaurantServiceImpl implements AdminRestaurantService {
	
	private AdminRestaurantDAO AdminRestaurantDAO = new AdminRestaurantDAOImpl();
	@Override
	public void insert(RestaurantDTO restaurantDTO) {
		// TODO Auto-generated method stub

	}

}
