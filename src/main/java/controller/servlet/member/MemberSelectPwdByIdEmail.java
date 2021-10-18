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
 * Servlet implementation class MemberSelectPwdByIdEmail
 */
@WebServlet("/memberSelectPwdByIdEmail")
public class MemberSelectPwdByIdEmail extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		MemberService service = new MemberServiceImpl();
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("id");
		String email = request.getParameter("email");
		
		//System.out.println("----servelt----");
		//System.out.println("id : " + id);
		//System.out.println("email : " + email);
		
		try {
			String pwd = service.selectPwdByIdEmail(id, email);		
			
			//System.out.println("pwd returned : " + pwd);
			//System.out.println("----servelt----");
			
			out.print(pwd);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
