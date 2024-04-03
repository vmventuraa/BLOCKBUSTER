package br.com.fiao.dao;

import java.util.List;

import br.com.fiap.exception.DBException;
import br.com.fiap.model.Genero;

public interface GeneroDAO {
	void cadastrar(Genero genero) throws DBException;
	void atualizar(Genero genero) throws DBException;
	void remover(int codigo) throws DBException;
	Genero buscar(int id);
	List<Genero> listar();
}
