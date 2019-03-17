package br.com.senai.agenda.service;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.senai.agenda.entities.Contato;

@Stateless
public class AgendaService {
	
	@PersistenceContext(unitName="AgendaPU")
	private EntityManager em;
	
	public void inserir(Contato contato) {
		em.persist(contato);
	}
	
	public void atualizar(Contato contato) {
		em.merge(contato);
	}
	
	public Collection<Contato> listar(){
		return em.createQuery("SELECT contato FROM Contato contato", Contato.class).getResultList();
	}
}
