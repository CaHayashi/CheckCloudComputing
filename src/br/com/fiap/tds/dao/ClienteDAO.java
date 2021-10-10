package br.com.fiap.tds.dao;

import java.util.List;

import br.com.fiap.tds.entity.Cliente;

public interface ClienteDAO extends GenericDAO<Cliente,Integer> {
	
	// MÉTODO DE BUSCAR CLIENTE POR NOME //
	List<Cliente> buscarPorNome(String nome);
	
	// MÉTODO DE BUSCAR CLIENTE POR CPF //
	List<Cliente> buscarPorCpf (String cpf);
	
	// MÉTODO DE BUSCAR CLIENTE PELO CÓDIGO //
	List<Cliente> buscarPorCodigo(int codigo);

}
