package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.RestaurantDTO;
import util.DbUtil;

public class RecommendCategoryDAO {
	public RestaurantDTO selectCategoryByRestaurantNo(int restaurantNo) throws SQLException{
		ResultSet rs = null;
		PreparedStatement ps = null;
		Connection conn = null;
		RestaurantDTO restaurantDTO = null;
		try {
			conn = DbUtil.getConnection();
			ps = conn.prepareStatement("select category_name, category_details_name, restaurant_name from restaurant natural join category_details natural join category where restaurant_no = ?");
			ps.setInt(1, restaurantNo);
			rs = ps.executeQuery();
			if(rs.next()) {
				restaurantDTO = new RestaurantDTO();
				restaurantDTO.setCategoryName(rs.getString(1));
				restaurantDTO.setCategoryDetailsName(rs.getString(2));
			}
			
		}finally {
			DbUtil.dbClose(rs, ps, conn);
		}
		return restaurantDTO;
	}
}
