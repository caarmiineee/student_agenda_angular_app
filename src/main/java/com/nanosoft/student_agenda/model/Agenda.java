package com.nanosoft.student_agenda.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Data
@Table(name = "agenda")
public class Agenda {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "nome")
	private String nome;

	@OneToMany(mappedBy = "agenda", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Appuntamento> appuntamenti = new ArrayList<Appuntamento>();

	public Agenda() {
	}

	public Agenda(String nome, List<Appuntamento> appuntamenti) {
		this.nome = nome;
		this.appuntamenti = appuntamenti;
	}

	public Agenda(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
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

	@Override
	public int hashCode() {
		return Objects.hash(appuntamenti, id, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Agenda other = (Agenda) obj;
		return Objects.equals(appuntamenti, other.appuntamenti) && Objects.equals(id, other.id)
				&& Objects.equals(nome, other.nome);
	}

	@Override
	public String toString() {
		return "Agenda [id=" + id + ", nome=" + nome + "]";
	}

}
