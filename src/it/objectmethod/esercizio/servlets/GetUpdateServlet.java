package it.objectmethod.esercizio.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.objectmethod.esercizio.model.Attivita;

public class GetUpdateServlet extends HttpServlet{

	private static final long serialVersionUID = 2724643155373692738L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		List<Attivita> lista = (List<Attivita>) session.getAttribute("lista");
		int id = Integer.parseInt(req.getParameter("numero"));
		String nome;
		String data;
		int durata;
		String tempo;
		
		for(int i = 0; i < lista.size(); i++)
		{
			if(lista.get(i).getId() == id)
			{
				nome = lista.get(i).getNome();
				data = lista.get(i).getData();
				durata = lista.get(i).getDurata();
				tempo = lista.get(i).getTempo();
				req.setAttribute("id", id);
				req.setAttribute("nome", nome);
				req.setAttribute("data", data);
				req.setAttribute("durata", durata);
				req.setAttribute("tempo", tempo);
				break;
			}
		}		
		
		session.setAttribute("lista", lista);
		req.getRequestDispatcher("/Visualizza").forward(req, resp);
	}
}
