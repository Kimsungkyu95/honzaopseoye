package dao;

import java.sql.SQLException;
import java.util.ArrayList;

import dto.MemberDTO;

public interface MemberDAO {
	
	MemberDTO login(MemberDTO member) throws SQLException;
	
	String idCheck(String id) throws SQLException;
	
	String emailCheck(String email) throws SQLException;
	
	int insert(MemberDTO member) throws SQLException;

	String selectIdByEmail(String email) throws SQLException;
	
	int updateByNo(MemberDTO member) throws SQLException;
	
	int updateLevelByNo(int exp) throws SQLException;
	
	int updateImageByNo(String image) throws SQLException;
	
	int updatePwdByNo(String pwd)throws SQLException;
	
	int deleteByNo(int no) throws SQLException;
	
	ArrayList<MemberDTO> memberList() throws SQLException;
}
