package br.com.fiap.tds.dao;

import java.util.List;

import br.com.fiap.tds.entity.Avaliacao;


public interface AvaliacaoDAO extends GenericDAO <Avaliacao, Integer> {

	// MÉTODO DE BUSCAR AVALIACAO POR HOTEL //
	List<Avaliacao> buscarPorHotel(String nomeHotel);
	
	// MÉTODO DE BUSCAR AVALIACAO POR ESTRELAS //
	List<Avaliacao> buscarPorEstrelas (int estrelas);
	
	// MÉTODO DE BUSCAR AVALIACAO PELO CÓDIGO //
	List<Avaliacao> buscarPorCodigo(int codigo);
	
}
