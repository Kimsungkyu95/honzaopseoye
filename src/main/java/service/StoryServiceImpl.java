package service;

import java.sql.SQLException;
import java.util.List;

import dao.StoryDAO;
import dao.StoryDAOImpl;
import dto.StoryDTO;
import dto.StoryDetailsDTO;

public class StoryServiceImpl implements StoryService {
	
	private StoryDAO storyDAO = new StoryDAOImpl();

	@Override
	public List<StoryDTO> select() throws SQLException {		
		return null;
	}
	
	@Override
	public StoryDetailsDTO selectBy() throws SQLException {	
		return null;
	}

	@Override
	public void insert(StoryDTO storyDTO) throws SQLException {
		
		
	}

	@Override
	public void update(StoryDTO storyDTO) throws SQLException {
		
		
	}

	@Override
	public void delete(StoryDTO storyDTO) throws SQLException {
		
		
	}

	

}
