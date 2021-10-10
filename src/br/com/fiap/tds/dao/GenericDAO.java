package br.com.fiap.tds.dao;

import java.util.List;

import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.exception.EntityNotFoundException;

public interface GenericDAO<T,K> {

	void cadastrar(T entity);
	void alterar(T entity);
	void remover(K codigo) throws EntityNotFoundException;
	T pesquisar(K codigo);
	void salvar() throws CommitException;
	
	List<T> listar();
	
	//LISTAR COM PAGINAÇÃO
	List<T> listar (int primeiraPosicao, int maximoPosicao);
}
