package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.AdminStoryDTO;
import dto.StoryDTO;
import util.DbUtil;

public class AdminStoryDAOImpl implements AdminStoryDAO{

	@Override
	public List<AdminStoryDTO> selectAll() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null; 
		List<AdminStoryDTO> list = new ArrayList<AdminStoryDTO>();
		String sql = "select story_no,member_no,story_title,story_regdate,story_visited from story order by story_no";
		try {
			con = DbUtil.getConnection();
			ps=con.prepareStatement(sql);

			rs=ps.executeQuery();
			while(rs.next()) { 
				AdminStoryDTO storylist=new AdminStoryDTO(rs.getInt(1), rs.getInt(2), 
						rs.getString(3), rs.getString(4), rs.getInt(5));
				list.add(storylist);
			}
		}catch(SQLException e) {
			e.printStackTrace();	
		}finally {
			DbUtil.dbClose(rs, ps, con);
			
		}
		
		return list;
	}
	
	@Override
	public int deleteByStoryNo(int storyNo){
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		String sql = "delete from story where story_no=?";
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, storyNo);
			result = ps.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DbUtil.dbClose(ps, con);
		}
		
		return result;
	}

}
