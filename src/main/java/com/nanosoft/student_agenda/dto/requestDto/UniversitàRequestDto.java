package com.nanosoft.student_agenda.dto.requestDto;

import java.util.List;

import com.nanosoft.student_agenda.model.Ufficio;

public class UniversitàRequestDto {

	private String nome;

	private List<Ufficio> uffici;

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

}
