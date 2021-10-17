package dao;

import java.sql.SQLException;
import java.util.List;

import dto.RestaurantDTO;

public interface RecommendDAO {
	
    List<RestaurantDTO> recByCommon() throws SQLException;
	
	List<RestaurantDTO> recByLevel(int levelNo) throws SQLException;
	
	List<RestaurantDTO> recByVisited() throws SQLException;
	
	List<RestaurantDTO> recByTag(int tagNo) throws SQLException;

}