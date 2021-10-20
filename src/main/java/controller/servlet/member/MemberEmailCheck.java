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
 * Servlet implementation class MemberEmailCheck
 */
@WebServlet("/memberEmailCheck")
public class MemberEmailCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		MemberService service = new MemberServiceImpl();
		PrintWriter out = response.getWriter();
		
		String searchEmail = request.getParameter("email");
		
		//System.out.println("----servlet----");
		//System.out.println("input email : " + searchEmail);
		
		try {
			String email = service.emailCheck(searchEmail);
			
			//System.out.println("output email : " + email);
			//System.out.println("----servlet----");
			
			if(searchEmail.equals(email)) {
				out.print("중복되는 이메일이 존재합니다.");
			}else {
				out.print("사용가능한 이메일 입니다.");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
