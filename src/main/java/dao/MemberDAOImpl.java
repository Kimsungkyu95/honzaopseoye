package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

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
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con=DbUtil.getConnection();
			ps=con.prepareStatement(sql);
			
			ps.setString(1, email);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {

				String id = rs.getString(1);
				
				returnValue = id;
				
			}
			
			
		} catch (Exception e) {//프로젝트 완료되고 오류 다 잡으면 catch블럭 지우는거 잊지 말기.
			e.printStackTrace();
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}

		
		return returnValue;
	}
	
	

}
