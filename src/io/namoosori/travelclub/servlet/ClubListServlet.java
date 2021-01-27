package io.namoosori.travelclub.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.namoosori.travelclub.entity.TravelClub;
import io.namoosori.travelclub.service.ClubService;
import io.namoosori.travelclub.service.logic.ClubServiceLogic;
import io.namoosori.travelclub.util.util.DateUtil;

/**
 * Servlet implementation class ClubListServlet
 */
@WebServlet("/list.do")
public class ClubListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		ClubService service = new ClubServiceLogic();
		
		String name = request.getParameter("name");
		List<TravelClub> clubList = service.findAll();
		
		request.setAttribute("clubList", clubList);
		
		request.getRequestDispatcher("views/club-list.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ClubService service = new ClubServiceLogic();
		
		String name = request.getParameter("clubName").trim();
		
		List<TravelClub> clubList = service.findByName(name.trim());
		
		request.setAttribute("clubList", clubList);
		
		request.getRequestDispatcher("views/club-list.jsp").forward(request, response);
	}
}
