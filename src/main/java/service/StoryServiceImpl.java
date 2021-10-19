package service;

import java.sql.SQLException;
import java.util.List;

import dao.StoryDAO;
import dao.StoryDAOImpl;
import dto.StoryDTO;
import dto.StoryDetailsDTO;
import dto.StoryImageDTO;

public class StoryServiceImpl implements StoryService {
	
	private StoryDAO storyDAO = new StoryDAOImpl();

	@Override
	public List<StoryDTO> selectAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StoryDTO selectByStoryNo(String storyNo, boolean flag) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertStory(StoryDTO storyDTO) throws SQLException {
		 if(storyDAO.insertStory(storyDTO) == 0 )
			  throw new SQLException("등록되지 않았습니다.");
	}

	@Override
	public void insertStoryDetails(StoryDetailsDTO storyDetailsDTO) throws SQLException {
		if(storyDAO.insertStoryDetails(storyDetailsDTO) == 0 )
			  throw new SQLException("등록되지 않았습니다.");
	}

	@Override
	public void insertStoryImg(StoryImageDTO storyImageDTO) throws SQLException {
		if(storyDAO.insertStoryImg(storyImageDTO) == 0 )
			  throw new SQLException("등록되지 않았습니다.");
	}

	@Override
	public void updateStory(StoryDTO storyDTO) throws SQLException {
		
	}

	@Override
	public void updateStoryDetails(StoryDetailsDTO storyDetailsDTO) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateStoryImg(StoryImageDTO storyImageDTO) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String storyNo, String password, String path) throws SQLException {
		// TODO Auto-generated method stub
		
	}

}
