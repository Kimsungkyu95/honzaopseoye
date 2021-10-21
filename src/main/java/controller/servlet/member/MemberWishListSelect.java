package controller.servlet.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.MemberService;
import service.MemberServiceImpl;

public class MemberWishListSelect extends HttpServlet {

@WebServlet("/memberWishListSelect")
	public class MemberWishSelct extends HttpServlet{
		private static final long serialVersionUID = 1L;
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html;charset=UTF-8");
			MemberService service = new MemberServiceImpl();
			PrintWriter out = response.getWriter();
			
			try {
				
				
			}catch(Exception e) {
				
			}
			
		}		
	}
}
