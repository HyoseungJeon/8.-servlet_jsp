package io.namoosori.travelclub.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.namoosori.travelclub.entity.TravelClub;
import io.namoosori.travelclub.service.ClubService;
import io.namoosori.travelclub.service.logic.ClubServiceLogic;

/**
 * Servlet implementation class ClubRegisterServlet
 */
@WebServlet("/register.do")
public class ClubRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.sendRedirect("views/club-register.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
		
		ClubService service = new ClubServiceLogic();
		
		
		String name = request.getParameter("clubName".trim());
		String intro = request.getParameter("clubIntro").trim();
		
		service.register(new TravelClub(name,intro));
		
		response.sendRedirect("list.do");
	}

}
