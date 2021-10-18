package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.MemberDTO;
import service.LevelUpExpService;
import service.LevelUpExpServiceImpl;
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
				
		MemberDTO member = new MemberDTO(id, pwd);
		
		MemberDTO loginMember = service.login(member);
			
		HttpSession session = request.getSession();
		session.setAttribute("loginId", loginMember.getMemberID());
		session.setAttribute("loginName", loginMember.getMemberName());
				
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
		
		//--------------레벨에 필요한 최소경험치 구하기-----------------------
		int memberLevel = Integer.parseInt(request.getParameter("memberLevel"));
		LevelUpExpService levelUpExpService = new LevelUpExpServiceImpl();
		int minExp = levelUpExpService.selectMinExpByMemberLevel(memberLevel);
		//--------------레벨에 필요한 최소경험치 구하기-----------------------
		
		MemberDTO member = new MemberDTO(0, id, pwd, name, email, phone, birth, null, minExp, null, null, null);
		
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

	public ModelAndView updateByNo(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String url = "error/error.jsp";
		String errorMsg = "Something Went Wrong.";
		
		String memberName = request.getParameter("memberName");
		String memberEmail = request.getParameter("memberEmail");
		String memberPhone = request.getParameter("memberPhone");
		String memberBirth = request.getParameter("memberBirth");
		int memberNo = Integer.parseInt(request.getParameter("memberNo"));
		
		MemberDTO member = new MemberDTO(memberNo, memberName, memberEmail, memberPhone, memberBirth);
		service.updateByNo(member);
		
		
		return new ModelAndView("myPage/myPageAccount.jsp");
		
	}
	
	public ModelAndView updateExpByNo(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String url = "error/error.jsp";
		String errorMsg = "Something Went Wrong.";
		
		int memberExp = Integer.parseInt(request.getParameter("memberExp"));
		int memberNo = Integer.parseInt(request.getParameter("memberNo"));
		
		MemberDTO member = new MemberDTO();
		member.setMemberExp(memberExp);
		member.setMemberNo(memberNo);
		
		service.updateExpByNo(member);

		return new ModelAndView("myPage/myPageLevel.jsp");
	}
	public ModelAndView updateImageByNo(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String url = "error/error.jsp";
		String errorMsg = "Something Went Wrong.";
		
		String profileImage = request.getParameter("profileImage");
		int memberNo = Integer.parseInt(request.getParameter("memberNo"));
		
		MemberDTO member = new MemberDTO();
		member.setProfileImage(profileImage);
		member.setMemberNo(memberNo);
		
		service.updateImageByNo(member);
		
		MemberDTO dbmember = service.selectMemberByNo(memberNo);	
		request.setAttribute("member", dbmember);
		return new ModelAndView("myPage/myPageLevel.jsp");
	}
	
	public ModelAndView updatePwdByNo(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		String url = "error/error.jsp";
		String errorMsg = "Something Went Wrong.";
		
		String profileImage = request.getParameter("memberPwd");
		int memberNo = Integer.parseInt(request.getParameter("memberNo"));
		
		MemberDTO member = new MemberDTO();
		member.setProfileImage(profileImage);
		member.setMemberNo(memberNo);

		service.updatePwdByNo(member);
		
		MemberDTO dbmember = service.selectMemberByNo(memberNo);
		request.setAttribute("memberNo", memberNo);
		return new ModelAndView("myPage/myPagePassword.jsp");
	}
	
	public ModelAndView deleteByNo(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
			
		return null;	
	}
	
	public ModelAndView selectMemberList(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return null;	
	}
	
	public ModelAndView selectMemberByNo(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return null;	
	}
	
	public ModelAndView updateMemberDetail(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return null;	
	}
	
}
