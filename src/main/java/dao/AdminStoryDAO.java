package dao;

import java.util.List;

import dto.AdminStoryDTO;

public interface AdminStoryDAO {
	
	  List<AdminStoryDTO> selectAll();

	  int deleteByStoryNo(int storyNo);
}
