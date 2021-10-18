package dao;

import java.sql.SQLException;

public interface LevelUpExpDAO {
	int selectMinExpByMemberLevel(int memberLevel) throws SQLException;
}
