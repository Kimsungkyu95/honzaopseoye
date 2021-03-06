package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import org.apache.catalina.valves.RemoteIpValve;

import dto.LevelUpExpDTO;
import dto.MemberDTO;
import dto.RestaurantDTO;
import dto.ReviewContentDTO;
import dto.ReviewDTO;
import util.DbUtil;

/**
 * DB의 member 테이블 관련 기능들을 모아둔 데이터베이스 액세스 클래스 
 * */
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

	/**
	 *  아이디, 비밀번호를 입력받아서 아이디와 이름을 리턴하여 로그인을 하게 해주는 메소드
	 *  @return MemberDTO (아이디, 이름만 있음)
	 * */
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
			
			
		} /*
			 * catch (Exception e) {//프로젝트 완료되고 오류 다 잡으면 catch블럭 지우는거 잊지 말기.
			 * e.printStackTrace(); }
			 */finally {
			DbUtil.dbClose(rs, ps, con);
		}

		
		return returnValue;
	}

	/**
	 * 아이디를 입력받아서 중복되는 아이디가 있는지 찾아주는 메소드
	 * @return 데이터 베이스에 존재하는 아이디. 없으면 null 리턴.
	 * */
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
			
			
		} /*
			 * catch (Exception e) {//프로젝트 완료되고 오류 다 잡으면 catch블럭 지우는거 잊지 말기.
			 * e.printStackTrace(); }
			 */finally {
			DbUtil.dbClose(rs, ps, con);
		}

		
		return returnValue;
	}
	
	/**
	 * 이메일을 입력받아서 중복되는 이메일이 있는지 찾아주는 메소드
	 * @return 데이터베이스에 존재하는 이메일. 없으면 null 리턴.
	 * */
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
			
			
		} /*
			 * catch (Exception e) {//프로젝트 완료되고 오류 다 잡으면 catch블럭 지우는거 잊지 말기.
			 * e.printStackTrace(); }
			 */finally {
			DbUtil.dbClose(rs, ps, con);
		}


		//System.out.println("returnValue : " + returnValue);
		//System.out.println("----dao----");
		return returnValue;
	}

	/**
	 * 회원 가입을 위한 데이터 삽입 메소드. id, pwd, name, email, phone, birth, exp를 입력 받는다.
	 * member_no는 시퀀스로 관리되며 가입일은 sysdate로 자동으로 입력된다.
	 * @return 가입 성공시 1 이상의 숫자. 가입 실패시 0.
	 * */
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
			
		} /*
			 * catch (Exception e) {//프로젝트 완료되고 오류 다 잡으면 catch블럭 지우는거 잊지 말기.
			 * e.printStackTrace(); }
			 */finally {
			DbUtil.dbClose(ps, con);
		}

		return returnValue;
	}

	/**
	 * 아이디 찾기용 메소드. 이메일을 입력하면 해당 이메일로 가입된 아이디를 리턴해준다.
	 * @return 이메일에 해당하는 아이디. 없으면 null 리턴. 
	 * */
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
			
			
		} /*
			 * catch (Exception e) {//프로젝트 완료되고 오류 다 잡으면 catch블럭 지우는거 잊지 말기.
			 * e.printStackTrace(); }
			 */finally {
			DbUtil.dbClose(rs, ps, con);
		}

		
		return returnValue;
	}

	/**
	 * 회원 정보 수정용 메소드. 이름, 이메일, 전화번호, 생일을 바꿀 수 있다.
	 * @return 성공하면 1 이상의 숫자. 실패시 0 리턴.
	 * */
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
			
		} /*
			 * catch (Exception e) {//프로젝트 완료되고 오류 다 잡으면 catch블럭 지우는거 잊지 말기.
			 * e.printStackTrace(); }
			 */finally {
			DbUtil.dbClose(ps, con);
		}
		return returnValue;
	}

	/**
	 * 프로필 사진 수정용 메소드. DB에 저장된 프로필 사진 이름을 바꿔준다.
	 * @return 성공하면 1 이상의 숫자. 실패시 0을 리턴.
	 * */
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
			
		} /*
			 * catch (Exception e) {//프로젝트 완료되고 오류 다 잡으면 catch블럭 지우는거 잊지 말기.
			 * e.printStackTrace(); }
			 */finally {
			DbUtil.dbClose(ps, con);
		}
		return returnValue;
	}

	/**
	 * 비밀번호 변경용 메소드. 아이디와 비밀번호를 가진 MemberDTO 객체를 받아서 비밀번호를 업데이트 해준다.
	 * @return 성공하면 1 이상의 숫자. 실패시 0을 리턴. 
	 * */
	@Override
	public int updatePwdById(MemberDTO member) throws SQLException {
		int returnValue = 0;
		
		String sql = proFile.getProperty("member.updatePwdById");
		
		Connection con = null;
		PreparedStatement ps = null;
		
		String memberPwd = member.getMemberPwd();
		String memberId = member.getMemberID();
		
		try {
			con=DbUtil.getConnection();
			ps=con.prepareStatement(sql);
			
			ps.setString(1, memberPwd);
			ps.setString(2, memberId);
			
			returnValue = ps.executeUpdate();
			
		} /*
			 * catch (Exception e) {//프로젝트 완료되고 오류 다 잡으면 catch블럭 지우는거 잊지 말기.
			 * e.printStackTrace(); }
			 */finally {
			DbUtil.dbClose(ps, con);
		}
		return returnValue;
	}

	/**
	 * 회원 탈퇴혹은 삭제용 메소드. 회원번호를 입력받아서 번호에 해당하는 회원 레코드를 테이블에서 삭제한다.
	 * @return 성공하면 1 이상의 숫자. 실패시 0을 리턴.
	 * */
	@Override
	public int deleteByNo(int no) throws SQLException {
		int returnValue = 0;
		
		String sql = proFile.getProperty("member.deleteByNo");
		Connection con = null;
		PreparedStatement ps = null;
		
		int memberNo = no;
		
		try {
			con=DbUtil.getConnection();
			ps=con.prepareStatement(sql);
			
			ps.setInt(1, memberNo);
			
			returnValue = ps.executeUpdate();
			
		} /*
			 * catch (Exception e) {//프로젝트 완료되고 오류 다 잡으면 catch블럭 지우는거 잊지 말기.
			 * e.printStackTrace(); }
			 */finally {
			DbUtil.dbClose(ps, con);
		}
		return returnValue;
	}

	/**
	 * 회원이 작성한 리뷰리스트를 조회하는 메소드
	 * @return 리뷰가 존재하지 않으면 null리턴
	 * */
	@Override
	public ArrayList<MemberDTO> selectMemberList() throws SQLException {
		
		String sql = proFile.getProperty("member.selectMemberList");
		
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

	/**
	 * 비밀번호 확인용 메소드. 회원의 아이디와 이메일을 입력하면 비밀번호를 리턴해준다.
	 * @return 아이디와 이메일이 일치하는 비밀번호. 실패시 null을 리턴.
	 * */
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
			
			
		} /*
			 * catch (Exception e) {//프로젝트 완료되고 오류 다 잡으면 catch블럭 지우는거 잊지 말기.
			 * e.printStackTrace(); }
			 */finally {
			DbUtil.dbClose(rs, ps, con);
		}

		
		return returnValue;
	}
	
	/**
	 * 관리자가 회원목록 조회메소드
	 * @return 없거나 실패하면 null리턴
	 */
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

	/**
	 * 관리자가 회원정보 수정메소드
	 * @return 실패시 0을 리턴
	 */
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
	 * 회원 정보 조회(아이디, 이름, 이메일, 전화번호, 생년월일)메소드
	 * @return 실패시 null리턴
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
				int memberNo = rs.getInt(1);
				String memberID = rs.getString(2);
				String memberName = rs.getString(3);
				String memberEmail = rs.getString(4);
				String memberPhone = rs.getString(5);
				String memberBirth = rs.getString(6);

				returnValue = new MemberDTO(memberNo, memberID, memberName, memberEmail, memberPhone, memberBirth);				
			}
		
		} catch (Exception e) {//프로젝트 완료되고 오류 다 잡으면 catch블럭 지우는거 잊지 말기.
			e.printStackTrace();
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return returnValue;
	}

	/**
	 * 회원 경험치 확인용 메소드. 아이디를 입력하면 해당 회원의 경험치 정보를 리턴한다.
	 * @return 해당 회원의 경험치 정보가 담긴 LevelUpExpDTO. 실패시 null을 리턴.
	 * */
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
			ps.setString(3, id);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				
				int minExp=rs.getInt(1);
				int maxExp=rs.getInt(2);
				int memberLevel=rs.getInt(3);
				int memberExp=rs.getInt(4);
	
				returnValue = new LevelUpExpDTO(memberExp, memberLevel, minExp, maxExp);			
			}
		
		} catch (Exception e) {//프로젝트 완료되고 오류 다 잡으면 catch블럭 지우는거 잊지 말기.
			e.printStackTrace();
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return returnValue;
	}

	/**
	 * 비밀번호 확인용 메소드. 아이디를 입력하면 비밀번호를 알려준다.
	 * @return String 비밀번호. 실패시 null을 리턴.
	 * */
	@Override
	public String selectPwdById(String id) throws SQLException {
		String pwd = null;	
		String sql = proFile.getProperty("member.selectPwdById");
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con=DbUtil.getConnection();
			ps=con.prepareStatement(sql);
			
			ps.setString(1, id);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				
				pwd=rs.getString(1);		
			}
		
		} /*
			 * catch (Exception e) {//프로젝트 완료되고 오류 다 잡으면 catch블럭 지우는거 잊지 말기.
			 * e.printStackTrace(); }
			 */finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return pwd;
	}

	/**
	 * 회원 리뷰리스트 조회 메소드
	 * @return 없거나 실패시 null리턴
	 */
	@Override
	public ArrayList<ReviewContentDTO> selectReviewList(String id) throws SQLException {
		String sql = proFile.getProperty("member.selectReviewList");
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		ArrayList<ReviewContentDTO> list = new ArrayList<ReviewContentDTO>();
		
		try {
			con=DbUtil.getConnection();
			ps=con.prepareStatement(sql);
			ps.setString(1, id);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				
				int restaurantNo=rs.getInt(1);
				int restaurantLevel=rs.getInt(2);
				String restaurantName=rs.getString(3);
				
				int reviewScore=rs.getInt(4);
				String reviewContent=rs.getString(5);
				String reviewRegdate=rs.getString(6);
				
				ReviewContentDTO reviceContent = new ReviewContentDTO(restaurantNo, restaurantLevel, restaurantName, reviewScore, reviewContent, reviewRegdate);
				
				list.add(reviceContent);
			}
			
		} catch (Exception e) {//프로젝트 완료되고 오류 다 잡으면 catch블럭 지우는거 잊지 말기.
			e.printStackTrace();
		}finally {
			DbUtil.dbClose(ps, con);
		}
		
		return list;
	}

	/**
	 * 프로필 이미지 확인용 메소드. 아이디를 입력하면 프로필 이미지 파일 이름을 리턴해준다.
	 * @return 프로필 이미지 파일 이름. 실패시 null을 리턴.
	 * */
	@Override
	public String selectProfileImageById(String id) throws SQLException {
		String profileImage = null;	
		String sql = proFile.getProperty("member.selectMemberByIDforImg");
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		//System.out.println("dao id : " + id);
		try {
			con=DbUtil.getConnection();
			ps=con.prepareStatement(sql);
			
			ps.setString(1, id);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				//System.out.println("dao: has next");
				profileImage=rs.getString(1);		
			}
		
		} /*
			 * catch (Exception e) {//프로젝트 완료되고 오류 다 잡으면 catch블럭 지우는거 잊지 말기.
			 * e.printStackTrace(); }
			 */finally {
			DbUtil.dbClose(rs, ps, con);
		}
		//System.out.println("dao : " +profileImage );
		return profileImage;
	}

	/**
	 * 프로필 이미지 수정용 메소드. 아이디와 수정할 이미지 파일 이름을 입력.
	 * @return 성공시 1 이상의 숫자. 실패시 0을 리턴.
	 * */
	@Override
	public int updupdateProfileImageById(String memberId, String profileImage) throws SQLException {
int returnValue = 0;
		
		String sql = proFile.getProperty("member.updateImageById");
		
		Connection con = null;
		PreparedStatement ps = null;
				
		try {
			con=DbUtil.getConnection();
			ps=con.prepareStatement(sql);
			
			ps.setString(1, profileImage);
			ps.setString(2, memberId);
			
			returnValue = ps.executeUpdate();
			
		} /*
			 * catch (Exception e) {//프로젝트 완료되고 오류 다 잡으면 catch블럭 지우는거 잊지 말기.
			 * e.printStackTrace(); }
			 */finally {
			DbUtil.dbClose(ps, con);
		}
		return returnValue;
	}
	
	/**
	 * 관리자가 회원정보 수정메소드 
	 * @return 실패시0리턴 
	 */
	@Override
	public int updateByNoForAdmin(MemberDTO member) throws SQLException {
		int returnValue = 0;
		
		String sql = proFile.getProperty("member.updateByNoForAdmin");
		
		Connection con = null;
		PreparedStatement ps = null;
		
		String memberID = member.getMemberID();
		String memberPwd = member.getMemberPwd();
		String memberName = member.getMemberName();
		String memberEmail = member.getMemberEmail();
		String memberPhone = member.getMemberPhone();
		String memberBirth = member.getMemberBirth();
		String memberJoinDate = member.getMemberJoinDate();
		int memberExp = member.getMemberExp();
		int memberNo = member.getMemberNo();
		
		try {
			con=DbUtil.getConnection();
			ps=con.prepareStatement(sql);
			
			
			ps.setString(1, memberID);
			ps.setString(2, memberPwd);
			ps.setString(3, memberName);
			ps.setString(4, memberEmail);
			ps.setString(5, memberPhone);
			ps.setString(6, memberBirth);
			ps.setString(7, memberJoinDate);
			ps.setInt(8, memberExp);
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
	 * 회원 번호 확인용 메소드. 아이디를 입력하면 해당 회원의 번호를 알려준다.
	 * @return int값의 회원 번호. 실패시 0을 리턴.
	 * */
	public int selectMemberId(String loginId) throws SQLException{
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = 0;
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement("select member_no from member where member_id = ?");
			ps.setString(1, loginId);
			rs = ps.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
			
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return result;
	}
	

	public int giveExp(int memberNo, int restaurantNo, Connection con) throws SQLException{
		PreparedStatement ps = null;
		int result = 0;
		try {
			ps = con.prepareStatement("update member set member_exp = member_exp + (select give_exp from restaurant natural join levelgive_exp where restaurant_no = ?) where member_no = ?");
			ps.setInt(1, restaurantNo);
			ps.setInt(2, memberNo);
			result = ps.executeUpdate();
			
		}finally {
			DbUtil.dbClose(ps, null);
		}
				
		return result;
	}
	
	/**
	 * 리뷰등록메소드 
	 * @return 실패시 0리턴
	 */
	@Override
	public int insertReview(String loginId, ReviewDTO reviewDTO) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int memberNo = selectMemberId(loginId);
		int result = 0;
		try {
			con = DbUtil.getConnection();
			con.setAutoCommit(false);
			
			ps = con.prepareStatement("insert into review values(review_seq.nextval, ?, ?, ?, ?, sysdate)");
			ps.setInt(1, memberNo);
			ps.setInt(2, reviewDTO.getRestaurantNo());
			ps.setInt(3, reviewDTO.getReviewScore());
			ps.setString(4, reviewDTO.getReviewContent());			
			result = ps.executeUpdate();
			
			if(giveExp(memberNo, reviewDTO.getRestaurantNo(), con) == 0) {
				throw new SQLException("리뷰에 따른 경험치를 올리지 못했습니다.");
			}	
			
			con.commit();
		}finally {
			DbUtil.dbClose(ps, con);
		}
				
		return result;
		
	}	
	
}
