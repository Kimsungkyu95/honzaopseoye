package dao;

import java.sql.SQLException;
import java.util.ArrayList;

import dto.LevelUpExpDTO;
import dto.MemberDTO;

public interface MemberDAO {
	
	MemberDTO login(MemberDTO member) throws SQLException;
	
	String idCheck(String id) throws SQLException;
	
	String emailCheck(String email) throws SQLException;
	
	int insert(MemberDTO member) throws SQLException;

	String selectIdByEmail(String email) throws SQLException;
	
	MemberDTO selectMemberByID(String id)throws SQLException;
	
	int updateByNo(MemberDTO member) throws SQLException;
	
	int updateImageByNo(MemberDTO member) throws SQLException;
	
	int updatePwdByNo(MemberDTO member)throws SQLException;
	
	int deleteByNo(int no) throws SQLException;
	
	MemberDTO selectMemberByNoForAdmin(int no) throws SQLException;
	
	int updateMemberDetail(MemberDTO member)throws SQLException;
	
	ArrayList<MemberDTO> selectMemberList() throws SQLException;
	
	String selectPwdByIdEmail(String id, String email) throws SQLException;

	LevelUpExpDTO selectExpById(String id);
	
	String selectPwdById(String id) throws SQLException;
}
