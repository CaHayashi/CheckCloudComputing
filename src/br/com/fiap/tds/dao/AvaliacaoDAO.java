package br.com.fiap.tds.dao;

import java.util.List;

import br.com.fiap.tds.entity.Avaliacao;


public interface AvaliacaoDAO extends GenericDAO <Avaliacao, Integer> {

	// M�TODO DE BUSCAR AVALIACAO POR HOTEL //
	List<Avaliacao> buscarPorHotel(String nomeHotel);
	
	// M�TODO DE BUSCAR AVALIACAO POR ESTRELAS //
	List<Avaliacao> buscarPorEstrelas (int estrelas);
	
	// M�TODO DE BUSCAR AVALIACAO PELO C�DIGO //
	List<Avaliacao> buscarPorCodigo(int codigo);
	
}
