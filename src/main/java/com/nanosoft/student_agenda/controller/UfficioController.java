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

import com.nanosoft.student_agenda.dto.requestDto.UfficioRequestDto;
import com.nanosoft.student_agenda.dto.responseDto.UfficioResponseDto;
import com.nanosoft.student_agenda.model.Appuntamento;
import com.nanosoft.student_agenda.service.UfficioService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RestController
@RequestMapping("/api/ufficio")
public class UfficioController {

	@Autowired
	private UfficioService ufficioService;
	
	@PostMapping("/add")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<UfficioResponseDto> addUfficio(@RequestBody UfficioRequestDto ufficioRequestDto) {
		UfficioResponseDto ufficioResponseDto = ufficioService.aggiungiUfficio(ufficioRequestDto);
		return new ResponseEntity<>(ufficioResponseDto, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public void deleteUfficio(@PathVariable Integer id) {
		ufficioService.rimuoviUfficio(id);
	}
	
	@GetMapping("/list")
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	public ResponseEntity<List<UfficioResponseDto>> getAllUfficio() {
		
		List<UfficioResponseDto> uffici = ufficioService.getAllUfficio();
		
		return new ResponseEntity<>(uffici, HttpStatus.OK);
	}
	
	@GetMapping("/{id}/list")
	@PreAuthorize("hasRole('ADMIN')")
	public List<Appuntamento> getAllAppuntamentiByUfficio(@PathVariable("id") Integer id) {
		return ufficioService.getAllAppuntamenti(id);
	}//ok
}
