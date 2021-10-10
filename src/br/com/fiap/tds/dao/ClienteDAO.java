package br.com.fiap.tds.dao;

import java.util.List;

import br.com.fiap.tds.entity.Cliente;

public interface ClienteDAO extends GenericDAO<Cliente,Integer> {
	
	// M�TODO DE BUSCAR CLIENTE POR NOME //
	List<Cliente> buscarPorNome(String nome);
	
	// M�TODO DE BUSCAR CLIENTE POR CPF //
	List<Cliente> buscarPorCpf (String cpf);
	
	// M�TODO DE BUSCAR CLIENTE PELO C�DIGO //
	List<Cliente> buscarPorCodigo(int codigo);

}
