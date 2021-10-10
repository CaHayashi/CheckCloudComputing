package br.com.fiap.tds.entity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table (name = "TB_CLIENTE")
@SequenceGenerator (name = "cliente", sequenceName = "SQ_TB_CLIENTE", allocationSize = 1)
public class Cliente {
	
	// ATRIBUTOS E SEUS MAPEAMENTOS //
	@Id
	@Column (name = "cd_cliente")
	@GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "cliente")
	private int codigo;
	
	@Column (name = "nm_cliente", length = 100, nullable = false)
	private String nome;
	
	@Column (name = "nr_cpf", length = 12, nullable = false)
	private String cpf;
	
	@Enumerated(EnumType.STRING)
	@Column (name = "ds_genero", length = 10, nullable = false)
	private Genero genero;
	 
	@Column (name = "dt_inicio", nullable = false)
	@Temporal (TemporalType.DATE)
	private Calendar dataInicio;
	
	@Column (name = "dt_saida")
	@Temporal (TemporalType.DATE)
	private Calendar dataSaida;
	
	@ManyToOne 
	@JoinColumn (name = "cd_hotel")
	private Hotel hotel;
	
	@OneToMany (mappedBy = "cliente", cascade = CascadeType.ALL)
	private List <Avaliacao> avaliacoes;
	
	// CONSTRUTOR //
	public Cliente (int codigo, String nome, String cpf, Genero genero, Calendar dataInicio, Calendar dataSaida) {
		
		this.codigo = codigo;
		this.nome = nome;
		this.cpf = cpf;
		this.genero = genero;
		this.dataInicio = dataInicio;
		this.dataSaida =  dataSaida;
				
	}
	
	// CONSTRUTOR VAZIO //
	public Cliente () {
		
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public Calendar getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Calendar dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Calendar getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(Calendar dataSaida) {
		this.dataSaida = dataSaida;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

}