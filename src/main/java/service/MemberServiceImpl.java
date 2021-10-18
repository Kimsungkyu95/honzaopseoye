package service;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.MemberDAO;
import dao.MemberDAOImpl;
import dto.MemberDTO;

public class MemberServiceImpl implements MemberService {
	
	MemberDAO dao = new MemberDAOImpl();

	@Override
	public MemberDTO login(MemberDTO member) throws SQLException {
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
		//System.out.println("----service----");
		//System.out.println("input email : " + email);
		String memberEmail = dao.emailCheck(email);
		

		//System.out.println("memberEmail : " + memberEmail);
		//System.out.println("----service----");
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
		//System.out.println("service");
		String memberId = dao.selectIdByEmail(email);
		
		if(memberId==null) {
			//System.out.println("failed");
			
			return "failed";
		}
		
		return memberId;
	}

	@Override
	public String selectPwdByIdEmail(String id, String email) throws SQLException {
		String memberPwd = dao.selectPwdByIdEmail(id, email);
		
		if(memberPwd==null) {
			memberPwd = "failed";
		}
		
		return memberPwd;
	}
	
	@Override
	public void updateByNo(MemberDTO member) throws SQLException {
		int result = dao.updateByNo(member);
		
		if(result == 0) {
			throw new SQLException("해당 번호의 회원정보가 존재하지 않습니다.");
		}
		
	}

	@Override
	public void updateExpByNo(MemberDTO member) throws SQLException {
		int result = dao.updateExpByNo(member);
		
		if(result == 0) {
			throw new SQLException("해당 번호의 회원정보가 존재하지 않습니다.");
		}
		
	}

	@Override
	public void updateImageByNo(MemberDTO member) throws SQLException {
		int result = dao.updateImageByNo(member);
		
		if(result == 0) {
			throw new SQLException("해당 번호의 회원정보가 존재하지 않습니다.");
		}
	}

	@Override
	public void updatePwdByNo(MemberDTO member) throws SQLException {
		int result = dao.updatePwdByNo(member);
		
		if(result == 0) {
			throw new SQLException("해당 번호의 회원정보가 존재하지 않습니다.");
		}
	}

	@Override
	public void deleteByNo(int no) throws SQLException {
		int result = dao.deleteByNo(no);
		
		if(result == 0) {
			throw new SQLException("해당 번호의 회원정보가 존재하지 않습니다.");
		}
	}

	@Override
	public ArrayList<MemberDTO> selectMemberList() throws SQLException {
		ArrayList<MemberDTO> list = dao.selectMemberList();

		return list;
	}

	@Override
	public MemberDTO selectMemberByNo(int no) throws SQLException {
		MemberDTO member = dao.selectMemberByNo(no);
		
		return member;
	}

	@Override
	public void updateMemberDetail(MemberDTO member) throws SQLException {
		int result = dao.updatePwdByNo(member);
		
		if(result == 0) {
			throw new SQLException("회원정보 업데이트에 실패했습니다.");
		}
	}

}
