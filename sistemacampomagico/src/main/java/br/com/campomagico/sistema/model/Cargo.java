package br.com.campomagico.sistema.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cargo")
public class Cargo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idcargo;
	
	@Column(name="nomecargo")
	private String nomecargo;
	
	@Column(name="descricaocargo")
	private String descricaocargo;
	
	public Long getIdcargo() {
		return idcargo;
	}
	public void setIdcargo(Long idcargo) {
		this.idcargo = idcargo;
	}
	public String getNomecargo() {
		return nomecargo;
	}
	public void setNomecargo(String nomecargo) {
		this.nomecargo = nomecargo;
	}
	public String getDescricaocargo() {
		return descricaocargo;
	}
	public void setDescricaocargo(String descricaocargo) {
		this.descricaocargo = descricaocargo;
	}
	
	
}
