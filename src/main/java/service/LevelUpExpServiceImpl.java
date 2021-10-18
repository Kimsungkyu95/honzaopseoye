package service;

import java.sql.SQLException;

import dao.LevelUpExpDAO;
import dao.LevelUpExpDAOImpl;


public class LevelUpExpServiceImpl implements LevelUpExpService {
	LevelUpExpDAO dao = new LevelUpExpDAOImpl();

	@Override
	public int selectMinExpByMemberLevel(int memberLevel) throws SQLException {
		int minExp = dao.selectMinExpByMemberLevel(memberLevel); 
		
		if(minExp==-1) {
			throw new SQLException("해당 레벨의 최소 경험치를 찾을 수 없습니다.");
		}
		
		return minExp;
	}

	@Override
	public int selectMemberLevelByExp(int exp) throws SQLException {
		int memberLevel = dao.selectMemberLevelByExp(exp);
		
		if(memberLevel==-1) {
			throw new SQLException("해당 경험치에 해당하는 레벨 정보를 찾을 수 없습니다.");
		}
		
		return memberLevel;
	}

}
