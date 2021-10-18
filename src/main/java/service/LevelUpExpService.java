package service;

import java.sql.SQLException;

public interface LevelUpExpService {
	
	int selectMinExpByMemberLevel(int memberLevel) throws SQLException;
	
	int selectMemberLevelByExp(int exp) throws SQLException;

}
