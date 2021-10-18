package dao;

import java.sql.SQLException;
import java.util.List;

import dto.CategoryDTO;
import dto.CategoryDetailsDTO;
import dto.RestaurantDTO;

public interface UserRestaurantDAO {
	
	/**
	 * 카레고리상세별 식당목록 검색
	 * */
	List<CategoryDTO> selectCategory(String category,String categoryDetail) throws SQLException;
	
	
}
