package service;

import java.util.List;

import dto.AdminStoryDTO;

public interface AdminStoryService {
	
	/**
     * 관리자 스토리 페이징 처리
     */
	List<AdminStoryDTO> selectPage(int pageNo, String selectKey, String selectValue);
    

}
