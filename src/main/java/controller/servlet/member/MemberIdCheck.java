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
 * Servlet implementation class MemberIdCheck
 */
@WebServlet("/memberIdCheck")
public class MemberIdCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		
		MemberService service = new MemberServiceImpl();
		
		String searchId = request.getParameter("id");
		//System.out.println("searchId: "+searchId);
		
		
		PrintWriter out = response.getWriter();
		
		try {
			String id = service.idCheck(searchId);
			
			if(searchId.equals(id)) {
				out.print("중복되는 아이디가 존재합니다.");
			}else {
				out.print("사용가능한 아이디 입니다.");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

}
