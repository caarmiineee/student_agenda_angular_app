package com.nanosoft.student_agenda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nanosoft.student_agenda.dto.requestDto.AgendaRequestDto;
import com.nanosoft.student_agenda.dto.responseDto.AgendaResponseDto;
import com.nanosoft.student_agenda.service.AgendaService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RestController
@RequestMapping("/api/agenda")
public class AgendaController {

	@Autowired
	private AgendaService agendaService;

	@PostMapping("/add")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<AgendaResponseDto> addAgenda(@RequestBody AgendaRequestDto agendaRequestDto) {
		AgendaResponseDto agendaResponseDto = agendaService.aggiungiAgenda(agendaRequestDto);
		return new ResponseEntity<>(agendaResponseDto, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public void deleteAgenda(@PathVariable Integer id) {
		agendaService.rimuoviAgenda(id);
	}

	@GetMapping("/list")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<List<AgendaResponseDto>> getAll() {

		List<AgendaResponseDto> agendaResponseDtos = agendaService.getAllAgenda();

		return new ResponseEntity<>(agendaResponseDtos, HttpStatus.OK);
	}

}
