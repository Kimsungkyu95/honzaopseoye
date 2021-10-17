package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import dto.RestaurantDTO;
import util.DbUtil;

public class UserRestaurantDAOImpl implements UserRestaurantDAO {
	Properties proFile = new Properties();

	public UserRestaurantDAOImpl() {
		super();
		try {
			proFile.load(getClass().getClassLoader().getResourceAsStream("dbQuery.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<RestaurantDTO> selectByCategory() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<RestaurantDTO> restaurantList  = new ArrayList<RestaurantDTO>();
		String sql=proFile.getProperty("userRestaurant.selectByCategory");
		try {
			con = DbUtil.getConnection();
			ps =  con.prepareStatement(sql);
			rs = ps.executeQuery();
		} finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return restaurantList;
	}

	@Override
	public List<RestaurantDTO> selectByCategoryDetail() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
