package service;

import dao.AdminStoryDAO;
import dao.AdminStoryDAOImpl;
import dto.AdminStoryDTO;

public class AdminStoryServiceImpl implements AdminStoryService {
	
	private AdminStoryDAO adminStoryDAO = new AdminStoryDAOImpl();

	@Override
	public AdminStoryDTO selectByStoryTitle() {
		
		return null;
	}

	@Override
	public AdminStoryDTO selectByMemberNo() {
		
		return null;
	}

}
