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
	
	//카테고리 가져오기
	@Override
	public List<CategoryDTO> selectCategory(String category, String categoryDetail) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql =  proFile.getProperty("userRestaurant.selectCategory");
		//select * from category
		List<CategoryDTO>categoryList = new ArrayList<CategoryDTO>();
		try {
			con = DbUtil.getConnection();
			ps =  con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				CategoryDTO c = new CategoryDTO(rs.getInt(1), rs.getString(2), this.selectCategoryDetails(rs.getInt(1)));
				categoryList.add(c);	
			}
			
		} finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return categoryList;
	}
	
	//카테고리 번호에 따른 카테고리 상세 가져오기
	public List<CategoryDetailsDTO> selectCategoryDetails(int categoryNo) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<CategoryDetailsDTO>categoryDetailsList = new ArrayList<CategoryDetailsDTO>();
		String sql =  proFile.getProperty("userRestaurant.selectCategoryDetails");
		//select * from category_details where category_no=?
		try {
			con = DbUtil.getConnection();
			ps =  con.prepareStatement(sql);
			ps.setInt(1, categoryNo);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				CategoryDetailsDTO cd = new CategoryDetailsDTO(rs.getInt(1),rs.getString(2), this.selectRestaurant(rs.getInt(1)));
				categoryDetailsList.add(cd);
			}
			
		} finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return categoryDetailsList;
	}
	
	//카테고리상세번호에 따른 맛집 가져오기
	public List<RestaurantDTO> selectRestaurant(int categoryDetailsNo) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql =  proFile.getProperty("userRestaurant.selectCategoryDetails");
		List<RestaurantDTO>restaurantList = new ArrayList<RestaurantDTO>();
		//select restaurant_no, restaurant_level, restaurant_name from restaurant where category_details_no=?;
		try {
			con = DbUtil.getConnection();
			ps =  con.prepareStatement(sql);
			ps.setInt(1, categoryDetailsNo);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				RestaurantDTO r = new RestaurantDTO(rs.getInt(1), rs.getInt(2), rs.getString(3));
				restaurantList.add(r);
			}
			
		} finally {
			DbUtil.dbClose(rs, ps, con);
		}
		return restaurantList;
	}

}
