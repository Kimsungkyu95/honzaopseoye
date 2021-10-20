package service;

import java.sql.SQLException;
import java.util.List;

import dao.AdminRestaurantDAO;
import dao.AdminRestaurantDAOImpl;
import dto.RestaurantDTO;

public class AdminRestaurantServiceImpl implements AdminRestaurantService {
	
	private AdminRestaurantDAO adminRestaurantDAO = new AdminRestaurantDAOImpl();
	
	@Override
	public void insert(RestaurantDTO restaurantDTO, String categoryDetailsName) throws SQLException{
		// 카테고리 알아오기
		int categoryDetailsNo = adminRestaurantDAO.selectCategoryDetailsNo(categoryDetailsName);
		if(categoryDetailsNo == 0) {
			throw new SQLException("존재하지 않는 카테고리입니다.");
		}
		
		restaurantDTO.setCategoryDetailsNo(categoryDetailsNo);
		int result = adminRestaurantDAO.insert(restaurantDTO);
		if(result == 0) {
			throw new SQLException("맛집 등록에 실패했습니다");
		}
	}
	
	@Override
	public List<RestaurantDTO> pagingSelect(int pageNo, String selectKey, String selectValue) throws SQLException {
		List<RestaurantDTO> restaurantList = adminRestaurantDAO.pagingSelect(pageNo, selectKey, selectValue);
		
		return restaurantList;
	}
	
	@Override
	public void delete(int restaurantNo) throws SQLException {
		int result = adminRestaurantDAO.delete(restaurantNo);
		if(result == 0) {
			throw new SQLException("맛집 삭제에 실패했습니다");
		}	
	}

	@Override
	public RestaurantDTO selectByRestaurantNo(int restaurantNo) throws SQLException {
		RestaurantDTO restaurantDTO = adminRestaurantDAO.selectByRestaurantNo(restaurantNo);
		if(restaurantDTO == null) {
			throw new SQLException("맛집 정보를 가져올 수 없습니다.");
		}
		return restaurantDTO;
	}

	@Override
	public List<String> selectAllHashTag() throws SQLException {
		List<String> hashTagList = adminRestaurantDAO.selectAllHashTag();
		return hashTagList;
	}

	@Override
	public void update(RestaurantDTO restaurantDTO, String categoryDetailsName) throws SQLException {
		System.out.println("restaurantNo=" +restaurantDTO.getRestaurantNo());
		int categoryDetailsNo = adminRestaurantDAO.selectCategoryDetailsNo(categoryDetailsName);
		if(categoryDetailsNo == 0) {
			throw new SQLException("존재하지 않는 카테고리입니다.");
		}
		
		restaurantDTO.setCategoryDetailsNo(categoryDetailsNo);
		int result = adminRestaurantDAO.update(restaurantDTO);
		if(result == 0) {
			throw new SQLException("맛집 수정에 실패했습니다");
		}
		
	}
	
	

}
