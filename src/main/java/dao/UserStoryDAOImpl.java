package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import dto.StoryDTO;
import dto.StoryImgDTO;
import util.DbUtil;

public class UserStoryDAOImpl implements UserStoryDAO {
	Properties proFile = new Properties();
	
	public UserStoryDAOImpl() {
		   try {
		     proFile.load(getClass().getClassLoader().getResourceAsStream("dbQuery.properties"));
		   }catch (Exception e) {
			e.printStackTrace();
		  }
	   }
	
	@Override
	public List<StoryDTO> selectAll() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null; 
		
		List<StoryDTO> storyList = new ArrayList<StoryDTO>();
		String sql = proFile.getProperty("userStory.select");
//		userStory.select=select story_no,story_title,member_id,story_visited from story natural join member order by story_regdate desc
		
		try {
			con = DbUtil.getConnection();
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			
			while(rs.next()) { 
				StoryDTO story = new StoryDTO();
				story.setStoryNo(rs.getInt(1));
				story.setStoryTitle(rs.getString(2));
				story.setMemberId(rs.getString(3));
				story.setStoryVisited(rs.getInt(4));
				
				storyList.add(story);
			}
		}catch(SQLException e) {
			e.printStackTrace();	
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}
		
		return storyList;
	}
	
	@Override
	public StoryDTO selectByStoryNo(int storyNo) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		StoryDTO storyDTO=null;
		String sql = proFile.getProperty("userStory.selectByStoryNo");
//		select story_no,story_title,member_id,story_visited,restaurant_name,story_content,story_regdate from story natural join member where story_no=?
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, storyNo);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				storyDTO = new StoryDTO();
				storyDTO.setStoryNo(rs.getInt(1));
				storyDTO.setStoryTitle(rs.getString(2));
				storyDTO.setMemberId(rs.getString(3));
				storyDTO.setStoryVisited(rs.getInt(4));
				storyDTO.setRestaurantName(rs.getString(5));
				storyDTO.setStoryContent(rs.getString(6));
				storyDTO.setStoryRegdate(rs.getString(7));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		finally {
			DbUtil.dbClose(rs, ps, con);
		}
		
		return storyDTO;
	}

	@Override
	public int insertStory(StoryDTO storyDTO) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		String sql = proFile.getProperty("userStory.insert");
//		userStory.insert=insert into story values(STORY_SEQ.NEXTVAL,?,?,?,?,SYSDATE,0,?)
		
		try {
			con = DbUtil.getConnection();
			con.setAutoCommit(false);
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, 1);
			ps.setString(2, storyDTO.getStoryTitle());
			ps.setString(3, storyDTO.getRestaurantName());
			ps.setString(4, storyDTO.getStoryContent());
			ps.setString(5, storyDTO.getStoryPassword());
			
			result = ps.executeUpdate();
			
			List<String> storyImgList = storyDTO.getStoryImgList();
			//이미지 리스트에 이미지가 있는경우
			if(storyImgList.size() >= 1) {
				int imgResult = insertStoryImg(storyImgList, con);
			}
			
			con.commit();
		}finally {
			DbUtil.dbClose(ps, con);
		}
		
		return result;
	}

	public int insertStoryImg(List<String> storyImgList, Connection con) throws SQLException {
		PreparedStatement ps=null;
		int result=0;
		String sql = proFile.getProperty("userStoryImg.insert");
//		userStoryImg.insert=insert into story_img values(STORY_IMG_SEQ.NEXTVAL, STORY_SEQ.CURRVAL, ?)
		
		try {
			ps = con.prepareStatement(sql);
			
			for(String storyImg: storyImgList) {
				ps.setString(1, storyImg);
			
				result = ps.executeUpdate();
				
				if(result == 0) {
					throw new SQLException("스토리 이미지 삽입에 실패했습니다.");
				}
			}
		}finally {
			DbUtil.dbClose(ps, null);
		}
		
		return result;
	}

	@Override
	public int updateStory(StoryDTO storyDTO) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		String sql = proFile.getProperty("userStory.update");
//		userStory.update=update story set story_title=?,restaurant_name=?,story_content=? where story_no=? and story_password=?
		
		try {
			con = DbUtil.getConnection();
			con.setAutoCommit(false);
			ps = con.prepareStatement(sql);
			
			ps.setString(1, storyDTO.getStoryTitle());
			ps.setString(2, storyDTO.getRestaurantName());
			ps.setString(3, storyDTO.getStoryContent());
			ps.setInt(4, storyDTO.getStoryNo());
			ps.setString(5, storyDTO.getStoryPassword());
			
			result = ps.executeUpdate();
			
			List<String> storyImgList = storyDTO.getStoryImgList();
			//이미지 리스트에 이미지가 있는경우
			if(storyImgList.size() >= 1) {
				int imgResult = insertStoryImg(storyImgList, con);
			}
			
			con.commit();
		}finally {
			DbUtil.dbClose(ps, con);
		}
		
		return result;
	}

	public int updateStoryImg(List<String> storyImgList, Connection con, int storyNo) throws SQLException {
		PreparedStatement ps=null;
		int result=0;
		String sql = proFile.getProperty("userStoryImg.update");
//		userStoryImg.update=update story_img set story_img=? where story_img_no=?
		
		try {
			ps = con.prepareStatement(sql);
			
			for(String storyImg: storyImgList) {
				ps.setString(1, storyImg);
				ps.setInt(2, storyNo);
				
				result = ps.executeUpdate();
				
				if(result == 0) {
					throw new SQLException("스토리 이미지 삽입에 실패했습니다.");
				}
			}
		}finally {
			DbUtil.dbClose(ps, null);
		}
		
		return result;
	}
	
	@Override
	public int deleteStory(int storyNo, String password) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		String sql = proFile.getProperty("userStory.delete");
//		userStory.delete=delete from story where story_no=? and password=?
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, storyNo);
			ps.setString(2, password);
			
			result = ps.executeUpdate();
		}finally {
			DbUtil.dbClose(ps, con);
		}
		
		return result;
	}

	@Override
	public int increamentByStoryVisited(int storyNo) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		String sql = proFile.getProperty("userStory.updateStoryVisited");
//		userStory.updateStoryVisited=update story set story_visited=story_visited+1 where story_no=?
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, storyNo);
			
			result = ps.executeUpdate();
		}finally {
			DbUtil.dbClose(ps, con);
		}
		
		return result;
	}
}
