package service;

import java.util.List;

import dao.AdminStoryDAO;
import dao.AdminStoryDAOImpl;
import dto.AdminStoryDTO;

public class AdminStoryServiceImpl implements AdminStoryService {
	
	private AdminStoryDAO dao = new AdminStoryDAOImpl();

	@Override
	public List<AdminStoryDTO> selectAll() {
		List<AdminStoryDTO> list = dao.selectAll();
		return list;
	}


}
