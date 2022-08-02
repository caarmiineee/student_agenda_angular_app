package com.nanosoft.student_agenda.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "tipologia_appuntamento")
public class TipologiaAppuntamento {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Enumerated(EnumType.STRING)
	@Column(name = "tipologia")
	private Tipologia tipologia;

	@OneToMany(mappedBy = "tipologiaAppuntamento", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Appuntamento> appuntamenti = new ArrayList<Appuntamento>();

	public TipologiaAppuntamento() {
	}

	public TipologiaAppuntamento(Tipologia tipologia, List<Appuntamento> appuntamenti) {
		this.tipologia = tipologia;
		this.appuntamenti = appuntamenti;
	}

	public TipologiaAppuntamento(Integer id, Tipologia tipologia) {
		this.id = id;
		this.tipologia = tipologia;
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

	public Tipologia getTipologia() {
		return tipologia;
	}

	public void setTipologia(Tipologia tipologia) {
		this.tipologia = tipologia;
	}

	public List<Appuntamento> getAppuntamenti() {
		return appuntamenti;
	}

	public void setAppuntamenti(List<Appuntamento> appuntamenti) {
		this.appuntamenti = appuntamenti;
	}

	@Override
	public int hashCode() {
		return Objects.hash(appuntamenti, id, tipologia);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TipologiaAppuntamento other = (TipologiaAppuntamento) obj;
		return Objects.equals(appuntamenti, other.appuntamenti) && Objects.equals(id, other.id)
				&& tipologia == other.tipologia;
	}

	@Override
	public String toString() {
		return "TipologiaAppuntamento [id=" + id + ", tipologia=" + tipologia + ", appuntamenti=" + appuntamenti + "]";
	}

}
