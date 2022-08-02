package com.nanosoft.student_agenda.model;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Entity
@Data
@Table(name = "appuntamenti")
public class Appuntamento{

	private static final String PATTERN_DATE = "dd-MMM-yyyy";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Min(value = 8, message = "l'ufficio apre alle 8 e chiude alle 20")
	@Max(value = 20, message = "l'ufficio apre alle 8 e chiude alle 20")
	@Column(name = "ora")
	private Integer ora;

	@Column(name = "descrizione")
	private String descrizione;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = PATTERN_DATE)
	@Column(name = "data")
	private LocalDate data;

	@ManyToOne(fetch = FetchType.LAZY, cascade = {
		CascadeType.DETACH,
		CascadeType.MERGE, 
		CascadeType.PERSIST,
		CascadeType.REFRESH
	})
	@JoinColumn(name = "agenda_id")
	private Agenda agenda;

	@ManyToOne(fetch = FetchType.LAZY, cascade = {
			CascadeType.DETACH,
			CascadeType.MERGE, 
			CascadeType.PERSIST,
			CascadeType.REFRESH
		})
	@JoinColumn(name = "ufficio_id")
	private Ufficio ufficio;

	@ManyToOne(fetch = FetchType.LAZY, cascade = {
			CascadeType.DETACH,
			CascadeType.MERGE, 
			CascadeType.PERSIST,
			CascadeType.REFRESH
		})
	@JoinColumn(name = "tipologia_id")
	private TipologiaAppuntamento tipologiaAppuntamento;

	public Appuntamento() {
	}

	public Appuntamento(Integer id, Integer ora, String descrizione, LocalDate data,
			Agenda agenda, Ufficio ufficio, TipologiaAppuntamento tipologiaAppuntamento) {
		this.id = id;
		this.ora = ora;
		this.descrizione = descrizione;
		this.data = data;
		this.agenda = agenda;
		this.ufficio = ufficio;
		this.tipologiaAppuntamento = tipologiaAppuntamento;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getOra() {
		return ora;
	}

	public void setOra(Integer ora) {
		this.ora = ora;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public Agenda getAgenda() {
		return agenda;
	}

	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	}

	public Ufficio getUfficio() {
		return ufficio;
	}

	public void setUfficio(Ufficio ufficio) {
		this.ufficio = ufficio;
	}

	public TipologiaAppuntamento getTipologia() {
		return tipologiaAppuntamento;
	}

	public void setTipologia(TipologiaAppuntamento tipologiaAppuntamento) {
		this.tipologiaAppuntamento = tipologiaAppuntamento;
	}

	@Override
	public int hashCode() {
		return Objects.hash(agenda, data, descrizione, id, ora, tipologiaAppuntamento, ufficio);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Appuntamento other = (Appuntamento) obj;
		return Objects.equals(agenda, other.agenda) && Objects.equals(data, other.data)
				&& Objects.equals(descrizione, other.descrizione) && Objects.equals(id, other.id)
				&& Objects.equals(ora, other.ora) && Objects.equals(tipologiaAppuntamento, other.tipologiaAppuntamento)
				&& Objects.equals(ufficio, other.ufficio);
	}

	@Override
	public String toString() {
		return "Appuntamento [id=" + id + ", ora=" + ora + ", descrizione=" + descrizione + ", data=" + data
				+ ", agenda=" + agenda + ", ufficio=" + ufficio + ", tipologiaAppuntamento=" + tipologiaAppuntamento
				+ "]";
	}

	public boolean ugualeAData(Object obj) {
		Appuntamento other = (Appuntamento) obj;
		return this.data.equals(other.getData());
	}
}
