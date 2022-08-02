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
import javax.validation.constraints.Pattern;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "università")
public class Università {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Pattern(regexp = "[a-z A-Z]{1,10}")
	@Column(name = "nome")
	private String nome;

	@OneToMany(mappedBy = "università", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Ufficio> uffici = new ArrayList<Ufficio>();

	public Università() {
	}

	public Università(String nome, List<Ufficio> uffici) {
		this.nome = nome;
		this.uffici = uffici;
	}

	public Università(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public void addUfficio(Ufficio ufficio) {
		uffici.add(ufficio);
	}

	public void removeUfficio(Ufficio ufficio) {
		uffici.remove(ufficio);
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

	public List<Ufficio> getUffici() {
		return uffici;
	}

	public void setUffici(List<Ufficio> uffici) {
		this.uffici = uffici;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nome, uffici);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Università other = (Università) obj;
		return Objects.equals(id, other.id) && Objects.equals(nome, other.nome) && Objects.equals(uffici, other.uffici);
	}

	@Override
	public String toString() {
		return "Università [id=" + id + ", nome=" + nome + ", uffici=" + uffici + "]";
	}

}
