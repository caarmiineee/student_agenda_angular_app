package com.nanosoft.student_agenda.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nanosoft.student_agenda.dto.Mapper;
import com.nanosoft.student_agenda.dto.requestDto.UfficioRequestDto;
import com.nanosoft.student_agenda.dto.responseDto.UfficioResponseDto;
import com.nanosoft.student_agenda.model.Appuntamento;
import com.nanosoft.student_agenda.model.Ufficio;
import com.nanosoft.student_agenda.model.Università;
import com.nanosoft.student_agenda.repository.UfficioRepository;

@Service
public class UfficioService {

	private UfficioRepository ufficioRepository;
	private UniversitàService universitàService;

	public UfficioService(UfficioRepository ufficioRepository) {
		super();
		this.ufficioRepository = ufficioRepository;
	}

	@Autowired
	public UfficioService(UfficioRepository ufficioRepository, UniversitàService universitàService) {
		super();
		this.ufficioRepository = ufficioRepository;
		this.universitàService = universitàService;
	}

	public Ufficio getUfficio(Integer ufficioId) {
		return ufficioRepository.findById(ufficioId)
				.orElseThrow(() -> new IllegalArgumentException("non trovo " + ufficioId));
	}

	public UfficioResponseDto aggiungiUfficio(UfficioRequestDto ufficioRequestDto) {
		
		Università università = universitàService.getUniversita(ufficioRequestDto.getUniversitaId());

		Ufficio ufficio = new Ufficio();
		ufficio.setNome(ufficioRequestDto.getNome());
		ufficio.setUniversità(università);

		ufficioRepository.save(ufficio);

		return Mapper.ufficioToUfficioResponseDto(ufficio);
	}

	public void rimuoviUfficio(Integer id) {

		ufficioRepository.findById(id).orElseThrow(() -> new IllegalStateException("id non trovato"));

		ufficioRepository.deleteById(id);
	}

	public List<UfficioResponseDto> getAllUfficio() {

		List<Ufficio> uffici = ufficioRepository.findAll();

		return Mapper.ufficiToUfficiResponseDto(uffici);

	}

	public List<Appuntamento> getAllAppuntamenti(Integer id) {
		ufficioRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("id non valido"));
		List<Ufficio> list = ufficioRepository.findAll();
		List<Appuntamento> appuntamenti = new ArrayList<Appuntamento>();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId().equals(id))
				appuntamenti = list.get(i).getAppuntamenti();
		}
		return appuntamenti;

	}
}
