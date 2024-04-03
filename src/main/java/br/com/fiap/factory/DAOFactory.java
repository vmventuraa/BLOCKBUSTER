package br.com.fiap.factory;

import br.com.fiao.dao.FilmeDAO;
import br.com.fiao.dao.GeneroDAO;
import br.com.fiao.dao.ProdutoraDAO;
import br.com.fiao.dao.UsuarioDAO;
import br.com.fiap.dao.impl.OracleFilmeDAO;
import br.com.fiap.dao.impl.OracleGeneroDAO;
import br.com.fiap.dao.impl.OracleProdutoraDAO;
import br.com.fiap.dao.impl.OracleUsuarioDAO;

public class DAOFactory {
	public static FilmeDAO getFilmeDAO() {
		return new OracleFilmeDAO();
	}
	
public static GeneroDAO getGeneroDAO() {
	return new OracleGeneroDAO();
}

public static ProdutoraDAO getProdutoraDAO() {
	return new OracleProdutoraDAO();
	
	
}
public static UsuarioDAO getUsuarioDAO() {
	return new OracleUsuarioDAO();
}
	
}
