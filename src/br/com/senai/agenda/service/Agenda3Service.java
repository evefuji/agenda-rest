package br.com.senai.agenda.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;

import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.sql.DataSource;

import br.com.senai.agenda.entities.Contato;

@Named
@RequestScoped
public class Agenda3Service {

	@Resource(lookup="java:/datasources:jdbc/Agenda3DS")
	private DataSource datasource;
	private Connection conn;
	
	public void inserir(Contato contato) {
		try {
			conn = datasource.getConnection();
			
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public Collection<Contato> listar() {
		// TODO Auto-generated method stub
		return null;
	}

}
