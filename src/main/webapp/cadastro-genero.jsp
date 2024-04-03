<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Filmes</title>
<%@ include file="header.jsp"%>
</head>
<body style="background-color:#0E3FA8">
	<%@ include file="menu.jsp"%>
	<div class="container">
	<br>
		<h1 style="color:#fff;">Cadastro de Gêneros</h1>
	<br>
		<c:if test="${not empty msg }">
			<div class="alert alert-success">${msg}</div>
		</c:if>
		<c:if test="${not empty erro }">
			<div class="alert alert-danger">${erro}</div>
		</c:if>
		<form action="genero" method="post">
			<input type="hidden" value="cadastrar" name="acao">
			<div class="form-group">
				<label for="id-nome" style="color:#fff;">Nome</label> <input type="text"
					name="nome" id="id-genero" class="form-control" required>
			</div>
			
			<br> <input style="color:#0E3FA8; background-color:#F4C213; border-color:#F4C213;" type="submit" value="Salvar" class="btn btn-primary">
		</form>
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>
