package br.com.desafio_berkan.data;

import java.sql.Connection;
import java.sql.SQLException;

public interface IConexaoJDBC {

	public Connection getConnection();

	public void close();

	public void commit() throws SQLException;

	public void rollback();
	
}