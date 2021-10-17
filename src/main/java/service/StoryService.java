package service;

import java.sql.SQLException;
import java.util.List;

import dto.StoryDTO;
import dto.StoryDetailsDTO;

public interface StoryService {
	
     List<StoryDTO> select() throws SQLException;
     
     StoryDetailsDTO selectBy() throws SQLException;

	 void insert(StoryDTO storyDTO) throws SQLException;
	 
	 void update(StoryDTO storyDTO) throws SQLException;
		 
     void delete(StoryDTO storyDTO) throws SQLException;
	 
}
