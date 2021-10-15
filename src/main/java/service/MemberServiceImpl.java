package service;

import java.sql.SQLException;

import dao.MemberDAO;
import dao.MemberDAOImpl;
import dto.MemberDTO;

public class MemberServiceImpl implements MemberService {
	
	MemberDAO dao = new MemberDAOImpl();

	@Override
	public MemberDTO login(MemberDTO member, boolean remember) throws SQLException {
		MemberDTO returnValue = dao.login(member);
		
		if(returnValue == null) {
			throw new SQLException("아이디와 비밀번호가 일치하는 회원정보를 찾지 못했습니다.");
		}
		return returnValue;
	}

	@Override
	public String idCheck(String id) throws SQLException {
		String memberId = dao.idCheck(id);
		
		return memberId;
	}

	@Override
	public String emailCheck(String email) throws SQLException {
		String memberEmail = dao.idCheck(email);
		
		return memberEmail;
	}

	@Override
	public void insert(MemberDTO member) throws SQLException {
		int result = dao.insert(member);
		
		if(result == 0) {
			//throw new SQLException("회원 가입에 실패했습니다.");
		}
		
	}

	@Override
	public String selectIdByEmail(String email) throws SQLException {
		String memberId = dao.idCheck(email);
		
		if(memberId==null) {
			return "이메일에 해당하는 회원 정보를 찾을 수 없습니다.";
		}
		
		return memberId;
	}
	
	

}
