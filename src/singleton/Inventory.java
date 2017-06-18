package singleton;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import model.Livro;
import mysql.ConexaoMySqlFactory;

public class Inventory {

	private List<Livro> listaLivros;

	private static Inventory uniqueInstance;

	private Inventory() {
		listaLivros = new LinkedList<Livro>();
	}

	public static Inventory getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new Inventory();
		}
		return uniqueInstance;
	}

	public boolean cadastrarLivro(Livro l) {
		// cadastra o livro
		try {
			Connection connection = ConexaoMySqlFactory.criarConexao();
			System.out.println("A conexão foi criada.");

			PreparedStatement statement = ConexaoMySqlFactory.criarPreparedStatement(connection,
					"INSERT INTO livro (nome, autor, editora, ano, categoria) VALUES (?, ?, ?, ?, ?)");
			statement.setString(1, l.getNome());
			statement.setString(2, l.getAutor());
			statement.setString(3, l.getEditora());
			statement.setInt(4, l.getAno());
			statement.setString(5, l.getCategoria());
			statement.execute();

			return true;

		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return false;
		// listaLivros.add(f);
	}

	public List<Livro> all()
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		Connection conn = null;
		try {
			Connection connection = ConexaoMySqlFactory.criarConexao();
			ResultSet rs = ConexaoMySqlFactory.executarSelect(connection, "SELECT * FROM livro");
			List<Livro> livros = new ArrayList<Livro>();
			while (rs.next()) {
				Livro l = new Livro();
				l.setNome(rs.getString("nome"));
				l.setAutor(rs.getString("autor"));
				l.setEditora(rs.getString("editora"));
				l.setAno(rs.getInt("ano"));
				l.setCategoria(rs.getString("categoria"));
				livros.add(l);
			}
			return livros;
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}

	public boolean delete(Livro entidade)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		Connection connection = null;
		try {
			connection = ConexaoMySqlFactory.criarConexao();
			PreparedStatement statement = ConexaoMySqlFactory.criarPreparedStatement(connection,
					"DELETE FROM livro WHERE nome = ?");
			statement.setString(1, entidade.getNome());
			statement.execute();
			
			return true;
		} finally {
			if (connection != null) {
				connection.close();
			}
		}
	}

	public List<Livro> buscar(String nome) {
		List<Livro> encontradas = new LinkedList<Livro>();

		for (Object i : listaLivros) {
			Livro livroInventory = (Livro) i;

		}
		return encontradas;
	}

}
