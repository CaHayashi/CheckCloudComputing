package br.com.fiap.tds.view;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.AvaliacaoDAO;
import br.com.fiap.tds.dao.ClienteDAO;
import br.com.fiap.tds.dao.HotelDAO;
import br.com.fiap.tds.dao.QuartoDAO;
import br.com.fiap.tds.entity.Avaliacao;
import br.com.fiap.tds.entity.Cliente;
import br.com.fiap.tds.entity.Genero;
import br.com.fiap.tds.entity.Hotel;
import br.com.fiap.tds.entity.Quarto;
import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.exception.EntityNotFoundException;
import br.com.fiap.tds.impl.AvaliacaoDAOImpl;
import br.com.fiap.tds.impl.ClienteDAOImpl;
import br.com.fiap.tds.impl.HotelDAOImpl;
import br.com.fiap.tds.impl.QuartoDAOImpl;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

public class Populando {

	public static void main (String [] args) throws CommitException{
				
		// OBTENDO A ENTITY MANAGER //
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		// !!! CRIACAO DE ENTIDADES !!! //
		// HOTEL //
		Hotel hotel = new Hotel (3, "ibis Styles São Paulo Anhembi", "Av. Cruzeiro do Sul, 1709 - Santana, São Paulo - SP, 02031-000", 2, 120);
				
		// QUARTO //
		Quarto quarto = new Quarto (1, "Suite Presidencial", "O melhor quarto do Hotel para você", 175, 15);
		hotel.addQuarto(quarto);

		// CLIENTE //
		Cliente cliente = new Cliente (2, "Tadeu Smith", "45278462189", Genero.MASCULINO, new GregorianCalendar (2021, Calendar.MAY, 20), new GregorianCalendar (2021, Calendar.JUNE, 10));
		hotel.addCliente(cliente);
		
		// AVALICAO //
		Avaliacao avaliacao = new Avaliacao (1, "ibis Styles São Paulo Anhembi", 1, "Péssimo atendimento e refeições, única qualidade é a área de lazer", new GregorianCalendar (2020, Calendar.DECEMBER, 15));
		Avaliacao avaliacao2 = new Avaliacao (2, "Hotel Fazenda Floresta Negra", 4, "Tudo perfeito, porém o único defeito são os mosquitos", new GregorianCalendar (2021, Calendar.MAY, 21));
		
		// !!! DAO !!! //
		// HOTEL DAO //
		HotelDAO hotelDao = new HotelDAOImpl (em);
		// CLIENTE DAO //
		ClienteDAO clienteDao = new ClienteDAOImpl (em);
		// QUARTO DAO //
		QuartoDAO quartoDao = new QuartoDAOImpl (em);
		// AVALICAO DAO //
		AvaliacaoDAO avaliacaoDao = new AvaliacaoDAOImpl (em);
			
		// CRIANDO E COMMIT //
		try {
			hotelDao.cadastrar(hotel);
			hotelDao.salvar();
			System.out.println("HOTEL CADASTRADO!");
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}
		

		// CRIANDO E COMMIT //
		try {
			clienteDao.cadastrar(cliente);
			clienteDao.salvar();
			System.out.println("CLIENTE CADASTRADO!");
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}
		

		// CRIANDO E COMMIT //
		try {
			quartoDao.cadastrar(quarto);
			quartoDao.salvar();
			System.out.println("QUARTO CADASTRADO!");
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}
		

		// CRIANDO E COMMIT //
		try {
			avaliacaoDao.cadastrar(avaliacao);
			avaliacaoDao.salvar();
			System.out.println("AVALIACAO CADASTRADA!");
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}

		// FECHAR //
		em.close();
		EntityManagerFactorySingleton.getInstance().close();
		
	}
	
}



