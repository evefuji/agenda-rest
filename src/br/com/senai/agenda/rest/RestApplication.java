package br.com.senai.agenda.rest;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import br.com.senai.agenda.endpoint.AgendaEndpoint;

@ApplicationPath("/rest")
public class RestApplication extends Application{
	
	private final static Set<Class<?>> CLASSES;
	static {
		CLASSES = new HashSet<>();
		CLASSES.add(CorsFilter.class);
		CLASSES.add(AgendaEndpoint.class);
	}
	
	@Override
	public Set<Class<?>> getClasses() {
		return CLASSES;
	}
	
}