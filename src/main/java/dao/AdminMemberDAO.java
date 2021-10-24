package dao;

import java.sql.SQLException;
import java.util.List;

import dto.ReviewDTO;

/**
 * 관리자 리뷰 조회 / 삭제 기능 제공 DAO
 * */
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
