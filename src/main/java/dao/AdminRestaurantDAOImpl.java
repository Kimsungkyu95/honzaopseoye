package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import dto.MenuDTO;
import dto.RestaurantDTO;
import paging.PageCnt;
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
	
	/**
	 * restaurant insert시 해시태그 관계 삽입 1단계
	 * */
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
	
	/**
	 * restaurant insert시 해시태그 관계 삽입 2단계
	 * */
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
	
	
	/**
	 * restaurant insert시 메뉴 삽입
	 * */
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
	
	/**
	 * restaurant insert시 이미지 삽입
	 * */
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
	
	/**
	 * 상세카테고리 명으로 상세카테고리 번호 알아오기
	 * */
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

	/**
	 * paging시 전체 row의 수 구하기
	 * */
	public int getTotalCount(String selectKey, String selectValue) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = 0;
		String sql = "";
		switch (selectKey) {
		case "restaurantName":
			sql = proFile.getProperty("adminRestaurant.restaurantNameTotalCount");
			break;
		case "categoryName":
			sql = proFile.getProperty("adminRestaurant.categoryNameTotalCount");
			break;
		default: //레스토랑 주소일경우
			sql = proFile.getProperty("adminRestaurant.restaurantAddrTotalCount");
			break;
		}		
		
		try {
			conn = DbUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, selectValue);
			rs = ps.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
			
		}finally {
			DbUtil.dbClose(rs, ps, conn);
		}
		
		return result;
	}
	
	@Override
	public List<RestaurantDTO> pagingSelect(int pageNo, String selectKey, String selectValue) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<RestaurantDTO> restaurantList = new ArrayList<RestaurantDTO>();
		
		String sql = "";
		switch (selectKey) {
		case "restaurantName":
			sql = proFile.getProperty("adminRestaurant.pagingSelectbyRestaurantName");
			break;
		case "categoryName":
			sql = proFile.getProperty("adminRestaurant.pagingSelectbyCategoryName");
			break;
		default: //레스토랑 주소일 경우
			sql = proFile.getProperty("adminRestaurant.pagingSelectbyRestaurantAddr");
			break;
		}
		
		try {
			//전체 게시물 수 구하기
			int totalCount = getTotalCount(selectKey, selectValue);
			
			//총 페이지 수 구하기
			PageCnt pageCnt = new PageCnt();
			pageCnt.setPageCnt((int)Math.ceil((double)totalCount/PageCnt.pagesize));
			PageCnt.setPageNo(pageNo);
			
			conn = DbUtil.getConnection();
			ps = conn.prepareStatement(sql);	
			ps.setString(1, selectValue);
			ps.setInt(2, PageCnt.getPagesize() * pageNo);
			ps.setInt(3, PageCnt.getPagesize() * (pageNo - 1) + 1);
			rs = ps.executeQuery();
			while(rs.next()) {
				RestaurantDTO restaurantDTO = new RestaurantDTO();
				restaurantDTO.setRestaurantNo(rs.getInt(1));
				restaurantDTO.setRestaurantName(rs.getString(2));
				restaurantDTO.setCategoryName(rs.getString(3));
				restaurantDTO.setCategoryDetailsName(rs.getString(4));
				restaurantDTO.setRestaurantAddr(rs.getString(5));
				restaurantDTO.setRestaurantRegDate(rs.getString(6));
				restaurantDTO.setRestaurantLevel(rs.getInt(7));
				restaurantDTO.setRestaurantVisited(rs.getInt(8));
				
				restaurantList.add(restaurantDTO);
			}		
			
		}finally {
			DbUtil.dbClose(rs, ps, conn);
		}			
		
		return restaurantList;
	}

	@Override
	public int delete(int restaurantNo) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = proFile.getProperty("adminRestaurant.delete");	
		try {
			conn = DbUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, restaurantNo);
			result = ps.executeUpdate();
		}finally {
			DbUtil.dbClose(ps, conn);
		}
		return result;
	}

	@Override
	public RestaurantDTO selectByRestaurantNo(int restaurantNo) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = proFile.getProperty("adminRestaurant.selectRestaurantByRestaurantNo");
		RestaurantDTO restaurantDTO = null;
		
		try {
			conn = DbUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, restaurantNo);
			rs = ps.executeQuery();
			if(rs.next()) {
				restaurantDTO = new RestaurantDTO();
				restaurantDTO.setRestaurantNo(rs.getInt(1));
				restaurantDTO.setRestaurantName(rs.getString(2));
				restaurantDTO.setCategoryName(rs.getString(3));
				restaurantDTO.setCategoryDetailsName(rs.getString(4));
				restaurantDTO.setRestaurantLevel(rs.getInt(5));
				restaurantDTO.setRestaurantPhone(rs.getString(6));
				restaurantDTO.setRestaurantRoadAddr(rs.getString(7));
				restaurantDTO.setRestaurantAddr(rs.getString(8));
				restaurantDTO.setRestaurantLongitude(rs.getDouble(9));
				restaurantDTO.setRestaurantLatitude(rs.getDouble(10));
				
				//해시태그 리스트 담기
				List<String> hashTagName = selectHashTagByRestaurantNo(restaurantNo);
				restaurantDTO.setHashTagName(hashTagName);
				
				//메뉴 리스트 담기
				List<MenuDTO> menuList = selectMenuByRestaurantNo(restaurantNo);
				restaurantDTO.setMenuList(menuList);
			}
			
			
		}finally {
			DbUtil.dbClose(rs, ps, conn);
		}
		return restaurantDTO;
	}
	
	/**
	 * restaurant 번호로 해시태그 검색
	 * */
	public List<String> selectHashTagByRestaurantNo(int restaurantNo) throws SQLException{
		List<String> hashTagName = new ArrayList<String>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = proFile.getProperty("adminRestaurant.selectHashTagByRestaurantNo");
		try {
			conn = DbUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, restaurantNo);
			rs = ps.executeQuery();
			while(rs.next()) {
				hashTagName.add(rs.getString(1));
			}
			
		}finally {
			DbUtil.dbClose(rs, ps, conn);
		}
		return hashTagName;
	}
	
	/**
	 * restaurant 번호로 메뉴 검색
	 * */
	public List<MenuDTO> selectMenuByRestaurantNo(int restaurantNo) throws SQLException{
		List<MenuDTO> menuList = new ArrayList<MenuDTO>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = proFile.getProperty("adminRestaurant.selectMenuByRestaurantNo");
		try {
			conn = DbUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, restaurantNo);
			rs = ps.executeQuery();
			while(rs.next()) {
				menuList.add(new MenuDTO(rs.getString(3), rs.getInt(4))); //메뉴이름, 가격 
			}
			
		}finally {
			DbUtil.dbClose(rs, ps, conn);
		}
		return menuList;
		
	}

	@Override
	public List<String> selectAllHashTag() throws SQLException {
		List<String> hashTagList = new ArrayList<String>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = proFile.getProperty("adminRestaurant.selectAllHashTag");
		try {
			conn = DbUtil.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				hashTagList.add(rs.getString(1));
			}
			
		}finally {
			DbUtil.dbClose(rs, ps, conn);
		}
		return hashTagList;
	}

	@Override
	public int update(RestaurantDTO restaurantDTO) throws SQLException {
		System.out.println("restaurantNo=" +restaurantDTO.getRestaurantNo());
		Connection conn = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = proFile.getProperty("adminRestaurant.update");
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
			ps.setInt(11, restaurantDTO.getRestaurantNo());
			result = ps.executeUpdate();

			//해시 태그 관계 테이블 데이터 삭제
			deleteHashTagRelByRestaurantNo(conn, restaurantDTO.getRestaurantNo());
			
			//메뉴 테이블 데이터 삭제
			deleteMenuByRestaurantNo(conn, restaurantDTO.getRestaurantNo());
			
			//맛집 이미지테이블 데이터 삭제
			deleteImgByRestaurantNo(conn, restaurantDTO.getRestaurantNo());
			
			//해시 태그 리스트에 해시태그가 있는경우
			List<String> hashTagName = restaurantDTO.getHashTagName();
			if(hashTagName.size() >= 1) {
				int hashTagResult = insertHashTag(conn, hashTagName, restaurantDTO.getRestaurantNo());
			}
			
			//메뉴 리스트에 메뉴가 있는경우
			List<MenuDTO> menuList = restaurantDTO.getMenuList();
			if(menuList.size() >= 1) {
				int menuResult = insertMenuByRestaurantNo(conn, menuList, restaurantDTO.getRestaurantNo());
			}
				
			//이미지 리스트에 이미지가 있는경우
			List<String> imgList = restaurantDTO.getImgList();
			if(imgList.size() >= 1) {
				int imgResult = insertImgByRestaurantNo(conn, imgList, restaurantDTO.getRestaurantNo());
			}
			
			conn.commit();
			
		}finally {
			DbUtil.dbClose(ps, conn);
		}
		return result;
	}
	
	/**
	 * restaurant 번호로 해시태그 관계 삭제
	 * */
	public int deleteHashTagRelByRestaurantNo(Connection conn, int restaurantNo) throws SQLException{
		PreparedStatement ps = null;
		int result = 0;
		String sql = proFile.getProperty("adminRestaurant.deleteHashTagRelByRestaurantNo");
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, restaurantNo);
			result = ps.executeUpdate();
		}finally {
			DbUtil.dbClose(ps, null);
		}
		
		return result;
	}
	
	/**
	 * restaurant 번호로 메뉴 삭제
	 * */
	public int deleteMenuByRestaurantNo(Connection conn, int restaurantNo) throws SQLException{
		PreparedStatement ps = null;
		int result = 0;
		String sql = proFile.getProperty("adminRestaurant.deleteMenuByRestaurantNo");
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, restaurantNo);
			result = ps.executeUpdate();
		}finally {
			DbUtil.dbClose(ps, null);
		}
		
		return result;
	}
	
	/**
	 * restaurant 번호로 이미지 삭제
	 * */
	public int deleteImgByRestaurantNo(Connection conn, int restaurantNo) throws SQLException{
		PreparedStatement ps = null;
		int result = 0;
		String sql = proFile.getProperty("adminRestaurant.deleteImgByRestaurantNo");
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, restaurantNo);
			result = ps.executeUpdate();
		}finally {
			DbUtil.dbClose(ps, null);
		}
		
		return result;
	}
	
	/**
	 * update시 restaurant 번호로 메뉴 삽입
	 * */
	public int insertMenuByRestaurantNo(Connection conn, List<MenuDTO> menuList, int restaurantNo) throws SQLException{
		PreparedStatement ps = null;
		int result = 0;
		String sql = proFile.getProperty("adminRestaurant.insertMenuByRestaurantNo");
		
		try {
			ps = conn.prepareStatement(sql);
			for(MenuDTO menuDTO : menuList) {
				ps.setInt(1, restaurantNo);
				ps.setString(2, menuDTO.getMenuName());
				ps.setInt(3, menuDTO.getMenuPrice());
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
	
	/**
	 * update시 restaurant 번호로 해시태그 관계 삽입 1단계 (insert시의 insertHashTag 메소드 오버로딩)
	 * */
	public int insertHashTag(Connection conn, List<String> hashTagName, int restaurantNo) throws SQLException{
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
					result = insertHashTagRelationByRestaurantNo(conn, hashTagNo, restaurantNo);
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
	
	/**
	 * update시 restaurant 번호로 해시태그 관계 삽입 2단계
	 * */
	public int insertHashTagRelationByRestaurantNo(Connection conn, int hashTagNo, int restaurantNo) throws SQLException{
		PreparedStatement ps = null;
		int result = 0;
		String sql = proFile.getProperty("adminRestaurant.insertHashTagRelationByRestaurantNo");
		
		try {
			System.out.println(hashTagNo + ", " + restaurantNo);
			ps = conn.prepareStatement(sql);
			ps.setInt(1, hashTagNo);
			ps.setInt(2, restaurantNo);
			result = ps.executeUpdate();
			
		}finally {
			DbUtil.dbClose(ps, null);
		}
		
		return result;
	}
	
	/**
	 * update시 restaurant 번호로 이미지 삽입
	 * */
	public int insertImgByRestaurantNo(Connection conn, List<String> imgList, int restaurantNo) throws SQLException{
		PreparedStatement ps = null;
		int result = 0;
		String sql = proFile.getProperty("adminRestaurant.insertImgByRestaurantNo");
		
		try {
			ps = conn.prepareStatement(sql);
			for(String imgName : imgList) {
				ps.setInt(1, restaurantNo);
				ps.setString(2, imgName);
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
}
