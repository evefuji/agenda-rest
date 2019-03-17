package br.com.senai.agenda.controller;

import java.io.IOException;
import java.util.Objects;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.senai.agenda.entities.Contato;
import br.com.senai.agenda.service.AgendaService;

/**
 * Servlet implementation class AgendaController
 */
@WebServlet("/agenda")
public class AgendaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private AgendaService agendaService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgendaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("agenda", agendaService.listar());
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome = request.getParameter("nome");
		String telefone  = request.getParameter("telefone");
		if(Objects.nonNull(nome) && Objects.nonNull(telefone)) {
			Contato contato = new Contato();
			contato.setNome(nome);
			contato.setTelefone(telefone);
			agendaService.inserir(contato);
		}
		response.sendRedirect(request.getRequestURI());
	}

}
