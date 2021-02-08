package it.objectmethod.esercizio.servlets;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.objectmethod.esercizio.entities.Attivita;

public class HomeServlet extends HttpServlet {

	private static final long serialVersionUID = -1876295150223471117L;
	private List<Attivita> lista = new ArrayList<Attivita>();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String bottone = req.getParameter("bottone");
		String ris = "";
		Attivita a;
		String nome = "";
		Date data;
		int durata;
		String tempo;
		
		switch(bottone.toLowerCase())
		{
		case "add" :
			nome = req.getParameter("nome");
			data = Date.valueOf(req.getParameter("data"));
			durata = Integer.parseInt(req.getParameter("durata"));
			tempo = req.getParameter("tempo");
			int dimensione = lista.size();
			a = new Attivita();
			if(lista.size() == 0)
			{
				a.setId(1);
			}
			else
			{
				a.setId(lista.get(dimensione-1).getId()+1);
			}
				
			a.setNome(nome);
			a.setData(data);
			a.setDurata(durata);
			a.setTempo(tempo);
			
			lista.add(a);
			
			
			break;
		case "del" :
			 int id = Integer.parseInt(req.getParameter("numero"));
			
			lista.remove(id-1);
			
			break;
		case "getupdate" :
			id = Integer.parseInt(req.getParameter("numero"))-1;
			nome = lista.get(id).getNome();
			data = lista.get(id).getData();
			durata = lista.get(id).getDurata();
			tempo = lista.get(id).getTempo();
			req.setAttribute("id", id);
			req.setAttribute("nome", nome);
			req.setAttribute("data", data);
			req.setAttribute("durata", durata);
			req.setAttribute("tempo", tempo);
			
			break;
		case "setupdate" :
			id = Integer.parseInt(req.getParameter("id"));
			nome = req.getParameter("nome");
			data = Date.valueOf(req.getParameter("data"));
			durata = Integer.parseInt(req.getParameter("durata"));
			tempo = req.getParameter("tempo");
			
			lista.get(id).setNome(nome);
			lista.get(id).setData(data);
			lista.get(id).setDurata(durata);
			lista.get(id).setTempo(tempo);
				
			
			
			break;
		default:
		}
		ris = stampaLista();
		req.setAttribute("lista", ris);
		req.getRequestDispatcher("pages/home.jsp").forward(req, resp);
	}
	
	public String stampaLista()
	{
		String ris = "";
		for(int i = 0; i < lista.size(); i++)
		{
			ris += "<tr></td>" + lista.get(i).toString() + "</tr>";
			
		}
		
		return ris;
	}
	
	

}
