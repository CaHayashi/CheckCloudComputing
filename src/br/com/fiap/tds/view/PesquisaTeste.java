package br.com.fiap.tds.view;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.ClienteDAO;
import br.com.fiap.tds.dao.HotelDAO;
import br.com.fiap.tds.dao.QuartoDAO;
import br.com.fiap.tds.entity.Cliente;
import br.com.fiap.tds.entity.Hotel;
import br.com.fiap.tds.entity.Quarto;
import br.com.fiap.tds.impl.ClienteDAOImpl;
import br.com.fiap.tds.impl.HotelDAOImpl;
import br.com.fiap.tds.impl.QuartoDAOImpl;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

public class PesquisaTeste {

	public static void main(String[] args) {
		
		// OBTENDO UMA ENTITY MANAGER //
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		// !!!!! HOTÉIS !!!!!!//		
		// OBTENDO HOTEL DAO //
		HotelDAO hotelDao = new HotelDAOImpl(em);
		
		// EXIBIR HOTÉIS CADASTRADOS //
		List<Hotel> hoteis = hotelDao.listar();
		System.out.println("Hotéis cadastradas:");
		for (Hotel hotel : hoteis) {
			System.out.println(hotel.getNome());
		}

		//	PESQUISAR OS HOTEIS POR PARTE DO NOME	//
		hoteis = hotelDao.buscarPorNome("Ala");
		System.out.println("Pesquisar por parte do nome");
		hoteis.forEach(h -> System.out.println(h.getNome()));
		
		// PESQUISAR OS HOTEIS POR ESTRELA //
		hoteis = hotelDao.buscarPorEstrelas(5);
		System.out.println("Hotéis de 5 estrelas: ");
		hoteis.forEach(h -> System.out.println(h.getNome()));
		
		// PESQUISAR OS HOTEIS PELO CODIGO //
		hoteis = hotelDao.buscarPorCodigo(1);
		System.out.println("Hotéis com o seguinte código: ");
		hoteis.forEach(h -> System.out.println(h.getNome()));
		
		
		// !!!!! CLIENTES !!!!!! //
		// OBTENDO CLIENTE DAO //
		ClienteDAO clienteDao = new ClienteDAOImpl(em);
		
		// BUSCANDO O CLIENTE E MOSTRANDO SEU CPF //
		List<Cliente> clientes = clienteDao.buscarPorNome("Rafael");
		System.out.println("CPF do cliente buscado: ");
		clientes.forEach(c -> System.out.println(c.getCpf()));
		
		// BUSCAR O CLIENTE PELO SEU CPF //
		clientes = clienteDao.buscarPorCpf("89469325965");
		System.out.println("Nome do cliente buscado pelo cpf: ");
		clientes.forEach(c -> System.out.println(c.getNome()));
		
		// BUSCAR O CLIENTE PELO CODIGO //
		clientes = clienteDao.buscarPorCodigo(2);
		System.out.println("Nome do cliente buscado pelo cpf: ");
		clientes.forEach(c -> System.out.println(c.getNome()));
		
		
		// !!!!! QUARTO !!!!! //
		// OBTENDO O QUARTO DAO //
		QuartoDAO quartoDao = new QuartoDAOImpl(em);	
		
		// BUSCAR OS NUMEROS DE SUITES PRESIDENCIAIS //
		List<Quarto> quartos = quartoDao.buscarPorNome("Suite Presidencial");
		System.out.println("Números das Suites Presidenciais: ");
		quartos.forEach(q -> System.out.println(q.getNumero()));
				
		// BUSCAR O TIPO DE QUARTO PESQUISADO PELO NUMERO //
		quartos = quartoDao.buscarPorNumero(75);
		System.out.println("Tipo de Quarto pesquisa: ");
		quartos.forEach (q -> System.out.println(q.getNome()));
       		
	}
}
