package service;

import java.sql.SQLException;
import java.util.ArrayList;

import dto.LevelUpExpDTO;
import dto.MemberDTO;
import dto.RestaurantDTO;
import dto.ReviewContentDTO;
import dto.ReviewDTO;

public interface MemberService {
	MemberDTO login(MemberDTO member) throws SQLException ;
	
	String idCheck(String id) throws SQLException;
	
	String emailCheck(String email) throws SQLException;
	
	void insert(MemberDTO member) throws SQLException;
	
	String selectIdByEmail(String email) throws SQLException;
	
	String selectPwdByIdEmail(String id, String email) throws SQLException;

	MemberDTO selectMemberByID(String id) throws SQLException;
	
	void updateByNo(MemberDTO member) throws SQLException;
	
	void updateImageByNo(MemberDTO member) throws SQLException;
	
	void updatePwdById(MemberDTO member)throws SQLException;
	
	void deleteByNo(int no) throws SQLException;
	
	ArrayList<MemberDTO> selectMemberList() throws SQLException;
	
	MemberDTO selectMemberByNoForAdmin(int no) throws SQLException;
	
	void updateMemberDetail(MemberDTO member)throws SQLException;
	
	LevelUpExpDTO selectExpById(String membeID)throws SQLException;
	
	String MemberSelectPwdById(String id) throws SQLException;
	
	ArrayList<ReviewContentDTO> selectReviewList(String memberID) throws SQLException;

	String selectProfileImageById(String id) throws SQLException;
	
	void updateProfileImageById(String memberId, String profileImage) throws SQLException;
	
	void updateByNoForAdmin(MemberDTO member)throws SQLException;

	void insertReview(String loginId, ReviewDTO reviewDTO) throws SQLException;
}
