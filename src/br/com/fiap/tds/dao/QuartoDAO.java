package br.com.fiap.tds.dao;

import java.util.List;

import br.com.fiap.tds.entity.Quarto;

public interface QuartoDAO extends GenericDAO <Quarto, Integer> {
	
	// MÉTODO DE BUSCAR QAURTO PELO NOME //
	List <Quarto> buscarPorNome (String nome);
	
	// MÉTODO DE BUSCAR QUARTO POR NÚMERO //
	List <Quarto> buscarPorNumero (int numero);
	
	// MÉTODO DE BUSCAR QUARTO POR NÚMERO DO ANDAR //
	List <Quarto> buscarPorAndar (int andar);
	
}
