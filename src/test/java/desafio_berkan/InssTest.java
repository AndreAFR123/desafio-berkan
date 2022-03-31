package desafio_berkan;

import java.sql.SQLException;
import org.junit.Assert;
import org.junit.Test;
import br.com.desafio_berkan.dao.InssDAO;

@SuppressWarnings("deprecation")
public class InssTest {

	private InssDAO inss;

	@Test
	public void verificaDescontoInss1000() throws ClassNotFoundException, SQLException {
		inss = new InssDAO();
		double salario = 1000.0;
		Assert.assertEquals(80, inss.getDescontoInss(salario), 0);
	}

	@Test
	public void verificaDescontoInss3000() throws ClassNotFoundException, SQLException {
		inss = new InssDAO();
		double salario = 3000.0;
		Assert.assertEquals(330, inss.getDescontoInss(salario), 0);
	}

	@Test
	public void verificaDescontoInss6000() throws ClassNotFoundException, SQLException {
		inss = new InssDAO();
		double salario = 6000.0;
		Assert.assertEquals(642.34, inss.getDescontoInss(salario), 0);
	}
}
