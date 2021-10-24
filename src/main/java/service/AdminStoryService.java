package service;

import java.util.List;

import dto.AdminStoryDTO;

public interface AdminStoryService {
	
	/**
	 * 관리자 스토리관리 부분 전체 목록 띄우는 메소드
	 * @return 전체 스토리 리스트 
	 */
	List<AdminStoryDTO> selectAll();
    

}
