<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
<nav class="navbar navbar-expand-lg navbar-warning bg-warning ">
	<p class="nav-link text-primary-emphasis" style="visibility: hidden;">|||||</p>
	<a class="navbar-brand text-primary" href="home.jsp"><img src="imagem/logo2.png" alt="logo" class="img_logo"> </a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item"><a class="nav-link text-primary-emphasis"
				href="filme?acao=abrir-form-cadastro">Cadastrar Filme</a></li>
				
				<li class="nav-link text-primary-emphasis">|</li>
				
			<li class="nav-item"><a class="nav-link text-primary-emphasis"
				href="filme?acao=listar">Filmes</a></li>
				
				<li class="nav-link text-primary-emphasis">|</li>
				
				<li class="nav-item"><a class="nav-link text-primary-emphasis "
				href="genero?acao=abrir-form-cadastro">Cadastrar Genêro</a></li>
				
				<li class="nav-link text-primary-emphasis">|</li>
				
				<li class="nav-item"><a class="nav-link text-primary-emphasis"
				href="genero?acao=listar">Genêros</a></li>
				
				<li class="nav-link text-primary-emphasis">|</li>
				
				<li class="nav-item"><a class="nav-link text-primary-emphasis"
				href="produtora?acao=abrir-form-cadastro">Cadastrar Produtora</a></li>
				
				<li class="nav-link text-primary-emphasis">|</li>
				
				<li class="nav-item"><a class="nav-link text-primary-emphasis"
				href="produtora?acao=listar">Produtoras</a></li>
				
		</ul>
		<c:if test="${empty user}">
			<span class="navbar-text text-danger" style="margin-left:auto" >
				${erro} </span>
			<form class="navbar-nav mr-auto" action="login" method="post">
				<input class="form-control mr-auto" type="text" name="email"
					placeholder="E-mail"> 
				<input class="form-control mr-auto"
					type="password" name="senha" placeholder="Senha">
				<button class="btn btn-outline-primary my-2 my-sm-auto"
					type="submit">Entrar</button>
			</form>
		</c:if>
		<c:if test="${not empty user }">
			<span class="navbar-text" style="margin-left:auto"> ${user} <a href="login"
				class="btn btn-outline-primary my-2 my-sm-auto">Sair</a>
			</span>
		</c:if>
	</div>
	<p class="nav-link text-primary-emphasis" style="visibility: hidden;">|||||</p>
</nav>
