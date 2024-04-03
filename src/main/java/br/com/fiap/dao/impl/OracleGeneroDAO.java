package br.com.fiap.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.fiao.dao.GeneroDAO;
import br.com.fiap.connection.ConnectionManager;
import br.com.fiap.exception.DBException;
import br.com.fiap.model.Filme;
import br.com.fiap.model.Genero;
import br.com.fiap.model.Produtora;

public class OracleGeneroDAO implements GeneroDAO {
	private Connection conexao;
	@Override
	public void cadastrar(Genero genero) throws DBException {
		PreparedStatement stmt = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "insert into genero(nome_genero) VALUES (?)";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, genero.getNome());
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
	public void atualizar(Genero genero) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "update genero set nome_genero = ? WHERE genero_id = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, genero.getNome());
			stmt.setInt(2, genero.getId());

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
			String sql = "DELETE FROM genero WHERE genero_id = ?";
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
	public List<Genero> listar() {
		List<Genero> lista = new ArrayList<Genero>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("select * from genero");
			rs = stmt.executeQuery();

			// Percorre todos os registros encontrados
			while (rs.next()) {
				int codigo = rs.getInt("GENERO_ID");
				String nome = rs.getString("nome_genero");
				Genero genero = new Genero(nome);
				genero.setId(codigo);
				lista.add(genero);
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

	@Override
	public Genero buscar(int id) {
		Genero genero = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM genero WHERE genero.genero_id = ?");
			stmt.setInt(1, id);
			rs = stmt.executeQuery();

			if (rs.next()) {
				int codigoGenero = rs.getInt("GENERO_ID");
				String nome = rs.getString("NOME_GENERO");
				genero = new Genero(nome);
				genero.setId(codigoGenero);
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
		return genero;
	}
}
