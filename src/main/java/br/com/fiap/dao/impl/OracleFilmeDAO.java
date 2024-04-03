package br.com.fiap.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.fiao.dao.FilmeDAO;
import br.com.fiap.connection.ConnectionManager;
import br.com.fiap.exception.DBException;
import br.com.fiap.model.Filme;
import br.com.fiap.model.Genero;
import br.com.fiap.model.Produtora;

public class OracleFilmeDAO implements FilmeDAO {
	private Connection conexao;

	@Override
	public void cadastrar(Filme filme) throws DBException {
		PreparedStatement stmt = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "insert into filmes (titulo,dataPublicacao,genero_id,classificacao,produtora_id,duracao) VALUES (?, ?, ?, ?, ?,?)";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, filme.getTitulo());
			java.sql.Date data = new java.sql.Date(filme.getDataPublicacao().getTimeInMillis());
			stmt.setDate(2, data);
			stmt.setInt(3, filme.getGenero().getId());
			stmt.setInt(4, filme.getClassificacao());
			stmt.setInt(5, filme.getProdutora().getId());
			stmt.setInt(6, filme.getDuracao());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao cadastrar.");
		} finally {
			try {
				stmt.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public void atualizar(Filme filme) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "update filmes set titulo = ?, dataPublicacao = ?, genero_id = ?, classificacao = ?, produtora_id = ?, duracao = ? WHERE filme_id = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, filme.getTitulo());
			java.sql.Date data = new java.sql.Date(filme.getDataPublicacao().getTimeInMillis());
			stmt.setDate(2, data);
			stmt.setDouble(3, filme.getGenero().getId());
			stmt.setInt(4, filme.getClassificacao());
			stmt.setInt(5, filme.getProdutora().getId());
			stmt.setInt(6, filme.getDuracao());
			stmt.setInt(7, filme.getId());

			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao atualizar.");
		} finally {
			try {
				stmt.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public void remover(int codigo) throws DBException {
		PreparedStatement stmt = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "DELETE FROM FILMES WHERE filme_id = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, codigo);
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao remover.");
		} finally {
			try {
				stmt.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public Filme buscar(int id) {
		Filme filme = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM filmes INNER JOIN genero \r\n"
					+ "ON filmes.genero_id = genero.genero_id\r\n" + "INNER JOIN produtora\r\n"
					+ "ON filmes.produtora_id = produtora.produtora_id\r\n" + "WHERE filmes.filme_id = ?");
			stmt.setInt(1, id);
			rs = stmt.executeQuery();

			if (rs.next()) {
				int codigoFilme = rs.getInt("FILME_ID");
				String titulo = rs.getString("TITULO");
				java.sql.Date data = rs.getDate("DATAPUBLICACAO");
				int codigoGenero = rs.getInt("GENERO_ID");
				String nomeGenero = rs.getString("NOME_GENERO");
				int classificacao = rs.getInt("CLASSIFICACAO");
				int codigoProdutora = rs.getInt("PRODUTORA_ID");
				String nomeProdutora = rs.getString("NOME_PRODUTORA");
				int duracao = rs.getInt("DURACAO");
				Calendar dataPublicacao = Calendar.getInstance();
				dataPublicacao.setTimeInMillis(data.getTime());

				filme = new Filme(titulo, dataPublicacao, classificacao, duracao);
				Genero genero = new Genero(nomeGenero);
				Produtora produtora = new Produtora(nomeProdutora);
				filme.setGenero(genero);
				filme.setProdutora(produtora);
				filme.setId(codigoFilme);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				rs.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return filme;
	}

	@Override
	public List<Filme> listar() {
		List<Filme> lista = new ArrayList<Filme>();
		Filme filme = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM filmes INNER JOIN genero \r\n"
					+ "ON filmes.genero_id = genero.genero_id\r\n" + "INNER JOIN produtora\r\n"
					+ "ON filmes.produtora_id = produtora.produtora_id\r\n");
			rs = stmt.executeQuery();

			if (rs.next()) {
				int codigoFilme = rs.getInt("FILME_ID");
				String titulo = rs.getString("TITULO");
				java.sql.Date data = rs.getDate("DATAPUBLICACAO");
				int codigoGenero = rs.getInt("GENERO_ID");
				String nomeGenero = rs.getString("NOME_GENERO");
				int classificacao = rs.getInt("CLASSIFICACAO");
				int codigoProdutora = rs.getInt("PRODUTORA_ID");
				String nomeProdutora = rs.getString("NOME_PRODUTORA");
				int duracao = rs.getInt("DURACAO");
				Calendar dataPublicacao = Calendar.getInstance();
				dataPublicacao.setTimeInMillis(data.getTime());

				filme = new Filme(titulo, dataPublicacao, classificacao, duracao);
				Genero genero = new Genero(nomeGenero);
				Produtora produtora = new Produtora(nomeProdutora);
				filme.setGenero(genero);
				filme.setProdutora(produtora);
				filme.setId(codigoFilme);
				lista.add(filme);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				rs.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return lista;

	}
}
