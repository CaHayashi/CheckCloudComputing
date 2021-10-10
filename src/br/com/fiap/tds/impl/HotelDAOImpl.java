package br.com.fiap.tds.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.tds.dao.HotelDAO;
import br.com.fiap.tds.entity.Hotel;

public class HotelDAOImpl extends GenericDAOImpl<Hotel,Integer> implements HotelDAO {
	
	public HotelDAOImpl (EntityManager entityManager) {
		super (entityManager);
	}

	@Override
	public List<Hotel> buscarPorNome(String nome) {
		// CRIANDO UMA QUERY //
		TypedQuery<Hotel> query = em.createQuery("from Hotel h where h.nome like :churros", Hotel.class);
		// SETANDO UM PARAMENTRO //
		query.setParameter("churros", "%" + nome + "%");
		// RETORNANDO O RESULTADO DA BUSCA //
		return query.getResultList();
	}

	@Override
	public List<Hotel> buscarPorEstrelas(int estrelas) {
		// CRIANDO UMA QUERY //
		return em.createQuery("from Hotel h where h.estrelas like :estrelas", Hotel.class)
				.setParameter("estrelas", estrelas)
				.getResultList();
	}
	
	@Override
	public List<Hotel> buscarPorCodigo(int codigo) {
		// CRIANDO UMA QUERY //
		TypedQuery<Hotel> query = em.createQuery("from Hotel h where h.codigo like :codigo", Hotel.class);	
		// SETANDO UM PARAMENTRO //
		query.setParameter("codigo", codigo);
		// RETORNANDO O RESULTADO DA BUSCA //
		return query.getResultList();
	}
	
}
