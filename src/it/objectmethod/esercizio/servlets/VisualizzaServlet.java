package it.objectmethod.esercizio.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class VisualizzaServlet extends HttpServlet{
	  
	private static final long serialVersionUID = -7751414639086766444L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(); 
		
		req.setAttribute("list", session.getAttribute("lista"));
		req.getRequestDispatcher("pages/home.jsp").forward(req, resp);
		
	}
}
