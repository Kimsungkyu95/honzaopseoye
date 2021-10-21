package controller.servlet.adminMember;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.MemberService;
import service.MemberServiceImpl;

@WebServlet("/adminMemberDelete")
public class AdminMemberDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		int memberNo = Integer.parseInt(request.getParameter("memberNo"));
		MemberService service = new MemberServiceImpl();
		PrintWriter out = response.getWriter();
		try {
			service.deleteByNo(memberNo);
			out.print("해당 회원이 삭제되었습니다.");
		}catch (Exception e) {
			out.print(e.getMessage());
		}	
	}

}