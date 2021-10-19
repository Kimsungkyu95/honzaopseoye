package dao;

import java.sql.SQLException;
import java.util.List;

import dto.StoryDTO;
import dto.StoryDetailsDTO;
import dto.StoryImageDTO;

public interface StoryDAO {
	  List<StoryDTO> selectAll() throws SQLException;
	  
	  /**
	   * 스토리 검색
	   */
	  StoryDTO selectByStoryNo(String storyNo) throws SQLException;
	  
	  /**
	   * 스토리 상세 검색
	   */
	  StoryDetailsDTO selectByStoryDetailsNo(String storyDetailsNo) throws SQLException;
	  
	  /**
	   * 스토리 이미지 검색
	   */
	  StoryImageDTO selectByStoryImgNo(String storyImgNo) throws SQLException;
	  
	  /**
	   * 조회수 증가
	   * update story set story_visited = story_visited + 1 where story_no=?
	   * */
	  int increamentByStoryVisited(int storyNo) throws SQLException;
	  
	  /**
	   * 스토리 레코드 삽입
	   */
	  int insertStory(StoryDTO storyDTO) throws SQLException;
	  
	  /**
	   * 스토리 상세 레코드 삽입
	   */
	  int insertStoryDetails(StoryDetailsDTO storyDetailsDTO) throws SQLException;
	  
	  /**
	   * 스토리 이미지 레코드 삽입
	   */
	  int insertStoryImg(StoryImageDTO storyImageDTO) throws SQLException;
	  
	  /**
	   * 스토리 레코드 수정
	   */
	  int updateStory(StoryDTO storyDTO) throws SQLException;
	  
	  /**
	   * 스토리 상세 레코드 수정
	   */
	  int updateStoryDetails(StoryDetailsDTO storyDetailsDTO) throws SQLException;
	  
	  /**
	   * 스토리 이미지 레코드 수정
	   */
	  int updateStoryImg(StoryImageDTO storyImageDTO) throws SQLException;
	  
	  /**
	   * 스토리 삭제
	   */
	  int delete(String storyNo, String password) throws SQLException;
}
