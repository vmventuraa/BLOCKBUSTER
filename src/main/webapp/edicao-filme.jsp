<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Atualização de Filmes</title>
<%@ include file="header.jsp"%>
</head>
<body style="background-color:#0E3FA8">
	<%@ include file="menu.jsp"%>
	<div class="container">
	<br>
		<h1 style="color:#fff;">Edição de Filme</h1>
	<br>
		<form action="filme" method="post">
			<input type="hidden" value="editar" name="acao"> <input
				type="hidden" value="${filme.id }" name="codigo">

			<div class="form-group">
				<label for="id-titulo" style="color:#fff;">Título</label> <input type="text"
					name="titulo" id="id-titulo" class="form-control"
					value="${filme.titulo }" required>
			</div>
			<br>
			<div class="form-group">
				<label for="id-publicacao" style="color:#fff;">Data de Publicação</label> <input
					type="text" name="publicacao" id="id-publicacao" class="form-control"
					value='<fmt:formatDate value="${filme.dataPublicacao.time }" pattern="dd/MM/yyyy"/>' required>
			</div>
			<br>

			<div class="form-group">
				<label for="id-genero" style="color:#fff;">Gênero</label> <select name="genero"
					id="id-genero" class="form-select">
					<option value="0" disabled>Selecione..</option>
					<c:forEach items="${generos}" var="g">
						<c:if test="${g.id == filme.genero.id }">
							<option value="${g.id }" selected>${g.nome }</option>
						</c:if>
						<c:if test="${g.id != filme.genero.id }">
							<option value="${g.id }">${g.nome }</option>
						</c:if>
					</c:forEach>
				</select>
			</div>
			<br>
			<div class="form-group">
				<label for="id-classificacao" style="color:#fff;">Classificação</label> <input
					type="text" name="classificacao" id="id-classificacao"
					class="form-control" value="${filme.classificacao}" required>

			</div>
			<br>
			<div class="form-group">
				<label for="id-produtora" style="color:#fff;">Produtora</label> <select name="produtora"
					id="id-produtora" class="form-select">
					<option value="0"disabled>Selecione..</option>
					<c:forEach items="${produtoras}" var="p">
						<c:if test="${p.id == filme.produtora.id }">
							<option value="${p.id }" selected>${p.nome }</option>
						</c:if>
						<c:if test="${p.id != filme.produtora.id }">
							<option value="${p.id }">${p.nome }</option>
						</c:if>
					</c:forEach>
				</select>
			</div>
			<br>
			<div class="form-group">
				<label for="id-duracao" style="color:#fff;">Duração</label> <input type="text"
					name="duracao" id="id-duracao" class="form-control"
					value="${filme.duracao}" required>
			</div>
			<br> <input style="color:#0E3FA8; background-color:#F4C213; border-color:#F4C213;" type="submit" value="Salvar" class="btn btn-primary">
			<a href="filme?acao=listar" class="btn btn-danger">Cancelar</a>
		</form>
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>
