package com.nanosoft.student_agenda.dto.requestDto;

import java.util.List;

import com.nanosoft.student_agenda.model.Appuntamento;
import com.nanosoft.student_agenda.model.Tipologia;

import lombok.Data;

@Data
public class TipologiaAppuntamentoRequestDto {

	private Tipologia tipologia;

	private List<Appuntamento> appuntamenti;

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

}
