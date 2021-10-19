package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dto.StoryDTO;
import dto.StoryImgDTO;

public interface StoryDAO {
	  List<StoryDTO> selectAll();
	  
	  /**
	   * 스토리 검색
	   */
	  StoryDTO selectByStoryNo(String storyNo) throws SQLException;
	   
	  /**
	   * 스토리 이미지 검색
	   */
	  StoryImgDTO selectByStoryImgNo(String storyImgNo) throws SQLException;
	  
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
	   * 스토리 레코드 수정
	   */
	  int updateStory(StoryDTO storyDTO) throws SQLException;
	   
	  /**
	   * 스토리 삭제
	   */
	  int delete(String storyNo, String password) throws SQLException;
	  /**
	   * 스토리번호로 삭제
	   * */
	  int deleteByStoryNo(int storyNo);
}
