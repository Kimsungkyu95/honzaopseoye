package dao;

import java.sql.SQLException;
import java.util.List;

import dto.RecommendDTO;

public interface RecommendDAO {
	
    List<RecommendDTO> recByScore();
	
	List<RecommendDTO> recByLevel(int levelNo);
	
	List<RecommendDTO> recByVisited() throws SQLException;
	
	List<RecommendDTO> recByTag(int tagNo) throws SQLException;

}
