package service;

import java.sql.SQLException;
import java.util.List;

import dao.RecommendDAO;
import dao.RecommendDAOImpl;
import dto.RecommendDTO;

public class RecommendServiceImpl implements RecommendService {
	
	private RecommendDAO recommendDao = new RecommendDAOImpl();

	@Override
	public List<RecommendDTO> recByScore() throws SQLException {
		
		return null;
	}

	@Override
	public List<RecommendDTO> recByLevel(int levelNo) throws SQLException {
		
		return null;
	}

	@Override
	public List<RecommendDTO> recByVisited() throws SQLException {
	    
		return null;
	}

	@Override
	public List<RecommendDTO> recByTag(int tagNo) throws SQLException {
		
		return null;
	}
	
	


}
