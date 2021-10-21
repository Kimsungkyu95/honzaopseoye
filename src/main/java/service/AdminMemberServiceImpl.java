package service;

import java.sql.SQLException;
import java.util.List;

import dao.AdminMemberDAO;
import dao.AdminMemberDAOImpl;
import dto.ReviewDTO;

public class AdminMemberServiceImpl implements AdminMemberService {
	
	private AdminMemberDAO adminMemberDAO = new AdminMemberDAOImpl();
	
	@Override
	public List<ReviewDTO> pagingSelectReview(int pageNo, String selectKey, String selectValue) throws SQLException {
		
		List<ReviewDTO> reviewList = adminMemberDAO.pagingSelectReview(pageNo, selectKey, selectValue);
		return reviewList;
	}

	@Override
	public void adminDeleteReview(int reviewNo) throws SQLException {
		if(adminMemberDAO.adminDeleteReview(reviewNo) == 0) {
			throw new SQLException("리뷰가 삭제되지 않았습니다.");
		}
		
	}

}
