package com.nanosoft.student_agenda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nanosoft.student_agenda.dto.Mapper;
import com.nanosoft.student_agenda.dto.requestDto.UniversitàRequestDto;
import com.nanosoft.student_agenda.dto.responseDto.UniversitàResponseDto;
import com.nanosoft.student_agenda.model.Università;
import com.nanosoft.student_agenda.repository.UniversitàRepository;

@Service
public class UniversitàService {

	@Autowired
	private UniversitàRepository universitàRepository;

	public UniversitàService(UniversitàRepository universitàRepository) {
		this.universitàRepository = universitàRepository;
	}

	public Università getUniversita(Integer universitaId) {
		return universitàRepository.findById(universitaId)
				.orElseThrow(() -> new IllegalArgumentException("non trovo " + universitaId));
	}

	public UniversitàResponseDto aggiungiUniversità(UniversitàRequestDto universitàRequestDto) {

		Università università = new Università();
		università.setNome(universitàRequestDto.getNome());

		universitàRepository.save(università);

		return Mapper.universitaToUniversitaResponseDto(università);
	}

	public void rimuoviUniversità(Integer id) {
		universitàRepository.deleteById(id);
	}

}
