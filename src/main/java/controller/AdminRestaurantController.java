package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import service.AdminRestaurantService;
import service.AdminRestaurantServiceImpl;

public class AdminRestaurantController implements Controller {
	
	private AdminRestaurantService adminRestaurantService = new AdminRestaurantServiceImpl();
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ModelAndView insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException{
		String saveDir = request.getServletContext().getRealPath("/img");
		int maxSize = 1024*1024*100; //100M
		String encoding = "UTF-8";
        
        MultipartRequest multi = new MultipartRequest(request, saveDir, maxSize, encoding, new DefaultFileRenamePolicy());
		return null;
	}
	

}
