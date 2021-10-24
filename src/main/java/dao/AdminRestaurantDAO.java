package dao;

import java.sql.SQLException;
import java.util.List;

import dto.RestaurantDTO;

/**
 * 관리자 맛집 crud 제공 DAO
 * */
public interface AdminRestaurantDAO {
	
	/**
	 * 맛집 데이터 insert
	 * */
	int insert(RestaurantDTO restaurantDTO) throws SQLException;
	
	/**
	 * 상세카테고리 이름으로 상세카테고리 번호 알아오기
	 * */
	int selectCategoryDetailsNo(String categoryDetailsName) throws SQLException;
	
	/**
	 * 맛집 delete
	 * */
	int delete(int restaurantNo) throws SQLException;
	
	/**
	 * 맛집 update
	 * */
	int update(RestaurantDTO restaurantDTO) throws SQLException;
	
	/**
	 * 맛집 리스트 페이징 select
	 * */
	List<RestaurantDTO> pagingSelect(int pageNo, String selectKey, String selectValue) throws SQLException;
	
	/**
	 * 맛집 번호로 상세검색
	 * */
	RestaurantDTO selectByRestaurantNo(int restaurantNo) throws SQLException;
	
	/**
	 * 해시태그 리스트 받아오기
	 * */
	List<String> selectAllHashTag() throws SQLException;
	
}
