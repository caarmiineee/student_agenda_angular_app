package com.nanosoft.student_agenda.dto.responseDto;

import lombok.Data;

@Data
public class UniversitàResponseDto {

	private Integer id;
	private String nome;

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

}
