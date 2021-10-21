package dao;

import java.sql.SQLException;
import java.util.List;

import dto.ReviewDTO;


public interface AdminMemberDAO {
	
	/**
	 * 리뷰 리스트 페이징
	 * */
	List<ReviewDTO> pagingSelectReview(int pageNo, String selectKey, String selectValue) throws SQLException;
	
	/**
	 * 리뷰 delete
	 * */
	int adminDeleteReview(int reviewNo) throws SQLException;
}
