package service;

import java.sql.SQLException;

import dto.AdminStoryDTO;

public interface AdminStoryService {
	
	/**
     * 스토리 제목으로 검색
     */
    AdminStoryDTO selectByStoryTitle(인수) throws SQLException;
    
    /**
     * 스토리 제목으로 검색
     */
    AdminStoryDTO selectByMemberNo(인수) throws SQLException;
    

}
