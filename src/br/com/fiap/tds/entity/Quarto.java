package br.com.fiap.tds.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity 
@Table (name ="TB_QUARTO")
@SequenceGenerator (name = "quarto", sequenceName = "SQ_TB_QUARTO", allocationSize = 1)
public class Quarto {

	// ATRIBUTOS E SEUS MAPEAMENTOS //
	@Id 
	@Column (name = "cd_quarto")	
	@GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "quarto")
	private int codigo;
	
	@Column (name = "nm_quarto", length = 50, nullable = false)
	private String nome; // EXEMPLO DE NOME = SUITE PRESIDENCIAL OU SUITE COMUM
	
	@Column (name = "ds_quarto", length = 300, nullable = false)
	private String descricao;
	
	@Column (name = "nr_quarto", nullable = false)
	private int numero;
	
	@Column (name = "nr_andar", nullable = false)
	private int andar;
	
	@ManyToOne 
	@JoinColumn (name = "cd_hotel")
	private Hotel hotel;

	// CONSTRUTOR //
	public Quarto (int codigo, String nome, String descricao, int numero, int andar) {
		
		this.codigo = codigo;
		this.nome = nome;
		this.descricao = descricao;
		this.numero = numero;
		this.andar = andar;
		
	}
	
	// CONSTRUTOR VAZIO //
	public Quarto () {
		
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getAndar() {
		return andar;
	}

	public void setAndar(int andar) {
		this.andar = andar;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

}