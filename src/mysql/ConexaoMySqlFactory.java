package mysql;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexaoMySqlFactory {

	public static Connection criarConexao()
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		String stringConexao = "jdbc:mysql://127.0.0.1/acervo?user=root";
		Connection connection = DriverManager.getConnection(stringConexao);
		return connection;
	}

	public static ResultSet executarSelect(Connection conn, String sql) throws SQLException {
		Statement query = conn.createStatement();
		return query.executeQuery(sql);
	}

	public static PreparedStatement criarPreparedStatement(Connection conn, String sql) throws SQLException {
		return conn.prepareStatement(sql);
	}

}
