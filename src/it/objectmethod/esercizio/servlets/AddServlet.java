package it.objectmethod.esercizio.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.objectmethod.esercizio.model.Attivita;

public class AddServlet extends HttpServlet{

	private static final long serialVersionUID = 3813420947456181689L;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		List<Attivita> lista = (List<Attivita>) session.getAttribute("lista");
		
		if(session.getAttribute("lista") == null)
		{
			lista = new ArrayList<Attivita>();
		}
		
		Attivita a = new Attivita();
		String nome = req.getParameter("nome");
		String data = req.getParameter("data"); 
		int durata = Integer.parseInt(req.getParameter("durata"));
		String tempo = req.getParameter("tempo");
		int dimensione = lista.size()-1;
		if(lista.size() == 0)
		{
			a.setId(1);
		}
		else
		{
			a.setId(lista.get(dimensione).getId()+1);
		}
			
		a.setNome(nome);
		a.setData(data);
		a.setDurata(durata);
		a.setTempo(tempo);
		
		lista.add(a);
		
		session.setAttribute("lista", lista);
		req.getRequestDispatcher("/Visualizza").forward(req, resp);
	}
}
