package io.namoosori.travelclub.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
 * Servlet implementation class ClubModifyServlet
 */
@WebServlet("/modify.do")
public class ClubModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ClubService service = new ClubServiceLogic();
		
		TravelClub foundClub = service.find(request.getParameter("name"));
		
		request.setAttribute("club", foundClub);
		
		request.getRequestDispatcher("views/club-modify.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ClubService service = new ClubServiceLogic();
		
		String name = request.getParameter("clubName").trim();
		String intro = request.getParameter("clubIntro").trim();
		String foundationTime_str = request.getParameter("clubFoundationTime").trim();
		long foundationTime = DateUtil.toLong(foundationTime_str);
		
		TravelClub club = service.find(name);
		club.setIntro(intro);
		club.setFoundationTime(foundationTime != 0 ? foundationTime : 0);
		service.modify(club);
		
		response.sendRedirect("modify.do?name=" + name);
		
		//request.setAttribute("foundClub", club);
		
		//request.getRequestDispatcher("views/club-detail.jsp").forward(request, response);
	}

}
