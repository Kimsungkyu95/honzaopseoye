package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import dto.MenuDTO;
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
	public int insert(RestaurantDTO restaurantDTO) throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = proFile.getProperty("adminRestaurant.insert");
		try {
			conn = DbUtil.getConnection();
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(sql);
			ps.setInt(1, restaurantDTO.getCategoryDetailsNo());
			ps.setInt(2, restaurantDTO.getRestaurantLevel());
			ps.setString(3, restaurantDTO.getRestaurantName());
			ps.setString(4, restaurantDTO.getRestaurantPhone());
			ps.setString(5, restaurantDTO.getRestaurantAddr());
			ps.setString(6, restaurantDTO.getRestaurantRoadAddr());
			ps.setString(7, restaurantDTO.getGu());
			ps.setString(8, restaurantDTO.getDong());
			ps.setDouble(9, restaurantDTO.getRestaurantLongitude());
			ps.setDouble(10, restaurantDTO.getRestaurantLatitude());
			result = ps.executeUpdate();
			
			//해시 태그 리스트에 해시태그가 있는경우
			List<String> hashTagName = restaurantDTO.getHashTagName();
			if(hashTagName.size() >= 1) {
				int hashTagResult = insertHashTag(conn, hashTagName);
			}
			
			//메뉴 리스트에 메뉴가 있는경우
			List<MenuDTO> menuList = restaurantDTO.getMenuList();
			if(menuList.size() >= 1) {
				int menuResult = insertMenu(conn, menuList);
			}
				
			//이미지 리스트에 이미지가 있는경우
			List<String> imgList = restaurantDTO.getImgList();
			if(imgList.size() >= 1) {
				int imgResult = insertImg(conn, imgList);
			}
			
			conn.commit();
			
		}finally {
			DbUtil.dbClose(ps, conn);
		}
		return result;
	}
	
	public int insertHashTag(Connection conn, List<String> hashTagName) throws SQLException{
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = 0;
		String sql = proFile.getProperty("adminRestaurant.selectHashTagByName");
		
		try {
			ps = conn.prepareStatement(sql);
			for(String hashTag : hashTagName) {
				ps.setString(1, hashTag);
				rs = ps.executeQuery();
				if(rs.next()) { //이 해시태그는 hashTag 테이블에 존재한다.
					int hashTagNo = rs.getInt(1);
					result = insertHashTagRelation(conn, hashTagNo);
					if(result == 0) {
						throw new SQLException("해시태그 삽입에 실패했습니다"); //해시태그 관계 삽입에 실패.
					}
				}
			}
			
		}finally {
			DbUtil.dbClose(ps, null);
		}
		
		return result;
	}
	
	public int insertHashTagRelation(Connection conn, int hashTagNo) throws SQLException{
		PreparedStatement ps = null;
		int result = 0;
		String sql = proFile.getProperty("adminRestaurant.insertHashTagRelation");
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, hashTagNo);
			result = ps.executeUpdate();
			
		}finally {
			DbUtil.dbClose(ps, null);
		}
		
		return result;
	}
	
	
	
	public int insertMenu(Connection conn, List<MenuDTO> menuList) throws SQLException{
		PreparedStatement ps = null;
		int result = 0;
		String sql = proFile.getProperty("adminRestaurant.insertMenu");
		
		try {
			ps = conn.prepareStatement(sql);
			for(MenuDTO menuDTO : menuList) {
				ps.setString(1, menuDTO.getMenuName());
				ps.setInt(2, menuDTO.getMenuPrice());
				result = ps.executeUpdate();
				if(result == 0) {
					throw new SQLException("메뉴 삽입에 실패했습니다.");
				}
			}
		}finally {
			DbUtil.dbClose(ps, null);
		}
		
		return result;
	}
	
	public int insertImg(Connection conn, List<String> imgList) throws SQLException{
		PreparedStatement ps = null;
		int result = 0;
		String sql = proFile.getProperty("adminRestaurant.insertImg");
		
		try {
			ps = conn.prepareStatement(sql);
			for(String imgName : imgList) {
				ps.setString(1, imgName);
				result = ps.executeUpdate();
				if(result == 0) {
					throw new SQLException("이미지 삽입에 실패했습니다.");
				}
			}
		}finally {
			DbUtil.dbClose(ps, null);
		}
		
		return result;
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
