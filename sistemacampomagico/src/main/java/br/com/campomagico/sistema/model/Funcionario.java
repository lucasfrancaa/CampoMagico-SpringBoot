package br.com.campomagico.sistema.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="funcionario")
public class Funcionario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idfuncionario;
	
	@Column(name="nomefuncionario")
	private String nomefuncionario;
	
	@Column(name="telefone")
	private String telefone;
	
	@Column(name="datanascimento")
	private LocalDate datanascimento;
	
	@Column(name="datacontratacao")
	private LocalDate datacontratacao;
	
	@Column(name="situacao")
	private String situacao;
	
	@Column(name="cpf")
	private String cpf;
	
	@Column(name="altura")
	private Float altura;
	
	@Column(name="idade")
	private Integer idade;
	
	public Long getIdfuncionario() {
		return idfuncionario;
	}
	public void setIdfuncionario(Long idfuncionario) {
		this.idfuncionario = idfuncionario;
	}
	public String getNomefuncionario() {
		return nomefuncionario;
	}
	public void setNomefuncionario(String nomefuncionario) {
		this.nomefuncionario = nomefuncionario;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public LocalDate getDatanascimento() {
		return datanascimento;
	}
	public void setDatanascimento(LocalDate datanascimento) {
		this.datanascimento = datanascimento;
	}
	public LocalDate getDatacontratacao() {
		return datacontratacao;
	}
	public void setDatacontratacao(LocalDate datacontratacao) {
		this.datacontratacao = datacontratacao;
	}
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Float getAltura() {
		return altura;
	}
	public void setAltura(Float altura) {
		this.altura = altura;
	}
	public Integer getIdade() {
		return idade;
	}
	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	
	@ManyToOne
	@JoinColumn(name="cargo_id")
	private Cargo cargo;

	public Cargo getCargo() {
		return cargo;
	}
	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}
}
