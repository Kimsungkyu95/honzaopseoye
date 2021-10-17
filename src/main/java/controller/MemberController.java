package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.MemberDTO;
import service.MemberService;
import service.MemberServiceImpl;

public class MemberController implements Controller {
	
	MemberService service = new MemberServiceImpl();

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
				
		String url = "error/error.jsp";
		String errorMsg = "Something Went Wrong.";
		ModelAndView mv = new ModelAndView(url, false);
		
		String id = request.getParameter("memberId");
		String pwd = request.getParameter("memberPwd");
		
		String rememberMe = request.getParameter("remember-me");
		boolean remember = false;
		//System.out.println("rememberMe: " + rememberMe);
		if(rememberMe.equals("remember-me")) {
			remember=true;
		}
		
		MemberDTO member = new MemberDTO(id, pwd);
		
		MemberDTO loginMember = service.login(member, remember);
			
		HttpSession session = request.getSession();
		session.setAttribute("loginId", loginMember.getMemberID());
		session.setAttribute("loginName", loginMember.getMemberName());
		if(remember) {
			
		}
				
		mv.setViewName("main.jsp");
		mv.setRedirect(true);
			
		return mv;
	}
	
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
				
		HttpSession session = request.getSession();
		
		session.invalidate(); 
		
		return new ModelAndView("main.jsp");
	}
	
	public ModelAndView insert(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String url = "error/error.jsp";
		String errorMsg = "Something Went Wrong.";
		ModelAndView mv = new ModelAndView(url, false);
		
		String id = request.getParameter("memberId");
		String pwd = request.getParameter("memberPwd");
		String name = request.getParameter("memberName");
		String email = request.getParameter("memberEmail");
		String phone = request.getParameter("memberPhone");
		String birth = request.getParameter("memberBirth");
		
		MemberDTO member = new MemberDTO(0, id, pwd, name, email, phone, birth, phone, 0, birth, null, null);
		
		service.insert(member);
		
		request.setAttribute("name", name);
		//-----자동으로 로그인 시켜버리기--------
		HttpSession session = request.getSession();
		session.setAttribute("loginId", id);
		session.setAttribute("loginName", name);
		//-----자동으로 로그인 시켜버리기--------
		
		mv.setViewName("/member/levelTestResult.jsp");
		mv.setRedirect(false);
		
		return mv;
	}
	
	public void selectIdByEmail(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		String email = request.getParameter("email");
		
		String id = service.selectIdByEmail(email);
		
		PrintWriter out = response.getWriter();
		out.print(id);
		
	}
	
	

}
