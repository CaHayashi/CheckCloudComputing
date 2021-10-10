package br.com.fiap.tds.dao;

import java.util.List;

import br.com.fiap.tds.entity.Hotel;

public interface HotelDAO extends GenericDAO<Hotel,Integer> {
	
	// M�TODO DE BUSCAR HOTEL POR NOME //
	List<Hotel> buscarPorNome(String nome);
	
	// M�TODO DE BUSCAR HOTEL POR ESTRELAS //
	List<Hotel> buscarPorEstrelas (int estrelas);
	
	// M�TODO DE BUSCAR HOTEL PELO C�DIGO //
	List<Hotel> buscarPorCodigo(int codigo);

}
