package br.com.desafio_berkan.controller;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.desafio_berkan.dao.IrpfDAO;
import br.com.desafio_berkan.model.Irpf;

@Path("irpf")
public class IrpfController {

	private IrpfDAO irpfDAO;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/")
	public List<Irpf> listCliente() {
		try {
			irpfDAO = new IrpfDAO();
			return irpfDAO.getIrpf();
		} catch (Exception ex) {
			Logger.getLogger(IrpfController.class.getName()).log(Level.SEVERE, null, ex);
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
	}
}