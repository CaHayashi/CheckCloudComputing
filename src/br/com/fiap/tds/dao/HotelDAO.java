package br.com.fiap.tds.dao;

import java.util.List;

import br.com.fiap.tds.entity.Hotel;

public interface HotelDAO extends GenericDAO<Hotel,Integer> {
	
	// MÉTODO DE BUSCAR HOTEL POR NOME //
	List<Hotel> buscarPorNome(String nome);
	
	// MÉTODO DE BUSCAR HOTEL POR ESTRELAS //
	List<Hotel> buscarPorEstrelas (int estrelas);
	
	// MÉTODO DE BUSCAR HOTEL PELO CÓDIGO //
	List<Hotel> buscarPorCodigo(int codigo);

}
