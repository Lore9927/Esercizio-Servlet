<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@  taglib  prefix="c"   uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Esercizio</title>
		<style>
			table, td, th {
				padding: 2px;
				text-align: center;
				border: 1px solid black;
				font-weight: normal;
			}
		</style>
		
	</head>
	<body>
		<h3>Aggiungi attività</h3>
		<form>
			<label>Nome attività</label> <input type="hidden" readonly name="id" value=${id != null ? id : ""} > <br>
			<input type="text" name="nome" value=${nome}> <br>
			<label>Data</label> <br>
			<input type="date" name="data" value=${data}> <br>
			<label>Durata</label> <br>
			<input type="number" name="durata" value=${durata}> 
			<select name="tempo">
				<option value="ora/e" ${tempo == "ora/e" ? "selected" : ""}>Ora/e</option>
				<option value="giorno/i" ${tempo == "giorno/i" ? "selected" : ""}>Giorno/i</option>
				<option value="settimana/e" ${tempo == "settimana/e" ? "selected" : ""}>Settimana/e</option>
			</select> <br> <br>
			<button type="submit" formaction="${nome != null ? '/esercizio-servlet/SetUpdate' : '/esercizio-servlet/AddServlet'}" name="bottone">Salva</button> <br> <br>
			<h3>Elimina/Modifica attività</h3>
			<label>Id attività</label>
			<input type="number" name="numero">
			<button type="submit" formaction="/esercizio-servlet/DeleteServlet" name="bottone" value="del">Elimina</button>
			<button type="submit" formaction="/esercizio-servlet/GetUpdate" name="bottone" value="getupdate">Modifica</button>
	  	</form>
		<h3>Lista attività:</h3>
		<table style="width: 50%;">
			<tr>
				<th>Id</th>
				<th>Attività</th>
				<th>Data</th>
				<th>Durata</th>
			</tr>
			<!--${lista}  -->
			<c:forEach items="${list}" var="attivita">
			<tr>
				<td>${attivita.getId()}</td>
				<td>${attivita.getNome()}</td>
				<td>${attivita.getData()}</td>
				<td>${attivita.getDurata()} ${attivita.getTempo()}</td>
			</tr>
			</c:forEach>
		
		</table>
		
	</body>
</html>