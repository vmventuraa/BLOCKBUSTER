package br.com.fiap.teste;

import br.com.fiao.dao.ProdutoraDAO;
import br.com.fiap.exception.DBException;
import br.com.fiap.factory.DAOFactory;
import br.com.fiap.model.Produtora;

public class ProdutoraDAOTeste {

	public static void main(String[] args) {

	ProdutoraDAO produtoradao = DAOFactory.getProdutoraDAO();

		// Cadastrar uma produtora
		Produtora produtora = new Produtora("Productora");
//		try {
//			produtoradao.cadastrar(produtora);
//			System.out.println("Produtora cadastrado.");
//		} catch (DBException e) {
//			e.printStackTrace();
//		}

//		// Buscar um produto pelo código e atualizar
//		produtora = produtoradao.buscar(5);
//		produtora.setNome("TV Samsung 65'");
//		try {
//			produtoradao.atualizar(produtora);
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
