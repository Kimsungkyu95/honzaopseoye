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

/**
 * Servlet implementation class MemberSelectIdByEmail
 */
@WebServlet("/memberSelectIdByEmail")
public class MemberSelectIdByEmail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		MemberService service = new MemberServiceImpl();
		PrintWriter out = response.getWriter();
		
		String email = request.getParameter("email");
		//System.out.println("servlet email: " + email);
		
		try {
		String id = service.selectIdByEmail(email);		
		
		out.print(id);
		
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
