package com.nanosoft.student_agenda.dto.requestDto;

import java.util.List;

import com.nanosoft.student_agenda.model.Appuntamento;

import lombok.Data;

@Data
public class UfficioRequestDto {

	private String nome;

	private List<Appuntamento> appuntamenti;

	private Integer universitaId;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getUniversitaId() {
		return universitaId;
	}

	public void setUniversitaId(Integer universitaId) {
		this.universitaId = universitaId;
	}

	public List<Appuntamento> getAppuntamenti() {
		return appuntamenti;
	}

	public void setAppuntamenti(List<Appuntamento> appuntamenti) {
		this.appuntamenti = appuntamenti;
	}
	
}
