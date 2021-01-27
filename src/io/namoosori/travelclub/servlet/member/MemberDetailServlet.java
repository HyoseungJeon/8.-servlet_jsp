package io.namoosori.travelclub.servlet.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.namoosori.travelclub.entity.ClubMember;
import io.namoosori.travelclub.entity.TravelClub;
import io.namoosori.travelclub.service.MemberService;
import io.namoosori.travelclub.service.logic.MemberServiceLogic;

/**
 * Servlet implementation class MemberDetailServlet
 */
@WebServlet("/member-detail.do")
public class MemberDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MemberService service = new MemberServiceLogic();
		
		ClubMember foundMember = service.find(request.getParameter("email"));
		
		request.setAttribute("foundMember", foundMember);
		
		request.getRequestDispatcher("views/member-detail.jsp").forward(request, response);
	}

}
