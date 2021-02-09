package it.objectmethod.esercizio.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.objectmethod.esercizio.model.Attivita;

public class SetUpdateServlet extends HttpServlet{

	private static final long serialVersionUID = -3214316158440604775L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		List<Attivita> lista = (List<Attivita>) session.getAttribute("lista");
		
		int id = Integer.parseInt(req.getParameter("id"));
		String nome = req.getParameter("nome");
		String data = req.getParameter("data");
		int durata = Integer.parseInt(req.getParameter("durata"));
		String tempo = req.getParameter("tempo");
		
		for(int i = 0; i < lista.size(); i++)
		{
			if(lista.get(i).getId() == id)
			{
				lista.get(i).setNome(nome);
				lista.get(i).setData(data);
				lista.get(i).setDurata(durata);
				lista.get(i).setTempo(tempo);
				break;
			}
		}		
		
		session.setAttribute("lista", lista);
		req.getRequestDispatcher("/Visualizza").forward(req, resp);
	}

}
