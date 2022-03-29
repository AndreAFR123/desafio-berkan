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

import br.com.desafio_berkan.dao.InssDAO;
import br.com.desafio_berkan.model.Inss;

@Path("inss")
public class InssController {

	private InssDAO inssDAO;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/")
	public List<Inss> listCliente() {
		try {
			inssDAO = new InssDAO();
			return inssDAO.getInss();
		} catch (Exception ex) {
			Logger.getLogger(InssController.class.getName()).log(Level.SEVERE, null, ex);
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
	}
}