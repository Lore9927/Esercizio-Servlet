package it.objectmethod.esercizio.entities;

import java.sql.Date;

public class Attivita 
{
	private int id;
	private String nome;
	private Date data;
	private int durata;
	private String tempo;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public int getDurata() {
		return durata;
	}
	public void setDurata(int durata) {
		this.durata = durata;
	}
	public String getTempo() {
		return tempo;
	}
	public void setTempo(String tempo) {
		this.tempo = tempo;
	}
	
	public String toString()
	{
		return    "<td>" + id + "</td>"
				+ "<td>" + nome + "</td>"
				+ "<td>" + data + "</td>"
				+ "<td>" + durata + " " + tempo + "</td>"
				;
	}
}
