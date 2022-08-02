package com.nanosoft.student_agenda.dto.requestDto;

import lombok.Data;

@Data
public class AppuntamentoRequestDto {

	private Integer ora;
	private String descrizione;
	private String data;
	private Integer agendaId;
	private Integer ufficioId;
	private Integer tipologiaId;

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

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Integer getAgendaId() {
		return agendaId;
	}

	public void setAgendaId(Integer agendaId) {
		this.agendaId = agendaId;
	}

	public Integer getUfficioId() {
		return ufficioId;
	}

	public void setUfficioId(Integer ufficioId) {
		this.ufficioId = ufficioId;
	}

	public Integer getTipologiaId() {
		return tipologiaId;
	}

	public void setTipologiaId(Integer tipologiaId) {
		this.tipologiaId = tipologiaId;
	}

}
