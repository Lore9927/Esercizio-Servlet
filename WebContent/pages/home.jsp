<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
		<form action="/esercizio-servlet/HomeServlet">
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
			<button type="submit" name="bottone" value="${nome != null ? 'setupdate' : 'add'}">Salva</button> <br> <br>
			<h3>Elimina attività</h3>
			<label>Id attività</label>
			<input type="number" name="numero">
			<button type="submit" name="bottone" value="del">Elimina</button>
			<button type="submit" name="bottone" value="getupdate">Modifica</button>
	  	</form>
		<h3>Lista attività:</h3>
		<table style="width: 50%;">
			<tr>
				<th>Id</th>
				<th>Attività</th>
				<th>Data</th>
				<th>Durata</th>
			</tr>
			${lista}
		</table>
		
	</body>
</html>