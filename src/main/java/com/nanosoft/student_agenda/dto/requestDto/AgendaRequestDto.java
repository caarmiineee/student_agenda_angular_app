package com.nanosoft.student_agenda.dto.requestDto;

import java.util.List;

import lombok.Data;

@Data
public class AgendaRequestDto {

	private String nome;

	private List<Integer> appuntamentiId;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Integer> getAppuntamentiId() {
		return appuntamentiId;
	}

	public void setAppuntamentiId(List<Integer> appuntamentiId) {
		this.appuntamentiId = appuntamentiId;
	}

}
