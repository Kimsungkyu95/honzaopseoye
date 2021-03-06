package service;

import java.sql.SQLException;
import java.util.List;

import dto.RestaurantDTO;

/**
 * 관리자 맛집 crud 제공 서비스
 * */
public interface AdminRestaurantService {
	/**
	 * 맛집 데이터 insert
	 * */
	void insert(RestaurantDTO restaurantDTO, String categoryDetailsName) throws SQLException;
	
	/**
	 * 맛집 delete
	 * */
	void delete(int restaurantNo) throws SQLException;

	/**
	 * 맛집 update
	 * */
	void update(RestaurantDTO restaurantDTO, String categoryDetailsName) throws SQLException;
	
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
