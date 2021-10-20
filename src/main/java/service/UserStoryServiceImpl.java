package service;

import java.sql.SQLException;
import java.util.List;

import dao.UserStoryDAO;
import dao.UserStoryDAOImpl;
import dto.StoryDTO;
import dto.StoryImgDTO;

public class UserStoryServiceImpl implements UserStoryService {
	
	private UserStoryDAO storyDAO = new UserStoryDAOImpl();

	@Override
	public List<StoryDTO> selectAll() throws SQLException {
		return storyDAO.selectAll();
	}

	@Override
	public StoryDTO selectByStoryNo(int storyNo, boolean flag) throws SQLException {
		if(flag) {
			if(storyDAO.increamentByStoryVisited(storyNo) == 0) {
				throw new SQLException("조회수 증가에 문제가 생겨 조회할 수 없습니다.");
			}
			
			StoryDTO storyDTO = storyDAO.selectByStoryNo(storyNo);
			if(storyDTO == null) {
				throw new SQLException(storyNo + " 제품을 조회할 수 없습니다.");
			}
		}
		
		return null;
	}

	@Override
	public void insertStory(StoryDTO storyDTO) throws SQLException {
		if(storyDAO.insertStory(storyDTO) == 0 )
			  throw new SQLException("스토리가 등록되지 않았습니다.");
	}

	@Override
	public void updateStory(StoryDTO storyDTO) throws SQLException {
		// 비밀번호 일치여부 판단
		StoryDTO dbStory = storyDAO.selectByStoryNo(storyDTO.getStoryNo());
		if(!dbStory.getStoryPassword().equals(storyDTO.getStoryPassword())) {
			throw new SQLException("비밀번호가 틀리므로 삭제할 수 없습니다.");
		}
		
		if(storyDAO.updateStory(storyDTO) == 0) {
			throw new SQLException("스토리가 수정되지 않았습니다.");
		}
	}

	@Override
	public void updateStoryImg(StoryImgDTO storyImageDTO) throws SQLException {
		
	}

	@Override
	public void delete(int storyNo, String password, String path) throws SQLException {
		// 비밀번호 일치여부를 판단
		StoryDTO dbStory = storyDAO.selectByStoryNo(storyNo);
		if(!dbStory.getStoryPassword().equals(password)) {
			throw new SQLException("비밀번호가 틀리므로 삭제할 수 없습니다.");
		}
		
		if(storyDAO.deleteStory(storyNo, password) == 0) {
			throw new SQLException("스토리가 삭제되지 않았습니다.");
		}
		
		// 삭제 완료되면 폴더에 자료 삭제

	}
}
