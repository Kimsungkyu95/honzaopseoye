package dao;

import java.sql.SQLException;

import dto.LevelUpExpDTO;

public interface LevelUpExpDAO {
	int selectMinExpByMemberLevel(int memberLevel) throws SQLException;
	int selectMemberLevelByExp(int exp) throws SQLException;
	int remainingExp(int memberLevel) throws SQLException;
	int selectMinExpByLevel(int memberLevel) throws SQLException;
}
