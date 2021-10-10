package br.com.fiap.tds.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table (name = "TB_HOTEL")
@SequenceGenerator (name = "hotel", sequenceName = "SQ_TB_HOTEL", allocationSize = 1)
public class Hotel {
	
	// ATRIBUTOS E SEUS MAPEAMENTOS //
	@Id 
	@Column (name = "cd_hotel")
	@GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "hotel")
	private int codigo;
	
	@Column (name = "nm_hotel", length = 150, nullable = false)
	private String nome;
	
	@Column (name = "ds_endereco", length = 300, nullable = false)
	private String endereco;
	
	@Column (name = "nr_estrelas", nullable = false)
	private int estrelas;
	
	@Column (name = "vl_estadia", nullable = false)
	private double preco;
	
	@OneToMany (mappedBy = "hotel", cascade = CascadeType.ALL)
	private List<Quarto> quartos;
	
	public void addQuarto (Quarto quarto) {
		if (quartos == null)
			quartos = new ArrayList<>();
		
		quartos.add(quarto);
		quarto.setHotel(this);
	}
	
	@OneToMany (mappedBy = "hotel", cascade = CascadeType.ALL)
	private List<Cliente> clientes;
	
	public void addCliente (Cliente cliente) {
		if (clientes == null)
			clientes = new ArrayList<>();
		
		clientes.add(cliente);
		cliente.setHotel(this);
	}
	
	// CONSTRUTOR //
	public Hotel (int codigo, String nome, String endereco, int estrelas, double preco) {
		
		this.codigo = codigo;
		this.nome = nome;
		this.endereco = endereco;
		this.estrelas = estrelas;
		this.preco = preco;
		
	}
	
	// CONSTRUTOR VAZIO //
	public Hotel () {
		
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

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public int getEstrelas() {
		return estrelas;
	}

	public void setEstrelas(int estrelas) {
		this.estrelas = estrelas;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}


}