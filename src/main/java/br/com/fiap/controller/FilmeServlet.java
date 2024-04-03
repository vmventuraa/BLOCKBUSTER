package br.com.fiap.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiao.dao.FilmeDAO;
import br.com.fiao.dao.GeneroDAO;
import br.com.fiao.dao.ProdutoraDAO;
import br.com.fiap.exception.DBException;
import br.com.fiap.factory.DAOFactory;
import br.com.fiap.model.Filme;
import br.com.fiap.model.Genero;
import br.com.fiap.model.Produtora;

@WebServlet("/filme")
public class FilmeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private FilmeDAO filmeDao;
	private GeneroDAO generoDao;
	private ProdutoraDAO produtoraDao;

	public void init() throws ServletException {
		super.init();
		filmeDao = DAOFactory.getFilmeDAO();
		generoDao = DAOFactory.getGeneroDAO();
		produtoraDao = DAOFactory.getProdutoraDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String acao = request.getParameter("acao");

		switch (acao) {
		case "listar":
			listar(request, response);
			break;
		case "abrir-form-cadastro":
			abrirFormCadastro(request, response);
			break;
		case "abrir-form-edicao":
			abrirFormEdicao(request, response);
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String acao = request.getParameter("acao");

		switch (acao) {
		case "cadastrar":
			cadastrar(request, response);
			break;
		case "editar":
			editar(request, response);
			break;
		case "excluir":
			excluir(request, response);
			break;
		default:
			break;
		}
	}

	private void abrirFormCadastro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		carregarOpcoesGenero(request);
		carregarOpcoesProdutora(request);
		request.getRequestDispatcher("cadastro-filme.jsp").forward(request, response);
	}

	private void carregarOpcoesProdutora(HttpServletRequest request) throws ServletException, IOException {
		List<Produtora> listaProdutora = produtoraDao.listar();
		request.setAttribute("produtoras", listaProdutora);

	}

	private void carregarOpcoesGenero(HttpServletRequest request) throws ServletException, IOException {
		List<Genero> listaGenero = generoDao.listar();
		request.setAttribute("generos", listaGenero);

	}

	private void excluir(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int codigo = Integer.parseInt(request.getParameter("codigo"));
		try {
			filmeDao.remover(codigo);
			request.setAttribute("msg", "Filme removido!");
		} catch (DBException e) {
			e.printStackTrace();
			request.setAttribute("erro", "Erro ao remover");
		}
		listar(request, response);
	}

	private void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int codigo = Integer.parseInt(request.getParameter("codigo"));
			String titulo = request.getParameter("titulo");
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			Calendar publicacao = Calendar.getInstance();
			publicacao.setTime(format.parse(request.getParameter("publicacao")));
			int codigoGenero = Integer.parseInt(request.getParameter("genero"));
			int classificacao = Integer.parseInt(request.getParameter("classificacao"));
			int codigoProdutora = Integer.parseInt(request.getParameter("produtora"));
			int duracao = Integer.parseInt(request.getParameter("duracao"));

			Genero genero = new Genero();
			genero.setId(codigoGenero);

			Produtora produtora = new Produtora();
			produtora.setId(codigoProdutora);

			Filme filme = new Filme(titulo, publicacao, classificacao, duracao);
			filme.setGenero(genero);
			filme.setProdutora(produtora);
			filme.setId(codigo);
			filmeDao.atualizar(filme);

			request.setAttribute("msg", "Filme Atualizado!");
		} catch (DBException db) {
			db.printStackTrace();
			request.setAttribute("erro", "Erro ao Atualizar");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", "Por favor, valide os dados");
		}
		abrirFormCadastro(request, response);

	}

	private void cadastrar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String titulo = request.getParameter("titulo");
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			Calendar publicacao = Calendar.getInstance();
			publicacao.setTime(format.parse(request.getParameter("publicacao")));
			int codigoGenero = Integer.parseInt(request.getParameter("genero"));
			int classificacao = Integer.parseInt(request.getParameter("classificacao"));
			int codigoProdutora = Integer.parseInt(request.getParameter("produtora"));
			int duracao = Integer.parseInt(request.getParameter("duracao"));

			Genero genero = new Genero();
			genero.setId(codigoGenero);

			Produtora produtora = new Produtora();
			produtora.setId(codigoProdutora);

			Filme filme = new Filme(titulo, publicacao, classificacao, duracao);
			filme.setGenero(genero);
			filme.setProdutora(produtora);

			filmeDao.cadastrar(filme);

			request.setAttribute("msg", "Filme cadastrado!");
		} catch (DBException db) {
			db.printStackTrace();
			request.setAttribute("erro", "Erro ao cadastrar");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", "Por favor, valide os dados");
		}
		abrirFormCadastro(request, response);

	}

	private void abrirFormEdicao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("codigo"));
		Filme filme = filmeDao.buscar(id);
		request.setAttribute("filme", filme);
		carregarOpcoesGenero(request);
		carregarOpcoesProdutora(request);
		request.getRequestDispatcher("edicao-filme.jsp").forward(request, response);
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Filme> lista = filmeDao.listar();
		request.setAttribute("filmes", lista);
		request.getRequestDispatcher("lista-filme.jsp").forward(request, response);

	}

}
