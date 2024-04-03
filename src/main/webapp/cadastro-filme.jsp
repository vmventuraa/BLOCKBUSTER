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
		<h1 style="color:#fff;">Cadastro de Filmes</h1>
	<br>
		<c:if test="${not empty msg }">
			<div class="alert alert-success">${msg}</div>
		</c:if>
		<c:if test="${not empty erro }">
			<div class="alert alert-danger">${erro}</div>
		</c:if>
		
		<form action="filme" method="post" onsubmit="return validarFormulario()">
			<span id="mensagemErro" style="color: red; display: none;">
        		Por favor, selecione uma opção na caixa de seleção antes de enviar o formulário.
        	</span>
			<input type="hidden" value="cadastrar" name="acao">
			<div class="form-group">
				<label for="id-titulo" style="color:#fff;">Título</label> <input type="text"
					name="titulo" id="id-titulo" class="form-control" required>
			</div>
			<br>
			<div class="form-group">
				<label for="id-publicacao" style="color:#fff;">Data de Publicação</label> <input
					type="text" name="publicacao" id="id-publicacao" class="form-control" required>
			</div>
			<br>
			<div class="form-group">
				<label for="id-genero" style="color:#fff;">Gênero</label> <select name="genero"
					id="id-genero" class="form-select">
					<option value="selecionado" selected disabled>Selecione..</option>
					<c:forEach items="${generos}" var="g">
						<option value="${g.id}">${g.nome}</option>
					</c:forEach>
				</select>
			</div>
			<br>
			<div class="form-group">
				<label for="id-classificacao" style="color:#fff;">Classificação</label> <input
					type="text" name="classificacao" id="id-classificacao"
					class="form-control" required>
			</div>
			<br>
			<div class="form-group">
				<label for="id-produtora" style="color:#fff;">Produtora</label> <select name="produtora"
					id="id-produtora" class="form-select">
					<option value="selecionado" selected disabled>Selecione..</option>
					<c:forEach items="${produtoras}" var="p">
						<option value="${p.id}">${p.nome}</option>
					</c:forEach>
				</select>
			</div>
			<br>
			<div class="form-group">
				<label for="id-duracao" style="color:#fff;">Duração</label> <input type="text"
					name="duracao" id="id-duracao" class="form-control" required>
			</div>
			<br> <input style="color:#0E3FA8; background-color:#F4C213; border-color:#F4C213;" type="submit" value="Salvar" class="btn btn-primary">
		</form>
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>
