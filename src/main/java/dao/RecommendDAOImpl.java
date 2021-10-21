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
	
	public List<RecommendDTO> recByScore() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<RecommendDTO> list = new ArrayList<RecommendDTO>();
		String sql = "select restaurant_img, restaurant_name, gu, category_name, category_details_name, restaurant_no from restaurant join restaurant_img using(restaurant_no) join category_details using(category_details_no) join category using(category_no) where restaurant_img like '%0%' and rownum<=16 order by restaurant_visited desc";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				list.add(new RecommendDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getInt(6)));
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
		String sql = "select distinct restaurant_img, restaurant_name, gu, category_name, category_details_name , restaurant_no from restaurant join restaurant_img using(restaurant_no) join category_details using(category_details_no) join category using(category_no) where restaurant_img like '%0%' and rownum<=16 AND RESTAURANT_LEVEL=?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, levelNo);
			rs = ps.executeQuery();

			while (rs.next()) {
				list.add(new RecommendDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5) ,rs.getInt(6)));
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
		String sql = "select restaurant_img, restaurant_name, gu, category_name, category_details_name, restaurant_no from restaurant join restaurant_img using(restaurant_no) join category_details using(category_details_no) join category using(category_no) where restaurant_img like '%0%' and rownum<=16 order by RESTAURANT_VISITED desc";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				list.add(new RecommendDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5) ,rs.getInt(6)));
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
		String sql = "select restaurant_img, restaurant_name, gu, category_name, category_details_name, restaurant_no from restaurant join restaurant_img using(restaurant_no) join category_details using(category_details_no) join category using(category_no) join hashtag_relation using(restaurant_no) join hashtag using(hashtag_no) where restaurant_img like '%0%' and rownum<=16 AND hashtag_no=?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, (tagNo+1));
			rs = ps.executeQuery();

			while (rs.next()) {
				list.add(new RecommendDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5) ,rs.getInt(6)));
		    }
		} catch (SQLException e) {
			   e.printStackTrace();
		}finally {
			DbUtil.dbClose(rs, ps, con);
		}

		return list;
	}
	
	

}
