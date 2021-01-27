package io.namoosori.travelclub.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.namoosori.travelclub.service.ClubService;
import io.namoosori.travelclub.service.logic.ClubServiceLogic;

/**
 * Servlet implementation class ClubDeleteServlet
 */
@WebServlet("/delete.do")
public class ClubDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		ClubService service = new ClubServiceLogic();
		
		service.delete(request.getParameter("name"));
		
		response.sendRedirect("list.do");
	}

}
