package service;

import java.sql.SQLException;

import dto.LevelUpExpDTO;

public interface LevelUpExpService {
	
	int selectMinExpByMemberLevel(int memberLevel) throws SQLException;
	
	int selectMemberLevelByExp(int exp) throws SQLException;
	
	int remainingExp(int memberExp) throws SQLException;

}
