package it.objectmethod.esercizio.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.objectmethod.esercizio.model.Attivita;

public class DeleteServlet extends HttpServlet{

	private static final long serialVersionUID = -5442438552746402199L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		List<Attivita> lista = (List<Attivita>) session.getAttribute("lista");
		int id = Integer.parseInt(req.getParameter("numero"));
		
		for(int i = 0; i < lista.size(); i++)
		{
			if(lista.get(i).getId() == id)
			{
				lista.remove(i);
				break;
			}
		}
		
		session.setAttribute("lista", lista);
		req.getRequestDispatcher("/Visualizza").forward(req, resp);
	}

}
