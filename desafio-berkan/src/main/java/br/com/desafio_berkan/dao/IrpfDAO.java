package br.com.desafio_berkan.dao;

import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.desafio_berkan.data.ConexaoJDBC;
import br.com.desafio_berkan.model.Irpf;

public class IrpfDAO {
	
	private final ConexaoJDBC conexao;

	public IrpfDAO() throws SQLException, ClassNotFoundException {
		this.conexao = new ConexaoJDBC();
	}
	
	public List<Irpf> getIrpf() throws SQLException, ClassNotFoundException {
		String sqlQuery = "SELECT * FROM irpf_2019 ORDER BY id_irpf";

		try {
			PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
			ResultSet rs = stmt.executeQuery();

			List<Irpf> lista = new ArrayList<>();

			while (rs.next()) {
				lista.add(parser(rs));
			}

			return lista;
		} catch (SQLException e) {
			throw e;
		}
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
