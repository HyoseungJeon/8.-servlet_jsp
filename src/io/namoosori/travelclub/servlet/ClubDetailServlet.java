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
 * Servlet implementation class ClubDetailServlet
 */
@WebServlet("/detail.do")
public class ClubDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ClubService service = new ClubServiceLogic();
		
		TravelClub foundClub = service.find(request.getParameter("name"));
		
		request.setAttribute("foundClub", foundClub);
		
		request.getRequestDispatcher("views/club-detail.jsp").forward(request, response);
	}
}
