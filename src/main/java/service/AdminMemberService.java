package service;

import java.sql.SQLException;
import java.util.List;

import dto.ReviewDTO;

public interface AdminMemberService {
	List<ReviewDTO> pagingSelectReview(int pageNo, String selectKey, String selectValue) throws SQLException;
	
}
