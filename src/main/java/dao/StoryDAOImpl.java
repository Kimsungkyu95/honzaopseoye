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
	public StoryImgDTO selectByStoryImgNo(String storyImgNo) throws SQLException {
		// TODO Auto-generated method stub
		return null;
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

	public int updateStoryImg(StoryImgDTO storyImageDTO, Connection con) throws SQLException {
		PreparedStatement ps=null;
		int result=0;
		String sql = proFile.getProperty("userStoryImg.update");
//		userStoryImg.update=update story_img set story_img=? where story_img_no=?
		
		try {
			ps = con.prepareStatement(sql);
			
			ps.setString(1, storyImageDTO.getStoryImg());
			ps.setInt(2, storyImageDTO.getStoryImgNo());
			
			result = ps.executeUpdate();
		}finally {
			DbUtil.dbClose(ps, null);
		}
		
		return result;
	}
	
	@Override
	public int deleteStory(String storyNo, String password) throws SQLException {
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
	public List<StoryDTO> selectAll() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null; 
		List<StoryDTO> list = new ArrayList<StoryDTO>();
		String sql = "";
		try {
			con = DbUtil.getConnection();
			ps=con.prepareStatement(sql);

			rs=ps.executeQuery();
			while(rs.next()) { 
				StoryDTO storylist=new StoryDTO(rs.getInt(1), rs.getInt(2), 
						rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),
						rs.getInt(7),rs.getString(8));
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
		String sql = "";
		
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
