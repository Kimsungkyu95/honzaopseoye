package service;

import java.sql.SQLException;
import java.util.List;

import dto.StoryDTO;
import dto.StoryImgDTO;

public interface StoryService {
	
     List<StoryDTO> selectAll() throws SQLException;
     
     StoryDTO selectByStoryNo(String storyNo, boolean flag) throws SQLException;

	 void insertStory(StoryDTO storyDTO) throws SQLException;
	 
	 void insertStoryImg(StoryImgDTO storyImageDTO) throws SQLException;
	 
	 void updateStory(StoryDTO storyDTO) throws SQLException;
	 
	 void updateStoryImg(StoryImgDTO storyImageDTO) throws SQLException;
		 
     void delete(String storyNo, String password , String path) throws SQLException;
	 
}
