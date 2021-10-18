package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import dto.CategoryDTO;
import dto.CategoryDetailsDTO;
import dto.RestaurantDTO;
import dto.RestaurantImgDTO;
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
	
	//카테고리상세 번호에 따른 맛집 리스트 가져오기
	@Override
	public List<RestaurantDTO> selectCategory(String categoryDetail) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql =  proFile.getProperty("userRestaurant.selectRestaurant");
		//select restaurant_no ,restaurant_level ,restaurant_name from restaurant where category_details_no=?
		List<RestaurantDTO>restaurantList = new ArrayList<RestaurantDTO>();
		try {
			con = DbUtil.getConnection();
			ps =  con.prepareStatement(sql);
			ps.setInt(1, this.selectRestaurant(categoryDetail));
			rs = ps.executeQuery();
			if(rs.next()) {
				RestaurantDTO restaurantDTO = new RestaurantDTO(rs.getInt(1), rs.getInt(2), rs.getString(3));
				restaurantList.add(restaurantDTO);	
			}
			
		} finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return restaurantList;
	}
	
	//카테고리 상세이름에 따른 카테고리 상세번호 
	public int selectRestaurant(String categoryDetail) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql =  proFile.getProperty("userRestaurant.selectCategoryDetails");
		//select category_details_no from category_details where category_details_name=?
		int result=0;
		try {
			con = DbUtil.getConnection();
			ps =  con.prepareStatement(sql);
			ps.setString(1, categoryDetail);
			rs = ps.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
		} finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return result;
	}

}
