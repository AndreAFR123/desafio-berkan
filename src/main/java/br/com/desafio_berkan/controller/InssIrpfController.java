package br.com.desafio_berkan.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.math3.util.Precision;

import br.com.desafio_berkan.dao.InssDAO;
import br.com.desafio_berkan.dao.IrpfDAO;

@Path("valores")
public class InssIrpfController {

	private IrpfDAO irpfDAO;
	private InssDAO inssDAO;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{dependentes}/{salario}/")
	public List<Double> getDescontos(@PathParam("dependentes") int dependentes, @PathParam("salario") double salario) {
		try {
			inssDAO = new InssDAO();
			double impostoInss = inssDAO.getDescontoInss(salario);
			salario -= impostoInss;
			
			irpfDAO = new IrpfDAO();
			double impostoIrpf = irpfDAO.getDescontoIrpf(dependentes, salario);
			salario -= impostoIrpf;
			
			double descontoTotal = impostoInss + impostoIrpf;
			
			List<Double> result = new ArrayList<>();
			result.add(impostoInss);
			result.add(impostoIrpf);
			result.add(Precision.round(descontoTotal, 2));
			result.add(Precision.round(salario, 2));
			return result;
		} catch (Exception ex) {
			Logger.getLogger(InssIrpfController.class.getName()).log(Level.SEVERE, null, ex);
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
	}
}