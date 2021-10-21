package service;

import java.util.List;

import dao.AdminStoryDAO;
import dao.AdminStoryDAOImpl;
import dto.AdminStoryDTO;

public class AdminStoryServiceImpl implements AdminStoryService {
	
	private AdminStoryDAO dao = new AdminStoryDAOImpl();

	@Override
	public List<AdminStoryDTO> selectPage(int pageNo, String selectKey, String selectValue) {
		List<AdminStoryDTO> list = dao.selectPage(pageNo, selectKey, selectValue);
		return list;
	}


}
