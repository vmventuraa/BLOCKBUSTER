<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Filmes</title>
<%@ include file="header.jsp"%>
</head>
<body style="background-color:#0E3FA8">

	<%@ include file="menu.jsp"%>
	<div class="container">
	<br>
		<h1 style="color:#fff;">Filmes</h1>
	<br>	
		<c:if test="${not empty msg }">
			<div class="alert alert-success">${msg}</div>
		</c:if>
		<c:if test="${not empty erro }">
			<div class="alert alert-danger">${erro}</div>
		</c:if>
		<table class="table table-striped">
			<tr>
				<th style="color:#fff;">T�tulo</th>
				<th style="color:#fff;">Data de Publica��o</th>
				<th style="color:#fff;">G�nero</th>
				<th style="color:#fff;">Classifica��o</th>
				<th style="color:#fff;">Produtora</th>
				<th style="color:#fff;">Dura��o</th>
				<th style="color:#fff;"></th>
			</tr>
			<c:forEach items="${filmes }" var="f">
				<tr>
					<td style="color:#fff;">${f.titulo}</td>
					<td style="color:#fff;"><fmt:formatDate value="${f.dataPublicacao.time }"
							pattern="dd/MM/yyyy" /></td>
					<td style="color:#fff;">${f.genero.nome}</td>
					<td style="color:#fff;">${f.classificacao}</td>
					<td style="color:#fff;">${f.produtora.nome}</td>
					<td style="color:#fff;">${f.duracao}</td>
					<td style="color:#fff;"><c:url value="filme" var="link">
							<c:param name="acao" value="abrir-form-edicao" />
							<c:param name="codigo" value="${f.id }" />
						</c:url> <a href="${link}" class="btn btn-primary btn-xs" style="color:#0E3FA8; background-color:#F4C213; border-color:#F4C213;">Editar</a>
						<button type="button" class="btn btn-warning btn-xs"
							data-toggle="modal" data-target="#excluirModal"
							onclick="codigoExcluir.value = ${f.id}" style="color:#fff; background-color:red; border-color:red;">Excluir</button></td>
				</tr>
			</c:forEach>
		</table>
	</div>

	<%@ include file="footer.jsp"%>

	<!-- Modal -->
	<div class="modal fade" id="excluirModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Confirma��o</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">Deseja realmente excluir o filme?</div>
				<div class="modal-footer">
					<form action="filme" method="post">
						<input type="hidden" name="acao" value="excluir"> <input
							type="hidden" name="codigo" id="codigoExcluir">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Cancelar</button>
						<button type="submit" class="btn btn-warning btn-xs">Excluir</button>
					</form>
				</div>
			</div>
		</div>
	</div>

</body>
</html>
