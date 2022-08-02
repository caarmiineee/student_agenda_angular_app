package com.nanosoft.student_agenda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nanosoft.student_agenda.dto.Mapper;
import com.nanosoft.student_agenda.dto.requestDto.AgendaRequestDto;
import com.nanosoft.student_agenda.dto.responseDto.AgendaResponseDto;
import com.nanosoft.student_agenda.model.Agenda;
import com.nanosoft.student_agenda.repository.AgendaRepository;

@Service
public class AgendaService {

	@Autowired
	private AgendaRepository agendaRepository;

	public AgendaService(AgendaRepository agendaRepository) {
		this.agendaRepository = agendaRepository;
	}

	public Agenda getAgenda(Integer agendaId) {
		return agendaRepository.findById(agendaId)
				.orElseThrow(() -> new IllegalArgumentException("non trovo " + agendaId));
	}

	public AgendaResponseDto aggiungiAgenda(AgendaRequestDto agendaRequestDto) {

		Agenda agenda = new Agenda();

		agenda.setNome(agendaRequestDto.getNome());

		agendaRepository.save(agenda);

		return Mapper.agendaToAgendaResponseDto(agenda);
	}

	public void rimuoviAgenda(Integer id) {

		agendaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("id " + id + " non presente"));
		agendaRepository.deleteById(id);
	}

	public List<AgendaResponseDto> getAllAgenda() {
		List<Agenda> agenda = agendaRepository.findAll();
		return Mapper.agendeToAgendeResponseDtos(agenda);
	}
}
