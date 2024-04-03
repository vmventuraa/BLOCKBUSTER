package br.com.fiao.dao;

import java.util.List;

import br.com.fiap.exception.DBException;
import br.com.fiap.model.Produtora;

public interface ProdutoraDAO {
	void cadastrar(Produtora produtora) throws DBException;
	void atualizar(Produtora produtora) throws DBException;
	void remover(int codigo) throws DBException;
	Produtora buscar(int id);
	List<Produtora> listar();
}
