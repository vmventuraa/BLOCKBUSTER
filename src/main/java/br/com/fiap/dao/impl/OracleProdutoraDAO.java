package br.com.fiap.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiao.dao.ProdutoraDAO;
import br.com.fiap.connection.ConnectionManager;
import br.com.fiap.exception.DBException;
import br.com.fiap.model.Genero;
import br.com.fiap.model.Produtora;

public class OracleProdutoraDAO implements ProdutoraDAO {
	private Connection conexao;
	@Override
	public void cadastrar(Produtora produtora) throws DBException {
		PreparedStatement stmt = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "insert into produtora(nome_produtora) VALUES (?)";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, produtora.getNome());
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
	public void atualizar(Produtora produtora) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "update produtora set nome_produtora = ?  WHERE produtora_id = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, produtora.getNome());
			stmt.setInt(2, produtora.getId());

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
			String sql = "DELETE FROM produtora WHERE produtora_id = ?";
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
	public List<Produtora> listar() {
		List<Produtora> lista = new ArrayList<Produtora>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("select * from produtora");
			rs = stmt.executeQuery();

			// Percorre todos os registros encontrados
			while (rs.next()) {
				int codigo = rs.getInt("produtora_id");
				String nome = rs.getString("nome_produtora");
				Produtora produtora = new Produtora(nome);
				produtora.setId(codigo);
				lista.add(produtora);
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
	public Produtora buscar(int id) {
		Produtora produtora = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM produtora WHERE produtora.produtora_id = ?");
			stmt.setInt(1, id);
			rs = stmt.executeQuery();

			if (rs.next()) {
				int codigoProdutora = rs.getInt("PRODUTORA_ID");
				String nome = rs.getString("NOME_PRODUTORA");

				produtora = new Produtora(nome);
				produtora.setId(codigoProdutora);
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
		return produtora;
	}

}
