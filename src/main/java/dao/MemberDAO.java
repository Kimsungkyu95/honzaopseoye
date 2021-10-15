package dao;

import java.sql.SQLException;

import dto.MemberDTO;

public interface MemberDAO {
	
	MemberDTO login(MemberDTO member) throws SQLException;
	
	String idCheck(String id) throws SQLException;
	
	String emailCheck(String email) throws SQLException;
	
	int insert(MemberDTO member) throws SQLException;

	String selectIdByEmail(String email) throws SQLException;
}
