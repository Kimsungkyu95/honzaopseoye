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
		String sql = "select restaurant_img, restaurant_name, review_score, gu from restaurant join restaurant_img using(restaurant_no) join review using(restaurant_no) where REVIEW_SCORE>1 and restaurant_img like '%0%'";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				list.add(new RecommendDTO(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4)));
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
		String sql = "";
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

	public List<RecommendDTO> recByVisited() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<RecommendDTO> list = new ArrayList<RecommendDTO>();
		String sql = "";
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

	public List<RecommendDTO> recByTag(int tagNo) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<RecommendDTO> list = new ArrayList<RecommendDTO>();
		String sql = "";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, tagNo);
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
	
	

}
