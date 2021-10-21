package service;

import java.util.List;

import dto.AdminStoryDTO;

public interface AdminStoryService {
	
	/**
     * 검색 옵션으로 검색
     */
	List<AdminStoryDTO> selectByOption(String selectKey, String selectValue);
    

}
