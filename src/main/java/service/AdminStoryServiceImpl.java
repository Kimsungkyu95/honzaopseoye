package service;

import java.util.List;

import dao.AdminStoryDAO;
import dao.AdminStoryDAOImpl;
import dto.AdminStoryDTO;

public class AdminStoryServiceImpl implements AdminStoryService {
	
	private AdminStoryDAO dao = new AdminStoryDAOImpl();

	@Override
	public List<AdminStoryDTO> selectByOption(String selectKey, String selectValue ) {
		List<AdminStoryDTO> list = dao.selectByOption(selectKey, selectValue);
		return list;
	}


}
