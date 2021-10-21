package service;

import java.sql.SQLException;
import java.util.List;

import dto.ReviewDTO;

public interface AdminMemberService {
	
	/**
	 * 리뷰리스트페이징
	 * */
	List<ReviewDTO> pagingSelectReview(int pageNo, String selectKey, String selectValue) throws SQLException;
	
	/**
	 * 리뷰 delete
	 * */
	void adminDeleteReview(int reviewNo) throws SQLException;
	
}
