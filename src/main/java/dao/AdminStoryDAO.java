package dao;

import java.util.List;

import dto.AdminStoryDTO;

public interface AdminStoryDAO {
	
	  List<AdminStoryDTO> selectAll();

	  int deleteByStoryNo(int storyNo);

	  /**
       * 검색 옵션으로 검색
       */
	  List<AdminStoryDTO> selectByOption(String selectKey, String selectValue);
   

	    

}
