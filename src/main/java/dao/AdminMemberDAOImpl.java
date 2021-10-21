package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import dto.ReviewDTO;
import paging.PageCnt;
import util.DbUtil;


public class AdminMemberDAOImpl implements AdminMemberDAO {
	private Properties proFile = new Properties();
	
	public AdminMemberDAOImpl() {
		try {			
			proFile.load(getClass().getClassLoader().getResourceAsStream("dbQueryAdminRestaurant.properties"));
		}catch (Exception e) {
			e.printStackTrace();
		}
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
		case "memberName":
			sql = proFile.getProperty("adminReview.MemberNameTotalCount");
			break;
		default: //맛집 이름일경우
			sql = proFile.getProperty("adminReview.RestaurantNameTotalCount");
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
	
	/**
	 * 리뷰리스트 페이징
	 * */
	@Override
	public List<ReviewDTO> pagingSelectReview(int pageNo, String selectKey, String selectValue) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ReviewDTO> reviewList = new ArrayList<ReviewDTO>();
		
		String sql = "";
		switch (selectKey) {
		case "memberName":
			sql = proFile.getProperty("adminReview.pagingReviewByMemberName");
			break;
		default: //맛집 이름일경우
			sql = proFile.getProperty("adminReview.pagingReviewByRestaurantName");
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
				ReviewDTO reviewDTO = new ReviewDTO();
				reviewDTO.setReviewNo(rs.getInt(1));
				reviewDTO.setMemberName(rs.getString(2));
				reviewDTO.setRestaurantName(rs.getString(3));
				reviewDTO.setReviewScore(rs.getInt(4));
				reviewDTO.setReviewContent(rs.getString(5));
				reviewDTO.setReviewRegdate(rs.getString(6));
				
				reviewList.add(reviewDTO);
			}		
			
		}finally {
			DbUtil.dbClose(rs, ps, conn);
		}			
		
		return reviewList;
		
	}

	@Override
	public int adminDeleteReview(int reviewNo) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = proFile.getProperty("adminReview.deleteReview");
		
		try {
			conn = DbUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, reviewNo);
			result = ps.executeUpdate();
		}finally {
			DbUtil.dbClose(ps, conn);
		}
		return result;
	}

}
