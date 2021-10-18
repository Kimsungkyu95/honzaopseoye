package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import dto.RestaurantDTO;
import util.DbUtil;

public class AdminRestaurantDAOImpl implements AdminRestaurantDAO {
	
	private Properties proFile = new Properties();
	
	public AdminRestaurantDAOImpl() {
		try {			
			proFile.load(getClass().getClassLoader().getResourceAsStream("dbQueryAdminRestaurant.properties"));
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public int insert(RestaurantDTO restaurantDTO) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = 0;
		String sql = proFile.getProperty("adminRestaurant.selectCategoryDetailsNo");
		return 0;
	}

	@Override
	public int selectCategoryDetailsNo(String categoryDetailsName) throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = 0;
		String sql = proFile.getProperty("adminRestaurant.selectCategoryDetailsNo");
		try {
			conn = DbUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, categoryDetailsName);
			rs = ps.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
			
		}finally {
			DbUtil.dbClose(rs, ps, conn);
		}
		
		return result;
	}

}
