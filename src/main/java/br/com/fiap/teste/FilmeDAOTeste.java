package br.com.fiap.teste;

import java.util.Calendar;

import br.com.fiao.dao.FilmeDAO;
import br.com.fiao.dao.GeneroDAO;
import br.com.fiao.dao.ProdutoraDAO;
import br.com.fiap.exception.DBException;
import br.com.fiap.factory.DAOFactory;
import br.com.fiap.model.Filme;
import br.com.fiap.model.Genero;
import br.com.fiap.model.Produtora;

public class FilmeDAOTeste {

	public static void main(String[] args) {

		FilmeDAO filmedao = DAOFactory.getFilmeDAO();
		GeneroDAO generodao = DAOFactory.getGeneroDAO();
		ProdutoraDAO produtoradao = DAOFactory.getProdutoraDAO();

		// Cadastrar um produto
		Filme filme = new Filme("Sev7n",Calendar.getInstance() ,10 , 100);
		Genero genero = new Genero("Suspense");
		Produtora produtora = new Produtora("Produções");
		
		filme.setGenero(genero);
		filme.setProdutora(produtora);
		
		try {
			filmedao.cadastrar(filme);
			System.out.println("Produto cadastrado.");
		} catch (DBException e) {
			e.printStackTrace();
		}

//		// Buscar um produto pelo código e atualizar
//		filme = dao.buscar(1);
//		filme.setTítulo("TV Samsung 65'");
//		try {
//			dao.atualizar(filme);
//			System.out.println("Produto atualizado.");
//		} catch (DBException e) {
//			e.printStackTrace();
//		}
//
//		// Listar os produtos
//		List<Produto> lista = dao.listar();
//		for (Produto item : lista) {
//			System.out.println(item.getNome() + " " + item.getQuantidade() + " " + item.getValor());
//		}
//
//		// Remover um produto
//		try {
//			dao.remover(1);
//			System.out.println("Produto removido.");
//		} catch (DBException e) {
//			e.printStackTrace();
//		}
	}

}
