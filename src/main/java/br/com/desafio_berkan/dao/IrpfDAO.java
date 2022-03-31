package br.com.desafio_berkan.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.math3.util.Precision;

import br.com.desafio_berkan.data.ConexaoJDBC;
import br.com.desafio_berkan.model.Irpf;

public class IrpfDAO {
	
	private final double valorDependente = 189.59;
	
	private final ConexaoJDBC conexao;

	public IrpfDAO() throws SQLException, ClassNotFoundException {
		this.conexao = new ConexaoJDBC();
	}
	
	public double getDescontoIrpf(int dependentes, double salario) throws SQLException, ClassNotFoundException {
		String sqlQuery = "SELECT id_irpf, salario_irpf, aliquota_irpf, desconto_irpf FROM irpf_2019 ORDER BY id_irpf";
		Irpf irpf = null;
		try {
			PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
			ResultSet rs = stmt.executeQuery();

			salario = salario - getValorTotalDependentes(dependentes);
			
			while (rs.next()) {
				irpf = parser(rs);
				if (salario < irpf.getSalario_irpf()) {
					return calculoSalario(salario, irpf);
				}
			}
			return calculoSalario(salario, irpf);
		} catch (SQLException e) {
			throw e;
		}
	}
	
	private double calculoSalario(double salario, Irpf irpf) {
		salario = (salario * irpf.getAliquota_irpf()) / 100;
		salario = salario - irpf.getDesconto_irpf();
		return Precision.round(salario, 2);
	}
	
	private double getValorTotalDependentes(int dependentes) {
		return valorDependente * dependentes;
	}
	
	private Irpf parser(ResultSet rs) throws SQLException {
		Irpf irpf = new Irpf();
		irpf.setId_irpf(rs.getInt("id_irpf"));
		irpf.setSalario_irpf(rs.getDouble("salario_irpf"));
		irpf.setAliquota_irpf(rs.getDouble("aliquota_irpf"));
		irpf.setDesconto_irpf(rs.getDouble("desconto_irpf"));
		return irpf;
	}
}
