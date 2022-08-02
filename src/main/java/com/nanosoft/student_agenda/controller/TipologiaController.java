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

import com.nanosoft.student_agenda.dto.requestDto.TipologiaAppuntamentoRequestDto;
import com.nanosoft.student_agenda.dto.responseDto.TipologiaAppuntamentoResponseDto;
import com.nanosoft.student_agenda.service.TipologiaAppuntamentoService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RestController
@RequestMapping("/api/tipologia")
public class TipologiaController {

	@Autowired
	private TipologiaAppuntamentoService tipologiaAppuntamentoService;
	
	@PostMapping("/add")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<TipologiaAppuntamentoResponseDto> addTipologia(@RequestBody final TipologiaAppuntamentoRequestDto tipologiaAppuntamentoRequestDto) {
		TipologiaAppuntamentoResponseDto tipologiaAppuntamentoResponseDto = tipologiaAppuntamentoService.aggiungiTipologia(tipologiaAppuntamentoRequestDto);
		return new ResponseEntity<>(tipologiaAppuntamentoResponseDto, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public void deleteTipologia(@PathVariable Integer id) {
		tipologiaAppuntamentoService.rimuoviTipologia(id);
	}
	
	@GetMapping("/list")
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	public ResponseEntity<List<TipologiaAppuntamentoResponseDto>> getAllTipologia() {
		
		List<TipologiaAppuntamentoResponseDto> tipologia = tipologiaAppuntamentoService.getAllTipologia();
		
		return new ResponseEntity<>(tipologia, HttpStatus.OK);
		
	}
}
