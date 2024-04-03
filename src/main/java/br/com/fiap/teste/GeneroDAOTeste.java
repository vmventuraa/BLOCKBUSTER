package br.com.fiap.teste;

import java.util.List;

import br.com.fiao.dao.GeneroDAO;
import br.com.fiap.factory.DAOFactory;
import br.com.fiap.model.Genero;

public class GeneroDAOTeste {

	public static void main(String[] args) {

	GeneroDAO dao = DAOFactory.getGeneroDAO();

//		 Cadastrar um genero
//		Genero genero = new Genero("Comédia21");
//		try {
//			dao.cadastrar(genero);
//			System.out.println("Genero cadastrado.");
//		} catch (DBException e) {
//			e.printStackTrace();
//		}
//
//		// Buscar um produto pelo código e atualizar
//		genero = dao.buscar(5);
//		genero.setNome("Muzikal");
//		try {
//			dao.atualizar(genero);
//			System.out.println("Produto atualizado.");
//		} catch (DBException e) {
//			e.printStackTrace();
//		}
//
//		// Listar os produtos
//		List<Genero> lista = dao.listar();
//		for (Genero item : lista) {
//			System.out.println( " " + item.getId() + " " + item.getNome());
//		}
//
//		// Remover um produto
//		try {
//			dao.remover(4);
//			System.out.println("Produto removido.");
//		} catch (DBException e) {
//			e.printStackTrace();
//		}
	}

}
