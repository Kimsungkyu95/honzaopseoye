package dao;

import java.sql.SQLException;
import java.util.List;

import dto.ReviewDTO;


public interface AdminMemberDAO {
	List<ReviewDTO> pagingSelectReview(int pageNo, String selectKey, String selectValue) throws SQLException;
}
