package dao;

import java.sql.SQLException;
import java.util.List;

import dto.StoryDTO;
import dto.StoryDetailsDTO;

public interface StoryDAO {
	
	List<StoryDTO> select() throws SQLException;
	 
	StoryDetailsDTO selectBy() throws SQLException;
	  
	int insert(StoryDTO storyDTO) throws SQLException;
	 
	int update(StoryDTO storyDTO) throws SQLException;
		 
    int delete(StoryDTO storyDTO) throws SQLException;

}
