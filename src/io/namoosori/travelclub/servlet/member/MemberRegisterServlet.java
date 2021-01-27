package io.namoosori.travelclub.servlet.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.namoosori.travelclub.entity.ClubMember;
import io.namoosori.travelclub.service.MemberService;
import io.namoosori.travelclub.service.logic.MemberServiceLogic;

/**
 * Servlet implementation class MemberRegisterServlet
 */
@WebServlet("/memberRegister.do")
public class MemberRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
		response.sendRedirect("views/member-register.jsp");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MemberService service = new MemberServiceLogic();
		
		String email = request.getParameter("memberEmail".trim());
		String name = request.getParameter("memberName".trim());
		String nickName = request.getParameter("memberNickname".trim());
		String password = request.getParameter("memberPassword".trim());
		String password2 = request.getParameter("memberPassword2".trim());
		String phoneNumber = request.getParameter("memberPhoneNumber".trim());
		String birthDay = request.getParameter("memberBirthDay".trim());
		
		if(!password.equals(password2)) {
			ClubMember member = new ClubMember(email, name, phoneNumber);
			
			member.setNickname(nickName);
			member.setPassword(password2);
			member.setBirthDay(birthDay);
			
			service.register(member);
			
			response.sendRedirect("list.do");
		}
		
	}
}
