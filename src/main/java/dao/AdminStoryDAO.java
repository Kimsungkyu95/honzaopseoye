package dao;

import java.sql.SQLException;
import java.util.List;

import dto.AdminStoryDTO;

public interface AdminStoryDAO {
	
	  List<AdminStoryDTO> selectAll();

	  int deleteByStoryNo(int storyNo);

	  /**
       * 관리자 스토리 페이징 처리
       */
	  List<AdminStoryDTO> selectPage(int pageNo, String selectKey, String selectValue);
   

	    

}
