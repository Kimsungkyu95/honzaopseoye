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
	public List<StoryDTO> selectAll() throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		List<StoryDTO> storyList = new ArrayList<StoryDTO>();
		String sql = proFile.getProperty("userStory.select");
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				StoryDTO story = new StoryDTO(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getInt(5));
				
				storyList.add(story);
			}
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}
		
		return storyList;
	}
	
	@Override
	public int increamentByReadnum(int storyNo) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String storyNo, String password) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertStoryDetails(StoryDetailsDTO storyDetailsDTO) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertStoryImg(StoryImageDTO storyImageDTO) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateStory(StoryDTO storyDTO) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateStoryDetails(StoryDetailsDTO storyDetailsDTO) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateStoryImg(StoryImageDTO storyImageDTO) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}
}
