package service;

import java.sql.SQLException;

import dto.MemberDTO;

public interface MemberService {
	MemberDTO login(MemberDTO member) throws SQLException ;
	
	String idCheck(String id) throws SQLException;
	
	String emailCheck(String email) throws SQLException;
	
	void insert(MemberDTO member) throws SQLException;
	
	String selectIdByEmail(String email) throws SQLException;
	
	String selectPwdByIdEmail(String id, String email) throws SQLException;

}
