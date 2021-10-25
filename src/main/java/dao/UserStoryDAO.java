package dao;

import java.sql.SQLException;
import java.util.List;

import dto.StoryDTO;

public interface UserStoryDAO { 
	  /**
	   * 스토리 전체 검색
	   */
	  List<StoryDTO> selectAll() throws SQLException;
	  
	  /**
	   * 스토리 번호로 검색
	   */
	  StoryDTO selectByStoryNo(int storyNo) throws SQLException;
	   
	  /**
	   * 스토리 조회수 증가
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
	   * 스토리 레코드 삭제
	   */
	  int deleteStory(int storyNo, String password) throws SQLException;
}
