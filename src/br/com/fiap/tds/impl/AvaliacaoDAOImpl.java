package br.com.fiap.tds.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.tds.dao.AvaliacaoDAO;
import br.com.fiap.tds.entity.Avaliacao;

public class AvaliacaoDAOImpl extends GenericDAOImpl <Avaliacao, Integer> implements AvaliacaoDAO {

	public AvaliacaoDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<Avaliacao> buscarPorHotel(String nomeHotel) {
		// CRIANDO UMA QUERY //
		TypedQuery<Avaliacao> query = em.createQuery("from Avaliacao a where a.nomeHotel like :churros", Avaliacao.class);
		// SETANDO UM PARAMENTRO //
		query.setParameter("churros", "%" + nomeHotel + "%");
		// RETORNANDO O RESULTADO DA BUSCA //
		return query.getResultList();
	}

	@Override
	public List<Avaliacao> buscarPorEstrelas(int estrelas) {
		// CRIANDO UMA QUERY //
		TypedQuery<Avaliacao> query = em.createQuery("select a.nomeHotel, a.estrelas from Avaliacao a where a.estrelas like :estrelas", Avaliacao.class);	
		// SETANDO UM PARAMENTRO //
		query.setParameter("estrelas", estrelas);
		// RETORNANDO O RESULTADO DA BUSCA //
		return query.getResultList();
	}

	@Override
	public List<Avaliacao> buscarPorCodigo(int codigo) {
		// CRIANDO UMA QUERY //
		TypedQuery<Avaliacao> query = em.createQuery("select a.nomeHotel, a.estrelas, a.descricao from Avaliacao a where a.codigo like :codigo", Avaliacao.class);	
		// SETANDO UM PARAMENTRO //
		query.setParameter("codigo", codigo);
		// RETORNANDO O RESULTADO DA BUSCA //
		return query.getResultList();
	}
	
}
