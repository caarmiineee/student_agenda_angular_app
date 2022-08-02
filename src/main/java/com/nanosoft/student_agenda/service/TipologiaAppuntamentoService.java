package com.nanosoft.student_agenda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nanosoft.student_agenda.dto.Mapper;
import com.nanosoft.student_agenda.dto.requestDto.TipologiaAppuntamentoRequestDto;
import com.nanosoft.student_agenda.dto.responseDto.TipologiaAppuntamentoResponseDto;
import com.nanosoft.student_agenda.model.TipologiaAppuntamento;
import com.nanosoft.student_agenda.repository.TipologiaAppuntamentoRepository;

@Service
public class TipologiaAppuntamentoService {

	@Autowired
	private TipologiaAppuntamentoRepository tipologiaAppuntamentoRepository;

	public TipologiaAppuntamentoService(TipologiaAppuntamentoRepository tipologiaAppuntamentoRepository) {
		this.tipologiaAppuntamentoRepository = tipologiaAppuntamentoRepository;
	}

	public TipologiaAppuntamento getTipologiaAppuntamento(Integer tipologiaId) {
		return tipologiaAppuntamentoRepository.findById(tipologiaId)
				.orElseThrow(() -> new IllegalArgumentException("non trovo " + tipologiaId));
	}

	public TipologiaAppuntamentoResponseDto aggiungiTipologia(TipologiaAppuntamentoRequestDto appuntamentoRequestDto) {
		TipologiaAppuntamento tipologia = new TipologiaAppuntamento();
		tipologia.setTipologia(appuntamentoRequestDto.getTipologia());
		tipologiaAppuntamentoRepository.save(tipologia);
		return Mapper.tipologiaToTipologiaResponseDto(tipologia);
	}

	public void rimuoviTipologia(Integer id) {

		tipologiaAppuntamentoRepository.findById(id).orElseThrow(() -> new IllegalStateException("id non trovato"));

		tipologiaAppuntamentoRepository.deleteById(id);

	}

	public List<TipologiaAppuntamentoResponseDto> getAllTipologia() {
		List<TipologiaAppuntamento> tipologia = tipologiaAppuntamentoRepository.findAll();
		return Mapper.tipologieToTipologieResponseDtos(tipologia);
	}

}
