package service;

import java.sql.SQLException;
import java.util.List;

import dto.ReviewDTO;

/**
 * 관리자 리뷰 조회 / 삭제 기능 제공 서비스
 * */
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
