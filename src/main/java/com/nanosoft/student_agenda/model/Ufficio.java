package com.nanosoft.student_agenda.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Data
@Table(name = "uffici")
public class Ufficio {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "nome")
	private String nome;

	@OneToMany(mappedBy = "ufficio", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Appuntamento> appuntamenti = new ArrayList<>();

	@ManyToOne(fetch = FetchType.LAZY, cascade = {
			CascadeType.DETACH,
			CascadeType.MERGE, 
			CascadeType.PERSIST,
			CascadeType.REFRESH
		})
	@JoinColumn(name = "università_id")
	private Università università;

	public Ufficio() {
	}

	public Ufficio(String nome, List<Appuntamento> appuntamenti, Università università) {
		this.nome = nome;
		this.appuntamenti = appuntamenti;
		this.università = università;
	}

	public Ufficio(Integer id, String nome, Università università) {
		this.id = id;
		this.nome = nome;
		this.università = università;
	}

	public void addAppuntamento(Appuntamento appuntamento) {
		appuntamenti.add(appuntamento);
	}

	public void removeAppuntamento(Appuntamento appuntamento) {
		appuntamenti.remove(appuntamento);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Appuntamento> getAppuntamenti() {
		return appuntamenti;
	}

	public void setAppuntamenti(List<Appuntamento> appuntamenti) {
		this.appuntamenti = appuntamenti;
	}

	public Università getUniversità() {
		return università;
	}

	public void setUniversità(Università università) {
		this.università = università;
	}

	@Override
	public int hashCode() {
		return Objects.hash(appuntamenti, id, nome, università);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ufficio other = (Ufficio) obj;
		return Objects.equals(appuntamenti, other.appuntamenti) && Objects.equals(id, other.id)
				&& Objects.equals(nome, other.nome) && Objects.equals(università, other.università);
	}

	@Override
	public String toString() {
		return "Ufficio [id=" + id + ", nome=" + nome + ", appuntamenti=" + appuntamenti + ", università=" + università
				+ "]";
	}

}
