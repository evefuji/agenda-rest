<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Objects" %>
<%@ page import="java.util.Collection" %>
<%@ page import="br.com.senai.agenda.entities.Contato" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>.: Agenda Telefônica :.</title>
	</head>
	<body>
		<h1>Agenda Telefônica</h1>
		<form method="POST" action="agenda">
			<label for="nome">Nome</label>
			<input name="nome" id="nome"/>
			<br/>
			<label for="telefone">Telefone</label>
			<input name="telefone" id="telefone"/>
			<input type="submit"/>
		</form>
		<%
		Object objeto = request.getAttribute("agenda");
		
		if (Objects.nonNull(objeto) && objeto instanceof Collection){
			Collection<Contato> agenda = (Collection<Contato>) objeto;
			if (!agenda.isEmpty()) {
		%>
		<table>
			<thead>
				<tr>
					<td>Nome</td>
					<td>Telefone</td>
					<td>Ação</td>
				</tr>
			</thead>
			<tbody>
				<%
				for (Contato contato:agenda) {
				%>
				<tr>
					<td><%=contato.getNome() %></td>
					<td><%=contato.getTelefone() %></td>
					<td>Excluir</td>
				</tr>
				<% } %>
			</tbody>
		</table>
		<%
			}
		}
		%>
	</body>
</html>