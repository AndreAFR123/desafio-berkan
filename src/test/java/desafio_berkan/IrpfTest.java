package desafio_berkan;

import java.sql.SQLException;

import org.junit.Assert;
import org.junit.Test;

import br.com.desafio_berkan.dao.InssDAO;
import br.com.desafio_berkan.dao.IrpfDAO;

@SuppressWarnings("deprecation")
public class IrpfTest {

	private IrpfDAO irpf;
	private InssDAO inss;
	
	@Test
	public void verificaDescontoIrpf1000() throws ClassNotFoundException, SQLException {
		irpf = new IrpfDAO();
		inss = new InssDAO();
		double salario = 1000.0;
		salario -= inss.getDescontoInss(salario);
		int dependentes = 0;
		Assert.assertEquals(0, irpf.getDescontoIrpf(dependentes, salario), 0);
	}

	@Test
	public void verificaDescontoIrpf3000() throws ClassNotFoundException, SQLException {
		irpf = new IrpfDAO();
		inss = new InssDAO();
		double salario = 3000.0;
		salario -= inss.getDescontoInss(salario);
		int dependentes = 2;
		Assert.assertEquals(29.01, irpf.getDescontoIrpf(dependentes, salario), 0);
	}

	@Test
	public void verificaDescontoIrpf6000() throws ClassNotFoundException, SQLException {
		irpf = new IrpfDAO();
		inss = new InssDAO();
		double salario = 6000.0;
		salario -= inss.getDescontoInss(salario);
		int dependentes = 0;
		Assert.assertEquals(604.00, irpf.getDescontoIrpf(dependentes, salario), 0);
	}

}
