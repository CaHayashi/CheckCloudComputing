package br.com.fiap.tds.dao;

import java.util.List;

import br.com.fiap.tds.entity.Quarto;

public interface QuartoDAO extends GenericDAO <Quarto, Integer> {
	
	// M�TODO DE BUSCAR QAURTO PELO NOME //
	List <Quarto> buscarPorNome (String nome);
	
	// M�TODO DE BUSCAR QUARTO POR N�MERO //
	List <Quarto> buscarPorNumero (int numero);
	
	// M�TODO DE BUSCAR QUARTO POR N�MERO DO ANDAR //
	List <Quarto> buscarPorAndar (int andar);
	
}
