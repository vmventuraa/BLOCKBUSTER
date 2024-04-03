package br.com.fiao.dao;

import java.util.List;

import br.com.fiap.exception.DBException;
import br.com.fiap.model.Filme;


public interface FilmeDAO {

	void cadastrar(Filme filme) throws DBException;
	void atualizar(Filme filme) throws DBException;
	void remover(int codigo) throws DBException;
	Filme buscar(int id);
	List<Filme> listar();
	
}
