package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import dto.LevelUpExpDTO;
import dto.MemberDTO;
import util.DbUtil;

public class MemberDAOImpl implements MemberDAO {
	Properties proFile = new Properties();

	public MemberDAOImpl() {
		super();
		try {
			proFile.load(getClass().getClassLoader().getResourceAsStream("dbQuery.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public MemberDTO login(MemberDTO member) throws SQLException {
		MemberDTO returnValue = null;
		String id = member.getMemberID();
		String pwd = member.getMemberPwd();
				
		String sql = proFile.getProperty("member.login");
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con=DbUtil.getConnection();
			ps=con.prepareStatement(sql);
			
			ps.setString(1, id);
			ps.setString(2, pwd);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {

				String loginId = rs.getString(1);
				String loginName = rs.getString(2);
				
				returnValue = new MemberDTO(loginId, pwd, loginName);
				
			}
			
			
		} catch (Exception e) {//프로젝트 완료되고 오류 다 잡으면 catch블럭 지우는거 잊지 말기.
			e.printStackTrace();
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}

		
		return returnValue;
	}

	@Override
	public String idCheck(String id) throws SQLException {
		String returnValue = null;
				
		String sql = proFile.getProperty("member.idCheck");
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con=DbUtil.getConnection();
			ps=con.prepareStatement(sql);
			
			ps.setString(1, id);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {

				String memberId = rs.getString(1);
				
				returnValue = memberId;
				
			}
			
			
		} catch (Exception e) {//프로젝트 완료되고 오류 다 잡으면 catch블럭 지우는거 잊지 말기.
			e.printStackTrace();
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}

		
		return returnValue;
	}

	@Override
	public String emailCheck(String email) throws SQLException {
		String returnValue = null;
		
		String sql = proFile.getProperty("member.emailCheck");
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		//System.out.println("----dao----");
		//System.out.println("input email : " + email);
		
		try {
			con=DbUtil.getConnection();
			ps=con.prepareStatement(sql);
			
			ps.setString(1, email);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {

				String memberEmail = rs.getString(1);
				
				returnValue = memberEmail;
				
			}
			
			
		} catch (Exception e) {//프로젝트 완료되고 오류 다 잡으면 catch블럭 지우는거 잊지 말기.
			e.printStackTrace();
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}


		//System.out.println("returnValue : " + returnValue);
		//System.out.println("----dao----");
		return returnValue;
	}

	@Override
	public int insert(MemberDTO member) throws SQLException {
		int returnValue = 0;
		
		String sql = proFile.getProperty("member.insert");
		
		//System.out.println("sql: " + sql);
		
		Connection con = null;
		PreparedStatement ps = null;
				
		String memberId = member.getMemberID();
		String memberPwd = member.getMemberPwd();
		String memberName = member.getMemberName();
		String memberEmail = member.getMemberEmail();
		String memberPhone = member.getMemberPhone();
		String memberBirth = member.getMemberBirth();
		int memberExp = member.getMemberExp();
		
		Date birth = Date.valueOf(memberBirth);
		
		try {
			con=DbUtil.getConnection();
			ps=con.prepareStatement(sql);
			
			ps.setString(1, memberId);
			ps.setString(2, memberPwd);
			ps.setString(3, memberName);
			ps.setString(4, memberEmail);
			ps.setString(5, memberPhone);
			ps.setDate(6, birth);
			ps.setInt(7, memberExp);
			
			
			returnValue = ps.executeUpdate();
			
		} catch (Exception e) {//프로젝트 완료되고 오류 다 잡으면 catch블럭 지우는거 잊지 말기.
			e.printStackTrace();
		}finally {
			DbUtil.dbClose(ps, con);
		}

		return returnValue;
	}

	@Override
	public String selectIdByEmail(String email) throws SQLException {
		String returnValue = null;
		
		String sql = proFile.getProperty("member.selectIdByEmail");
		//System.out.println("dao");
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con=DbUtil.getConnection();
			ps=con.prepareStatement(sql);
			
			ps.setString(1, email);
			//System.out.println("dao email: " + email);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {

				String id = rs.getString(1);
				//System.out.println("id:" + id);				
				returnValue = id;
				
			}
			
			
		} catch (Exception e) {//프로젝트 완료되고 오류 다 잡으면 catch블럭 지우는거 잊지 말기.
			e.printStackTrace();
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}

		
		return returnValue;
	}

	@Override
	public int updateByNo(MemberDTO member) throws SQLException {
		int returnValue = 0;
		
		String sql = proFile.getProperty("member.updateByNo");
		
		Connection con = null;
		PreparedStatement ps = null;
		
		String memberName = member.getMemberName();
		String memberEmail = member.getMemberEmail();
		String memberPhone = member.getMemberPhone();
		String memberBirth = member.getMemberBirth();
		int memberNo = member.getMemberNo();
		
		Date birth = Date.valueOf(memberBirth);
		
		try {
			con=DbUtil.getConnection();
			ps=con.prepareStatement(sql);
			
			ps.setString(1, memberName);
			ps.setString(2, memberEmail);
			ps.setString(3, memberPhone);
			ps.setString(4, memberBirth);
			ps.setInt(5, memberNo);
			
			returnValue = ps.executeUpdate();
			
		} catch (Exception e) {//프로젝트 완료되고 오류 다 잡으면 catch블럭 지우는거 잊지 말기.
			e.printStackTrace();
		}finally {
			DbUtil.dbClose(ps, con);
		}
		return returnValue;
	}

	@Override
	public int updateImageByNo(MemberDTO member) throws SQLException {
		int returnValue = 0;
		
		String sql = proFile.getProperty("member.updateImageByNo");
		
		Connection con = null;
		PreparedStatement ps = null;
		
		String profileImage = member.getProfileImage();
		int memberNo = member.getMemberNo();
		
		try {
			con=DbUtil.getConnection();
			ps=con.prepareStatement(sql);
			
			ps.setString(1, profileImage);
			ps.setInt(2, memberNo);
			
			returnValue = ps.executeUpdate();
			
		} catch (Exception e) {//프로젝트 완료되고 오류 다 잡으면 catch블럭 지우는거 잊지 말기.
			e.printStackTrace();
		}finally {
			DbUtil.dbClose(ps, con);
		}
		return returnValue;
	}

	@Override
	public int updatePwdByNo(MemberDTO member) throws SQLException {
		int returnValue = 0;
		
		String sql = proFile.getProperty("member.updatePwdByNo");
		
		Connection con = null;
		PreparedStatement ps = null;
		
		String memberPwd = member.getMemberPwd();
		int memberNo = member.getMemberNo();
		
		try {
			con=DbUtil.getConnection();
			ps=con.prepareStatement(sql);
			
			ps.setString(1, memberPwd);
			ps.setInt(2, memberNo);
			
			returnValue = ps.executeUpdate();
			
		} catch (Exception e) {//프로젝트 완료되고 오류 다 잡으면 catch블럭 지우는거 잊지 말기.
			e.printStackTrace();
		}finally {
			DbUtil.dbClose(ps, con);
		}
		return returnValue;
	}

	@Override
	public int deleteByNo(int no) throws SQLException {
		int returnValue = 0;
		
		String sql = proFile.getProperty("member.deleteByNo");
		//delete from member where num=?
		Connection con = null;
		PreparedStatement ps = null;
		
		int memberNo = no;
		
		try {
			con=DbUtil.getConnection();
			ps=con.prepareStatement(sql);
			
			ps.setInt(1, memberNo);
			
			returnValue = ps.executeUpdate();
			
		} catch (Exception e) {//프로젝트 완료되고 오류 다 잡으면 catch블럭 지우는거 잊지 말기.
			e.printStackTrace();
		}finally {
			DbUtil.dbClose(ps, con);
		}
		return returnValue;
	}

	@Override
	public ArrayList<MemberDTO> selectMemberList() throws SQLException {
		
		String sql = proFile.getProperty("member.selectMemberList");
//member.selectMemberList=select member_no, member_id, member_name, member_join_date member_exp from member

		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
		
		try {
			con=DbUtil.getConnection();
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				int memberNo = rs.getInt(1);
				String memberId = rs.getString(2);
				String memberName = rs.getString(3);
				String joinDate = rs.getString(4);
				int memberExp = rs.getInt(5);
				
				
				MemberDTO dto = new MemberDTO(memberNo, memberId, memberName, joinDate, memberExp);
				list.add(dto);
			}
			
		} catch (Exception e) {//프로젝트 완료되고 오류 다 잡으면 catch블럭 지우는거 잊지 말기.
			e.printStackTrace();
		}finally {
			DbUtil.dbClose(ps, con);
		}
		
		return list;
	}

	@Override
	public String selectPwdByIdEmail(String id, String email) throws SQLException {
		String returnValue = null;
		
		String sql = proFile.getProperty("member.selectPwdByIdEmail");
		//System.out.println("dao");
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con=DbUtil.getConnection();
			ps=con.prepareStatement(sql);
			
			ps.setString(1, id);
			ps.setString(2, email);
			//System.out.println("dao email: " + email);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {

				String pwd = rs.getString(1);
				//System.out.println("id:" + id);				
				returnValue = pwd;
				
			}
			
			
		} catch (Exception e) {//프로젝트 완료되고 오류 다 잡으면 catch블럭 지우는거 잊지 말기.
			e.printStackTrace();
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}

		
		return returnValue;
	}

	@Override
	public MemberDTO selectMemberByNoForAdmin(int no) throws SQLException {
		MemberDTO returnValue = null;	
		String sql = proFile.getProperty("member.selectMemberByNoForAdmin");
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con=DbUtil.getConnection();
			ps=con.prepareStatement(sql);
			
			ps.setInt(1, no);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {

				int memberNo = rs.getInt(1);
				String memberID = rs.getString(2);
				String memberPwd = rs.getString(3);
				String memberName = rs.getString(4);
				String memberEmail = rs.getString(5);
				String memberPhone = rs.getString(6);
				String memberBirth = rs.getString(7);
				String joinDate = rs.getString(8);
				int memberExp = rs.getInt(9);
				String profileImage = rs.getString(10);
				
				returnValue = new MemberDTO(memberNo, memberID, memberPwd, memberName, memberEmail, memberPhone,memberBirth, joinDate, memberExp, profileImage);				
			}
		
		} catch (Exception e) {//프로젝트 완료되고 오류 다 잡으면 catch블럭 지우는거 잊지 말기.
			e.printStackTrace();
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return returnValue;
	}

	
	@Override
	public int updateMemberDetail(MemberDTO member) throws SQLException {
		int returnValue = 0;
		
		String sql = proFile.getProperty("member.updateMemberDetail");
		
		Connection con = null;
		PreparedStatement ps = null;
		
		int memberNo = member.getMemberNo();
		String memberID = member.getMemberID();
		String memberPwd = member.getMemberPwd();
		String memberName = member.getMemberName();
		String memberEmail = member.getMemberEmail();
		String memberPhone = member.getMemberPhone();
		String memberBirth = member.getMemberBirth();
		int memberExp = member.getMemberExp();
		String profileImage = member.getProfileImage();
		
		try {
			con=DbUtil.getConnection();
			ps=con.prepareStatement(sql);
			
			
			ps.setString(1, memberID);
			ps.setString(2, memberPwd);
			ps.setString(3, memberName);
			ps.setString(4, memberEmail);
			ps.setString(5, memberPhone);
			ps.setString(6, memberBirth);
			ps.setInt(7, memberExp);
			ps.setString(8, profileImage);
			ps.setInt(9, memberNo);

			
			returnValue = ps.executeUpdate();
			
		} catch (Exception e) {//프로젝트 완료되고 오류 다 잡으면 catch블럭 지우는거 잊지 말기.
			e.printStackTrace();
		}finally {
			DbUtil.dbClose(ps, con);
		}
		return returnValue;
	}

	/**
	 * myPageAccount - 계정정보 확인(아이디-수정X, 이름, 이메일, 전화번호, 생년월일)
	 */
	@Override
	public MemberDTO selectMemberByID(String id) throws SQLException {
		MemberDTO returnValue = null;	
		String sql = proFile.getProperty("member.selectMemberByID");
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con=DbUtil.getConnection();
			ps=con.prepareStatement(sql);
			
			ps.setString(1, id);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {

				String memberID = rs.getString(1);
				String memberName = rs.getString(2);
				String memberEmail = rs.getString(3);
				String memberPhone = rs.getString(4);
				String memberBirth = rs.getString(5);

				returnValue = new MemberDTO(memberID, memberName, memberEmail, memberPhone, memberBirth);				
			}
		
		} catch (Exception e) {//프로젝트 완료되고 오류 다 잡으면 catch블럭 지우는거 잊지 말기.
			e.printStackTrace();
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return returnValue;
	}

	@Override
	public LevelUpExpDTO selectExpById(String id) {
		LevelUpExpDTO returnValue = null;	
		String sql = proFile.getProperty("member.selectExpById");
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con=DbUtil.getConnection();
			ps=con.prepareStatement(sql);
			
			ps.setString(1, id);
			ps.setString(2, id);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				int minExp=rs.getInt(1);
				int maxExp=rs.getInt(2);
				int memberLevel=rs.getInt(3);
	
				returnValue = new LevelUpExpDTO(memberLevel, minExp, maxExp);			
			}
		
		} catch (Exception e) {//프로젝트 완료되고 오류 다 잡으면 catch블럭 지우는거 잊지 말기.
			e.printStackTrace();
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return returnValue;
	}

	

}
