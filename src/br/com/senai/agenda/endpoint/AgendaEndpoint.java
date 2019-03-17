package br.com.senai.agenda.endpoint;

import java.util.Collection;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.senai.agenda.entities.Contato;
import br.com.senai.agenda.service.AgendaService;

@Named
@Path("/agenda")
@Produces ( { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML } )
@Consumes ( { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML } )
public class AgendaEndpoint {

	@Inject
	private AgendaService agendaService;
	
	@POST
	public void inserir(Contato contato) {
		agendaService.inserir(contato);
	} 
	
	@PUT
	@Path("{id}")
	public void atualizar(@PathParam("id") Long id, Contato contato) {
		contato.setId(id);
		agendaService.atualizar(contato);
	} 
	
	@GET
	public Collection<Contato> listar(){
		return agendaService.listar();
	}
	
}

