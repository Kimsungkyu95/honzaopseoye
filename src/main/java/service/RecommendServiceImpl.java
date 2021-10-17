package service;

import java.sql.SQLException;
import java.util.List;

import dao.RecommendDAO;
import dao.RecommendDAOImpl;
import dto.RestaurantDTO;

public class RecommendServiceImpl implements RecommendService {
	
	private RecommendDAO recommendDao = new RecommendDAOImpl();

	@Override
	public List<RestaurantDTO> recByCommon() throws SQLException {
		
		return null;
	}

	@Override
	public List<RestaurantDTO> recByLevel(int levelNo) throws SQLException {
		
		return null;
	}

	@Override
	public List<RestaurantDTO> recByVisited() throws SQLException {
	    
		return null;
	}

	@Override
	public List<RestaurantDTO> recByTag(int tagNo) throws SQLException {
		
		return null;
	}
	
	


}
