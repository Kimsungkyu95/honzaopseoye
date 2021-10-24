package dao;

import java.util.List;

import dto.AdminStoryDTO;

public interface AdminStoryDAO {
	
	/**
	 * 관리자 스토리 전체 목록 띄우는 메소드
	 * @return 전체 스토리 리스트 
	 */
	  List<AdminStoryDTO> selectAll();
	/**
	 * 관리자 스토리 삭제 메소드
	 * @return 전체 스토리 리스트 
	 * @param 스토리번호
	 */
	  int deleteByStoryNo(int storyNo);

	 /**
      * 검색 옵션으로 검색
      * @return select 옵션에 해당하는 스토리 리스트 
	  * @param 검색옵션 key, 검색어 value
      */
	  List<AdminStoryDTO> selectByOption(String selectKey, String selectValue);
   

	    

}
