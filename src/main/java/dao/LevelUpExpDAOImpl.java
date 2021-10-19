package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import dto.LevelUpExpDTO;
import dto.MemberDTO;
import util.DbUtil;

public class LevelUpExpDAOImpl implements LevelUpExpDAO {
	Properties proFile = new Properties();
	
	

	public LevelUpExpDAOImpl() {
		super();
		try {
			proFile.load(getClass().getClassLoader().getResourceAsStream("dbQuery.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



	@Override
	public int selectMinExpByMemberLevel(int memberLevel) throws SQLException {
		int minExp=-1;
				
		String sql = proFile.getProperty("levelUp.selectMinExpByMemberLevel");
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con=DbUtil.getConnection();
			ps=con.prepareStatement(sql);
			
			ps.setInt(1, memberLevel);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {

				minExp = rs.getInt(1);
				
			}
			
			
		} catch (Exception e) {//프로젝트 완료되고 오류 다 잡으면 catch블럭 지우는거 잊지 말기.
			e.printStackTrace();
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}

		
		return minExp;
	}



	@Override
	public int selectMemberLevelByExp(int exp) throws SQLException {
		int memberLevel=-1;
		
		String sql = proFile.getProperty("levelUp.selectMemberLevelByExp");
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con=DbUtil.getConnection();
			ps=con.prepareStatement(sql);
			
			ps.setInt(1, exp);
			ps.setInt(2, exp);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {

				memberLevel = rs.getInt(1);
				
			}
			
			
		} catch (Exception e) {//프로젝트 완료되고 오류 다 잡으면 catch블럭 지우는거 잊지 말기.
			e.printStackTrace();
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}
		
		return memberLevel;
	}


	/**
	 * 현재 레벨을 입력하면 다음 레벨까지 경험치가 얼마나 남았는지 알려주는 메소드
	 * @return 다음 레벨까지 남은 경험치. 리턴값이 -1이면 뭔가 문제가 생김. 0이면 현재 만렙이라는 뜻.
	 * */
	@Override
	public int remainingExp(int memberExp) throws SQLException {
		int remainingExp = -1;
		
		//현재 레벨
		int currentLevel = this.selectMemberLevelByExp(memberExp);
		
		//다음 레벨
		int nextLevel = this.nextLevel(currentLevel);
		
		if(nextLevel == currentLevel) { //만약에 다음레벨이 현재레벨이랑 동일하면..
			//만렙이니까 0 리턴.
			return 0;
		}
		
		//다음 레벨의 최소 레벨
		int minExpforNextLevel=this.selectMinExpByLevel(nextLevel);
		
		//남은 exp = 다음레벨의 최소레벨 - 현재 exp
		remainingExp = minExpforNextLevel - memberExp;
		
		return remainingExp;
	}
	
	/**
	 * 현재 레벨을 입력하면 다음 레벨을 알려주는 메소드
	 * @return 다음 레벨. 결과값이 -1이면 오류. 만랩(7)일 경우 그냥 현재 레벨을 리턴함.
	 * */
	private int nextLevel(int currentLevel) {
		int nextLevel=-1;
		
		if(currentLevel>=7) {
			nextLevel=currentLevel;
		}else {
			nextLevel=currentLevel+1;
		}
		return nextLevel;
	}
	
	/**
	 * 해당 레벨의 최소 경험이를 알려주는 메소드
	 * @return 해당 레벨의 최소 경험치. -1이면 오류.
	 * */
	public int selectMinExpByLevel(int memberLevel) throws SQLException {
		int minExp=-1;
		String sql = proFile.getProperty("levelUp.selectMinExpByMemberLevel");
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con=DbUtil.getConnection();
			ps=con.prepareStatement(sql);
			
			ps.setInt(1, memberLevel);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {

				minExp = rs.getInt(1);
				
			}
			
		} catch (Exception e) {//프로젝트 완료되고 오류 다 잡으면 catch블럭 지우는거 잊지 말기.
			e.printStackTrace();
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return minExp;
	}
	
	

}
