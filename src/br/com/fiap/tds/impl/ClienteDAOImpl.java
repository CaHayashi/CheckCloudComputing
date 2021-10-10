package br.com.fiap.tds.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.tds.dao.ClienteDAO;
import br.com.fiap.tds.entity.Cliente;

public class ClienteDAOImpl extends GenericDAOImpl<Cliente,Integer> implements ClienteDAO {

	public ClienteDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}
	
	// MÉTODO PARA BUSCAR UM CLIENTE PELO SEU NOME //
	@Override
	public List<Cliente> buscarPorNome(String nome) {
		TypedQuery<Cliente> query = em.createQuery("from Cliente c where c.nome like :churros", Cliente.class);
		query.setParameter("churros", "%" + nome + "%");
		return query.getResultList();
	}

	// MÉTODO PARA BUSCAR UM CLIENTE PELO CPF //
	@Override
	public List<Cliente> buscarPorCpf(String cpf) {
		return em.createQuery("from Cliente c where c.cpf = :pEstado", Cliente.class)
				.setParameter("pEstado", cpf)
				.getResultList();
	}

	public List<Cliente> buscarPorCodigo (int codigo) {
		return em.createQuery("from Cliente c where c.codigo like :codigo", Cliente.class)
				.setParameter("codigo", codigo)
				.getResultList();
	}

}