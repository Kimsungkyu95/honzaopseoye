package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import dto.RecommendDTO;
import util.DbUtil;

public class RecommendDAOImpl implements RecommendDAO {
	/**
recommend.recByScore=select * from restaurant natural join review natural join restaurant_img natural join menu where REVIEW_SCORE > 4 and rownum <=16;
recommend.recByTag=select * from restaurant natural join review natural join restaurant_img natural join menu where hashtag_no=? and rownum <=16;
recommend.recByLevel=select * from restaurant natural join review natural join restaurant_img natural join menu where member_level = ? and rownum <=16;
recommend.recByVisited=select * from restaurant natural join review natural join restaurant_img natural join menu where rownum<=16 order by RESTAURANT_VISITED DESC;
	 * */
	
	/*Properties proFile = new Properties();
	
	public RecommendDAOImpl() {
		super();
		try {
			proFile.load(getClass().getClassLoader().getResourceAsStream("dbQuery.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	public List<RecommendDTO> recByScore() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<RecommendDTO> list = new ArrayList<RecommendDTO>();
		String sql = "select restaurant_img, restaurant_name, review_score, gu, menu_name from restaurant natural join review natural join restaurant_img natural join menu where REVIEW_SCORE > 0 and rownum <=16";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				list.add(new RecommendDTO(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5)));
		    }
		} catch (SQLException e) {
			   e.printStackTrace();
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}

		return list;
	}

	public List<RecommendDTO> recByLevel(int levelNo) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<RecommendDTO> list = new ArrayList<RecommendDTO>();
		String sql = "select restaurant_img, restaurant_name, review_score, restaurant_addr, menu_name from restaurant natural join review natural join restaurant_img natural join menu where member_level = ? and rownum <=16";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, levelNo);
			rs = ps.executeQuery();

			while (rs.next()) {
				list.add(new RecommendDTO(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5)));
		    }
		} catch (SQLException e) {
			   e.printStackTrace();
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}

		return list;
	}

	public List<RecommendDTO> recByVisited() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<RecommendDTO> list = new ArrayList<RecommendDTO>();
		String sql = "select restaurant_img, restaurant_name, review_score, restaurant_addr, menu_name from restaurant natural join review natural join restaurant_img natural join menu where rownum<=16 order by RESTAURANT_VISITED DESC";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				list.add(new RecommendDTO(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5)));
		    }
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}

		return list;
	}

	public List<RecommendDTO> recByTag(int tagNo) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<RecommendDTO> list = new ArrayList<RecommendDTO>();
		String sql = "select restaurant_img, restaurant_name, review_score, restaurant_addr, menu_name from restaurant natural join review natural join restaurant_img natural join menu where hashtag_no=? and rownum <=16";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, tagNo);
			rs = ps.executeQuery();

			while (rs.next()) {
				list.add(new RecommendDTO(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5)));
		    }
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}

		return list;
	}
	
	

}
