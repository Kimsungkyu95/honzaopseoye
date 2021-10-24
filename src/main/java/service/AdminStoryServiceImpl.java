package service;

import java.util.List;

import dao.AdminStoryDAO;
import dao.AdminStoryDAOImpl;
import dto.AdminStoryDTO;

public class AdminStoryServiceImpl implements AdminStoryService {
	
	private AdminStoryDAO dao = new AdminStoryDAOImpl();

	/**
	 * 관리자 스토리관리 부분 전체 목록 띄우는 메소드
	 * @return 전체 스토리 리스트 
	 */
	@Override
	public List<AdminStoryDTO> selectAll() {
		List<AdminStoryDTO> list = dao.selectAll();
		return list;
	}


}
