<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Atualização de Gêneros</title>
<%@ include file="header.jsp"%>
</head>
<body style="background-color:#0E3FA8">
	<%@ include file="menu.jsp"%>
	<div class="container">
	<br>
		<h1 style="color:#fff;">Edição de Gênero</h1>
	<br>	
		<form action="genero" method="post">
			<input type="hidden" value="editar" name="acao"> <input
				type="hidden" value="${genero.id}" name="codigo">

			<div class="form-group">
				<label for="id-nome" style="color:#fff;">Nome</label> <input type="text"
					name="nome" id="id-nome" class="form-control"
					value="${genero.nome}" required>
			</div>
			
			

			<br> <input style="color:#0E3FA8; background-color:#F4C213; border-color:#F4C213;" type="submit" value="Salvar" class="btn btn-primary">
			<a href="genero?acao=listar" class="btn btn-danger">Cancelar</a>
		</form>
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>
