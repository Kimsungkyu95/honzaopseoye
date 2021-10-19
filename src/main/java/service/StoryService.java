package service;

import java.sql.SQLException;
import java.util.List;

import dto.StoryDTO;
import dto.StoryDetailsDTO;
import dto.StoryImageDTO;

public interface StoryService {
	
     List<StoryDTO> selectAll() throws SQLException;
     
     StoryDTO selectByStoryNo(String storyNo, boolean flag) throws SQLException;

	 void insertStory(StoryDTO storyDTO) throws SQLException;
	 
	 void insertStoryDetails(StoryDetailsDTO storyDetailsDTO) throws SQLException;
	 
	 void insertStoryImg(StoryImageDTO storyImageDTO) throws SQLException;
	 
	 void updateStory(StoryDTO storyDTO) throws SQLException;
	 
	 void updateStoryDetails(StoryDetailsDTO storyDetailsDTO) throws SQLException;
	 
	 void updateStoryImg(StoryImageDTO storyImageDTO) throws SQLException;
		 
     void delete(String storyNo, String password , String path) throws SQLException;
	 
}
