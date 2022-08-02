package com.nanosoft.student_agenda.dto.responseDto;

import lombok.Data;

@Data
public class UfficioResponseDto {

	private Integer id;
	private String nome;
	private String universitaNome;

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

	public String getUniversitaNome() {
		return universitaNome;
	}

	public void setUniversitaNome(String universitaNome) {
		this.universitaNome = universitaNome;
	}

}
