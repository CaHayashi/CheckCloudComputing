package br.com.fiap.tds.entity;

import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table (name = "TB_AVALIACAO")
@SequenceGenerator (name = "avaliacao", sequenceName = "SQ_TB_AVALIACAO", allocationSize = 1)
public class Avaliacao {

	// ATRIBUTOS E SEUS MAPEAMENTOS //
	@Id
	@Column (name = "cd_avaliacao")
	@GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "avaliacao")
	private int codigo;
	
	@Column (name = "nm_hotel", length = 100, nullable = false)
	private String nomeHotel;
	
	@Column (name = "nr_estrelas", nullable = false)
	private int estrelas;
	
	@Column (name = "ds_descricao", length = 250, nullable = false)
	private String descricao;
	
	@Column (name = "dt_avaliacao", nullable = false)
	@Temporal (TemporalType.DATE)
	private Calendar dtAvaliacao;
	
	@ManyToOne
	@JoinColumn (name = "cd_cliente")
	private Cliente cliente;
	
	public Avaliacao() {
		
	}
	
	public Avaliacao (int codigo, String nomeHotel, int estrelas, String descricao, Calendar dtAvaliacao) {
		
		this.codigo = codigo;
		this.nomeHotel = nomeHotel;
		this.estrelas = estrelas;
		this.descricao = descricao;
		this.dtAvaliacao = dtAvaliacao;
		
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNomeHotel() {
		return nomeHotel;
	}

	public void setNomeHotel(String nomeHotel) {
		this.nomeHotel = nomeHotel;
	}

	public int getEstrelas() {
		return estrelas;
	}

	public void setEstrelas(int estrelas) {
		this.estrelas = estrelas;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Calendar getDtAvaliacao() {
		return dtAvaliacao;
	}

	public void setDtAvaliacao(Calendar dtAvaliacao) {
		this.dtAvaliacao = dtAvaliacao;
	}
	
}