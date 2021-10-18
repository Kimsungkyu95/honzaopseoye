package service;

import java.sql.SQLException;
import java.util.List;

import dto.RecommendDTO;

public interface RecommendService {
	
    List<RecommendDTO> recByScore() throws SQLException;
	
	List<RecommendDTO> recByLevel(int levelNo) throws SQLException;
	
	List<RecommendDTO> recByVisited() throws SQLException;
	
	List<RecommendDTO> recByTag(int tagNo) throws SQLException;
	

}
