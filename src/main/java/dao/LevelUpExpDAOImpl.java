package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

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

}
