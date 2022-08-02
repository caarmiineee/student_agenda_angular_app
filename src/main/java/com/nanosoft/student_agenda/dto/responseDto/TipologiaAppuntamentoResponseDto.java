package com.nanosoft.student_agenda.dto.responseDto;

import com.nanosoft.student_agenda.model.Tipologia;

import lombok.Data;

@Data
public class TipologiaAppuntamentoResponseDto {

	private Integer id;

	private Tipologia tipologia;

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

}
