package br.com.desafio_berkan.dao;

import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.desafio_berkan.data.ConexaoJDBC;
import br.com.desafio_berkan.model.Inss;

public class InssDAO {
	
	private final ConexaoJDBC conexao;

	public InssDAO() throws SQLException, ClassNotFoundException {
		this.conexao = new ConexaoJDBC();
	}
	
	public List<Inss> getInss() throws SQLException, ClassNotFoundException {
		String sqlQuery = "SELECT * FROM inss_2019 ORDER BY id_inss";

		try {
			PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
			ResultSet rs = stmt.executeQuery();

			List<Inss> lista = new ArrayList<>();

			while (rs.next()) {
				lista.add(parser(rs));
			}

			return lista;
		} catch (SQLException e) {
			throw e;
		}
	}
	
	private Inss parser(ResultSet rs) throws SQLException {
		Inss inss = new Inss();
		inss.setId_inss(rs.getInt("id_inss"));
		inss.setSalario_inss(rs.getDouble("salario_inss"));
		inss.setAliquota_inss(rs.getDouble("aliquota_inss"));
		return inss;
	}
}
