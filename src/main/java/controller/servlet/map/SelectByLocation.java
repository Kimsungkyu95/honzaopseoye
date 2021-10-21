package controller.servlet.map;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.RestaurantDTO;
import net.sf.json.JSONArray;
import service.UserRestaurantService;
import service.UserRestaurantServiceImpl;

/**
 * Servlet implementation class SelectByLocation
 */
@WebServlet("/SelectByLocation")
public class SelectByLocation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserRestaurantService urService = new UserRestaurantServiceImpl();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String gu = request.getParameter("gu");
		String dong = request.getParameter("dong");
		
		List<RestaurantDTO> reList = new ArrayList<RestaurantDTO>();

		try {
			reList= urService.selectByGu(gu,dong);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JSONArray arr = JSONArray.fromObject(reList);
		PrintWriter out = response.getWriter();
		out.print(arr);
	}

}
