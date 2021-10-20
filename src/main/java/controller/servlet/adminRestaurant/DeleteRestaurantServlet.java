package controller.servlet.adminRestaurant;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.AdminRestaurantService;
import service.AdminRestaurantServiceImpl;

/**
 * Servlet implementation class DeleteRestaurantServlet
 */
@WebServlet("/deleteRestaurantServlet")
public class DeleteRestaurantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("text/html;charset=UTF-8");
		int restaurantNo = Integer.parseInt(request.getParameter("restaurantNo"));
		String restaurantName = request.getParameter("restaurantName");
		String categoryName = request.getParameter("categoryName");
		String categoryDetailsName = request.getParameter("categoryDetailsName");
		
		System.out.println(restaurantNo);
		System.out.println(restaurantName);
		System.out.println(categoryName);
		System.out.println(categoryDetailsName);
		
		
		AdminRestaurantService adminRestaurantService = new AdminRestaurantServiceImpl();
		PrintWriter out = response.getWriter();
		try { 
			//서비스 호출
			adminRestaurantService.delete(restaurantNo);
			
			//맛집 사진 파일 삭제
			File folder = new File(request.getServletContext().getRealPath("/img/restaurantImage") + "/" + categoryName + "/" + categoryDetailsName + "/" + restaurantName);
			if(folder.exists()) {
				File [] fileList = folder.listFiles();
				for(File file : fileList) {
					file.delete();
					System.out.println("맛집 사진 파일 삭제 완료");
				}
				folder.delete();
			}
			out.print("맛집 삭제가 완료되었습니다.");
		}catch (Exception e) {
			out.print(e.getMessage());
		}
		
	}

}
