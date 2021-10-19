package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import dto.StoryDTO;
import dto.StoryDetailsDTO;
import dto.StoryImageDTO;
import util.DbUtil;

public class StoryDAOImpl implements StoryDAO {
	Properties proFile = new Properties();
	
	public StoryDAOImpl() {
		   try {
		     proFile.load(getClass().getClassLoader().getResourceAsStream("dbQuery.properties"));
		     
		     System.out.println("query : " + proFile.getProperty("userStory.select"));
		     
		   }catch (Exception e) {
			e.printStackTrace();
		  }
	   }

	@Override
	public StoryDTO selectByStoryNo(String storyNo) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StoryDetailsDTO selectByStoryDetailsNo(String storyDetailsNo) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StoryImageDTO selectByStoryImgNo(String storyImgNo) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertStory(StoryDTO storyDTO) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		String sql = proFile.getProperty("userStory.insert");
//		userStory.insert=insert into story values(STORY_SEQ.NEXTVAL, ?, ?, SYSDATE, ?)
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, storyDTO.getMemberNo());
			ps.setString(2, storyDTO.getStoryTitle());
			ps.setInt(3, storyDTO.getStoryVisited());
			
			result = ps.executeUpdate();
		}finally {
			DbUtil.dbClose(ps, con);
		}
		
		return result;
	}

	@Override
	public int insertStoryDetails(StoryDetailsDTO storyDetailsDTO) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		String sql = proFile.getProperty("userStoryDetails.insert");
//		userStoryDetails.insert=insert into story_details(STORY_DETAILS_SEQ.NEXTVAL, ?, STORY_SEQ.CURRVAL, ?)
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, storyDetailsDTO.getRestaurantNo());
			ps.setString(2, storyDetailsDTO.getStoryContent());
			
			result = ps.executeUpdate();
		}finally {
			DbUtil.dbClose(ps, con);
		}
		
		return result;
	}

	@Override
	public int insertStoryImg(StoryImageDTO storyImageDTO) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		String sql = proFile.getProperty("userStoryImg.insert");
//		userStoryImg.insert=insert into story_img values(STORY_IMG_SEQ.NEXTVAL, STORY_DETAILS_SEQ.CURRVAL, ?)
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, storyImageDTO.getStoryImg());
			
			result = ps.executeUpdate();
		}finally {
			DbUtil.dbClose(ps, con);
		}
		
		return result;
	}

	@Override
	public int updateStory(StoryDTO storyDTO) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		String sql = proFile.getProperty("userStory.update");
//		userStory.update=update story set story_title=? where story_no=? and password=?
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, storyDTO.getStoryTitle());
			ps.setInt(2, storyDTO.getStoryNo());
			ps.setString(3, storyDTO.getStoryPassword());
			
			result = ps.executeUpdate();
		}finally {
			DbUtil.dbClose(ps, con);
		}
		
		return result;
	}

	@Override
	public int updateStoryDetails(StoryDetailsDTO storyDetailsDTO) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		String sql = proFile.getProperty("userStoryDetails.update");
//		userStoryDetails.update=update story_details set story_content=? where story_details_no=? 
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, storyDetailsDTO.getStoryContent());
			ps.setInt(2, storyDetailsDTO.getStoryDetailsNo());
			
			result = ps.executeUpdate();
		}finally {
			DbUtil.dbClose(ps, con);
		}
		
		return result;
	}

	@Override
	public int updateStoryImg(StoryImageDTO storyImageDTO) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		String sql = proFile.getProperty("userStoryImg.update");
//		userStoryImg.update=update story_img set story_img=? where story_img_no=?
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, storyImageDTO.getStoryImg());
			ps.setInt(2, storyImageDTO.getStoryImgNo());
			
			result = ps.executeUpdate();
		}finally {
			DbUtil.dbClose(ps, con);
		}
		
		return result;
	}
	
	@Override
	public int delete(String storyNo, String password) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		String sql = proFile.getProperty("userStory.delete");
//		userStory.delete=delete from story where story_no=? and password=?
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, storyNo);
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

	@Override
	public List<StoryDTO> selectAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
}
