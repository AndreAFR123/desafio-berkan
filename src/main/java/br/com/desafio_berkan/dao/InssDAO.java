package br.com.desafio_berkan.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.math3.util.Precision;

import br.com.desafio_berkan.data.ConexaoJDBC;
import br.com.desafio_berkan.model.Inss;

public class InssDAO {
	
	private final double maxInss = 642.34;
	
	private final ConexaoJDBC conexao;

	public InssDAO() throws SQLException, ClassNotFoundException {
		this.conexao = new ConexaoJDBC();
	}
	
	public double getDescontoInss(double salario) throws SQLException, ClassNotFoundException {
		String sqlQuery = "SELECT id_inss, salario_inss, aliquota_inss FROM inss_2019 ORDER BY id_inss";
		Inss inss = null;
		try {
			PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				inss = parser(rs);
				
				if (salario < inss.getSalario_inss()) {
					salario = (inss.getAliquota_inss() * salario) / 100; 
					return Precision.round(salario, 2);
				}
			}
			return maxInss;
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
