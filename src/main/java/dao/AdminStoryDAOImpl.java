package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.AdminStoryDTO;
import dto.RestaurantDTO;
import paging.PageCnt;
import util.DbUtil;

public class AdminStoryDAOImpl implements AdminStoryDAO{

	/**
	 * 관리자 스토리 전체 목록 띄우는 메소드
	 * @return 전체 스토리 리스트 
	 */
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
	
	/**
	 * 관리자 스토리 삭제 메소드
	 * @return 전체 스토리 리스트 
	 * @param 스토리번호
	 */
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

	 /**
     * 검색 옵션으로 검색
     * @return select 옵션에 해당하는 스토리 리스트 
	  * @param 검색옵션 key, 검색어 value
     */
	@Override
	public List<AdminStoryDTO> selectByOption(String selectKey, String selectValue) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<AdminStoryDTO> list = new ArrayList<AdminStoryDTO>();
		
		try {
			String sql="";
			switch (selectKey) {
			case "selectByMemberNo":
				sql = "select story_no,member_no,story_title,story_regdate,story_visited from story where member_no = ?";
				conn = DbUtil.getConnection();
				ps = conn.prepareStatement(sql);	
				ps.setInt(1, Integer.parseInt(selectValue));
				rs = ps.executeQuery();
				break;
			default :
				sql = "select story_no,member_no,story_title,story_regdate,story_visited from story where story_title like '%'||?||'%'";
				conn = DbUtil.getConnection();
				ps = conn.prepareStatement(sql);	
				ps.setString(1, selectValue);
				rs = ps.executeQuery();
				break;

			}
							
				while(rs.next()) {
					AdminStoryDTO dto=new AdminStoryDTO(rs.getInt(1), rs.getInt(2), 
							rs.getString(3), rs.getString(4), rs.getInt(5));
					
					list.add(dto);
				}	
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DbUtil.dbClose(rs, ps, conn);
		}			
		
		return list;

	}




}
