package br.com.fiap.tds.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.tds.dao.QuartoDAO;
import br.com.fiap.tds.entity.Quarto;

public class QuartoDAOImpl extends GenericDAOImpl <Quarto, Integer> implements QuartoDAO {

	public QuartoDAOImpl (EntityManager entityManager) {
		super (entityManager);
	}

	@Override
	public List<Quarto> buscarPorNome(String nome) {
		// CRIANDO UMA QUERY //
		TypedQuery<Quarto> query = em.createQuery("from Quarto q where q.nome like :churros", Quarto.class);
		// SETANDO UM PARAMENTRO //
		query.setParameter("churros", "%" + nome + "%");
		// RETORNANDO O RESULTADO DA BUSCA //
		return query.getResultList();
	}

	@Override
	public List<Quarto> buscarPorNumero(int numero) {
		// CRIANDO UMA QUERY //
		TypedQuery <Quarto> query = em.createQuery("from Quarto q where q.numero  =:numero", Quarto.class);
		// SETANDO UM PARAMENTRO //
		query.setParameter("numero", numero);
		// RETORNANDO O RESULTADO DA BUSCA //
		return query.getResultList();
	}

	@Override
	public List<Quarto> buscarPorAndar(int andar) {
		// CRIANDO UMA QUERY //
		TypedQuery <Quarto> query = em.createQuery("from Quarto q where q.numero like :andar", Quarto.class);
		// SETANDO UM PARAMENTRO //
		query.setParameter("andar", "%" + andar + "%");
		// RETORNANDO O RESULTADO DA BUSCA //
		return query.getResultList();
	}
	
}
