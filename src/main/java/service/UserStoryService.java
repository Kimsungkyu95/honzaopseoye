package service;

import java.sql.SQLException;
import java.util.List;

import dto.StoryDTO;
import dto.StoryImgDTO;

public interface UserStoryService {
	/**
	 * 전체 검색
	 */
     List<StoryDTO> selectAll() throws SQLException;
     
     /**
      * 스토리 번호로 검색
      */
     StoryDTO selectByStoryNo(int storyNo, boolean flag) throws SQLException;
     
     /**
      * 스토리 레코드 삽입
      */
	 void insertStory(StoryDTO storyDTO) throws SQLException;
	 
	 /**
	  * 스토리 레코드 수정
	  */
	 void updateStory(StoryDTO storyDTO) throws SQLException;
	 
	 void updateStoryImg(StoryImgDTO storyImageDTO) throws SQLException;
	 
	 /**
	  * 스토리 레코드 삭제
	  */
     void delete(int storyNo, String password , String path) throws SQLException;
}
